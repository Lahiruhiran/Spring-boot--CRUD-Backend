package com.essaycode.demoapplicatio.repository;

import com.essaycode.demoapplicatio.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

}
