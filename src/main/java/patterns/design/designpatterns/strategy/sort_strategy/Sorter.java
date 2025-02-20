package patterns.design.designpatterns.strategy.sort_strategy;

public class Sorter {

    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] array) {

        if (strategy != null) {
            strategy.sort(array);
        } else {
            System.out.println("Please select a sort strategy");
        }
    }
}
