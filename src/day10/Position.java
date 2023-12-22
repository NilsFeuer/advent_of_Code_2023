package day10;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Position {
    public static int NORTH = 0;
    public static int SOUTH = 1;
    public static int EAST = 2;
    public static int WEST = 3;
    private int x;
    private int y;
    private int direction;
    private long count;

    private GeneralPath gp = new GeneralPath(GeneralPath.WIND_EVEN_ODD);

    private boolean canMove = true;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;

        gp.moveTo((x + 1) * 10, (y + 1) * 10);
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
        gp.lineTo((x + 1) * 10, (y + 1) * 10);
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

    public int getArea(boolean[] visited) throws IOException {
        int MAP_SIZE = 140;

        BufferedImage bi = new BufferedImage(2000, 2000, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = (Graphics2D) bi.getGraphics();
        g.setBackground(Color.WHITE);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 2000, 2000);
        g.setColor(Color.BLACK);
        g.draw(gp);

        int area = 0;
        for (int y = 0; y < MAP_SIZE; y++) {
            for (int x = 0; x < MAP_SIZE; x++) {
                if (!visited[y * MAP_SIZE + x]) {
                    if (gp.contains((x + 1) * 10 + 1, (y + 1) * 10 + 1, 8, 8)) {
                        area += 1;
                        g.fillRect((x + 1) * 10 + 1, (y + 1) * 10 + 1, 8, 8);
                    }
                }
            }
        }
        g.dispose();
        ImageIO.write(bi, "PNG", new File("img.png"));
        return area;
    }
}
