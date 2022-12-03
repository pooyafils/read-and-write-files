package com.read.excle.propertiesfile.readfile.repository;

import com.read.excle.propertiesfile.readfile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrivilegeRepository extends JpaRepository<User, Integer> {
    User findByMail(String username);
}
