public abstract class Pet {

    //Instance Variables
    private String name;
    private double health; //percentage value from 0.0 to 1.0
    private int painLevel; //ranges from 1 to 10

    //Constructor
    public Pet(String name, double health, int painLevel){
        this.name = name;
        this.health = health;
        this.painLevel = painLevel;

        if(this.health > 1.0){
            this.health = 1.0;
        } else if (this.health < 0){
            this.health = 0.0;
        }

        if(this.painLevel > 10){
            this.painLevel = 10;
        } else if (this.painLevel < 0){
            this.painLevel = 0;
        }
    }

    //Getters
    public double getHealth(){
        return this.health;
    }
    public int getPainLevel(){
        return this.painLevel;
    }
    public String getName(){
        return this.name;
    }

    //Setters
    public void setHealth(){
        this.health = health;
    }
    public void setPainLevel(){
        this.painLevel = painLevel;
    }

    //Pet Methods
    abstract int treat();

    public void speak(){
        String message = "Hello! My name is " + this.name;
        if(this.painLevel > 5){
            System.out.println(message.toUpperCase());
        } else {
            System.out.println(message);
        }
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Pet){
            return ((Pet) o).getName() == this.name;
        }
        return false;
    }

    protected void heal(){
        this.health = 1.0;
        this.painLevel = 0;
    }

}
