package patterns.design.designpatterns.decorator.cpu;

import patterns.design.designpatterns.decorator.Server;

public class NormalCPU implements Server {

    @Override
    public double getCost() {
        return 0.01484;
    }
}
