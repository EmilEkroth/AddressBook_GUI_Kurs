package sample;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Person currentPerson = new Person(0); //TODO fix list
    List<Person> people = new ArrayList<Person>(1);

    public List<Button> personButton; //TODO fix list
    public TextField fieldFirst;
    public TextField fieldLast;
    public TextField fieldPhone;
    public TextField fieldEmail;
    public TextField fieldPost;
    public TextField fieldCity;

    public void handleUpdate ()
    { //This function is called upon when a text field is edited.
        currentPerson.setFirstName(fieldFirst.getText());
        currentPerson.setLastName(fieldLast.getText());
        currentPerson.setPhone(fieldPhone.getText());
        currentPerson.setEmail(fieldEmail.getText());
        currentPerson.setPostCode(fieldPost.getText());
        currentPerson.setCity(fieldCity.getText());

        personButton.get(currentPerson.nr).setText(currentPerson.getFirstName());
    }

    public void handleNewPerson ()
    {
            people.add(new Person(people.size()));
            personButton.add(new Button());
    }
}
