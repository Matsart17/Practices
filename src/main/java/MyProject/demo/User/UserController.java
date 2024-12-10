package MyProject.demo.User;

import MyProject.demo.Exceptions.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    public UserController(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    @GetMapping("/api/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", myUserRepository.findAll());
        return "users";
    }

    @PostMapping("/api/users")
    public String addUser(
            @ModelAttribute MyUser u, Model model) {
        if (u.getUsername().equals("www")) throw new ErrorException("Ошибка");
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userService.createUser(u);
        model.addAttribute("users", myUserRepository.findAll());
        return "users";
    }
}
