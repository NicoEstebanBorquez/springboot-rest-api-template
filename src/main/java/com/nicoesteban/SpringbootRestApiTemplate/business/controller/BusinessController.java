package com.nicoesteban.SpringbootRestApiTemplate.business.controller;

import com.nicoesteban.SpringbootRestApiTemplate.business.Business;
import com.nicoesteban.SpringbootRestApiTemplate.business.repository.BusinessRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BusinessController {

    @Autowired
    BusinessRepository businessRepository;

    @GetMapping("businesses/{id}")
    public ResponseEntity<Business> getBusiness(@PathVariable Long id) {
        return businessRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/businesses")
    public ResponseEntity<List<Business>> getBusinesses() {
        List<Business> businesses = businessRepository.findAll();
        return !businesses.isEmpty() ? ResponseEntity.ok(businesses) : ResponseEntity.noContent().build();
    }

    @PostMapping("/businesses")
    public ResponseEntity<Business> createBusiness(@RequestBody @Valid Business business) {
        return ResponseEntity.status(HttpStatus.CREATED).body(businessRepository.save(business));
    }

    @DeleteMapping("businesses/{id}")
    public ResponseEntity<Void> deleteBusiness(@PathVariable Long id) {
        try {
            businessRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
