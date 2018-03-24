public class Rover {
    private int x;
    private int y;
    private char direction;
    private Plateau plateau;

    public Rover(int x, int y, char direction, Plateau plateau) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.plateau = plateau;
    }

    public void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'E':
                direction = 'N';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'W':
                direction = 'S';
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    public void moveForward() {
        switch (direction) {
            case 'N':
                if (!plateau.isCoordinatesOutOfBounds(x, y + 1)) {
                    y++;
                }
                break;
            case 'E':
                if (!plateau.isCoordinatesOutOfBounds(x + 1, y)) {
                    x++;
                }
                break;
            case 'S':
                if (!plateau.isCoordinatesOutOfBounds(x, y - 1)) {
                    y--;
                }
                break;
            case 'W':
                if (!plateau.isCoordinatesOutOfBounds(x - 1, y)) {
                    x--;
                }
                break;
        }
    }

    public void listenInstruction(char instruction) {
        switch (instruction) {
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'M':
                moveForward();
                break;
        }
    }

    public String toString() {
        return x + " " + y + " " + direction;
    }
}
