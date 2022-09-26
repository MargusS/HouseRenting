package com.backend.houserenting.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.backend.houserenting.dto.Message;
import com.backend.houserenting.dto.HouseDto;
import com.backend.houserenting.entity.House;
import com.backend.houserenting.service.HouseService;

@RestController
@RequestMapping("/house")
@CrossOrigin
public class HouseController {
	
	    @Autowired
	    HouseService houseService;

	    @GetMapping("/lista")
	    public ResponseEntity<List<House>> list(){
	        List<House> list = houseService.list();
	        return new ResponseEntity(list, HttpStatus.OK);
	    }

	    @GetMapping("/detail/{id}")
	    public ResponseEntity<House> getById(@PathVariable("id") int id){
	        if(!houseService.existsById(id))
	            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
	        House house = houseService.getOne(id).get();
	        return new ResponseEntity(house, HttpStatus.OK);
	    }

	    @GetMapping("/detailname/{title}")
	    public ResponseEntity<House> getByTitle(@PathVariable("title") String title){
	        if(!houseService.existsByTitle(title))
	            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
	        House house = houseService.getByTitle(title).get();
	        return new ResponseEntity(house, HttpStatus.OK);
	    }

	    @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody HouseDto houseDto){
	        if(StringUtils.isBlank(houseDto.getTitle()))
	            return new ResponseEntity(new Message("el title es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(houseDto.getPrice() == 0L || houseDto.getPrice() < 0  ) {
	            return new ResponseEntity(new Message("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
	        }
	        if(houseService.existsByTitle(houseDto.getTitle()))
	            return new ResponseEntity(new Message("ese title ya existe"), HttpStatus.BAD_REQUEST);
	        House house = new House(houseDto.getTitle(),houseDto.getDescription(),houseDto.getWc(),houseDto.getRooms(), houseDto.getPrice(),houseDto.getLocation());
	        houseService.save(house);
	        return new ResponseEntity(new Message("house creado"), HttpStatus.OK);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody HouseDto houseDto){
	        if(!houseService.existsById(id))
	            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
	        if(houseService.existsByTitle(houseDto.getTitle()) && houseService.getByTitle(houseDto.getTitle()).get().getId() != id)
	            return new ResponseEntity(new Message("ese title ya existe"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(houseDto.getTitle()))
	            return new ResponseEntity(new Message("el title es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(houseDto.getPrice()==0L || houseDto.getPrice()<0 )
	            return new ResponseEntity(new Message("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

	        House house = houseService.getOne(id).get();
	        house.setTitle(houseDto.getTitle());
	        house.setPrice(houseDto.getPrice());
	        houseService.save(house);
	        return new ResponseEntity(new Message("house actualizado"), HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")int id){
	        if(!houseService.existsById(id))
	            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
	        houseService.delete(id);
	        return new ResponseEntity(new Message("house eliminado"), HttpStatus.OK);
	    }
}
