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
//    public boolean add
//     for (int i = 0; i < merchantStocks.size(); i++) {
//        if(merchantStocks.get(i).getStock()==productid)
//            merchantStocks.
//    }

}
