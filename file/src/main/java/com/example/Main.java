package com.example;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        proxy();
    }

    private static void extracted() {
        String s = "        location ^~ %s {\n" +
                "                proxy_pass %s;\n" +
                "        }";
        //读取D盘下 api.txt文件为流

        //读取一行并处理
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\api.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\result.txt"));) {
            while ((line = reader.readLine()) != null) {
                //处理这行
                String s1 = line.split("=")[1];
                String s2 = s1.replace("http://open.api.tianyancha.com", "");

                String result = String.format(s, s2, s1);
                writer.write(result);
                writer.newLine();
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sss() {
        StringBuilder sb = new StringBuilder();
        String line;
        try (InputStream inputStream = Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("23062800004json.txt"));
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("D:\\23062800004json.pdf"));) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            JSONObject entries = JSONUtil.parseObj(sb);
            byte[] files = entries.getBytes("invoiceFile");
            outputStream.write(files);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void proxy(){
        Animal target = new Animal();

        // 创建代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Animal.class);
        enhancer.setCallback(new CustomMethodInterceptor());
        Animal proxy = (Animal) enhancer.create();
        target.setName("1123");
        System.out.println("proxy = " + proxy);
        // 使用代理对象调用方法
        //proxy.method();
    }

    static class CustomMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            // 在方法执行前添加额外的行为
            System.out.println("方法执行前");
            System.out.println(method.getName());
            // 调用目标方法
            Object result = proxy.invokeSuper(obj, args);

            // 在方法执行后添加额外的行为
            System.out.println("方法执行后");

            return result;
        }
    }
}