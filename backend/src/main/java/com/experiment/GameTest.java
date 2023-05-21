package com.experiment;

public class GameTest {
    public static void main(String[] args) {
        RoleOne roleOne = new RoleOne("Role One", 100);
        RoleTwo roleTwo = new RoleTwo("Role Two", 200);
        RoleThree roleThree = new RoleThree("Role Three", 300);

        // 测试获取和设置角色id和health属性的方法
        System.out.println(roleOne.getId());
        System.out.println(roleOne.getHealth());
        roleOne.setId("New Role One");
        roleOne.setHealth(150);
        System.out.println(roleOne.getId());
        System.out.println(roleOne.getHealth());

        // 测试角色移动方法
        roleOne.move();
        roleTwo.move();
        roleThree.move();

        // 测试角色必杀技方法
        roleOne.surDragonPalm();
        roleTwo.sixPulseSowrd();
        roleThree.oneSunFinger();
    }
}