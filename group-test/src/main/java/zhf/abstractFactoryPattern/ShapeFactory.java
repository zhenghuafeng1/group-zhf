package zhf.abstractFactoryPattern;

import java.util.Objects;

public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {

        return null;
    }

    @Override
    public Shape getsShape(String shape) {
        if(Objects.equals(shape,"square")){
            return new Square();
        }else if(Objects.equals(shape,"circle")){
            return new Circle();
        }
        return null;
    }
}
