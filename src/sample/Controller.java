package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {
    Person currentPerson = new Person(0); //TODO fix list
    List<Person> people = new ArrayList(){};


    @FXML private Button newButton;
    @FXML private Button deleteButton;
    public ListView personList;
    public List<Button> personbutton = new ArrayList(){};
    public TextField fieldFirst;
    public TextField fieldLast;
    public TextField fieldPhone;
    public TextField fieldEmail;
    public TextField fieldPost;
    public TextField fieldCity;
    EventHandler handler;

    public void handleUpdate()
    { //This function is called upon when a text field is edited.
        currentPerson.setFirstName(fieldFirst.getText());
        currentPerson.setLastName(fieldLast.getText());
        currentPerson.setPhone(fieldPhone.getText());
        currentPerson.setEmail(fieldEmail.getText());
        currentPerson.setPostCode(fieldPost.getText());
        currentPerson.setCity(fieldCity.getText());

        personbutton.get(currentPerson.nr).setText(currentPerson.getFirstName());
    }

    void UpdateFields ()
    {
        fieldFirst.setText(currentPerson.getFirstName());
        fieldLast.setText(currentPerson.getLastName());
        fieldPhone.setText(currentPerson.getPhone());
        fieldEmail.setText(currentPerson.getEmail());
        fieldPost.setText(currentPerson.getPostCode());
        fieldCity.setText(currentPerson.getCity());

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
        people.add(new Person(people.size()));
        personbutton.add(new Button());
        personbutton.get(i).setOnAction(e -> changePerson(people.get(i)));
        personbutton.get(i).setText("Unnamed");
        personbutton.get(i).setMaxSize(125,20);
        personbutton.get(i).setLayoutX(13);
        personList.getItems().add(personbutton.get(i));
    }
}
