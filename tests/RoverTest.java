import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class RoverTest {
    Plateau plateau;

    @Before
    public void beforeTest() {
        plateau = new Plateau(5, 5);
    }

    @Test
    public void stringCastingTest() {
        Rover rover = new Rover(3, 3, 'S', plateau);

        assertEquals("3 3 S", rover.toString());
    }

    @Test
    public void turnLeftInstructionTest() {
        Rover rover = new Rover(3, 3, 'N', plateau);

        rover.turnLeft();
        assertEquals("3 3 W", rover.toString());
        rover.turnLeft();
        assertEquals("3 3 S", rover.toString());
        rover.turnLeft();
        assertEquals("3 3 E", rover.toString());
        rover.turnLeft();
        assertEquals("3 3 N", rover.toString());
    }

    @Test
    public void turnRightInstructionTest() {
        Rover rover = new Rover(3, 3, 'N', plateau);

        rover.turnRight();
        assertEquals("3 3 E", rover.toString());
        rover.turnRight();
        assertEquals("3 3 S", rover.toString());
        rover.turnRight();
        assertEquals("3 3 W", rover.toString());
        rover.turnRight();
        assertEquals("3 3 N", rover.toString());
    }

    @Test
    public void moveForwardInstructionTest() {
        Rover rover = new Rover(3, 3, 'N', plateau);

        rover.moveForward();
        assertEquals("3 4 N", rover.toString());

        rover.turnRight();
        rover.moveForward();
        assertEquals("4 4 E", rover.toString());

        rover.turnRight();
        rover.moveForward();
        assertEquals("4 3 S", rover.toString());

        rover.turnRight();
        rover.moveForward();
        assertEquals("3 3 W", rover.toString());
    }
}
