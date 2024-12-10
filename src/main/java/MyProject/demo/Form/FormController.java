package MyProject.demo.Form;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {
    @Autowired
    private FormService formService;
    @GetMapping("/api/user/form")
    public String form(Model model) {
        FormDTO f = new FormDTO();
        model.addAttribute("form", f);
        return "form";
    }

    @PostMapping(value = "/api/user/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addForm(
            @RequestParam String fullName,
            @RequestParam String address,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String comments,
            @RequestParam String currentJob,
            @RequestParam String jobType,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String groupName,
            Model model) {
        FormDTO f = new FormDTO();
        f.setAddress(address);
        f.setFullName(fullName);
        f.setPhone(phone);
        f.setEmail(email);
        f.setComments(comments);
        f.setCurrentJob(currentJob);
        f.setJobType(jobType);
        f.setUsername(username);
        f.setPassword(password);
        f.setGroupName(groupName);
         formService.loadForm(f);
        return "form";
    }
}
