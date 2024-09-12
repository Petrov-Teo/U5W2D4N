package PetrovTodor.Validation_Images_Upload_E_Emails.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor
public class PayloadCreazionePostDto {
    private UUID idAutore;
    private String categoria;
    private String titolo;
    private String contenuto;
}
