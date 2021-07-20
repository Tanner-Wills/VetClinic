public class TestClinic {
    public static void main(String[] args) {

    Dog poopsie = new Dog("poopsie", 10, 3, 0);
    Cat cowboy = new Cat("Cowboy", 10, 10, 10);
    Cat johm = new Cat("John", 10, 10, 10);
        poopsie.speak();
        System.out.println(poopsie.getDroolRate());

        cowboy.speak();
        System.out.println(johm.equals(cowboy));
    }
}
