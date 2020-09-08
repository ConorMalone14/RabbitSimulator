package com.spartaglobal.RabbitSimulator.Rabbit;

public class Rabbit {

    private int age;
    private boolean male;

    public Rabbit() {
        age = 0;
    }

    public boolean isExpired() {
        if(age > 60){
            return true;
        }
        return false;
    }

    public boolean isEligible() {
        if(age >= 3 && age <= 60){
            return true;
        } return false;
    }

    public void incrementAge() {
        age++;
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
