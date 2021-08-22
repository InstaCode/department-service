package io.instacode.university.department;

import io.instacode.university.department.dto.DepartmentDTO;
import io.instacode.university.department.mapper.DepartmentMapper;
import io.instacode.university.department.model.Department;
import java.util.List;

public class DepartmentBuilder {
  public static Department getEntity() {
    return new Department(Long.valueOf("1L"), "ICS", "Computer Science");
  }

  public static DepartmentDTO getDTO() {
    return null;
  }

  public static List<DepartmentDTO> getListDTO() {
    return null;
  }

  public static List<Department> getListEntities() {
    return null;
  }
}
