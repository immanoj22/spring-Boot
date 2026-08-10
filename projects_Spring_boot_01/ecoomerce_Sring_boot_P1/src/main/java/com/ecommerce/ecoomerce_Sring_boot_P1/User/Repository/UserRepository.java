package com.ecommerce.ecoomerce_Sring_boot_P1.User.Repository;

import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByEmail(String email);
}
