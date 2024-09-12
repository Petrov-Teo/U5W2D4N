package PetrovTodor.Validation_Images_Upload_E_Emails.reposytoris;


import PetrovTodor.Validation_Images_Upload_E_Emails.entities.AutorePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AutoreRepository extends JpaRepository<AutorePost, UUID> {

    Optional<AutorePost> findByEmail(String email);

}
