package com.example.theprojectfullspringboot.Controller;

import com.example.theprojectfullspringboot.ApiResponse.ApiResponse;
import com.example.theprojectfullspringboot.Model.Category;
import com.example.theprojectfullspringboot.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/get")
    public ResponseEntity getCatigory(){
//       والميثود بترجع لي اري ليست فانا لازم اعرف متغير من نوع اري ااخزن فيها-غ الاوبجكت عندي هو القاتقوري عشانن اوصل للاري
        ArrayList<Category> categories=categoryService.getCategories();
        //برجع له بالبدي الاري   صار يعني اول رسبونس احط الستاس 200 وداخل البودي  ارسل الاري كامله
        return ResponseEntity.status(200).body(categories);
    }
    //بتأخذ ريكوست بدي لان هنا القيت قاعده تتعامامل مع الجيسون

    @RequestMapping("/add")
    public ResponseEntity addCatigory(@Valid @RequestBody Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        categoryService.addCategories(category);
        return ResponseEntity.status(200).body("category added ");
    }
    @RequestMapping("/update/{id}")

    public ResponseEntity updateCatigory(@Valid@RequestBody Category category , Errors errors, @PathVariable int id){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        boolean isUpdatit= categoryService.updateCategory(id, category);
        if(isUpdatit){
            return ResponseEntity.status(200).body("category added ");
        }            return ResponseEntity.status(400).body("Wrong id");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCatigory(@PathVariable int id){
        boolean isDeletit= categoryService.deleteCategory(id);
        if(isDeletit){
            return ResponseEntity.status(200).body("category delete it ");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }
}
