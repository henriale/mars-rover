import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    private Scanner fileScanner;

    public Reader(String filename) throws FileNotFoundException {
        fileScanner = new Scanner(new File(filename));
    }

    public Plateau readPlateau() {
        int width = fileScanner.nextInt();
        int height = fileScanner.nextInt();

        return new Plateau(width, height);
    }

    public Rover readRover(Plateau plateau) {
        int x = fileScanner.nextInt();
        int y = fileScanner.nextInt();
        String direction = fileScanner.next();

        return new Rover(x, y, direction.charAt(0), plateau);
    }

    public boolean hasRover() {
        return fileScanner.hasNextLine();
    }

    public String readInstructions() {
        return fileScanner.next();
    }
}
