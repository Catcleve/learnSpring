package com.example.demo.aliasRegistyLearn;

import org.junit.Test;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.xml.SimpleSaxErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

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

    private static class XmlBeanDefinitionReader1 extends XmlBeanDefinitionReader{

        private DocumentLoader documentLoader = new DefaultDocumentLoader();

        private ErrorHandler errorHandler = new SimpleSaxErrorHandler(logger);

        /**
         * Create new XmlBeanDefinitionReader for the given bean factory.
         *
         * @param registry the BeanFactory to load bean definitions into,
         *                 in the form of a BeanDefinitionRegistry
         */
        public XmlBeanDefinitionReader1(BeanDefinitionRegistry registry) {
            super(registry);
        }


        @Override
        public int doLoadBeanDefinitions(InputSource inputSource, Resource resource)
                throws BeanDefinitionStoreException {
            return super.doLoadBeanDefinitions(inputSource, resource);
        }

        @Override
        public Document doLoadDocument(InputSource inputSource, Resource resource) throws Exception {
            return this.documentLoader.loadDocument(inputSource, getEntityResolver(), this.errorHandler,
                    getValidationModeForResource(resource), isNamespaceAware());
        }

    }

    ClassPathResource resource = new ClassPathResource("beanFactoryTest.xml");

    XmlBeanFactory factory = new XmlBeanFactory(resource);

    XmlBeanDefinitionReader1 reader = new XmlBeanDefinitionReader1(factory);

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
    public void testXmlBeanFactory() throws Exception {

        ClassPathResource resource = new ClassPathResource("beanFactoryTest.xml");

        InputSource inputSource = new InputSource(resource.getInputStream());
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        //
        /*
        * 调用1 super()
        * 会一直调用到 AbstractAutowireCapableBeanFactory构造方法
        * 		ignoreDependencyInterface(BeanNameAware.class);
		*       ignoreDependencyInterface(BeanFactoryAware.class);
        *       ignoreDependencyInterface(BeanClassLoaderAware.class);
        * 这三个方法 是忽略自动装备，当一个bean的属性实现了这些接口，会不再自动装配这些属性
        * */

        //new XmlBeanFactory(resource, null);


        /*
        *
        * 对resource对象进行包装为 EncodedResource 为了编码使用
        * 把当前的 EncodedResource 对象放入ThreadLocal中 用来检测避免循环注入 A-->注入B-->注入A 检测到同一个 EncodedResource
        * 通过流获取到 InputSource 对象 使用 doLoadBeanDefinitions(InputSource inputSource, Resource resource) 来完成加载
        * */
        reader.loadBeanDefinitions(resource);

        /*
        *
        * 验证xml文件
        * 解析xml文件
        * 创建bean对象
        *
        * */
        reader.doLoadBeanDefinitions(inputSource, resource);




    }

    /**
     * 验证xml文件
     * 解析xml文件
     * @throws Exception 异常
     */
    @Test
    public void testDoLoadDocument () throws Exception {
        Document document = reader.doLoadDocument(new InputSource(new ClassPathResource("beanFactoryTest.xml").getInputStream()), new ClassPathResource("beanFactoryTest.xml"));
        Element documentElement = document.getDocumentElement();
        System.out.println("documentElement = " + documentElement);
        System.out.println("document = " + document);
        reader.registerBeanDefinitions(document, new ClassPathResource("beanFactoryTest.xml"));
    }

/*
    @Test
    public void test (){


    }

    @Test
    public void test (){


    }

    @Test
    public void test (){


    }

    @Test
    public void test (){


    }*/
}
