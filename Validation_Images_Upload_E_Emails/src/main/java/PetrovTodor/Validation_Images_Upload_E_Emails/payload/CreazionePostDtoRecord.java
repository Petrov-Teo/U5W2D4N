package PetrovTodor.Validation_Images_Upload_E_Emails.payload;

import java.util.UUID;

public record CreazionePostDtoRecord(UUID idAutore,
                                     String categoria,
                                     String titolo,
                                     String contenuto) {
}
