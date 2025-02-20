package patterns.design.designpatterns.command;

public class PhotoEditorDemo {

    public static void main(String[] args) {

        Photo photo = new Photo("test.jpg");

        MacroCommand portraitEnhancement = new MacroCommand("Portrait Enhancement");

        portraitEnhancement.addCommand(new BrightnessCommand(photo, 10));
        portraitEnhancement.addCommand(new ContrastCommand(photo, 15));
        portraitEnhancement.addCommand(new SharpenCommand(photo, 5));

        MacroCommand vintageEffect = new MacroCommand("Vintage Effect");

        vintageEffect.addCommand(new ContrastCommand(photo, -10));
        vintageEffect.addCommand(new ColorCommand(photo, -15));
        vintageEffect.addCommand(new BlurCommand(photo, 3));

        MacroCommand hdrEffect = new MacroCommand("HDR Effect");

        hdrEffect.addCommand(new BrightnessCommand(photo, 20));
        hdrEffect.addCommand(new ContrastCommand(photo, 25));
        hdrEffect.addCommand(new SharpenCommand(photo, 10));
        hdrEffect.addCommand(new ColorCommand(photo, 15));

        portraitEnhancement.execute();

        portraitEnhancement.undo();

        vintageEffect.execute();

        vintageEffect.undo();

        hdrEffect.execute();

        hdrEffect.undo();
    }
}
