package com.example.theprojectfullspringboot.Controller;

import com.example.theprojectfullspringboot.ApiResponse.ApiResponse;
import com.example.theprojectfullspringboot.Model.Merchant;
import com.example.theprojectfullspringboot.Model.MerchantStock;
import com.example.theprojectfullspringboot.Model.User;
import com.example.theprojectfullspringboot.Service.ProductService;
import com.example.theprojectfullspringboot.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ProductService productService;
//    private final MerchantStock merchantStock;


    @GetMapping("/get")
    public ResponseEntity getUsers() {
        ArrayList<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUsers(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        userService.addUsers(user);
        return ResponseEntity.status(200).body("user added ");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers(@Valid @PathVariable int id, Errors errors, @RequestBody User user) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));

        }
        boolean isUpdate = userService.updateUsers(id, user);
        if (isUpdate) {
            return ResponseEntity.status(200).body("user Updated");
        }
        return ResponseEntity.status(400).body("Wrong id");
//
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUsers(@PathVariable int id) {
        boolean isDeleted = userService.deleteUsers(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("THe user is deleted");
        }
        return ResponseEntity.status(400).body("Wrong id");

    }}

//    @PutMapping("/buy/{userid}/{productid}/{merchantid}")
//    public ResponseEntity buyProduct(@PathVariable int userid,@PathVariable int productid,@PathVariable int merchantid) {
////        if (userService.(userid) & productService.(productid) & merchant.(merchantid))
////        if (userService.getUsers().get(userService.getUsers(userid)).getBalance()-productService.getProducts().get(productid)<0)
////
////                return ResponseEntity.status(400).body("the balance is not enough");
////            if (merchantStock.getStock(merchantid){
////                userService.buyP(merchantid,i)
////                        (userid,productController.getProducts().getPrice(productid));
////                return ResponseEntity.status(200).body(" bought");
////            }else ResponseEntity.status(400).body("merchant does not have product in stock");
////        }return ResponseEntity.status(400).body("id not found");
////    }
//    }}
//}