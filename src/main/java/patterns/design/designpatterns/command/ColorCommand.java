package patterns.design.designpatterns.command;

public class ColorCommand implements Command {

    private Photo photo;
    private int level;

    public ColorCommand(Photo photo, int level) {
        this.photo = photo;
        this.level = level;
    }

    @Override
    public void execute() {
        photo.applyEffect("color", level);
    }

    @Override
    public void undo() {
        photo.removeEffect("color", level);
    }

    @Override
    public String getName() {
        return "Color";
    }
}
