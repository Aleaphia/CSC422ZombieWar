package zombiewar;

public abstract class Weapon {
    protected String name;
    protected int damage;
    protected double accuracy;

    public Weapon(String name, int damage, double accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public boolean hitsTarget() {
        return Math.random() < accuracy;
    }

    @Override
    public String toString() {
        return name + " (Damage: " + damage + ", Accuracy: " + (int) (accuracy * 100) + "%)";
    }
}
