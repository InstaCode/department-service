package io.instacode.university.department.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name = "Department")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Department implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  private String departmentCode;
  private String departmentName;

  public Department(String departmentCode, String departmentName){
    this.departmentCode = departmentCode;
    this.departmentName = departmentName;
  }




}
