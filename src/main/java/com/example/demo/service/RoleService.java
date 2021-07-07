package com.example.demo.service;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import com.example.demo.dao.RoleDao;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleService {
  @Autowired
  private RoleDao roleDao;
  @Autowired
  private UserService userService;
  // Trouver Role Apartir du Nom
    public Role findByRoleName(String roleName) {
        return roleDao.findByRoleName(roleName);
    }
    // List des Roles
    public List<Role> findAll() {
        return roleDao.findAll();
    }
    //Ajouter Un Role
    public Result save(Role role) {
        Result result= new Result("RoleInput",role);
        if (findByRoleName(role.getRoleName())!= null){
            result.addError(-1,"role deja existant");
        }
        if (role.getRoleName()==null){
            result.addError(-2,"champ nom role est vide");
        }
        if (result.hasNoError()){
            String name = role.getRoleName().toUpperCase();
            role.setRoleName(name);
            roleDao.save(role);
            result.addInfo(1,"role est ajouter");
        }
        return result;
    }
    // Supprimer Un Role
    @Transactional
    public Result deleteByRoleName(String roleName) {
        Result result= new Result("RoleDelete",roleName);
        if (findByRoleName(roleName)==null){
            result.addError(-1,"role n'exist pas");
        }
        if (userService.findByRole_RoleName(roleName)!=null){
            result.addError(-2,"user avec ce role exist imposible de supprimer");
        }
        if (result.hasNoError()){
            roleDao.deleteByRoleName(roleName);
            result.addInfo(1,"role est supprimer");
        }

        return result;
    }
    // Modifier Un Role
    public Result updateRole(String roleName,Role roleMod){
        Result result= new Result("RoleUpdate",roleName);
        Role role = roleDao.findByRoleName(roleName);
        if (role == null){
            result.addError(-1,"role : "+roleName+" n'exist pas");
        }
        if (roleMod.getRoleName()==null){
            result.addError(-2,"nom role est vide");
        }

        if (result.hasNoError()){
            role.setRoleName(roleMod.getRoleName().toUpperCase());
            Role updatedRole = roleDao.save(role);
            result.addInfo(1,"role est modifier");
        }
        return result;
    }/*
    public Result modifierRole(Long id,Role roleMod){
        Result result= new Result("RoleMod",id);
        Role role = roleDao.findById(id).get();
        if (roleDao.findById(id).get() == null){
            result.addError(-1,"role : "+id+" n'exist pas");
        }
        if (result.hasNoError()){
            role.setRoleName(roleMod.getRoleName());
            Role updatedRole = roleDao.save(role);
            result.addInfo(1,"role est modifier");
        }
        return result;
    }*/
}
