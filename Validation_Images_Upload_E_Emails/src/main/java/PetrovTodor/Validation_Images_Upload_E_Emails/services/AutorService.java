package PetrovTodor.Validation_Images_Upload_E_Emails.services;


import PetrovTodor.Validation_Images_Upload_E_Emails.entities.AutorePost;
import PetrovTodor.Validation_Images_Upload_E_Emails.exceptions.BadRequestExeption;
import PetrovTodor.Validation_Images_Upload_E_Emails.exceptions.NotFoundException;
import PetrovTodor.Validation_Images_Upload_E_Emails.payload.NewAutoreDto;
import PetrovTodor.Validation_Images_Upload_E_Emails.reposytoris.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AutorService {

    @Autowired
    private AutoreRepository autorePostRepo;


    public Page<AutorePost> findAll(int page, int size, String sortBy) {
        if (page > 100) page = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.autorePostRepo.findAll(pageable);
    }

    public AutorePost saveAutorePost(NewAutoreDto body) {
        this.autorePostRepo.findByEmail(body.email()).ifPresent(autorePost -> {
            throw new BadRequestExeption("L'email " + body.email() + " è già in uso!");
        });
        AutorePost autorePost = new AutorePost(body.nome(), body.cognome(), body.email(), body.dataDiNascita(),"https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome());
        return this.autorePostRepo.save(autorePost);
    }

    public AutorePost findById(UUID autoreId) {
        return this.autorePostRepo.findById(autoreId).orElseThrow(() -> new NotFoundException(autoreId));
    }

    public AutorePost findByIdAndUpdate(UUID autoreId, AutorePost body) {
        this.autorePostRepo.findByEmail(body.getEmail()).ifPresent(autorePost -> {
            throw new BadRequestExeption("L'email " + body.getEmail() + " è già in uso!");
        });
        AutorePost found = this.findById(autoreId);
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());
        return this.autorePostRepo.save(found);
    }

    public void findByIdAndDelete(UUID autoreId) {
        AutorePost found = this.findById(autoreId);
        this.autorePostRepo.delete(found);
    }
}
