package com.example.demo.aliasRegistyLearn;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * XmlBeanDefinitionReader学习
 *
 *
 * @author maonengneng
 * @date 2023/02/28
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void testFiles() throws IOException {
        //读入resource下的文件
        ClassPathResource resource = new ClassPathResource("application.yml");
        resource.exists();
        resource.isFile();
        System.out.println(resource.getFilename());
        try (InputStream inputStream = resource.getInputStream()) {

        }
        System.out.println(resource.getURL());
        System.out.println(resource.getURI());
        File file = resource.getFile();

        File out = new File("D:\\111.class");
        if (!out.exists()) {
            out.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream("D:\\111.class");
        Path path = file.toPath();
        Files.copy(path, outputStream);
    }

    @Test
    public void testXmlBeanFactory() {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        //
        /*
        * 调用1 super()
        * 会一直调用到 AbstractAutowireCapableBeanFactory构造方法
        * 		ignoreDependencyInterface(BeanNameAware.class);
		*       ignoreDependencyInterface(BeanFactoryAware.class);
        *       ignoreDependencyInterface(BeanClassLoaderAware.class);
        * 这三个方法 是忽略自动装备，当一个bean的属性实现了这些接口，会不再自动装配这些属性
        * */
        new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"), null);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(null);
        /*
        *
        * 对resource对象进行包装为 EncodedResource 为了编码使用
        * 把当前的 EncodedResource 对象放入ThreadLocal中 用来检测避免循环注入 A-->注入B-->注入A 检测到同一个 EncodedResource
        * 通过流获取到 InputSource 对象 使用 doLoadBeanDefinitions(InputSource inputSource, Resource resource) 来完成加载
        * */
        reader.loadBeanDefinitions(new ClassPathResource("beanFactoryTest.xml"));

    }

}
