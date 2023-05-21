package com.example.theprojectfullspringboot.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class Product {
    @NotNull(message = " the ID Cannot be null")
    @Size(min =3,message = "the id should be 3 ")
    private int id;
    @NotEmpty(message = "title cant be embty")
    @Length(min=3,message = "the size of name  between more then 4")
    private String name;
    @NotEmpty(message = "The price  cant be embty")
    @Positive
    private  int price;
    @NotEmpty(message = "The price  cant be embty")
    @Length(min =3,message = "the id should be 3 ")
    private String categoryID;
}
