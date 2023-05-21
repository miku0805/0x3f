import java.util.LinkedList;

public class TankTest {
    public static void main(String[] args) {
        Tank tank1 = new Tank(10, 20, 0, 1, true, "red");
        Tank tank2 = new Tank(20, 30, 1, 2, true, "blue");
        Tank tank3 = new Tank(10, 20, 2, 3, true, "green");
        Tank tank4 = new Tank(40, 50, 3, 4, true, "yellow");
        Tank tank5 = new Tank(30, 40, 0, 5, true, "pink");
        Tank tank6 = new Tank(10, 20, 1, 6, true, "orange");

        LinkedList<Tank> tanks = new LinkedList<>();
        tanks.add(tank1);
        tanks.add(tank2);
        tanks.add(tank3);
        tanks.add(tank4);
        tanks.add(tank5);
        tanks.add(tank6);

        for (int i = 0; i < tanks.size(); i++) {
            for (int j = i + 1; j < tanks.size(); j++) {
                if (tanks.get(i).equals(tanks.get(j))) {
                    tanks.remove(j);
                    j--;
                }
            }
        }
        
        for (Tank tank : tanks) {
            System.out.println("x: " + tank.getX() + ", y: " + tank.getY() + ", direction: " + tank.getDirection()
                    + ", speed: " + tank.getSpeed() + ", isAlive: " + tank.isAlive() + ", color: " + tank.getColor());
        }
    }
}