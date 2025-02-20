package patterns.design.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {

    private String name;
    private List<Command> commands = new ArrayList<>();

    public MacroCommand(String name) {
        this.name = name;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        System.out.println("Executing macro: " + name);
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        System.out.println("Undoing macro: " + name);
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
