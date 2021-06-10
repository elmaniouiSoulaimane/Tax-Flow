package com.example.demo.ws;

import com.example.demo.bean.Role;
import com.example.demo.service.RoleService;
import com.example.demo.service.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("TaxFlow/v1")
@CrossOrigin("http://localhost:4200")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/RechercheRole/{roleName}")
    public Role findByRoleName(@PathVariable String roleName) {
        return roleService.findByRoleName(roleName);
    }
    @GetMapping("/ListRoles")
    public List<Role> findAll() {
        return roleService.findAll();
    }
    @PostMapping("AjouterRole")
    public Result save(@RequestBody Role role) {
        return roleService.save(role);
    }
    @Transactional
    @DeleteMapping("/DeleteRole/{roleName}")
    public Result deleteByRoleName(@PathVariable String roleName) {
        return roleService.deleteByRoleName(roleName);
    }
    @PutMapping("/ModifierRole/{roleName}")
    public Result updateRole(@PathVariable String roleName, @RequestBody Role roleMod) {
        return roleService.updateRole(roleName, roleMod);
    }

}
