package com.example.theprojectfullspringboot.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class MerchantStock {

@NotEmpty
@Size(min =3,message = "the id should be 3 ")
    private int id;
    @NotEmpty(message = " the ID Cannot be null")
    private int productid;
    @NotEmpty
    @Length(min=3 ,message ="the ID have to be 3 length long")
    private int merchantid;
    @NotEmpty
    @Min(value =10,message = "the stock should be 10 at least as start")
    private int stock;

}
