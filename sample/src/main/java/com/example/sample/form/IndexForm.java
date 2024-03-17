package com.example.sample.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IndexForm {
    @NotBlank
    @Size(min = 0, max = 30)
    private String name;
}
