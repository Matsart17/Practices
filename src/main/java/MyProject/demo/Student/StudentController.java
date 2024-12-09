package MyProject.demo.Student;

import MyProject.demo.Exceptions.ErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String viewProducts(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students.html";
    }

    @PostMapping("/students")
    public String addStudent(
            @ModelAttribute Student s, Model model) {
        if (s.getFull_name().equals("www")) throw new ErrorException("Ошибка");
        studentRepository.save(s);
        model.addAttribute("students", studentRepository.findAll());
        return "students.html";
    }

    @GetMapping("/students/edit")
    public String updateStudent(
            @ModelAttribute Student p,
            Model model) {
        studentRepository.save(p);
        model.addAttribute("students", studentRepository.findAll());
        return "students.html";
    }

    @GetMapping("/students/delete")
    private String deleteStudent(
            @RequestParam Long id,
            Model model) {
        try {
            if (id == 100) throw new RuntimeException();
            studentRepository.deleteById(id);
            model.addAttribute("students", studentRepository.findAll());
            return "students.html";
        } catch (RuntimeException e) {
            model.addAttribute("status", "Ошибка номера записи");
            model.addAttribute("students", studentRepository.findAll());
            return "students.html";
        }
    }
}
