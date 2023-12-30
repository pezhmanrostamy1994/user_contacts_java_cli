package Model;

public class BusinessContact extends  Contact{
    private  String _fax;

    public BusinessContact(String name, String number,String fax)  {
        super(name , number , ContactType.BUSINESS);
        this._fax = fax;
    }

    public String getFax() {
        return _fax;
    }

    public void setFax(String fax) {
        _fax = fax;
    }

    @Override
    public String toString() {
        return super.toString() + " Fax: " + _fax;
    }
}