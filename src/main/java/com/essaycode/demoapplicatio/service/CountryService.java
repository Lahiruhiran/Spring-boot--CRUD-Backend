package com.essaycode.demoapplicatio.service;

import com.essaycode.demoapplicatio.Exception.CountryNotFoundException;
import com.essaycode.demoapplicatio.model.Country;

import java.util.List;

public interface CountryService {

    Country addCountry(Country country);

    List<Country> fetchDepartmentList();

    Country fetchDepartmentById(Long countryId) throws CountryNotFoundException;

    void deleteDepartmentById(Long departmentId)throws CountryNotFoundException;

    Country updateDepartment(Long countryId, Country country);
}
