package zhf.abstractFactoryPattern;

public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("fill: red");
    }
}
