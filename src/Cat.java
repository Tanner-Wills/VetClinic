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
        int treatTime;
        if (this.miceCaught < 4) {
            treatTime = ((int) ((this.getPainLevel() * 2) / this.getHealth()));
        } else if (this.getMiceCaught() >= 4 && this.getMiceCaught() <= 7) {
            treatTime = ((int) (this.getPainLevel() / this.getHealth()));
        } else {
            treatTime = ((int) (this.getPainLevel() / (this.getHealth() * 2)));
        }
        return treatTime;
    }

    @Override
    public void speak(){
        String meow = "meow ".repeat(this.getMiceCaught()).trim();
        meow = this.getMiceCaught() > 5 ? meow.toUpperCase(Locale.ROOT) : meow;
        super.speak();
        System.out.println(meow + "\n");
    }

    public boolean equals(Object o){
        return super.equals(o) && this.getMiceCaught() == getMiceCaught();
    }


}
