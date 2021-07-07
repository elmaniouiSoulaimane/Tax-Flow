package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;
import com.example.demo.service.util.Result;
import com.example.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findByRole_RoleName(String roleName) {
        return userDao.findByRole_RoleName(roleName);
    }

    //Methode Cryptage
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //Trouver Utilisateur par username

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
    // Liste des Utilisateur
    public List<User> findAll() {
        return userDao.findAll();
    }
    // Ajouter Utilisateur
    public Result save(User user) {
        Result result = new Result("UserInput",user);
        if (getUserByUsername(user.getUsername())!=null){
            result.addError(-1,"username deja existant");
        }
        if (user.getUsername()==null){
            result.addError(-2,"champ username est vide");
        }
        if (user.getPassword()==null){
            result.addError(-3,"champ password est vide");
        }
        if (result.hasNoError()){
            String pass= user.getPassword();
            user.setPassword(passwordEncoder().encode(user.getPassword()));

            userDao.save(user);
        }
        return result;
    }
    //Modifier Utilisateur
    public Result updateUser(String username,User userMod){
        Result result = new Result("UserUpdate",userMod);
        User user = getUserByUsername(username);
        if (user == null){
            result.addError(-1,"username : "+username+" n'exist pas");
        }
        if (result.hasNoError()){
            user.setUsername(userMod.getUsername());
            user.setPassword(passwordEncoder().encode(userMod.getPassword()));
            user.setRole(userMod.getRole());
            user.setCommune(userMod.getCommune());
            User updatedUser = userDao.save(user);
            result.addInfo(1,"user est modifier");
        }
        return result;
    }
    //Supprimer User

    public Result deleteByUsername(String username) {
        Result result = new Result("UserDelete",username);
        if (getUserByUsername(username)==null){
            result.addError(-1,"username n'exist pas");
        }
        if (result.hasNoError()){
            userDao.deleteByUsername(username);
        }
        return result;
    }



    public User verifyLogin(UserVo userVo)throws Exception{
        Result result = new Result("loginInput",userVo/*username*/);
        User user = null;
        //UserVo userVo = new UserVo();
        //userVo.setUsername(username);
        //userVo.setPassword(password);
        if (getUserByUsername(userVo.getUsername())!=null) {
            user  = getUserByUsername(userVo.getUsername());
        }
        if (!(user.getUsername().equals(userVo.getUsername()))
                || !(passwordEncoder().matches(userVo.getPassword(),user.getPassword()))){
            result.addError(-3,"username or password incorect");
            throw new Exception("bad credintials");
        }
       /* if (!passwordEncoder().matches(userVo.getPassword(),user.getPassword()))    {
            result.addError(-4,"nom ou mot de pass invalid");
        }*/
        if (!user.isEnabled()){
            result.addError(-2,"acount not activated plz contact administration");
            throw new Exception("acount not activated");
        }
        if (result.hasNoError()){
            result.addInfo(1,"Login Successful ");
        }
        return user;
    }
/*
    public User verifyLoginIn(String username,String password){
        User user = new User();
        UserVo userVo = new UserVo();
        userVo.setUsername(username);
        userVo.setPassword(password);
        if (getUserByUsername(userVo.getUsername())!=null) {
            user  = getUserByUsername(userVo.getUsername());
        }else {
            user.setUsername("user n'exist pas");
        }
        return user;
    }*/
}
