package com.example.demo.AliasRegistyLearn;

import com.example.demo.Annotation.TestAnno;
import com.example.demo.bean.TestBean;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.util.StringValueResolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author maonengneng
 */
public class AliasRegistryLearn {

    DefaultListableBeanFactory factory = new DefaultListableBeanFactory();


    @Test
    public void testAlias() {
        //别名注册
        factory.registerAlias("bean1", "aaa");
        //如果有循环别名则报错 -- registerAlias("aaa","bean1");
        factory.registerAlias("bean1", "aab");
        factory.registerAlias("bean2", "aac");
        String[] names = factory.getAliases("bean1");
        System.out.println("names = " + Arrays.toString(names));
    }

    @Test
    public void testDefaultSingletonBeanRegistry() {
        //DefaultSingletonBeanRegistry 方法测试 注册单例bean
        factory.registerSingleton("bean1", new AliasRegistryLearn());
        Object abc = factory.getBean("bean1");
        System.out.println("abc = " + abc);
        //只会返回已经实例化的bean名称
        String[] singletonNames = factory.getSingletonNames();
        System.out.println("singletonNames = " + Arrays.toString(singletonNames));
        //获取bean的提供者，类似于Optional可以延迟使用这个bean，支持stream
        ObjectProvider<AliasRegistryLearn> provider = factory.getBeanProvider(AliasRegistryLearn.class);
        AliasRegistryLearn ifAvailable = provider.getIfAvailable();
        System.out.println("ifAvailable = " + ifAvailable);
        System.out.println("provider = " + provider);
        System.out.println(factory);
    }

    @Test
    public void testBeanFactory() {
        //HierarchicalBeanFactory接口 支持了父工厂的功能
        BeanFactory parentBeanFactory = factory.getParentBeanFactory();
    }

    /**
     * 测试BeanDefinitionRegistry
     * beanName = bean2
     */
    @Test
    public void testBeanDefinitionRegistry() {
        //BeanDefinitionRegistry接口，支持操作BeanDefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(TestBean.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        HashMap<String, String> propertyMap = new HashMap<>(2);
        propertyMap.put("property1", "123");
        propertyMap.put("property2", "456");
        propertyValues.addPropertyValues(propertyMap);
        beanDefinition.setPropertyValues(propertyValues);
        factory.registerBeanDefinition("bean2", beanDefinition);
        Object bean2 = factory.getBean("bean2");
        System.out.println("bean2 = " + bean2);
    }

    /*
     * FactoryBeanRegistrySupport 扩展DefaultSingletonBeanRegistry
     *   支持了FactoryBean 暂时不懂 后面再回顾
     * */

    /**
     * ConfigurableBeanFactory 支持工厂功能，配置工厂属性
     * 设置类加载器
     * 解析表达式
     * 转换值（配置文件中的各种配置方式）
     * 初始化前置后置处理器{@link AbstractAutowireCapableBeanFactory#initializeBean(String, Object, RootBeanDefinition)}
     */
    @Test
    public void testConfigurableBeanFactory() {
        //设置类加载器
        factory.setBeanClassLoader(AliasRegistryLearn.class.getClassLoader());
        //设置解析器，多个解析器会顺序解析
        StringValueResolver resolver = strVal -> strVal + "----resolver";
        factory.addEmbeddedValueResolver(resolver);
        factory.addEmbeddedValueResolver(strVal -> strVal + "----resolver1");
        String testResolver = factory.resolveEmbeddedValue("testResolver");
        System.out.println("testResolver = " + testResolver);
        //bean前置处理器,在类AbstractAutowireCapableBeanFactory中initializeBean()方法中环绕invokeInitMethods()方法调用
        factory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                if ("bean2".equals(beanName)) {
                    System.out.println("postProcess----Before----Initialization");
                    ((TestBean) bean).setProperty2("postProcessBefore" + ((TestBean) bean).getProperty2());
                }
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if ("bean2".equals(beanName)) {
                    System.out.println("postProcess----After----Initialization");
                    ((TestBean) bean).setProperty2("postProcessAfter" + ((TestBean) bean).getProperty2());
                }
                return bean;
            }
        });
        testBeanDefinitionRegistry();
    }

    /**
     * 测试ListableBeanFactory
     */
    @Test
    public void testListableBeanFactory() {
        testBeanDefinitionRegistry();
        //获取beanDefinition
        BeanDefinition beanDefinition = factory.getBeanDefinition("bean2");
        beanDefinition.getPropertyValues().stream().forEach(System.out::println);

        //获取有对应注解的bean #自定义注解忘记加@Retention(RetentionPolicy.RUNTIME)导致获取不到
        Map<String, Object> annotation = factory.getBeansWithAnnotation(TestAnno.class);
        System.out.println(annotation);

        //获取bean上的注解
        TestAnno anno = factory.findAnnotationOnBean("bean2", TestAnno.class);
        System.out.println("anno = " + anno);
    }

    /**
     * AbstractBeanFactory
     * 继承FactoryBeanRegistrySupport和实现 ConfigurableBeanFactory
     * {@link #testConfigurableBeanFactory()}
     */
    @Test
    public void testAbstractBeanFactory() {
        //创建上方的bean2
        testBeanDefinitionRegistry();
        //定义新的 beanDefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(TestBean.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        HashMap<String, String> propertyMap = new HashMap<>(2);
        propertyMap.put("property1", "777");
        propertyMap.put("property2", "999");
        propertyValues.addPropertyValues(propertyMap);
        beanDefinition.setPropertyValues(propertyValues);
        factory.registerBeanDefinition("testBean", beanDefinition);
        System.out.println(factory.getBeansOfType(TestBean.class));
    }

/*    @Test
    public void testAlias (){

    }

    @Test
    public void testAlias (){

    }*/


}
