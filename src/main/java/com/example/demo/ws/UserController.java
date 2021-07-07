package com.example.demo.ws;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import com.example.demo.service.util.Result;
import com.example.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("TaxFlow/V1/User")
@CrossOrigin("http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/userByRoleName/{roleName}")
    public User findByRole_RoleName(@PathVariable String roleName) {
        return userService.findByRole_RoleName(roleName);
    }

    @GetMapping("/rechercheUsername/{username}")
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
    @GetMapping("/ListUsers")
    public List<User> findAll() {
        return userService.findAll();
    }
    @PostMapping("/AjouterUser")
    public Result save(@RequestBody User user) {
        return userService.save(user);
    }
    @PutMapping("/ModifierUser/{username}")
    public Result updateUser(@PathVariable String username,@RequestBody User userMod) {
        return userService.updateUser(username, userMod);
    }
    @Transactional
    @DeleteMapping("/DeleteUser/{username}")
    public Result deleteByUsername(@PathVariable String username) {
        return userService.deleteByUsername(username);
    }
    /*@PostMapping("/LoginPage")
    public Result verifyLogin(@RequestBody UserVo userVo) {
        return userService.verifyLogin(userVo);
    }*/
    /*@GetMapping("/loginPage/{username}/{password}")
    public User verifyLoginIn(@PathVariable String username,
                              @PathVariable String password) {
        return userService.verifyLoginIn(username, password);
    }*/
    @PostMapping("/LoginPage")
    public User verifyLogin(@RequestBody UserVo userVo) throws Exception {
        return userService.verifyLogin(userVo);
    }
}
