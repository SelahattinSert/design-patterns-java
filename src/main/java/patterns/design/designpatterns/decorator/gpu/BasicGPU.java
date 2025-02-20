package patterns.design.designpatterns.decorator.gpu;

import patterns.design.designpatterns.decorator.Server;
import patterns.design.designpatterns.decorator.ServerDecorator;

public class BasicGPU extends ServerDecorator {

    public BasicGPU(Server decoratedServer) {
        super(decoratedServer);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.006867;
    }
}
