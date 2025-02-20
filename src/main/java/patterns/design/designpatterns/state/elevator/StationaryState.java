package patterns.design.designpatterns.state.elevator;

public class StationaryState implements ElevatorState {

    @Override
    public void pressButton(Elevator elevator, int destinationFloor) {
        int currentFloor = elevator.getCurrentFloor();

        if (destinationFloor > currentFloor) {
            // Transition to moving up state
            System.out.println("Moving upward from floor " + currentFloor);
            elevator.setState(new MovingUpState());
            elevator.moveToFloor(destinationFloor);
        } else if (destinationFloor < currentFloor) {
            // Transition to moving down state
            System.out.println("Moving downward from floor " + currentFloor);
            elevator.setState(new MovingDownState());
            elevator.moveToFloor(destinationFloor);
        } else {
            System.out.println("Already on floor " + currentFloor);
        }
    }
}
