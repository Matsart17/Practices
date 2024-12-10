package MyProject.demo.Student;

import MyProject.demo.Student.StudentService;
import MyProject.demo.Exceptions.ErrorException;
import MyProject.demo.Group.GroupRepository;
import MyProject.demo.User.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/students")
public class StudentController {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository, GroupRepository groupRepository, MyUserRepository myUserRepository, GroupRepository groupRepository1, MyUserRepository myUserRepository1) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String viewProducts(@ModelAttribute Student s, Model model) {
        model.addAttribute("student", studentRepository.findAll());
        return "students";
    }

    @PostMapping
    public String addStudent(
            @ModelAttribute Student s, Model model) {
        if (s.getFullName().equals("www")) throw new ErrorException("Ошибка");
        studentRepository.save(s);
        model.addAttribute("student", studentRepository.findAll());
        return "students";
    }

    @GetMapping("/edit")
    public String updateStudent(
            @ModelAttribute Student s,
            Model model) {
        studentRepository.save(s);
        model.addAttribute("student", studentRepository.findAll());
        return "students";
    }

    @GetMapping("/delete")
    private String deleteStudent(
            @RequestParam Long id,
            Model model) {
        try {
            if (id == 100) throw new RuntimeException();
            studentRepository.deleteById(id);
            model.addAttribute("student", studentRepository.findAll());
            return "students";
        } catch (RuntimeException e) {
            model.addAttribute("status", "Ошибка номера записи");
            model.addAttribute("student", studentRepository.findAll());
            return "students";
        }
    }
}
