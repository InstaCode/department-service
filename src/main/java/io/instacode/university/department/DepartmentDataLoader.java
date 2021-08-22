package io.instacode.university.department;

import io.instacode.university.department.model.Department;
import io.instacode.university.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DepartmentDataLoader implements ApplicationRunner {

  private DepartmentService departmentService;

  @Autowired
  public DepartmentDataLoader(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Department department = Department.builder().departmentCode("ICS").departmentName("Computer Science").build();
    departmentService.save(department);
  }
}

/*



package com.baeldung.spring.cloud.bootstrap.svcbook;

import com.baeldung.spring.cloud.bootstrap.svcbook.book.Book;
import com.baeldung.spring.cloud.bootstrap.svcbook.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private BookService bookService;

    @Autowired
    public DataLoader(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        this.bookService.createBook(new Book("Aldous Huxley", "Brave new world"));
        this.bookService.createBook(new Book("George Orwell", "Animal Farm"));
    }
}

 */
