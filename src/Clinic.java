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
        String patient = "";
        String petData = "";
        Pet patientPet = null;
        String miceDrool = "";

        //Loop through file to obtain information from patients and assign to variables.
        while(scanner.hasNextLine()){
            patient = scanner.nextLine();
            String[] token = patient.split(",");
            String name = token[0];
            String typeOfPet = token[1];
            String military = token[3];

            //Print initial message from Clinic
            String appoint = "Consultation for " + name + " the " + typeOfPet + " at " + milTime(military) + ".\nWhat is the health of " + name + "?\n";
            System.out.println(appoint);

            //Request user input for health of patient
            double health = userData();

            //Request user input for pain of patient
            System.out.println("On a scale of 1 to 10, how much pain is " + name + " in right now? \n");
            int painLevel = ((int)userData());

            //Determine Class type of patient
            if(typeOfPet.equals("Dog")){
                double droolRate = Double.parseDouble(token[2]);
                miceDrool = String.valueOf(droolRate);
                patientPet = new Dog(name, health, painLevel, droolRate);

            } else if (typeOfPet.equals("Cat")){
                int miceCaught = Integer.parseInt(token[2]);
                miceDrool = String.valueOf(miceCaught);
                patientPet = new Cat(name, health, painLevel, miceCaught);
            }

            //Have patient speak
            patientPet.speak();

            //Calculate time to treat the patient
            int timeToTreat = patientPet.treat();
            String timeFinish = addTime(military, timeToTreat);

            //Append patient data to string
            petData += String.join(",",name, typeOfPet, miceDrool, "Day " + day, military, timeFinish, String.valueOf(patientPet.getHealth()), String.valueOf(patientPet.getPainLevel()) + "\n");
            patientPet.treat();
            day += 1;

        }

        scanner.close();
        System.out.println(petData);
        return petData;
    }


    public boolean addToFile(String patientInfo){
        return true;
    }
    private double userData(){
        boolean success = false;

        Scanner userIn = new Scanner(System.in);
        while(!success){
            if(userIn.hasNextDouble()){
                success = true;
            } else {
                System.out.println("Please enter a number.");
                userIn.nextLine();
            }
        }
        return userIn.nextDouble();
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

    private String addTime(String timeIn, int treatmentTime){
        String outTime = String.valueOf(Integer.parseInt(timeIn) + treatmentTime);
        if(Integer.parseInt(outTime) < 1000){
            outTime = "0" + outTime;
        }
        return outTime;
    }

}