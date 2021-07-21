import java.io.FileNotFoundException;

public class TestClinic {
    public static void main(String[] args) throws FileNotFoundException {

        Clinic happy = new Clinic("C:\\Users\\dvuf0zn\\IdeaProjects\\VetClinic\\Appointments.csv");
        happy.nextDay("C:\\Users\\dvuf0zn\\IdeaProjects\\VetClinic\\Appointments.csv");

    }
}
