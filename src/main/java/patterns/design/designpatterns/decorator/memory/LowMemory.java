package patterns.design.designpatterns.decorator.memory;

import patterns.design.designpatterns.decorator.Server;
import patterns.design.designpatterns.decorator.ServerDecorator;

public class LowMemory extends ServerDecorator {

    public LowMemory(Server decoratedServer) {
        super(decoratedServer);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.000920;
    }
}
