package com.mrpalizatech.martinbank2.controller;

import com.mrpalizatech.martinbank2.dto.CardDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @PostMapping("/create")
    public ResponseEntity<CardDTO> create() {
        CardDTO cardDTO = new CardDTO();
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }
}
