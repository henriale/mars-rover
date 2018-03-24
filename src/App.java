import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter your filename: ");

        Scanner SysScanner = new Scanner(System.in);
        String filename = SysScanner.nextLine();

        Reader reader = new Reader(filename);
        Plateau plateau = reader.readPlateau();
        RoverController controller = new RoverController(plateau, reader);

        controller.run();
    }
}
