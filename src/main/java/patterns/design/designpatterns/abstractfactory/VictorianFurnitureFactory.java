package patterns.design.designpatterns.abstractfactory;

public class VictorianFurnitureFactory extends FurnitureFactory {

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}
