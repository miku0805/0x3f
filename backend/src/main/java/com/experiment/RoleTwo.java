package com.experiment;

import cn.gdpu.FightingSkills;

public class RoleTwo extends Character implements FightingSkills{
    public RoleTwo(String id, int health) {
        super(id, health);
    }

    @Override
    public void move() {
        System.out.println(getId() + " is moving.");
    }

    @Override
    public void surDragonPalm() {

    }

    @Override
    public void sixPulseSowrd() {
        System.out.println(getId() + " is using sixPulseSowrd.");
    }

    @Override
    public void oneSunFinger() {

    }
}