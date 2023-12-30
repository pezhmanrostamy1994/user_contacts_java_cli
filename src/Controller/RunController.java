package Controller;

import Service.Contact.ContactService;
import Service.Contact.IContactService;

import java.util.Scanner;

public class RunController {
    public void runContactHandller(String service){
        if(service.equalsIgnoreCase("contact") || service.isEmpty() ){
            IContactService contactService =  new ContactService(new Scanner(System.in));
            contactService.run();
        }


    }
}
