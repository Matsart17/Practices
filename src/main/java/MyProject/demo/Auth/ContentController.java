package MyProject.demo.Auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

  @GetMapping("/admin/home")
  public String handleAdminHome() {
    return "adminhome";
  }

  @GetMapping("/user/home")
  public String handleUserHome() {
    return "userhome";
  }

  @GetMapping("/login")
  public String handleLogin() {
    return "custom_login";
  }

}
