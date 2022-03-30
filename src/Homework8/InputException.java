package Homework8;

public class InputException extends Exception{

    private String inputLine;
    private char desired;

    public InputException (String message, String inputLine, char desired) {
        super(message);
        this.inputLine = inputLine;
        this.desired = desired;
    }

    public String getInputLine() {
        return inputLine;
    }

    public char getDesired() {
        return desired;
    }

}
