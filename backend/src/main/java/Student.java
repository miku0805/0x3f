class Student {
    static {
        System.out.println("Student 静态代码块");
    }

    {
        System.out.println("Student 构造代码块");
    }

    public Student() {
        System.out.println("Student 构造方法");
    }
}
