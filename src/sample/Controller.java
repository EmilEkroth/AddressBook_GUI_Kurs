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

public class Controller {
    Person currentPerson = new Person(0); //TODO fix list
    List<Person> people = new ArrayList<Person>(1);


    @FXML private Button newButton;
    @FXML private Button deleteButton;
    public ListView personList;
    public List<Button> personbutton;
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

        //personbutton.get(currentPerson.nr).setText(currentPerson.getFirstName());
    }

    EventHandler<ActionEvent> eventchangeperson = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            fieldFirst.setText("oke detta fungera");
        }
    };

    public void handleNewPerson ()
    {
        int i = personList.getItems().size();
        people.add(new Person(people.size()));
        Button b = newButton;
        b.setOnAction(eventchangeperson);
        personList.getItems().add(b);
    }
}
