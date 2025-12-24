package com.thejoa703.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {
	private int authId;
	private String email;
	private String auth;
	private int appUserId; 
	
    public AuthDto(String email, String auth) {
        this.email = email;
        this.auth = auth;
    }
}
