package Model;

public class PersonalContact extends Contact{
    public PersonalContact(String name, String number)  {
        super(name , number , ContactType.PERSONAL);
    }

}