import Controller.RunController;
import Service.Contact.ContactService;

import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        var runService = new RunController();
        runService.runContactHandller("");
    }

}
