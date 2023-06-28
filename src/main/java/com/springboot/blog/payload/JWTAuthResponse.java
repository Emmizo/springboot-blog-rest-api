package com.springboot.blog.payload;


import com.springboot.blog.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
    // private List<User> user;
    private String accessToken;
    private String tokenType = "Bearer";

}
