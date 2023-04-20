package com.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//enterPrise.base.info.url=http://open.api.tianyancha.com/services/v3/open/baseinfo
        String s = "        location ^~ %s {\n" +
                "                proxy_pass %s;\n" +
                "        }";
        //读取D盘下 api.txt文件为流

        //读取一行并处理
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\api.txt"));
                     BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\result.txt"));){
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
}