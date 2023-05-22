package com.example.theprojectfullspringboot.Service;

import com.example.theprojectfullspringboot.Model.MerchantStock;

import com.example.theprojectfullspringboot.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MerchantStockService {
   ArrayList<MerchantStock>merchantStocks=new ArrayList<>();
    ArrayList<Product> products=new ArrayList<>();
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


    public boolean addProudactsTo(int productid,int merchantid,int stock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getProductid() == productid & merchantStocks.get(i).getMerchantid() == merchantid){
                if (merchantStocks.get(i).getStock() > 0)
               merchantStocks.get(i).setStock(merchantStocks.get(i).getStock()+stock);
            merchantStocks.get(i).setStock(merchantStocks.get(i).getStock() - 1);
           return true;}
//
            }return false;}}

