package zhf.SingletionMode;

/**
 * @Autor zhenghf
 * @Date 2022/7/14
 * @ClassName
 * @Customer
 **/
public class LazySingletionMode2 {
    private LazySingletionMode2(){

    }

    private static LazySingletionMode2 lazySingletionMode2;

    public static synchronized LazySingletionMode2 getLazySingletionMode2(){
        if(lazySingletionMode2==null){
            lazySingletionMode2=new LazySingletionMode2();
        }
        return lazySingletionMode2;
    }

    public void showMessage(){
        System.out.println("===================");
        System.out.println("create LazySingletionMode2");
        System.out.println("===================");
    }

}
