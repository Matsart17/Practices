package MyProject.demo.User;

import MyProject.demo.Exceptions.ErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final MyUserRepository myUserRepository;

    public UserController(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    @GetMapping("/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", myUserRepository.findAll());
        return "users.html";
    }

    @PostMapping("/users")
    public String addUser(
            @ModelAttribute MyUser u, Model model) {
        if (u.getUsername().equals("www")) throw new ErrorException("Ошибка");
        myUserRepository.save(u);
        model.addAttribute("users", myUserRepository.findAll());
        return "users.html";
    }
}
