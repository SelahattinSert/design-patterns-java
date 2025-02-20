package patterns.design.designpatterns.state.elevator;

public class ElevatorTest {

    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        System.out.println("Initial floor: " +
                elevator.getCurrentFloor());
        elevator.pressButton(5);
        elevator.pressButton(2);
        elevator.pressButton(3);
        elevator.pressButton(6);
        elevator.pressButton(3);
    }
}
