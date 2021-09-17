package com.essaycode.demoapplicatio.service.Impl;

import com.essaycode.demoapplicatio.Exception.CountryNotFoundException;
import com.essaycode.demoapplicatio.model.Country;
import com.essaycode.demoapplicatio.repository.CountryRepository;
import com.essaycode.demoapplicatio.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.IconUIResource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> fetchDepartmentList() {
        return countryRepository.findAll();
    }

    @Override
    public Country fetchDepartmentById(Long countryId) throws CountryNotFoundException {
        Optional<Country> country =
                countryRepository.findById(countryId);

        if(!country.isPresent()) {
            throw new CountryNotFoundException("Country Not available");
        }

        return  country.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
       countryRepository.deleteById(departmentId);
    }

    @Override
    public Country updateDepartment(Long countryId, Country country) {
        Country countryDB = countryRepository.findById(countryId).get();

        if(Objects.nonNull(country.getName()) &&
                !"".equalsIgnoreCase(country.getName())) {
            countryDB.setName(country.getName());
        }

        if(Objects.nonNull(country.getDescription()) &&
                !"".equalsIgnoreCase(country.getDescription())) {
            countryDB.setDescription(country.getDescription());
        }

          return countryRepository.save(countryDB);
    }
}
