public class Rectangle {
    Integer l;
    Integer r;

    public Rectangle() {
        this.l = 0;
        this.r = 0;
    }
    public Rectangle(Integer l,Integer r)
    {
        this.l = l;
        this.r = r;
    }
    public Integer circumference() {
        return (l + r ) * 2;
    }
    public Integer area() {
        return l * r;
    }
}
