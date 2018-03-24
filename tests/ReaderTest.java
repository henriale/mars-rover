import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class ReaderTest {
    @Test
    public void ValidFileTest() throws FileNotFoundException {
        Reader reader = new Reader("test_input.txt");
        assertThat(reader, instanceOf(Reader.class));
    }

    @Test(expected = FileNotFoundException.class)
    public void InvalidFileTest() throws FileNotFoundException {
        new Reader("invalidFileName.txt");
    }

    @Test
    public void plateauBoundsTest() throws FileNotFoundException {
        Reader reader = new Reader("test_input.txt");
        Plateau plateau = reader.readPlateau();

        assertThat(plateau, instanceOf(Plateau.class));
        assertTrue(plateau.isCoordinatesOutOfBounds(0, -1));
        assertTrue(plateau.isCoordinatesOutOfBounds(-1, 0));
        assertTrue(plateau.isCoordinatesOutOfBounds(0, 6));
        assertTrue(plateau.isCoordinatesOutOfBounds(6, 0));

        assertFalse(plateau.isCoordinatesOutOfBounds(0, 0));
        assertFalse(plateau.isCoordinatesOutOfBounds(0, 5));
        assertFalse(plateau.isCoordinatesOutOfBounds(5, 0));
        assertFalse(plateau.isCoordinatesOutOfBounds(5, 5));
    }
}
