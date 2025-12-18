package com.library.library_management.DTO;

import lombok.Data;
import java.util.List;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private List<String> books;
}
