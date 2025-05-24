package com.hostel.myHostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hostel.myHostel.model.Property;
import com.hostel.myHostel.service.PropertyService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/add")
    public Property addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);
    }

    @GetMapping
    public List<Property> getProperties() {
        return propertyService.getAllProperties();
    }
}
