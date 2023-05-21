package com.example.theprojectfullspringboot.Service;

import com.example.theprojectfullspringboot.Model.MerchantStock;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Service
public class MerchantStockService {
   ArrayList<MerchantStock>merchantStocks=new ArrayList<>();

   public ArrayList<MerchantStock> getMerchantStock(){
       return merchantStocks;
   }
   public void addMerchantStock(MerchantStock merchantStock){
       merchantStocks.add(merchantStock);

   }
   public boolean updateMerchantStock(int id ,MerchantStock merchantStock){
       for(int i=0;i<merchantStocks.size();i++)
           if(merchantStocks.get(i).getId()==id){
               merchantStocks.set(id, merchantStock);
               return true;
           }return false;
   }
   public boolean deleteMerchantStock(int id){
       for(int i=0;i<merchantStocks.size();i++)
           if(merchantStocks.get(i).getId()==id){
               merchantStocks.remove(i);
               return true;
       }return false;
   }
   // user can buy a product directly
   //check if all the given id is valid or not
   //check if the merchant have the product in stock or return bad request.
   //reduce the stock from the MerchantStock.
   //deducted the price of the product from the user balance.
   //if balance is less than the product price return bad request.
    public boolean addProudacts(int id,int productid,int merchantid,int stock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id & merchantStocks.get(i).getProductid() == productid & merchantStocks.get(i).getMerchantid() == merchantid)
//                merchantStocks.set(i)
                return true;
        }return false;
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getStock()==productid)
                merchantStocks.get(i).=-stock;
        }
        }//first-Q
    public boolean buyProudacts(int id,int productid,int merchantid,int stock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id & merchantStocks.get(i).getProductid() == productid & merchantStocks.get(i).getMerchantid() == merchantid)
                if(stock>0)
                 merchantStocks.set(i,addProudacts(stock));
                return true;
        }
        return false;
        //second

    }
    }
