package com.minc.projectx.repositories.user;


import com.minc.projectx.entities.user.Role;
import com.minc.projectx.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Role,Integer> {

    User findByUsername(String username);
}
