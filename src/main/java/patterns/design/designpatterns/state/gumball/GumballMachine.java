package patterns.design.designpatterns.state.gumball;

public class GumballMachine {

    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;

    private State state;
    private int count;

    public GumballMachine(int count) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        this.count = count;
        state = (count > 0) ? noQuarterState : soldOutState;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
    }

    public void dispense() {
        state.dispense();
    }

    public void releaseBall() {
        if (count > 0) {
            System.out.println("A gumball comes rolling out the slot");
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    public void refill(int numGumBalls) {
        this.count = numGumBalls;
        state = noQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2024\n");
        result.append("Inventory: ").append(count).append(" gumball");
        if (count != 1) result.append("s");
        result.append("\nMachine is ").append(state.getClass().getSimpleName());
        return result.toString();
    }
}
