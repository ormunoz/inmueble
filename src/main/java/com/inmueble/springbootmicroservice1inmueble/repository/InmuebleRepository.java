package com.inmueble.springbootmicroservice1inmueble.repository;

import com.inmueble.springbootmicroservice1inmueble.model.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long>{

}
