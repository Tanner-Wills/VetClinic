import java.util.Locale;

public class Cat extends Pet {

    //Variables
    private int miceCaught;

    //Constructors
    public Cat(String name, double health, int painLevel) {
        this(name,health,painLevel, 0);
    }

    public Cat(String name, double health, int painLevel, int miceCaught){
        super(name, health, painLevel);
        this.miceCaught = Math.max(miceCaught, 0);
    }

    //Getters
    public int getMiceCaught(){
        return this.miceCaught;
    }

    //Setters
    public void setMiceCaught(){
        this.miceCaught = miceCaught;
    }

    //Cat Methods
    @Override
    public int treat(){
        super.heal();
        int treatment;
        if (this.miceCaught < 4) {
            treatment = ((int) ((this.getPainLevel() * 2) / this.getHealth()));
        } else if (this.getMiceCaught() >= 4 && this.getMiceCaught() <= 7) {
            treatment = ((int) (this.getPainLevel() / this.getHealth()));
        } else {
            treatment = ((int) (this.getPainLevel() / (this.getHealth() * 2)));
        }
        return treatment;
    }

    @Override
    public void speak(){
        String meow = "meow ".repeat(this.getMiceCaught()).trim();
        meow = this.getMiceCaught() > 5 ? meow.toUpperCase(Locale.ROOT) : meow;
        super.speak();
        System.out.println(meow);
    }

    public boolean equals(Object o){
        return super.equals(o) && this.getMiceCaught() == getMiceCaught();
    }


}
