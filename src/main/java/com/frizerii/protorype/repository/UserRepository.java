package com.frizerii.protorype.repository;

import com.frizerii.protorype.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity save(UsersEntity userEntity);
    UsersEntity getById(Long id);
    UsersEntity findByEmail(String email);
}
