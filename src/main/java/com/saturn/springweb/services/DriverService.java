package com.saturn.springweb.services;

import com.saturn.springweb.dto.DriverDto;
import com.saturn.springweb.entities.DriverEntity;
import com.saturn.springweb.repositories.DriverRepo;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class DriverService {

    private final ModelMapper mapper;
    private final DriverRepo driverRepo;

    public DriverService(ModelMapper mapper, DriverRepo driverRepo){
        this.driverRepo = driverRepo;
        this.mapper = mapper;
    }

    public DriverDto getDriverById(Long id){
        DriverEntity driver = driverRepo.findById(id).orElseThrow(() -> new RuntimeException("Driver does not exists"));
        return mapper.map(driver, DriverDto.class);
    }

    public List<DriverDto> getAllDrivers(){
        List<DriverEntity> drivers = driverRepo.findAll();
        return drivers.stream().map(driver -> mapper.map(driver, DriverDto.class)).toList();
    }

    public DriverDto saveDriver(DriverDto driver){
        DriverEntity driverEntity = mapper.map(driver, DriverEntity.class);
        return mapper.map(driverRepo.save(driverEntity), DriverDto.class);
    }

    public DriverDto updateDriver(DriverDto driver, Long id){
        DriverEntity driverEntity = mapper.map(driver, DriverEntity.class);
        driverEntity.setId(id);
        return mapper.map(driverRepo.save(driverEntity), DriverDto.class);
    }

    public DriverDto updatePartial(Map<String, Object> updates, Long id) {
        DriverEntity driver = driverRepo.findById(id).orElseThrow(() -> new RuntimeException("driver does not exists"));
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.getRequiredField(DriverEntity.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,driver,value);
        });
        return mapper.map(driverRepo.save(driver),DriverDto.class);
    }

    public Boolean deleteDriver(Long id){
        if(driverRepo.existsById(id)){
            driverRepo.deleteById(id);
            return true;
        }else throw new NoSuchElementException("driver does not exists");
    }
}
