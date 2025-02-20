package patterns.design.designpatterns.command;

public interface Command {
    void execute();
    void undo();
    String getName();
}
