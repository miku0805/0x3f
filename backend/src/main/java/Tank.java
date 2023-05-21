public class Tank {
    private int x;
    private int y;
    private int direction;
    private int speed;
    private boolean isAlive;
    private String color;

    public Tank(int x, int y, int direction, int speed, boolean isAlive, String color) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
        this.isAlive = isAlive;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tank) {
            Tank other = (Tank) obj;
            return this.x == other.x && this.y == other.y;
        }
        return false;
    }
}