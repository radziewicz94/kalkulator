package exception;

public class WrongMatrixDimensionsException extends RuntimeException{
    public WrongMatrixDimensionsException(String message) {
        super(message);
    }
}
