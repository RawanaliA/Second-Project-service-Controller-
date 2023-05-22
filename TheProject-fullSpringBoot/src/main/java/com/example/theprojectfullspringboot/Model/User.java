package com.example.theprojectfullspringboot.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = " the ID Cannot be null")
    @Size(min =3,max = 3,message = "the id should be 3 ")
    private int id;
    @NotEmpty(message = " the ID Cannot be null")
    @Size(min =5,message = "the id should be 3 ")
    private  String username;
    @Email
  private String email;
    @NotEmpty
//    @Size(min =5,message = "the id should be 3 ")
    @Pattern(regexp = "^[a-zA-Z0-9]{6}$")
    //اضيف كاركتر يعني لازم يدخل كاركتر
    private String  password;
    @NotEmpty(message = " the ID Cannot be null")
    @Pattern(regexp = "Admin|Custemer",message = " YOU Should be an Admin OR Custemer ")
    private  String role;
    @NotEmpty(message = " the ID Cannot be null")
   @Positive
    private int  balance;
}
