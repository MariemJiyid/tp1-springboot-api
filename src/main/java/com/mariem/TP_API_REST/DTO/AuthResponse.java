package com.mariem.TP_API_REST.DTO;

import com.mariem.TP_API_REST.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private final String token;
    private final AppUser user;
}
