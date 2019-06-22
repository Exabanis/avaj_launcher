public class OwnException extends Exception {
    String exception;
    public OwnException(String exception){
//        super(exception);
        this.exception = exception;
    }

    @Override
    public String toString() {
        return exception;
    }
}
