package com.example.theprojectfullspringboot.Controller;
import com.example.theprojectfullspringboot.ApiResponse.ApiResponse;
import com.example.theprojectfullspringboot.Model.Product;
import com.example.theprojectfullspringboot.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getProduct(){
        ArrayList<Product>products=productService.getProducts();
        return ResponseEntity.status(200).body(products);
    }
    @PostMapping  ("/add")
    public ResponseEntity addProduct(@Valid@RequestBody Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        productService.addProducts(product);
        return ResponseEntity.status(200).body("Prouduct added ");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProducts(@Valid@PathVariable int id,Errors errors,@RequestBody Product product){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));

    }   boolean isUpdate=productService.updateProduct(id, product);
        if(isUpdate){
        return ResponseEntity.status(200).body("Prouduct Updated");}
        return ResponseEntity.status(400).body("Wrong id");
//
}
@DeleteMapping("/delete/{id}")
public ResponseEntity deleteProduct(@PathVariable int id){
        boolean isDeleted=productService.deleteProduct(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("THe product is deleted");
        }return ResponseEntity.status(400).body("Wrong id");

}//i need to review it
}
