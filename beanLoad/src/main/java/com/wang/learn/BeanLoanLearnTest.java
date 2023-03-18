package com.wang.learn;

import com.wang.learn.bean.TestBean;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * bean加载学习
 *
 * @author maonengneng
 * @date 2023/03/14
 */
public class BeanLoanLearnTest {


    /**
     * {@link AbstractBeanFactory#transformedBeanName}解析名称
     * <p>
     * 学习了getBean的前几步 从缓存中加载，如何没有就存缓存的factoryBean中加载，然后执行 getObject方法来获取bean
     * 在返回对应的bean之前，会在finally中执行 BeanPostProcessor的postProcessAfterInitialization方法，也就是bean的后置处理器
     * 可以通过实现 BeanPostProcessor来执行自己业务逻辑
     * 这些全是从缓存中加载到bean的处理，如果缓存中加载不到，则执行从头加载的过程，见5.4学习
     */
    @Test
    public void testAlias() {

        ClassPathResource resource = new ClassPathResource("beanFactoryTest.xml");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        //第一次执行会完整的加载bean
        TestBean a = factory.getBean("a", TestBean.class);
        //第二次则会直接去缓存中获取bean
        TestBean a1 = factory.getBean("a", TestBean.class);
        System.out.println(a.getProperty1());
        System.out.println(a.getProperty2());

        //bean配置为string，获取的时候指定类型为integer，会通过getBean最后的转换方法来转换类型
        Integer str = factory.getBean("str", Integer.class);
        System.out.println("str = " + str);

    }

    /**
     * 加载bean,如果上面从缓存中没有获取到bean，则会进入下面的方法来加载bean
     */
    @Test
    public void testGetBean() {

        ClassPathResource resource = new ClassPathResource("beanFactoryTest.xml");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        //第一次执行会完整的加载bean
        TestBean a = factory.getBean("a", TestBean.class);
        Object daili = factory.getBean("daili");
        System.out.println("daili = " + daili);
        /*
        * public Object getSingleton(String beanName, ObjectFactory<?> singletonFactory) {
            Assert.notNull(beanName, "Bean name must not be null");
            synchronized (this.singletonObjects) {
                // 从 singletonObjects 集合中获取单例对象
                Object singletonObject = this.singletonObjects.get(beanName);
                if (singletonObject == null) {
                    if (this.singletonsCurrentlyInDestruction) {
                        // 如果当前 BeanFactory 正在销毁单例对象，则抛出 BeanCreationNotAllowedException 异常
                        throw new BeanCreationNotAllowedException(beanName,
                                "Singleton bean creation not allowed while singletons of this factory are in destruction " +
                                "(Do not request a bean from a BeanFactory in a destroy method implementation!)");
                    }
                    if (logger.isDebugEnabled()) {
                        logger.debug("Creating shared instance of singleton bean '" + beanName + "'");
                    }
                    // 为当前 beanName 的单例对象创建前的回调方法
                    beforeSingletonCreation(beanName);
                    // 记录是否新创建了一个单例对象
                    boolean newSingleton = false;
                    // 判断是否需要记录异常
                    boolean recordSuppressedExceptions = (this.suppressedExceptions == null);
                    if (recordSuppressedExceptions) {
                        // 如果需要记录异常，则创建 LinkedHashSet 集合
                        this.suppressedExceptions = new LinkedHashSet<>();
                    }
                    try {
                        // 通过 singletonFactory 获取单例对象
                        singletonObject = singletonFactory.getObject();
                        newSingleton = true;
                    }
                    catch (IllegalStateException ex) {
                        // 如果 getObject() 抛出了 IllegalStateException 异常，则重新获取一遍单例对象
                        // 是否已经存在的对象
                        singletonObject = this.singletonObjects.get(beanName);
                        if (singletonObject == null) {
                            throw ex;
                        }
                    }
                    catch (BeanCreationException ex) {
                        // 如果 getObject() 抛出了 BeanCreationException 异常，则将异常加入 suppressedExceptions 集合中
                        if (recordSuppressedExceptions) {
                            for (Exception suppressedException : this.suppressedExceptions) {
                                ex.addRelatedCause(suppressedException);
                            }
                        }
                        throw ex;
                    }
                    finally {
                        if (recordSuppressedExceptions) {
                            this.suppressedExceptions = null;
                        }
                        // 为当前 beanName 的单例对象创建后的回调方法
                        afterSingletonCreation(beanName);
                    }
                    if (newSingleton) {
                        // 如果新创建了一个单例对象，则将其添加到 singletonObjects 集合中
                        addSingleton(beanName, singletonObject);
                    }
                }
                return singletonObject;
            }
        }
        * */

    }

    /**
     * 该方法首先检查是否存在覆盖方法，如果没有，则不执行任何操作并返回。如果存在，则对每个覆盖方法进行以下操作：
     *
     * 获取该方法的名称、参数类型和标志位。
     * 检查是否已经存在具有相同名称、参数类型和标志位的方法覆盖。如果存在，则抛出一个异常。
     * 否则，将该方法覆盖添加到方法覆盖集合中，该集合存储在 Bean 定义对象的相应字段中。
     * 此方法的主要目的是确保 Bean 定义中的方法覆盖数据结构是正确填充的，以便在 Bean 实例化期间调用适当的方法。
     *
     */
    @Test
    public void testPrepareMethodOverrides(){


    }
}
