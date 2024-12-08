package MyProject.demo.Controllers;

import MyProject.demo.Entities.Student;
import MyProject.demo.Exceptions.ErrorException;
import MyProject.demo.Repositories.StudentRepository;
import MyProject.demo.User.User;
import MyProject.demo.User.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users.html";
    }

    @PostMapping("/users")
    public String addUser(
            @ModelAttribute User u, Model model) {
        if (u.getName().equals("www")) throw new ErrorException("Ошибка");
        userRepository.save(u);
        model.addAttribute("users", userRepository.findAll());
        return "users.html";
    }
}
