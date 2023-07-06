package com.springboot.blog.payload;

import java.util.List;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDtoV2 {
    private long id;
@Schema(
    description = "Blog post Title"
)
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;
    @Schema(
        description =  "Blog post Description"
    )
    @NotEmpty
    @Size(min = 10, message = "Description should have at least 10 characters")
    private String description;
    @Schema(description="Blog post Content")
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
    // @Schema(
    //     description = "Blog Post category Id"
    // )
    // private Long categoryId;
    private List<String> tags;


}
