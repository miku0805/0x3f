package com.experiment;

public abstract class Character {
    private String id;
    private int health;

    public Character(String id, int health) {
        this.id = id;
        this.health = health;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void move();
}