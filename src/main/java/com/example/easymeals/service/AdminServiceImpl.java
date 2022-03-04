package com.example.easymeals.service;

import com.example.easymeals.dataprovider.dto.AdminDto;
import com.example.easymeals.entity.Admin;
import com.example.easymeals.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.crypto.spec.PSource;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin save(AdminDto adminDto) {
        Admin admin = modelMapper.map(adminDto, Admin.class);
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> update(Long id, AdminDto adminDto) {
        return adminRepository.findById(id).map(PSource -> {
            Admin admin = modelMapper.map(adminDto, Admin.class);
            admin.setId(id);
            return admin;
        });
    }

    @Override
    public void deleteById(Long id) {
        try {
            adminRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.info(e.getMessage(), e);
        }
    }
}
