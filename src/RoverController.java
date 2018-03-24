public class RoverController {
    private Plateau plateau;
    private Reader reader;

    public RoverController(Plateau plateau, Reader reader) {
        this.plateau = plateau;
        this.reader = reader;
    }

    public void run() {
        while (reader.hasRover()) {
            Rover rover = controlRover(reader.readRover(plateau));
            System.out.println(rover.toString());
        }
    }

    private Rover controlRover(Rover rover) {
        String instructions = reader.readInstructions();

        for (int i = 0; i < instructions.length(); i++) {
            rover.listenInstruction(instructions.charAt(i));
        }

        return rover;
    }
}
