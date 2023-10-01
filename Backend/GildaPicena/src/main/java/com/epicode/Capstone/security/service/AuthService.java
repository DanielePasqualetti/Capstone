package com.epicode.Capstone.security.service;

import com.epicode.Capstone.security.payload.LoginDto;
import com.epicode.Capstone.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
       
}
