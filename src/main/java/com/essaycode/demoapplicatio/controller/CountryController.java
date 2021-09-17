package com.essaycode.demoapplicatio.controller;

import com.essaycode.demoapplicatio.Exception.CountryNotFoundException;
import com.essaycode.demoapplicatio.model.Country;
import com.essaycode.demoapplicatio.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/v1/rest/")
public class CountryController {

    private CountryService countryService;

    @PostMapping("/country")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }
    @GetMapping("/countries")
    public List<Country> fetchDepartmentList() {
        return countryService.fetchDepartmentList();
    }

    @GetMapping("/country/{id}")
    public Country fetchDepartmentById(@PathVariable("id") Long countryId)
            throws CountryNotFoundException {
        return countryService.fetchDepartmentById(countryId);
    }

    @DeleteMapping("/country/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) throws CountryNotFoundException {
        countryService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!!";
    }

    @PutMapping("/country/{id}")
    public Country updateDepartment(@PathVariable("id") Long countryId,
                                       @RequestBody Country country) {
        return countryService.updateDepartment(countryId,country);
    }
}
