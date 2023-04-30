package seminar3;

import javax.xml.crypto.Data;

public class DataBase {
    private String lastName;
    private String firstName;
    private String patronymicName;
    private String birthDate;
    private String phone;
    private String gender;
    public DataBase(String lastName,String firstName ,String patronymicName, String birthDate,String phone,String gender){
        this.lastName=lastName;
        this.firstName=firstName;
        this.patronymicName=patronymicName;
        this.birthDate=birthDate;
        this.phone=phone;
        this.gender=gender;
    }

    @Override
    public String toString() {
        return "<" + lastName +">"+
                "<" + firstName +">"+
                "<" + patronymicName +">"+
                "<" + birthDate +">"+
                "<" + phone +">"+
                "<" + gender +">";
    }
    public String getLastName(){
        return lastName;
    }
}
