package com.garagem.services;

import com.garagem.domains.Garagem;
import com.garagem.domains.dtos.GaragemDTO;
import com.garagem.repositories.GaragemRepository;

import com.garagem.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GaragemService {

    @Autowired
    public GaragemRepository garagemRepo;


    public List<GaragemDTO> findAll(){
        return garagemRepo.findAll().stream()
                .map(obj -> new GaragemDTO(obj))
                .collect(Collectors.toList());
    }

    public Garagem findById(Integer id){
        Optional<Garagem> obj = garagemRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Garagem não foi encontrada! ID:" +id));
    }

    public Garagem findByCnpj(String cnpj){
        Optional<Garagem> obj = garagemRepo.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Garagem não foi encontrada! CNPJ: "+cnpj));
    }

    public Garagem create (GaragemDTO dto){
        dto.setIdGaragem(null);
        validaEstabelecimento(dto);
        Garagem obj = new Garagem(dto);
        return garagemRepo.save(obj);
    }

    public void validaEstabelecimento(GaragemDTO dto){
        Optional<Garagem> obj = garagemRepo.findByCnpj(dto.getCnpj());
        if (obj.isPresent() && obj.get().getIdGaragem() != dto.getIdGaragem()){
            throw new DataIntegrityViolationException("CNPJ já esta  cadastrado no sistema");
        }
    }

    public Garagem update(Integer id, GaragemDTO objDto){
        objDto.setIdGaragem(id);
        Garagem oldObj = findById(id);
        validaEstabelecimento(objDto);
        oldObj = new Garagem(objDto);
        return garagemRepo.save(oldObj);
    }

    public void delete(Integer id){
        Garagem obj = findById(id);

        if(obj.getCarros().size()>0){
            throw new DataIntegrityViolationException("Garagem não pode ser deletada, existem carros vinculados");
        }

        garagemRepo.deleteById(id);
    }
}
