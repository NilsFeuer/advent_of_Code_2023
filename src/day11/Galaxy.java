package day11;

public class Galaxy {

    private int x;
    private int y;
    private int numberOfGalaxy;

    public Galaxy(int numberOfGalaxy, int x, int y) {
        this.numberOfGalaxy = numberOfGalaxy;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumberOfGalaxy() {
        return numberOfGalaxy;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
