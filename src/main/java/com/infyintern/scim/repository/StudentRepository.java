package com.infyintern.scim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infyintern.scim.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer>{

}
