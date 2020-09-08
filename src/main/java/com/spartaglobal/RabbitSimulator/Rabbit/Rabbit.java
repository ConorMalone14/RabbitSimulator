package com.spartaglobal.RabbitSimulator.Rabbit;

public class Rabbit {

    private int age;
    private boolean male;

    public boolean isExpired() {
        return true;
    }

    public boolean isEligible() {
        return true;
    }

    public void incrementAge() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}
