package io.instacode.university.department.controller.impl;

import io.instacode.university.department.controller.DepartmentController;
import io.instacode.university.department.model.Department;
import io.instacode.university.department.dto.DepartmentDTO;
import io.instacode.university.department.mapper.DepartmentMapper;
import io.instacode.university.department.service.DepartmentService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/department-service")
@RestController
public class DepartmentControllerImpl implements DepartmentController {
  private final DepartmentService departmentService;
  private final DepartmentMapper departmentMapper;

  public DepartmentControllerImpl(DepartmentService departmentService, DepartmentMapper departmentMapper) {
    this.departmentService = departmentService;
    this.departmentMapper = departmentMapper;
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public DepartmentDTO save(@RequestBody DepartmentDTO departmentDTO) {
    Department department = departmentMapper.asEntity(departmentDTO);
    return departmentMapper.asDTO(departmentService.save(department));
  }

  @Override
  @GetMapping("/{id}")
  public DepartmentDTO findById(@PathVariable("id") Long id) {
    Department department = departmentService.findById(id).orElse(null);
    return departmentMapper.asDTO(department);
  }

  @Override
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    departmentService.deleteById(id);
  }

  @Override
  @GetMapping
  public List<DepartmentDTO> list() {
    return departmentMapper.asDTOList(departmentService.findAll());
  }

  @Override
  @GetMapping("/page-query")
  public Page<DepartmentDTO> pageQuery(Pageable pageable) {
    Page<Department> departmentPage = departmentService.findAll(pageable);
    List<DepartmentDTO> dtoList = departmentPage.stream().map(departmentMapper::asDTO).collect(Collectors.toList());
    return new PageImpl<>(dtoList, pageable, departmentPage.getTotalElements());
  }

  @Override
  @PutMapping("/{id}")
  public DepartmentDTO update(@RequestBody DepartmentDTO departmentDTO, @PathVariable("id") Long id) {
    Department department = departmentMapper.asEntity(departmentDTO);
    return departmentMapper.asDTO(departmentService.update(department, id));
  }
}