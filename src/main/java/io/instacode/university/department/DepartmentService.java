package io.instacode.university.department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;


@Service
public class DepartmentService {

  @PersistenceContext
  private EntityManager entityManager;
}