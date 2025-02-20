package patterns.design.designpatterns.command;

public class ContrastCommand implements Command {

    private Photo photo;
    private int level;

    public ContrastCommand(Photo photo, int level) {
        this.photo = photo;
        this.level = level;
    }

    @Override
    public void execute() {
        photo.applyEffect("contrast", level);
    }

    @Override
    public void undo() {
        photo.removeEffect("contrast", level);
    }

    @Override
    public String getName() {
        return "Contrast";
    }
}
