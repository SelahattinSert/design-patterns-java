package patterns.design.designpatterns.state.elevator;

public interface ElevatorState {
    void pressButton(Elevator elevator, int destinationFloor);
}
