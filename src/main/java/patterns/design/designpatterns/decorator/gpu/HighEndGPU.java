package patterns.design.designpatterns.decorator.gpu;

import patterns.design.designpatterns.decorator.Server;
import patterns.design.designpatterns.decorator.ServerDecorator;

public class HighEndGPU extends ServerDecorator {

    public HighEndGPU(Server decoratedServer) {
        super(decoratedServer);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.022890;
    }
}
