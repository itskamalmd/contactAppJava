public class Contact{
    // 10 digit number cannot be sotred in int variable to storing it in a String typed variable
    private String name;
    private String number;
    private String mailId;

    // constructor 
    Contact(String name,String number,String mailId){
        this.name = name;
        this.number = number;
        this.mailId = mailId;
    }
    // getter setter
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public void setMailId(String mailId){
        this.mailId = mailId;
    }
    public String getName(){
        return name;
    }
    public String getNumber(){
        return number;
    }
    public String getMailId(){
        return mailId;
    }
    // this methods return the current contact working
    public Contact editContact (String name,String number,String mailId){
        this.name = name;
        this.number = number;
        this.mailId = mailId;

        return this;
    }
    public String toString(){
        return "Name : " + this.name + ", Number : " + this.number + ", Mail Id: " + this.mailId;
    }
    
}