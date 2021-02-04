import exception.NoSuchOptionException;
import exception.WrongMatrixDimensionsException;
import io.DataReader;
import model.OneMatriceOneVector;
import model.OneRealNumberAndMatrices;
import model.OneRealNumberAndOneVector;
import model.availableOperations.OneMatriceOneVectorOperation;
import model.availableOperations.TwoMatricsOperation;
import model.availableOperations.TwoRealNumbersOperations;
import model.availableOperations.TwoVectorsOperations;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class AppControl {

    private DataReader dataReader;
    private TwoRealNumbersOperations twoRealNumbersOperations;
    private OneRealNumberAndOneVector oneNumberAndVectosOperation;
    private OneRealNumberAndMatrices oneRealNumberAndMatrices;
    private TwoVectorsOperations twoVectorsOperations;
    private TwoMatricsOperation twoMatricsOperation;
    private OneMatriceOneVectorOperation oneMatriceOneVectorOperation;

    List<Double> values = new ArrayList<>();

    public AppControl() {
        this.twoRealNumbersOperations = new TwoRealNumbersOperations();
        this.oneNumberAndVectosOperation = new OneRealNumberAndOneVector();
        this.oneRealNumberAndMatrices = new OneRealNumberAndMatrices();
        this.twoVectorsOperations = new TwoVectorsOperations();
        this.twoMatricsOperation = new TwoMatricsOperation();
        this.oneMatriceOneVectorOperation = new OneMatriceOneVectorOperation();
        this.dataReader = new DataReader();
    }

    public void appLoop() {
        Options option;
        do {
            System.out.println("Wybierz opcję");
            Options.printOption();
            option = chooseOption();
            switch (option) {
                case EXIT:
                    exit();
                    break;
                case REAL_NUMBER:
                    twoRealNumbersOperations.operation();
                    break;
                case REAL_NUMBER_VECTOR:
                    oneNumberAndVectosOperation.multiByNumber();
                    break;
                case REAL_NUMBER_MATRICES:
                    oneRealNumberAndMatrices.multiplyByRealNumber();
                    break;
                case TWO_VECTORS:
                    twoVectorsOperations.operation();
                    break;
                case TWO_MATRICES:
                    try {
                        twoMatricsOperation.operation();
                    }catch (WrongMatrixDimensionsException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case MATRICES_VECTOR:
                    try{
                        oneMatriceOneVectorOperation.operation();
                    }catch (WrongMatrixDimensionsException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        } while (option != Options.EXIT);

    }

    private void exit() {
        dataReader.closeScanner();
        System.out.println("Wychodzę z programu");
    }

    private Options chooseOption() {
        Options options = null;
        boolean optionOk = false;
        while(!optionOk) {
            try {
                options = Options.getOption(dataReader.getInt());
                optionOk = true;
            } catch (InputMismatchException e) {
                System.out.println("Błędnie podany format danych, spróbuj jeszcze raz");
            }catch (NoSuchOptionException e){
                System.out.println(e.getMessage());
            }
        }
        return options;
    }

    enum Options {
        EXIT(0, "Wyjście z programu"),
        REAL_NUMBER(1, "2 Liczby rzeczywiste"),
        REAL_NUMBER_VECTOR(2, "Liczba rzeczywista i wektor"),
        REAL_NUMBER_MATRICES(3, "Liczba rzeczywista i macierz"),
        TWO_VECTORS(4, "Dwa wektory"),
        TWO_MATRICES(5, "Dwie macierze"),
        MATRICES_VECTOR(6, "Macierz i wektor");

        Options(int value, String description) {
            this.value = value;
            this.description = description;
        }

        int value;
        String description;

        static void printOption() {
            for (Options value : Options.values()) {
                System.out.println(value);
            }
        }

        static Options getOption(int value) throws NoSuchOptionException {
            try {
                return Options.values()[value];
            }catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchOptionException("Nie ma takiej opcji o id " + value + " spróbuj jeszcze raz");
            }
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }
    }

}



