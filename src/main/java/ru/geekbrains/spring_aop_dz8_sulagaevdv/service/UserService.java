package ru.geekbrains.spring_aop_dz8_sulagaevdv.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_aop_dz8_sulagaevdv.aspect.TrackUserAction;
import ru.geekbrains.spring_aop_dz8_sulagaevdv.model.User;
import ru.geekbrains.spring_aop_dz8_sulagaevdv.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    @TrackUserAction
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    @TrackUserAction
    public User getUserById(Long id){
        return repository.findById(id).orElse(new User());
    }
    @TrackUserAction
    public User createUser(User user){
        return repository.save(user);
    }
    @TrackUserAction
    public User updateUser(User user, Long id){
        User oldUser = getUserById(id);
        oldUser.setLogin(user.getLogin());
        oldUser.setPassword(user.getPassword());
        return repository.save(oldUser);
    }
    @TrackUserAction
    public void deleteUser(Long id){
        repository.deleteById(id);
    }
}
