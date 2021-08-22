package io.instacode.university.department.dto;

public class DepartmentDTO extends AbstractDTO<Long> {
  private Long id;
  private String departmentCode;
  private String departmentName;

  public DepartmentDTO() {
  }

  public DepartmentDTO(String departmentCode, String departmentName) {
    super();
    this.departmentCode = departmentCode;
    this.departmentName = departmentName;
  }

  public DepartmentDTO(Long id, String departmentCode, String departmentName) {
    this.id = id;
    this.departmentCode = departmentCode;
    this.departmentName = departmentName;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }

  public void setDepartmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
  }

  public String getDepartmentCode() {
    return this.departmentCode;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getDepartmentName() {
    return this.departmentName;
  }
}