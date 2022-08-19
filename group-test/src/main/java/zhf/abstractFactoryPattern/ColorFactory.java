package zhf.abstractFactoryPattern;

import java.util.Objects;

public class ColorFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        if(Objects.equals(color,"red")){
            return new Red();
        }else if(Objects.equals(color,"blue")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getsShape(String shape) {
        return null;
    }
}
