package com.ecommerce.ecoomerce_Sring_boot_P1.User.Repository;

import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
