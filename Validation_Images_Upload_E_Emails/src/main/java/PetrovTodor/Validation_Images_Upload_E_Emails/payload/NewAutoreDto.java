package PetrovTodor.Validation_Images_Upload_E_Emails.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record NewAutoreDto(
        @NotEmpty(message = "Il nome è un campo obbligatorio!")
        @Size(min = 2, message = "Per il nome proprio minimo 2 caratteri!")
        String nome,
        @NotEmpty(message = "Il cognome è un campo obbligatorio!")
        @Size(min = 2,message = "Per il nome proprio minimo 2 caratteri!")
        String cognome,
        @NotEmpty(message = "Il l'email è un campo obbligatorio!")
        @Email
        String email,
        @NotEmpty(message = "Il la data di nascita è un campo obbligatorio!")
        LocalDate dataDiNascita) {
}
