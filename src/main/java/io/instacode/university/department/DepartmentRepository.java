package io.instacode.university.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

  Department findDepartmentById(Long id);
  Department findDepartmentByDepartmentCode(String code);

}