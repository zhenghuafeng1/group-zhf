package zhf.SingletionMode;

/**
 * @Autor zhenghf
 * @Date 2022/7/14
 * @ClassName
 * @Customer
 **/
public class DoubleCheckedLocking {

    private DoubleCheckedLocking (){}

    private volatile static DoubleCheckedLocking doubleCheckedLocking;

    public static DoubleCheckedLocking getDoubleCheckedLocking(){
        if(doubleCheckedLocking==null){
            synchronized (DoubleCheckedLocking.class){
                if(doubleCheckedLocking==null){
                    doubleCheckedLocking=new DoubleCheckedLocking();
                }
            }
        }
        return doubleCheckedLocking;
    }

    public void showMessage(){
        System.out.println("===================");
        System.out.println("create doubleCheckedLocking");
        System.out.println("===================");
    }

}
