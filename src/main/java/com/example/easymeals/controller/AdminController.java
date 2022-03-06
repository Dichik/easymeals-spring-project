package com.example.easymeals.controller;

import com.example.easymeals.dataprovider.dto.AdminDto;
import com.example.easymeals.exception.InvalidIdentifierException;
import com.example.easymeals.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    // TODO check, there should be bugs !!!

    private final AdminService adminService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable Long id) {
        return adminService.findById(id)
                .map(admin -> ResponseEntity.ok(modelMapper.map(admin, AdminDto.class)))
                .orElseThrow(() -> new InvalidIdentifierException(id));
    }

    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<AdminDto> updateAdminById(
            @PathVariable Long id,
            @RequestBody AdminDto adminDto) {
        return adminService.update(id, adminDto)
                .map(admin -> ResponseEntity.ok(modelMapper.map(admin, AdminDto.class)))
                .orElseThrow(() -> new InvalidIdentifierException(id));
    }

    @DeleteMapping("/{id:[\\d]+}")
    public ResponseEntity<AdminDto> deleteAdminById(@PathVariable Long id) {
        adminService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
