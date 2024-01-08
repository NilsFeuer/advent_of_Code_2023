package day16;

public class Beam {

    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int WEST = 2;
    public static final int SOUTH = 3;
    private int x;
    private int y;
    private int direction;


    public Beam(int xStart, int yStart, int direction) {
        this.x = xStart;
        this.y = yStart;
        this.direction = direction;
    }

    public void move(int direction) {
        if (direction == NORTH) {
            this.direction = NORTH;
            y--;
        }
        if (direction == SOUTH) {
            this.direction = SOUTH;
            y++;
        }
        if (direction == EAST) {
            this.direction = EAST;
            x++;
        }
        if (direction == WEST) {
            this.direction = WEST;
            x--;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }
}
