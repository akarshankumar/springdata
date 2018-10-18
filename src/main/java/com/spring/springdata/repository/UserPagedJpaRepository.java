package com.spring.springdata.repository;

import com.spring.springdata.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPagedJpaRepository extends PagingAndSortingRepository<User, Long> {
}
