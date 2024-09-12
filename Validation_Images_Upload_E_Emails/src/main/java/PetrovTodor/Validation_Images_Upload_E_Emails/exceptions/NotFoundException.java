package PetrovTodor.Validation_Images_Upload_E_Emails.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("UPSSSS, l'elemento " + " " + id + " " + "non è stato trovato! Ritenta saraì più fortunato! ;-) ");
    }
}
