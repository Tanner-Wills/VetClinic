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
        Scanner scanner = new Scanner("C:\\Users\\dvuf0zn\\IdeaProjects\\VetClinic\\Appointments.csv");
        scanner.useDelimiter(",");
        String appoint = "Consultation for " + scanner.next() + " the " + scanner.next() + " at " + scanner.next() + ".\nWhat is the health of " + scanner.next() + "?\n";
        System.out.println(appoint);
        scanner.close();

        return appoint;
    }
    public String nextDay(String filename){
        Scanner scanner = new Scanner("C:\\Users\\dvuf0zn\\IdeaProjects\\VetClinic\\Appointments.csv");
        scanner.useDelimiter(",");
        String appoint = "Consultation for " + scanner.next() + " the " + scanner.next() + " at " + scanner.next() + ".\nWhat is the health of " + scanner.next() + "?\n";
        System.out.println(appoint);
        scanner.close();

        return appoint;
    }
}