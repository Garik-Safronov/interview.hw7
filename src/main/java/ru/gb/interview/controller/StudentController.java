package ru.gb.interview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.interview.entity.Student;
import ru.gb.interview.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public String saveStudent(Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @RequestMapping("/add")
    public String productAdd(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student_add";
    }

    @GetMapping("/all")
    public String getStudentsList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students-list";
    }

    @GetMapping("/{id}")
    public String findById (Model model, @PathVariable Long id) {
        Student student;
        if (id != null) {
            student = studentService.findById(id);
        } else {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        return "student-info";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(Model model, @PathVariable Long id) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student_upd";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }


}
