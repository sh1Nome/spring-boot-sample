package com.example.sample.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IndexForm {
    @NotBlank(message = "名前を入力してください。")
    @Size(min = 0, max = 30, message = "名前は{min}~{max}文字で入力してください。")
    private String name;
}
