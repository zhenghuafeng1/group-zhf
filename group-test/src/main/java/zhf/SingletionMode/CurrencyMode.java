package zhf.SingletionMode;

/**
 * @Autor zhenghf
 * @Date 2022/7/14
 * @ClassName
 * @Customer
 **/
public class CurrencyMode {
    private CurrencyMode(){

    }

    private static CurrencyMode currencyMode=new CurrencyMode();

    public static CurrencyMode getCurrencyMode(){
        return currencyMode;
    }

    public void showMessage(){
        System.out.println("===================");
        System.out.println("create CurrencyMode");
        System.out.println("===================");
    }
}
