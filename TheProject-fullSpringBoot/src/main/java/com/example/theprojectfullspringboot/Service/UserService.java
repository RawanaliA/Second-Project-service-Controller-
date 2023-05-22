package com.example.theprojectfullspringboot.Service;

import com.example.theprojectfullspringboot.Model.Merchant;
import com.example.theprojectfullspringboot.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserService {
    ArrayList<User> users=new ArrayList<>();
    public ArrayList<User> getUsers(){
        return users;
    }
    public void addUsers(User user){
        users.add(user);
    }

    public boolean updateUsers(int id,User user ){
        for (int i=0;i<users.size();i++){
            if(users.get(i).getId()==id)
                users.set(i, user);
            return true;
        }
        return false;
    }
    public boolean deleteUsers(int id){
        for (int i=0;i<users.size();i++){
            if(users.get(i).getId()==id)
                users.remove(i);
            return true;
        }
        return false;
    }
    // user can buy a product directly
    //check if all the given id is valid or not
    //check if the merchant have the product in stock or return bad request.
    //reduce the stock from the MerchantStock.
    //deducted the price of the product from the user balance.
    //if balance is less than the product price return bad request.
        public boolean buyP(int id, int price) {
            for (int i = 0; i < users.size(); i++) {
                if ((users.get(getUsers().indexOf(id)).getBalance() - price) < 0 & users.get(i).getId() != id)
                    return false;}
                users.get(getUsers().indexOf(id)).setBalance(users.get(getUsers().indexOf(id)).getBalance() - price);

            return true;
        }
    }

