package io.instacode.university.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department-service")
public class DepartmentController {

    @Autowired
    private DepartmentService service;


}