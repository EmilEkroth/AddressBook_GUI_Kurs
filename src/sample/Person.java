package sample;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.stream.Stream;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String postCode;
    private String city;

    public int nr;

    public Person(int nr){
        this.nr=nr;
    }

    //TODO defensiv kopiering:
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
