package patterns.design.designpatterns.decorator.memory;

import patterns.design.designpatterns.decorator.Server;
import patterns.design.designpatterns.decorator.ServerDecorator;

public class HighMemory extends ServerDecorator {

    public HighMemory(Server decoratedServer) {
        super(decoratedServer);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.003067;
    }
}
