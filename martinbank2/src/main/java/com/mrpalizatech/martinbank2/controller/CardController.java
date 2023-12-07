package com.mrpalizatech.martinbank2.controller;

import com.mrpalizatech.martinbank2.dto.CardDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @PostMapping("/create")
    public ResponseEntity<CardDTO> create() {
        CardDTO cardDTO = new CardDTO();
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<CardDTO> getAll() {
        CardDTO cardDTO = new CardDTO();
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }

}
