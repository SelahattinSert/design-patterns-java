package patterns.design.designpatterns.abstractfactory;

public abstract class FurnitureFactory {

    public abstract Chair createChair();
    public abstract Table createTable();

    public static FurnitureFactory getFactory(String style) {
        if (style.equalsIgnoreCase("Modern")) {
            return new ModernFurnitureFactory();
        } else if (style.equalsIgnoreCase("Victorian")) {
            return new VictorianFurnitureFactory();
        }
        throw new IllegalArgumentException("Unknown furniture style: " + style);
    }
}
