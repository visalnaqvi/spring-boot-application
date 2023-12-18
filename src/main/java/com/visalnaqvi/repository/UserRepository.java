package com.visalnaqvi.repository;

import com.visalnaqvi.modals.SalaryModal;
import com.visalnaqvi.modals.UserModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModal , Integer> {
    @Query("SELECT u FROM UserModal u INNER JOIN SalaryModal s ON u.id = s.userId WHERE s.salary > 50000")
    List<UserModal> findUsersWithSalaryGreaterThan50K();

}
