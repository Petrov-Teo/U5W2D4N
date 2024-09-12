package PetrovTodor.Validation_Images_Upload_E_Emails.exceptions;

public class BadRequestExeption extends RuntimeException {
    public BadRequestExeption(String st) {
        super("Verifica i campi inseriti err-400" + st);
    }
}
