package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

public class Controller {
    protected File file=new File("Resources");
    private String filePath= file.getAbsolutePath();


    public Person currentPerson = new Person(0); //TODO fix list
    public   List<Person> people = new ArrayList<Person>(1);

    @FXML public ImageView new24pic;
    @FXML public ImageView new16pic;
    @FXML public ImageView delete24pic;
    @FXML public ImageView delete16pic;
    @FXML public ImageView flagpic;

    @FXML public Button newButton;
    @FXML public Button deleteButton;
    public ListView personList;
    public List<Button> personbutton = new ArrayList(){};
    public TextField fieldFirst;
    public TextField fieldLast;
    public TextField fieldPhone;
    public TextField fieldEmail;
    public TextField fieldPost;
    public TextField fieldCity;
    public TextField fieldAddress;


    public void initialize(){
        try {
            flagpic.setImage(new Image(new FileInputStream(filePath+"/UKflag.png")));
            new24pic.setImage(new Image(new FileInputStream(filePath+"/New24.gif")));
            new16pic.setImage(new Image(new FileInputStream(filePath+"/New16.gif")));
            delete16pic.setImage(new Image(new FileInputStream(filePath+"/Delete16.gif")));
            delete24pic.setImage(new Image(new FileInputStream(filePath+"/Delete24.gif")));
        }
        catch (FileNotFoundException e) {
                e.printStackTrace();
            }

    }
    public void handleUpdate()
    { //This function is called upon when a text field is edited.

        currentPerson.setFirstName(fieldFirst.getText());
        currentPerson.setLastName(fieldLast.getText());
        currentPerson.setPhone(fieldPhone.getText());
        currentPerson.setEmail(fieldEmail.getText());
        currentPerson.setPostCode(fieldPost.getText());
        currentPerson.setCity(fieldCity.getText());
        currentPerson.setAdress(fieldAddress.getText());

        personbutton.get(currentPerson.nr).setText(currentPerson.getFirstName() +" "+ currentPerson.getLastName());
    }

    void UpdateFields ()
    {
        fieldFirst.setText(currentPerson.getFirstName());
        fieldLast.setText(currentPerson.getLastName());
        fieldPhone.setText(currentPerson.getPhone());
        fieldEmail.setText(currentPerson.getEmail());
        fieldPost.setText(currentPerson.getPostCode());
        fieldCity.setText(currentPerson.getCity());
        fieldAddress.setText(currentPerson.getAdress());

    }

    @FXML
    private void changePerson (Person p)
    {
        currentPerson = p;
        UpdateFields();
    }

    public void handleNewPerson ()
    {
        int i = personbutton.size();
        people.add(new Person(i));
        personbutton.add(new Button());
        personbutton.get(i).setOnAction(e -> changePerson(people.get(i)));
        personbutton.get(i).setText("blank");
        personbutton.get(i).setMaxSize(125,20);
        personbutton.get(i).setLayoutX(13);
        personList.getItems().add(personbutton.get(i));
    }
    public void deletePerson(){
        if(currentPerson==null) return;
        people.remove(currentPerson);
        personbutton.remove(currentPerson.nr);
        personList.getItems().remove(currentPerson.nr);
        for (int k=currentPerson.nr;k<people.size();k++ ) {
            people.get(k).nr--;
            int tmp = k;
            personbutton.get(k).setOnAction(e -> changePerson(people.get(tmp)));
        }
        if(people.size()==0) currentPerson=null;
        else currentPerson=people.get(0);
    }
    public void savePersons() {

        try {
            FileOutputStream fileOut = new FileOutputStream(filePath+"/people");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(people);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public void loadPersons() {

        try {
            FileInputStream fileIn = new FileInputStream(filePath+"/people");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            people=(List<Person>) objectIn.readObject();

            for(Person p: people){
                int i =personbutton.size();
                personbutton.add(new Button());
                personbutton.get(i).setOnAction(e -> changePerson(people.get(i)));
                personbutton.get(i).setText(people.get(i).getFirstName()+" "+ people.get(i).getLastName());
                personbutton.get(i).setMaxSize(125,20);
                personbutton.get(i).setLayoutX(13);
                personList.getItems().add(personbutton.get(i));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    }
    public void die(){
        System.exit(0);
    }
}
