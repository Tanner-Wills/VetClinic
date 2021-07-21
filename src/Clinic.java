import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class Clinic {

    //Variables
    File patientFile;
    private int day;


    //Constructor
    public Clinic(File file) {
        this.patientFile = file;
        day = 1;
    }

    public Clinic(String filename) {
        this(new File(filename));
        day = 1;
    }

    //Clinic Methods
    public String nextDay(File f) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(String.valueOf(f)));
        scanner.useDelimiter(",");

        return "a";
    }
    public String nextDay(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        String patient = null;

        //Loop through file to obtain information from patients and assign to variables.
        while(scanner.hasNextLine()){
            patient = scanner.nextLine();
            String[] token = patient.split(",");
            String name = token[0];
            String typeOfPet = token[1];
            if(typeOfPet == "Dog"){
                double droolRate = Double.parseDouble(token[2]);
            } else if (typeOfPet == "Cat") {
                int miceCaught = Integer.parseInt(token[2]);
            }
            String military = token[3];


            //Print initial message from Clinic
            String appoint = "Consultation for " + name + " the " + typeOfPet + " at " + milTime(military) + ".\nWhat is the health of " + name + "?\n";
            System.out.println(appoint);

            //Request user input for health of patient
            int healthFind = 0;
            Scanner inputHealth = new Scanner(System.in);
            while(healthFind < 1){
                if(inputHealth.hasNextInt()){
                    int health = inputHealth.nextInt();
                    healthFind = 1;
                } else {
                    System.out.println("Please enter a number\nWhat is the health of" + name + "?");
                    inputHealth.nextLine();
                }
            }

            //Request user input for pain of patient
            System.out.println("On a scale of 1 to 10, how much pain is " + name + " in right now? \n");
            int painFind = 0;
            Scanner inputPain = new Scanner(System.in);
            while(painFind < 1){
                if(inputPain.hasNextInt()){
                    int pain = inputPain.nextInt();
                    painFind = 1;
                } else {
                    System.out.println("Please enter a number\nOn a scale of 1 to 10, how much pain is " + name + " in right now? \n");
                    inputPain.nextLine();
                }
            }
        }
        scanner.close();
        return patient;
    }




    private String milTime(String military){
        String hours;
        String minutes;
        int hour0 = Integer.parseInt(Character.toString(military.charAt(0)));
        int hour1 = Integer.parseInt(Character.toString(military.charAt(1)));
        String hour0str = Character.toString(military.charAt(0));
        String hour1str = Character.toString(military.charAt(1));
        String hour2str = Character.toString(military.charAt(2));
        String hour3str = Character.toString(military.charAt(3));

            //for times greater than 1200
        if(hour0 > 0 && hour1 > 2){
            hours = String.valueOf(Integer.parseInt((hour0str + hour1str)) - 12);
            minutes = hour2str + hour3str + " pm";

            //for times between 1200 and 1300
        } else if (hour0 > 0 && hour1 == 2){
            hours = hour0str + hour1str;
            minutes = hour2str + hour3str + " pm";

            //for times between 1000 and 1159
        } else if (hour0 > 0 && hour1 < 2){
            hours = hour0str + hour1str;
            minutes = hour2str + hour3str + " am";

            //for times less than 1000
        } else {
            hours = hour1str;
            minutes = hour2str + hour3str + " am";
        }
        return military = hours + ":" + minutes;
    }

}