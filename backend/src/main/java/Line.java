class Line extends Point{
    protected int x,y;
    Line(int a,int b){
        Point point = new Point(a,b);
        setLine(a,b);
    }
    public void setLine(int x,int y)  {
        this.x=x+x;
        this.y=y+y;
    }
    public double length(){
        int x1=super.x,y1=super.y,x2=this.x,y2=this.y;
        return Math.sqrt((x2-21)*(x2-x1)+(y2-y1)*(y2-y1));
    }
    public String toString(){
        return "直线端点：["+super.x+","+super.y+"]["+x+","+y+"]直线长度："+this.length();
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
}
