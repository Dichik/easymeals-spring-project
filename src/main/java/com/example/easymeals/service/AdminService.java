package com.example.easymeals.service;

import com.example.easymeals.dataprovider.dto.AdminDto;
import com.example.easymeals.entity.Admin;

import java.util.Optional;

public interface AdminService {

    Optional<Admin> findById(Long id);

    Admin save(AdminDto adminDto);

    Optional<Admin> update(Long id, AdminDto adminDto);

    void deleteById(Long id);

}
