package com.example.theprojectfullspringboot.Controller;

import com.example.theprojectfullspringboot.ApiResponse.ApiResponse;
import com.example.theprojectfullspringboot.Model.Merchant;
import com.example.theprojectfullspringboot.Model.Product;
import com.example.theprojectfullspringboot.Service.MerchantService;
import com.example.theprojectfullspringboot.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

   @GetMapping("/get")
    public ResponseEntity getMarchant(){
        ArrayList<Merchant>merchants=merchantService.getMerchants();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/add")
    public ResponseEntity addMarchant(@Valid @RequestBody Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        merchantService.addMarchants(merchant);
        return ResponseEntity.status(200).body("merchant added ");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMarchant(@Valid@PathVariable int id,Errors errors,@RequestBody Merchant merchant){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));

        }   boolean isUpdate=merchantService.updateMerchant(id, merchant);
        if(isUpdate){
            return ResponseEntity.status(200).body("merchant Updated");}
        return ResponseEntity.status(400).body("Wrong id");
//
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMarchant(@PathVariable int id){
        boolean isDeleted=merchantService.deleteMerchant(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("THe merchant is deleted");
        }return ResponseEntity.status(400).body("Wrong id");

    }

}
