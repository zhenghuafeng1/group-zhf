package zhf.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Autor zhenghf
 * @Date 2022/8/4
 * @ClassName
 * @Customer
 **/
public class PersonProxyHandler implements InvocationHandler {

    private Object o;
    //
    //public PersonProxyHandler(Object o){
    //    this.o=o;
    //}

    @Override
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        return method.invoke(o,objects);
    }

    public Object getInstance(Object object){
        this.o=object;
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),
                o.getClass().getInterfaces(),
                this);
    }
}
