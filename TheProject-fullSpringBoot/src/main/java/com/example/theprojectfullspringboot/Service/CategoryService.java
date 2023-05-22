package com.example.theprojectfullspringboot.Service;

import com.example.theprojectfullspringboot.ApiResponse.ApiResponse;
import com.example.theprojectfullspringboot.Model.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Service
public class CategoryService {
    ArrayList<Category>categories=new ArrayList<>();
    public ArrayList<Category> getCategories(){
        return categories;
    }
    public void addCategories(Category category){
        categories.add(category);
    }
    public boolean updateCategory(int id ,Category category){
        for (int i=0;i<categories.size();i++){
            if(categories.get(i).getId()==id)
                categories.set(i,category);
                return true;
        }return false;
    }
    public boolean deleteCategory(int id ){
        for (int i=0;i<categories.size();i++){
            if(categories.get(i).getId()==id)
                categories.remove(i);
                return true;
        }return false;
    }
//    public categories CategoYYries(){
//        return categories;
//    }

}
