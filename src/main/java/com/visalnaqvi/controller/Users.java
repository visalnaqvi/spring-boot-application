package com.visalnaqvi.controller;


import com.visalnaqvi.modals.SalaryModal;
import com.visalnaqvi.modals.UserModal;
import com.visalnaqvi.modals.UserSalaryModal;
import com.visalnaqvi.repository.SalayRepository;
import com.visalnaqvi.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class Users {

    private final UserRepository userRepository;
    private final SalayRepository salayRepository;

    @Autowired
    public Users(UserRepository userRepository , SalayRepository salayRepository){

        this.userRepository = userRepository;
        this.salayRepository = salayRepository;
    }

    @GetMapping("")
    public List<UserModal> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public String createUser(@RequestBody UserSalaryModal userSalaryModal) {
        try {
            // Save the new user using the UserRepository
            SalaryModal salaryModal = new SalaryModal();
            salaryModal.setSalary(userSalaryModal.getSalary());
            salaryModal.setId(userSalaryModal.getId());
            salaryModal.setUserId(userSalaryModal.getId());


            UserModal userModal = new UserModal();
            userModal.setId(userSalaryModal.getId());
            userModal.setFullName(userSalaryModal.getFullName());

            userRepository.save(userModal);
            salayRepository.save(salaryModal);
            return "User created successfully";
        } catch (Exception e) {
            return "Error creating user: " + e.getMessage();
        }
    }


    @GetMapping("/salary")
    public List<UserModal> getSal(){
        return userRepository.findUsersWithSalaryGreaterThan50K();
    }
}
