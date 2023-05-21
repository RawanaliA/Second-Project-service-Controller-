package com.example.theprojectfullspringboot.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotEmpty(message = " the ID Cannot be null")
    @Size(min =3,max = 3,message = "the id should be 3 ")
    private int id;
    @NotEmpty(message = " the name Cannot be null")
    @Size(min =3,max = 3,message = "the id should be 3 ")
 private String name;
}
