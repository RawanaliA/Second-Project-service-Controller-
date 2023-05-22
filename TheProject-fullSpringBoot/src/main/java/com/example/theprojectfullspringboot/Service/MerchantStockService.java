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
   // user can buy a product directly
   //check if all the given id is valid or not
   //check if the merchant have the product in stock or return bad request.
   //reduce the stock from the MerchantStock.
   //deducted the price of the product from the user balance.
   //if balance is less than the product price return bad request.
    public void addProudactsTo(int id,int productid,int merchantid,int stock,Product product) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id & merchantStocks.get(i).getProductid() == productid & merchantStocks.get(i).getMerchantid() == merchantid)

//
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getStock()!=0){
                String toAdd=products.get(product).getId()+stock;
            }
//                merchantStocks.add(product,stock);
        }
        }//first-Q

    }
    }
