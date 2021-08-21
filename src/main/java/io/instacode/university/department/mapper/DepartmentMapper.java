package io.instacode.university.department.mapper;

import io.instacode.university.department.dto.DepartmentDTO;
import io.instacode.university.department.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface DepartmentMapper extends GenericMapper<Department, DepartmentDTO> {


}