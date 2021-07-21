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
            if(typeOfPet == "Dog"){
                String droolRate = token[2];
                //double droolRate = Double.parseDouble(token[2]);
            } else if (typeOfPet == "Cat") {
                String miceCaught = token[2];
                //int miceCaught = Integer.parseInt(token[2]);
            }
            String military = token[3];

            String appoint = "Consultation for " + name + " the " + typeOfPet + " at " + miltime(military) + ".\nWhat is the health of " + name + "?\n";
            System.out.println(appoint);
        }
        scanner.close();
        return patient;
    }


    private String miltime(String military){
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