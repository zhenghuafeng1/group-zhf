package zhf.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @Autor zhenghf
 * @Date 2022/8/4
 * @ClassName
 * @Customer
 **/
public class JdkProxyMain {

    /**
     *     IPerson target = new ManPerson();
     *     IPerson proxy = (IPerson)Proxy.newProxyInstance(
     *         target.getClass().getClassLoader(),
     *         target.getClass().getInterfaces(),
     *         new PersonInvocationHandler(target));
     *     proxy.eat();
     *     proxy.sleep();
     */
    public static void main(String[] args) {
        //IPerson man=new ManPerson();
        IPerson proxy= (IPerson) new PersonProxyHandler().getInstance(new ManPerson());
        proxy.action();
    }
}
