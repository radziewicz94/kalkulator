package model.availableOperations;

import exception.NoSuchOptionException;
import io.DataReader;
import model.TwoVectors;

import java.util.InputMismatchException;

public class TwoVectorsOperations {
    private TwoVectors twoVectors = new TwoVectors();
    private DataReader dataReader = new DataReader();

    private Option chooseOption() {

        Option option = null;
        boolean optionOk = false;
        while (!optionOk) {
            try {
                option = Option.getOption(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return option;
    }

    public void operation() {
        System.out.println("Wybierz opcję");
        Option.printOption();

        Option option = chooseOption();
        switch (option) {
            case ADD:
                addNumber();
                break;
            case SUBTRACT:
                subtractNumber();
                break;
            default:
                System.out.println("Nie ma takiej operacji");
        }
    }

    private void addNumber() {
        System.out.println(twoVectors.addNumber());
    }

    private void subtractNumber() {
        System.out.println(twoVectors.subtractNumber());
    }
}

enum Option {
    ADD(1, "Dodaj"),
    SUBTRACT(2, "Odejmij");

    Option(int number, String description) {
        this.number = number;
        this.description = description;
    }

    int number;
    String description;

    static void printOption() {
        for (Option value : Option.values()) {
            System.out.println(value);
        }
    }

    static Option getOption(int option) throws NoSuchOptionException {
        try {
            return Option.values()[option - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("Nie ma takiej opcji o id " + option + " spróbuj jeszcze raz");
        }
    }

    @Override
    public String toString() {
        return number + " - " + description;
    }
}
