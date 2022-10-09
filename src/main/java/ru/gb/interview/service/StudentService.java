package ru.gb.interview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.interview.entity.Student;
import ru.gb.interview.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Такой студент не найден"));
    }

    public void update(Student student) {
        Student studentUpd = studentRepository.findById(student.getId()).orElseThrow(() ->
                new RuntimeException("Такой студент не найден"));
        studentUpd.setName(student.getName());
        studentUpd.setAge(student.getAge());
        studentRepository.save(student);
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

}
