import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.util.List;

public class Clinic {

    //Variables
    File patientFile;
    private int day;


    //Constructor
    public Clinic(File file) {
        this.patientFile = file;

    }

    public Clinic(String filename) {
        this(new File(filename));

    }

    //Clinic Methods
    public String nextDay(File f) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(String.valueOf(f)));
        scanner.useDelimiter(",");

        String appoint = "Consultation for " + scanner.next() + " the " + scanner.next() + " at " + scanner.next() + ".\nWhat is the health of " + scanner.next() + "?\n";
        System.out.println(appoint);
        scanner.close();

        return appoint;
    }
    public String nextDay(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        String patient = null;
        while(scanner.hasNextLine()){
            patient = scanner.nextLine();

            String[] token = patient.split(",");
            String name = token[0];
            String typeOfPet = token[1];
            if(typeOfPet == "Cat"){
                String droolRate = token[2];
                //double droolRate = Double.parseDouble(token[2]);
            } else {
                String miceCaught = token[2];
                //int miceCaught = Integer.parseInt(token[2]);
            }
            String time = token[3];
            
            String appoint = "Consultation for " + name + " the " + typeOfPet + " at " + time + ".\nWhat is the health of " + name + "?\n";
            System.out.println(appoint);
        }



        //scanner.useDelimiter(",");
        //String appoint = "Consultation for " + scanner.next() + " the " + scanner.next() + " at " + scanner.next() + ".\nWhat is the health of " + scanner.next() + "?\n";
        scanner.close();

        return patient;
    }
}