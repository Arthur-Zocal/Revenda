package com.garagem.services;

import com.garagem.domains.Carro;
import com.garagem.domains.dtos.CarroDTO;
import com.garagem.repositories.CarroRepositoy;
import com.garagem.repositories.GaragemRepository;

import com.garagem.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {@Autowired
private CarroRepositoy carroRepo;

    @Autowired
    private GaragemRepository garagemRepo;

    public List<CarroDTO> findAll(){
        return carroRepo.findAll().stream()
                .map(obj -> new CarroDTO(obj))
                .collect(Collectors.toList());
    }

    public Carro findById(Integer id){
        Optional<Carro> obj = carroRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro não foi encontrado! ID: "+ id));
    }

    public Carro findByPlaca(String placa){
        Optional<Carro> obj = carroRepo.findByPlaca(placa);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Carro não foi encontrado! PLACA: "+ placa));
    }

    public Carro create (CarroDTO dto){
        dto.setIdCarro(null);
        validaCarro(dto);
        Carro obj = new Carro(dto);
        return carroRepo.save(obj);
    }

    public void validaCarro(CarroDTO dto){
        Optional<Carro> objCnpj = carroRepo.findByPlaca(dto.getPlaca());
        if (objCnpj.isPresent() && objCnpj.get().getIdCarro() != dto.getIdCarro()){
            throw new DataIntegrityViolationException("Placa ja esta cadastrada no sistema");
        }
        if (!garagemRepo.existsById(dto.getGaragem())){
            throw new DataIntegrityViolationException("Garagem não foi encontrada! ID" +dto.getGaragem());
        }
    }

    public Carro update(Integer id, CarroDTO objDto){
        objDto.setIdCarro(id);
        Carro oldObj = findById(id);
        validaCarro(objDto);
        oldObj = new Carro(objDto);
        return carroRepo.save(oldObj);
    }

    public void delete(Integer id){
        Carro obj = findById(id);
        carroRepo.deleteById(id);
    }

}
