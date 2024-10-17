package ru.geekbrains.spring_aop_dz8_sulagaevdv.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_aop_dz8_sulagaevdv.aspect.TrackUserAction;
import ru.geekbrains.spring_aop_dz8_sulagaevdv.model.User;
import ru.geekbrains.spring_aop_dz8_sulagaevdv.service.UserService;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
