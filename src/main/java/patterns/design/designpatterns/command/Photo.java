package patterns.design.designpatterns.command;

public class Photo {

    private String name;

    public Photo(String name) {
        this.name = name;
    }

    public void applyEffect(String effect, int level) {
        System.out.println("Applying " + effect + " (level: " + level + ") to " + name);
    }

    public void removeEffect(String effect, int level) {
        System.out.println("Removing " + effect + " (level: " + level + ") from " + name);
    }

}
