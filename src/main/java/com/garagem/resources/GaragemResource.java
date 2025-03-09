package com.garagem.resources;

import com.garagem.domains.Garagem;
import com.garagem.domains.dtos.GaragemDTO;
import com.garagem.services.GaragemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/garagem")
public class GaragemResource {
    @Autowired
    private GaragemService garagemService;

    @GetMapping
    public ResponseEntity<List<GaragemDTO>> findAll(){

        return ResponseEntity.ok().body(garagemService.findAll());
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity<GaragemDTO> findById(@PathVariable Integer id){
        Garagem obj = this.garagemService.findById(id);
        return ResponseEntity.ok().body(new GaragemDTO(obj));
    }

    @GetMapping(value="cnpj/{cnpj}")
    public ResponseEntity<GaragemDTO> findByCnpj(@PathVariable String cnpj){
        Garagem obj = this.garagemService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(new GaragemDTO(obj));
    }

    @PostMapping
    public ResponseEntity<GaragemDTO> create(@Valid @RequestBody GaragemDTO dto){
        Garagem garagem = garagemService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(garagem.getIdGaragem()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<GaragemDTO> update(@PathVariable Integer id,@Valid @RequestBody GaragemDTO objDto){
        Garagem Obj = garagemService.update(id, objDto);
        return ResponseEntity.ok().body(new GaragemDTO(Obj));
    }

    @DeleteMapping
    public ResponseEntity<GaragemDTO> delete(@PathVariable Integer id){
        garagemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

