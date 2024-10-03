package net.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.example.demo.entity.Password;


@Repository
public interface  PasswordRepository extends JpaRepository<Password, Long> {
    Password findByUserId(String userId);
    Password findByResetToken(String resetToken);

}
