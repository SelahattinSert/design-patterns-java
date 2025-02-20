package patterns.design.designpatterns.decorator;

public abstract class ServerDecorator implements Server {

    protected Server decoratedServer;

    public ServerDecorator(Server decoratedServer) {
        this.decoratedServer = decoratedServer;
    }

    @Override
    public double getCost() {
        return decoratedServer.getCost();
    }
}