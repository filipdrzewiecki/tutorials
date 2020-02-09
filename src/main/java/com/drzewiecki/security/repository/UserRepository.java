package com.drzewiecki.security.repository;

import com.drzewiecki.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u left join fetch u.roles where upper(u.userName) = upper(:userName)")
    Optional<User> findByUser(@Param("userName") String userName);

    Optional<User> findByUserName(String userName);
}
