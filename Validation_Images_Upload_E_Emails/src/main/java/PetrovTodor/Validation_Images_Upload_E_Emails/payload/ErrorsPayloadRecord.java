package PetrovTodor.Validation_Images_Upload_E_Emails.payload;

import java.time.LocalDateTime;

public record ErrorsPayloadRecord(String message, LocalDateTime timeStamp) {
}
