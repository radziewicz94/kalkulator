package model.availableOperations;

import exception.NoSuchOptionException;
import io.DataReader;
import model.OneMatriceOneVector;

import java.util.InputMismatchException;

public class OneMatriceOneVectorOperation {
    private DataReader dataReader = new DataReader();
    private OneMatriceOneVector oneMatriceOneVector = new OneMatriceOneVector();

    public void operation() {
        System.out.println("Wybierz opcję");
        Option.printOption();

        Option option = chooseOption();
        switch (option) {
            case MULTIPLY_MATRICE_VECTOR:
                multipyMyNumber();
                break;
            default:
                System.out.println("Nie ma takiej operacji");
        }
    }
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
    private void multipyMyNumber() {
        System.out.println(oneMatriceOneVector.multiplyMatriceByVector());
    }


    enum Option {
        MULTIPLY_MATRICE_VECTOR(1, "Mnożenie przez Wektor");

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
}

