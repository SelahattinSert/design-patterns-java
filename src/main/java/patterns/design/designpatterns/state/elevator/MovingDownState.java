package patterns.design.designpatterns.state.elevator;

public class MovingDownState implements ElevatorState {

    @Override
    public void pressButton(Elevator elevator, int destinationFloor) {
        int currentFloor = elevator.getCurrentFloor();

        if (destinationFloor < currentFloor) {
            System.out.println("Already moving down. Adding floor " +
                    destinationFloor + " to queue");
        } else {
            System.out.println("Cannot process request for floor " +
                    destinationFloor + " while moving down");
        }
    }

}
