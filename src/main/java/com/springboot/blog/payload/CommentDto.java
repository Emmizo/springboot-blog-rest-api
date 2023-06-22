package com.springboot.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
    private long id;
    @NotEmpty(message = "Name should not be null or empty")
    private String name;
    @NotEmpty(message = "Email should not be empty please")
    @Email
    private String email;
    @NotEmpty(message = "Comment should not be empty")
    @Size(min = 10, message = "Comment should not be less than 10")
    private String body;
}
