package com.withcodeq.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.withcodeq.user.service.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long>{

    Users findByUserId(Long userId);
    
}
