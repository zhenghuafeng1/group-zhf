package zhf.jdkProxy;

/**
 * @Autor zhenghf
 * @Date 2022/8/4
 * @ClassName
 * @Customer
 **/
public class ManPerson  implements IPerson{
    @Override
    public void action() {
        System.out.println("this man is sleep");
    }
}
