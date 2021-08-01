package io.instacode.university.department.controller;

import io.instacode.university.department.dto.DepartmentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "Department API")
public interface DepartmentController {
  @ApiOperation("Add new data")
  public DepartmentDTO save(@RequestBody DepartmentDTO department);

  @ApiOperation("Find by Id")
  public DepartmentDTO findById(@PathVariable("id") Long id);

  @ApiOperation("Delete based on primary key")
  public void delete(@PathVariable("id") Long id);

  @ApiOperation("Find all data")
  public List<DepartmentDTO> list();

  @ApiOperation("Pagination request")
  public Page<DepartmentDTO> pageQuery(Pageable pageable);

  @ApiOperation("Update one data")
  public DepartmentDTO update(@RequestBody DepartmentDTO dto, @PathVariable("id") Long id);
}