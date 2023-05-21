package com.experiment;

import cn.gdpu.FightingSkills;

public class RoleThree extends Character implements FightingSkills{
    public RoleThree(String id, int health) {
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

    }

    @Override
    public void oneSunFinger() {
        System.out.println(getId() + " is using oneSunFinger.");
    }
}