package com.experiment;

import cn.gdpu.FightingSkills;

public class RoleOne extends Character implements FightingSkills{
    public RoleOne(String id, int health) {
        super(id, health);
    }

    @Override
    public void move() {
        System.out.println(getId() + " is moving.");
    }

    @Override
    public void surDragonPalm() {
        System.out.println(getId() + " is using surDragonPalm.");
    }

    @Override
    public void sixPulseSowrd() {

    }

    @Override
    public void oneSunFinger() {

    }
}