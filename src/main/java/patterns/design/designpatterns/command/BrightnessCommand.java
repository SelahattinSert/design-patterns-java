package patterns.design.designpatterns.command;

public class BrightnessCommand implements Command {

    private Photo photo;
    private int level;

    public BrightnessCommand(Photo photo, int level) {
        this.photo = photo;
        this.level = level;
    }

    @Override
    public void execute() {
        photo.applyEffect("brightness", level);
    }

    @Override
    public void undo() {
        photo.removeEffect("brightness", level);
    }

    @Override
    public String getName() {
        return "Brightness";
    }
}
