package zhf.SingletionMode;

/**
 * @Autor zhenghf
 * @Date 2022/7/14
 * @ClassName
 * @Customer
 **/
public class LazySingletionMode1 {

    private LazySingletionMode1(){

    }

    private static LazySingletionMode1 lazySingletionMode1;

    public static LazySingletionMode1 getLazySingletionMode1(){
        if(lazySingletionMode1 == null) {
            lazySingletionMode1 = new LazySingletionMode1();
        }
        return lazySingletionMode1;
    }

    public void showMessage(){
        System.out.println("===================");
        System.out.println("create LazySingletionMode1");
        System.out.println("===================");
    }
}
