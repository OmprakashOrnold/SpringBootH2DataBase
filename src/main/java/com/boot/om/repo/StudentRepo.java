package com.boot.om.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.boot.om.entities.Student;

public interface StudentRepo extends PagingAndSortingRepository<Student, Long> {

}
