package day10;

public class Position {
    public static int NORTH = 0;
    public static int SOUTH = 1;
    public static int EAST = 2;
    public static int WEST = 3;
    private int x;
    private int y;
    private int direction;
    private long count;

    private boolean canMove = true;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getCount() {
        return count;
    }

    public void move(int direction) {
        count++;
        this.direction = direction;
        if (direction == NORTH) {
            y++;
        }
        if (direction == SOUTH) {
            y--;
        }
        if (direction == WEST) {
            x--;
        }
        if (direction == EAST) {
            x++;
        }
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public int getDirection() {
        return direction;
    }
}
