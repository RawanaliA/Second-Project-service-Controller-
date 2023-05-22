package com.example.theprojectfullspringboot.Controller;
import com.example.theprojectfullspringboot.ApiResponse.ApiResponse;
import com.example.theprojectfullspringboot.Model.MerchantStock;
import com.example.theprojectfullspringboot.Model.Product;
import com.example.theprojectfullspringboot.Service.MerchantStockService;
import com.example.theprojectfullspringboot.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchantstock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

 @GetMapping("/get")
    public ResponseEntity getMerchantStock() {
        ArrayList<MerchantStock>merchantStocks=merchantStockService.getMerchantStock();
        return ResponseEntity.status(200).body(merchantStocks);
    }
    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid@RequestBody MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("addMerchantStockService Succssufully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@Valid@RequestBody MerchantStock merchantStock,Errors errors,int id)
    { if (errors.hasErrors()) {
        String massage = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(massage));
    } merchantStockService.updateMerchantStock(id,merchantStock);
        return ResponseEntity.status(200).body("updated succssfuly");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id){
        boolean isDeletit= merchantStockService.deleteMerchantStock(id);
        if(isDeletit){
            return ResponseEntity.status(200).body("category delete it ");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }
    @PutMapping ("/addProdudct/{productid}/{merchantid}/{stock}")
    public ResponseEntity addProdudctTo(@Valid@PathVariable int productid,int merchantid,int stock,Errors errors){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massage));
        }
       boolean isAddit= merchantStockService.addProudactsTo(productid, merchantid, stock);
        if(isAddit){
        return ResponseEntity.status(200).body("Add it Succssufully");
    }
        return ResponseEntity.status(400).body("Wrong id");
}}
