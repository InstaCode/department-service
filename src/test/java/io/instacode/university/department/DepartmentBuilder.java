package io.instacode.university.department;

import io.instacode.university.department.dto.DepartmentDTO;
import io.instacode.university.department.mapper.DepartmentMapper;
import io.instacode.university.department.model.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartmentBuilder {
  public static Department getEntity() {
    return new Department(1L ,"ICS", "Computer Science");
  }

  public static DepartmentDTO getDTO() {
    return new DepartmentDTO(1L, "ICS", "Computer Science");
  }

  public static List<DepartmentDTO> getListDTO() {
    List<DepartmentDTO> departmentDTOList = new ArrayList<>();
    departmentDTOList.add(new DepartmentDTO(1L,"ICS", "Computer Science"));
    departmentDTOList.add(new DepartmentDTO(2L,"CFS", "Computer Forensics"));
    //departmentDTOList.add(new DepartmentDTO("MATH", "Mathematics"));
    return departmentDTOList;
  }

  public static List<Department> getListEntities() {
    List<Department> departmentList = new ArrayList<>();
    departmentList.add(new Department(1L,"ICS", "Computer Science"));
    departmentList.add(new Department(2L,"CFS", "Computer Forensics"));
    departmentList.add(new Department(3L,"MATH", "Mathematics"));
    return departmentList;
  }
}
