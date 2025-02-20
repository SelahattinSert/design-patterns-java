package patterns.design.designpatterns.state.elevator;

public class Elevator {

    private ElevatorState currentState;
    private int currentFloor;

    public Elevator() {
        this.currentState = new StationaryState();
        this.currentFloor = 0;
    }

    // State management
    public void setState(ElevatorState state) {
        this.currentState = state;
    }

    // Floor management
    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveToFloor(int floor) {
        this.currentFloor = floor;
        System.out.println("Arrived at floor " + floor);
        this.setState(new StationaryState());
    }

    // Request handling
    public void pressButton(int destinationFloor) {
        currentState.pressButton(this, destinationFloor);
    }

}
