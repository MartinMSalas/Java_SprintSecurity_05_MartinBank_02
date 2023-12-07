package com.mrpalizatech.martinbank2.dto;

import lombok.Data;

@Data
public class CardDTO {
    private String cardNumber;
    private String cardHolder;
    private String expirationDate;
    private String cvv;
    private String cardType;
    private String cardStatus;


}
