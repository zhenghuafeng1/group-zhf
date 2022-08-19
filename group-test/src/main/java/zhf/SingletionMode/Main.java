package zhf.SingletionMode;

/**
 * @Autor zhenghf
 * @Date 2022/7/14
 * @ClassName
 * @Customer
 **/
public class Main {
    public static void main(String[] args) {
        //CurrencyMode
        CurrencyMode currencyMode=CurrencyMode.getCurrencyMode();
        currencyMode.showMessage();

        //LazySingletionMode1
        LazySingletionMode1 lazySingletionMode1=LazySingletionMode1.getLazySingletionMode1();
        lazySingletionMode1.showMessage();

        //LazySingletionMode2
        LazySingletionMode2 lazySingletionMode2=LazySingletionMode2.getLazySingletionMode2();
        lazySingletionMode2.showMessage();

        //DoubleCheckedLocking
        DoubleCheckedLocking doubleCheckedLocking=DoubleCheckedLocking.getDoubleCheckedLocking();
        doubleCheckedLocking.showMessage();
    }
}
