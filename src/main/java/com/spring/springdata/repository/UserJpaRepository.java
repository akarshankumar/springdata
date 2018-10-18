package com.spring.springdata.repository;

import com.spring.springdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long>
{
    User findByName(String name);
}
