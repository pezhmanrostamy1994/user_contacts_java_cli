package Model;

public  class Contact {
    private  String _name;

    private  String _number;
    private final ContactType _contactType;

    public Contact(String name, String number,ContactType contactType) {
        this._name = name;
        this._number = number;
        this._contactType = contactType;

    }

    public String getName() {
        return _name;
    }

    public String getNumber() {
        return _number;
    }
    public void setNumber(String number) {
        this._number = number;
    }
    public ContactType getContactType() {
        return _contactType;
    }

    @Override
    public String toString() {
        return "Contact : " +
                "_name='" + _name + '\'' +
                ", _number='" + _number + '\'' +
                ", _contactType=" + _contactType +  '\'' 
                ;
    }



}