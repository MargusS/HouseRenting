package com.backend.houserenting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.houserenting.entity.House;
import com.backend.houserenting.repository.HouseRepository;

@Service
@Transactional
public class HouseService {
	@Autowired
    HouseRepository houseRepository;

    public List<House> list(){
        return houseRepository.findAll();
    }

    public Optional<House> getOne(long id){
        return houseRepository.findById(id);
    }

    public Optional<House> getByTitle(String title){
        return houseRepository.findByTitle(title);
    }

    public void  save(House house){
        houseRepository.save(house);
    }

    public void delete(long id){
        houseRepository.deleteById(id);
    }

    public boolean existsById(long id){
        return houseRepository.existsById(id);
    }

    public boolean existsByTitle(String title){
        return houseRepository.existsByTitle(title);
    }
}
