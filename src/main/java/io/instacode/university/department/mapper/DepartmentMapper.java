package io.instacode.university.department.mapper;

import io.instacode.university.department.model.Department;
import io.instacode.university.department.dto.DepartmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface DepartmentMapper extends GenericMapper<Department, DepartmentDTO> {
  @Override
  @Mapping(target = "id", ignore = false)
  Department asEntity(DepartmentDTO dto);
}