import java.util.Locale;

public class Dog extends Pet {

    //Instance Variables
    private double droolRate;

    //Constructors
    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = Math.max(droolRate, 0.5);

    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);

    }

    //Getters
    public double getDroolRate() {
        return this.droolRate;
    }

    //Setters
    public void setDroolRate() {
        this.droolRate = droolRate;
    }

    //Dog Methods
    @Override
    public int treat() {
        super.heal();
        int treatTime;
        if (this.droolRate < 3.5) {
            treatTime = ((int) ((this.getPainLevel() * 2) / this.getHealth()));
        } else if (this.droolRate >= 3.5 && this.droolRate <= 7.5) {
            treatTime = ((int) (this.getPainLevel() / this.getHealth()));
        } else {
            treatTime = ((int) (this.getPainLevel() / (this.getHealth() * 2)));
        }
        return treatTime;
    }

    @Override
    public void speak() {
        String bark = "bark ".repeat(this.getPainLevel()).trim();
        bark = this.getPainLevel() > 5 ? bark.toUpperCase(Locale.ROOT): bark;
        super.speak();
        System.out.println(bark + "\n");
        }

    @Override
    public boolean equals(Object o){
        return super.equals(o) && this.droolRate == getDroolRate();
    }

}