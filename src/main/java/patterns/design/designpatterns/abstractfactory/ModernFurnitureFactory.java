package patterns.design.designpatterns.abstractfactory;

public class ModernFurnitureFactory extends FurnitureFactory {

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}
