package ru.gb.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.interview.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}