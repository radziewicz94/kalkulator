package model.availableOperations;

import exception.NoSuchOptionException;
import io.DataReader;
import model.TwoMatrices;

import java.util.InputMismatchException;

public class TwoMatricsOperation {
    private TwoMatrices twoMatrices = new TwoMatrices();
    private DataReader dataReader = new DataReader();
//    public List<String> addNumber() {
//        List<String> sum2Vectors = new ArrayList<>();
//        valueOfVectors();
//        double result = 0;
//        for (int i = 0; i < vector1.length; i++) {
//            result = vector1[i] + vector2[i];
//            sum2Vectors.add(String.format("%.2f", result));
//        }
//        System.out.println("Wynikiem dodawania 2 wektorów jest: ");
//        return sum2Vectors;
//    }


    public void operation() {
        System.out.println("Wybierz opcję");
        Option.printOption();

        Option option = chooseOption();
        switch (option) {
            case ADD:
                addMatrices();
                break;
            case SUBTRACT:
                subtractMatrices();
                break;
            case MULTIPLY:
                multiplyMatrices();
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
    private void subtractMatrices() {
        System.out.println(twoMatrices.subtractMatrices());
    }
    private void multiplyMatrices(){
        System.out.println(twoMatrices.multiplyMatrices());
    }
    private void addMatrices() {
        System.out.println(twoMatrices.addMatrices());
    }

    enum Option {
        ADD(1, "Dodawanie"),
        SUBTRACT(2, "Odejmowanie"),
        MULTIPLY(3, "Mnożenie");

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
