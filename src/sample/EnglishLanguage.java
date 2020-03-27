package sample;

public class EnglishLanguage implements Language {

    @Override
    public String File() {
        return "File";
    }

    @Override
    public String help() {
        return "Help";
    }

    @Override
    public String newcontact() {
        return "New Contact";
    }

    @Override
    public String deletecontact() {
        return "Delete Contact";
    }

    @Override
    public String exit() {
        return "Exit";
    }

    @Override
    public String about() {
        return "About";
    }

    @Override
    public String unnnamed() {
        return "Unnamed";
    }

    @Override
    public String firstName() {
        return "First Name";
    }

    @Override
    public String lastName() {
        return "Last Name";
    }

    @Override
    public String phone() {
        return "Phone";
    }

    @Override
    public String email() {
        return "Email";
    }

    @Override
    public String postcode() {
        return "Post Code";
    }

    @Override
    public String city() {
        return "City";
    }
}
