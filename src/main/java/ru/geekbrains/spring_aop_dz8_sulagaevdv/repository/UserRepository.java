package ru.geekbrains.spring_aop_dz8_sulagaevdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_aop_dz8_sulagaevdv.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
