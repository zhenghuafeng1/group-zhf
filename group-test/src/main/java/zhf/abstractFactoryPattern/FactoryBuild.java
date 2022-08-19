package zhf.abstractFactoryPattern;

import java.util.Objects;

public class FactoryBuild {
    public static AbstractFactory getFactory(String type){
        if(Objects.equals(type,"shape")){
            return new ShapeFactory();
        }else if(Objects.equals(type,"color")){
            return new ColorFactory();
        }
        return null;
    }
}
