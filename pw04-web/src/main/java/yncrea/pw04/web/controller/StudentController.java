package yncrea.pw04.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yncrea.pw04.entity.Student;
import yncrea.pw04.service.StudentService;

import javax.inject.Inject;

@Controller
public class StudentController {

    @Inject
    private StudentService studentService;

    @RequestMapping(path = "/list")
    public String getListOfStudents(ModelMap modelMap){
        modelMap.put("students", this.studentService.findAllWithCourses());
        return "studentsList";
    }

    @RequestMapping(path = "/form")
    public String getForm(ModelMap modelMap){
        modelMap.put("student", new Student());
        return "studentForm";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("student") Student student){
        this.studentService.saveStudent(student);
        return "redirect:list";
    }
}
