package patterns.design.designpatterns.observer;

public interface Observer {
    void update(String sourceName, String messageType, String message);
}
