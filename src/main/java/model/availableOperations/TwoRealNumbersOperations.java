package model.availableOperations;

import exception.DivisionByZeroException;
import exception.NoSuchOptionException;
import exception.RageNumberException;
import io.DataReader;
import model.TwoRealNumbers;

import java.util.InputMismatchException;

public class TwoRealNumbersOperations {

    private final DataReader dataReader = new DataReader();
    private final TwoRealNumbers twoRealNumbers = new TwoRealNumbers();

        public void operation () {
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
                case MULTIPLICATION:
                    multiNumber();
                    break;
                case DIVISION:
                    divNumber();
                    break;
                case EXPONENTIATION:
                    exponentiationNumber();
                    break;
                case REDICAL:
                    redicalNumber();
                    break;
                default:
                    System.out.println("Nie ma takiej operacji");
            }
        }

    private Option chooseOption() {
        Option option = null;
        boolean optionOk = false;
        while(!optionOk) {
            try {
                option = Option.getOption(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return option;
    }

    private void redicalNumber() {
        System.out.println(twoRealNumbers.redicalNumber());
    }

    private void exponentiationNumber() {
        try {
            System.out.println(twoRealNumbers.expNumber());
        }catch (RageNumberException e){
            System.out.println(e.getMessage());
        }
    }

    private void multiNumber() {
        System.out.println(twoRealNumbers.multiNumber());
    }

    private void subtractNumber() {
        System.out.println(twoRealNumbers.subtractNumber());
    }

    private void addNumber() {
        System.out.println(twoRealNumbers.addNumber());
    }

    private void divNumber(){
            try {
                System.out.println(twoRealNumbers.divNumber());
            }catch (DivisionByZeroException e){
                System.out.println(e.getMessage());
            }
        }

        enum Option {
            ADD(1, "Dodaj"),
            SUBTRACT(2, "Odejmij"),
            MULTIPLICATION(3, "Mnożenie"),
            DIVISION(4, "Dzielenie"),
            EXPONENTIATION(5, "Potęgowanie"),
            REDICAL(6, "Pierwiastowanie");

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
                }catch (ArrayIndexOutOfBoundsException e){
                    throw new NoSuchOptionException("Nie ma takiej opcji o id " + option + " spróbuj jeszcze raz");
                }
            }

            @Override
            public String toString() {
                return number + " - " + description;
            }
        }
    }

