package io.instacode.university.department;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import io.instacode.university.department.data.Converter;
import io.instacode.university.department.data.Course;
import io.instacode.university.department.model.Department;
import io.instacode.university.department.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DepartmentServiceApplicationTests {

  @Test
  void contextLoads() {
  }

  @Autowired
  private DepartmentRepository departmentRepository;

  public void loadMyData() throws IOException {
    File file = new File("data/MetroState-Course-Info_2021-08-22.json");
    FileReader reader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(reader);
    StringBuilder stringBuilder = new StringBuilder();
    String line = null;
    String ls = System.getProperty("line.separator");
    while ((line = bufferedReader.readLine()) != null) {
      stringBuilder.append(line);
      stringBuilder.append(ls);
    }
    // delete the last new line separator
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    bufferedReader.close();

    String content = stringBuilder.toString();
    Course[] courses = Converter.fromJsonString(content);

    for (Course course : courses)    {
      if (departmentRepository.findDepartmentByDepartmentCode(course.getDepartment()) == null)
      departmentRepository.save(new Department(course.getDepartment(), ""));
      System.out.println("Department added: " + course.getDepartment());
    }

  }
}
