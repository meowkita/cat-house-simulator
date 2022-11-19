package io.meowkita.catsimulator.cat;

import java.util.Random;

public class Cat {

    private final String name;
    private final int age;
    private int satiety;
    private int happiness;
    private int health;

    public Cat(String name, int age) {
        this(name, age, 50, 50, 50);
    }

    public Cat(String name, int age, int satiety, int happiness, int health) {
        this.name = name;
        this.age = age;
        this.satiety = satiety;
        this.happiness = happiness;
        this.health = health;
    }

    protected Cat(Cat cat) {
        this(cat.name, cat.age, cat.satiety, cat.happiness, cat.health);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSatiety() {
        return satiety;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHealth() {
        return health;
    }

    public void play(int amount) {
        increaseHappiness(amount);
        decreaseSatiety((int) (amount * 0.15));
        decreaseHealth((int) (amount * 0.15));
    }

    public void feed(int amount) {
        decreaseHappiness((int) (amount * 0.15));
        increaseSatiety(amount);
        decreaseHealth((int) (amount * 0.15));
    }

    public void heal(int amount) {
        decreaseHappiness((int) (amount * 0.15));
        decreaseSatiety((int) (amount * 0.15));
        increaseHealth(amount);
    }

    public void sleep(int amount) {
        decreaseHappiness(amount);
        decreaseSatiety(amount);
        decreaseHealth(amount);
    }

    public int getStatsAverage() {
        return (health + happiness + satiety) / 3;
    }

    private void increaseSatiety(int amount) {
        int newSatiety = satiety + amount;
        this.satiety = Math.min(100, newSatiety);
    }

    private void decreaseSatiety(int amount) {
        int newSatiety = satiety - amount;
        this.satiety = Math.max(0, newSatiety);
    }

    private void increaseHappiness(int amount) {
        int newHappiness = happiness + amount;
        this.happiness = Math.min(100, newHappiness);
    }

    private void decreaseHappiness(int amount) {
        int newHappiness = happiness - amount;
        this.happiness = Math.max(0, newHappiness);
    }

    private void increaseHealth(int amount) {
        int newHealth = health + amount;
        this.health = Math.min(100, newHealth);
    }

    private void decreaseHealth(int amount) {
        int newHealth = health - amount;
        this.health = Math.max(0, newHealth);
    }

    public static class CatBuilder {

        private String name;
        private int age;
        private int satiety;
        private int happiness;
        private int health;

        public CatBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CatBuilder age(int age) {
            age = Math.min(17, age);
            age = Math.max(1, age);
            this.age = age;
            return this;
        }

        public CatBuilder satiety(int satiety) {
            this.satiety = satiety;
            return this;
        }

        public CatBuilder happiness(int happiness) {
            this.happiness = happiness;
            return this;
        }

        public CatBuilder health(int health) {
            this.health = health;
            return this;
        }

        public CatBuilder randomStats() {
            Random random = new Random();
            this.satiety = random.nextInt(60) + 20;
            this.happiness = random.nextInt(60) + 20;
            this.health = random.nextInt(60) + 20;
            return this;
        }

        public Cat build() {
            return new Cat(name, age, satiety, happiness, health);
        }

    }

}
