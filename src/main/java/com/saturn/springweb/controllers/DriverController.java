package com.saturn.springweb.controllers;

import com.saturn.springweb.dto.DriverDto;
import com.saturn.springweb.services.DriverService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping(path = "getDrivers")
    public List<DriverDto> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @PostMapping(path="/createDriver")
    public DriverDto saveDriver(@Valid @RequestBody DriverDto dto){
        return driverService.saveDriver(dto);
    }

    @GetMapping(path = "driver/{driverId}")
    public DriverDto getById(@PathVariable Long driverId){
        return driverService.getDriverById(driverId);
    }

    @PutMapping(path = "driver/{driverId}")
    public DriverDto updateDriver(@Valid @RequestBody DriverDto dto, @PathVariable Long driverId){
        return driverService.updateDriver(dto, driverId);
    }

    @PatchMapping(path = "driver/{dId}")
    public DriverDto patchDriver(@RequestBody Map<String, Object> updates, @PathVariable Long dId){
        return driverService.updatePartial(updates, dId);
    }

    @DeleteMapping(path = "driver/{dId}")
    public Boolean deleteDriver(@PathVariable Long dId){
        return driverService.deleteDriver(dId);
    }


}
