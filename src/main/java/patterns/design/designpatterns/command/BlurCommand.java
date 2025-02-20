package patterns.design.designpatterns.command;

public class BlurCommand implements Command {

    private Photo photo;
    private int amount;

    public BlurCommand(Photo photo, int amount) {
        this.photo = photo;
        this.amount = amount;
    }

    @Override
    public void execute() {
        photo.applyEffect("blur", amount);
    }

    @Override
    public void undo() {
        photo.removeEffect("blur", amount);
    }

    @Override
    public String getName() {
        return "Blur";
    }
}
