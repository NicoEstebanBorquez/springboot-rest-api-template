package com.nicoesteban.SpringbootRestApiTemplate.business.repository;


import com.nicoesteban.SpringbootRestApiTemplate.business.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

}
