package PetrovTodor.Validation_Images_Upload_E_Emails.controllers;


import PetrovTodor.Validation_Images_Upload_E_Emails.entities.AutorePost;
import PetrovTodor.Validation_Images_Upload_E_Emails.payload.NewAutoreDto;
import PetrovTodor.Validation_Images_Upload_E_Emails.payload.NewAutoreRespDto;
import PetrovTodor.Validation_Images_Upload_E_Emails.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
/*
1. GET http://localhost:3001/autors
2. POST http://localhost:3001/autors (+ body)
3. GET  http://localhost:3001/autors/{autoreId}
4. PUT http://localhost:3001/autors/{autoreId}
5. DELETE http://localhost:3001/autors/{autoreId}


 */


@RestController
@RequestMapping("/autors")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // 1. GET http://localhost:3001/autors
    @GetMapping
    private Page<AutorePost> getAllAutors(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "idAutore") String sortBy) {
        return this.autorService.findAll(page, size, sortBy);
    }


    // 2. POST http://localhost:3001/autors (+ body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private NewAutoreRespDto createAutore(@RequestBody @Validated NewAutoreDto body){

        return new NewAutoreRespDto(this.autorService.saveAutorePost(body).getIdAutore()) ;
    }

    // 3. GET  http://localhost:3001/autors/{autoreId}

    @GetMapping("/{autoreId}")
    private AutorePost getAutorePostById(@PathVariable UUID autoreId)
    {
        return autorService.findById(autoreId);
    }

    //4. PUT http://localhost:3001/autors/{autoreId}
    @PutMapping("/{autoreId}")
    private AutorePost findByIdAndUpdate(@PathVariable UUID autoreId, @RequestBody AutorePost body) {
        return autorService.findByIdAndUpdate(autoreId, body);
    }
    //5. DELETE http://localhost:3001/autors/{autoreId}

    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void findByIdAndDelete(@PathVariable UUID autoreId) {
        autorService.findByIdAndDelete(autoreId);
    }
}
