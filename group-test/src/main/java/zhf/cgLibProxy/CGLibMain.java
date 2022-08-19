package zhf.cgLibProxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @Autor zhenghf
 * @Date 2022/8/5
 * @ClassName
 * @Customer
 **/
public class CGLibMain {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\temp");
        GPerson gPerson= (GPerson) new CGLibProxyHandler(new GPerson()).getProxy();
        gPerson.action();
        //GPerson gPerson= (GPerson) Enhancer.create(GPerson.class,new CGLibProxyHandler());
        //gPerson.action();
    }
}
