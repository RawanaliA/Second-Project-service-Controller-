package com.example.theprojectfullspringboot.Service;

import com.example.theprojectfullspringboot.Model.Merchant;
import com.example.theprojectfullspringboot.Model.Product;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Service
public class MerchantService {
    ArrayList<Merchant> merchants=new ArrayList<>();

    public ArrayList<Merchant> getMerchants(){
        return merchants;
    }
    public void addMarchants(Merchant merchant){
        merchants.add(merchant);
    }

    public boolean updateMerchant(int id,Merchant merchant ){
        for (int i=0;i<merchants.size();i++){
            if(merchants.get(i).getId()==id)
                merchants.set(i, merchant);
            return true;
        }
        return false;
    }
    public boolean deleteMerchant(int id){
        for (int i=0;i<merchants.size();i++){
            if(merchants.get(i).getId()==id)
                merchants.remove(i);
            return true;
        }
        return false;
    }

}
