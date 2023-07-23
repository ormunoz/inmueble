package com.inmueble.springbootmicroservice1inmueble.service;

import com.inmueble.springbootmicroservice1inmueble.model.Inmueble;
import com.inmueble.springbootmicroservice1inmueble.repository.InmuebleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InmuebleServiceImpl implements InmuebleService {
    private final InmuebleRepository inmuebleRepository;

    public InmuebleServiceImpl(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }
    @Override
    public Inmueble saveInmueble(Inmueble inmueble){
        inmueble.setFecha_creacion(LocalDateTime.now());
        inmuebleRepository.save(inmueble);
        return inmueble;
    }
    @Override
    public void deleteInmueble(Long inmuebleId){
        inmuebleRepository.deleteById(inmuebleId);
    }

    @Override
    public List<Inmueble> findAllInmuebles(){
        return inmuebleRepository.findAll();
    }
}














