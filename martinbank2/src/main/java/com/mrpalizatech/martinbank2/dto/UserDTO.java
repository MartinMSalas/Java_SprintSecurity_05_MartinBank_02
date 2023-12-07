package com.mrpalizatech.martinbank2.dto;

import com.mrpalizatech.martinbank2.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    @Column(nullable = false)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    @Enumerated(EnumType.STRING)
    private Role role;

}
