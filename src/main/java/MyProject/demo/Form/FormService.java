package MyProject.demo.Form;

import MyProject.demo.Group.Group;
import MyProject.demo.Group.GroupRepository;
import MyProject.demo.Student.Student;
import MyProject.demo.Student.StudentRepository;
import MyProject.demo.User.MyUser;
import MyProject.demo.User.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class FormService {
    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public void loadForm(FormDTO form) {
        MyUser myUser = new MyUser();
        Student student = new Student();
        Group group = new Group();
        myUser.setUsername(form.getUsername());
        myUser.setPassword(passwordEncoder.encode(form.getPassword()));
        group.setGroupName(form.getGroupName());
        if (myUserRepository.getMyUserByUsername(myUser.getUsername()) != null) {
            myUser = myUserRepository.getMyUserByUsername(myUser.getUsername());
            group = groupRepository.save(group);
            student.setStudentGroup(group);
            student.setMyUser(myUser);
            student.setFullName(form.getFullName());
            student.setAddress(form.getAddress());
            student.setPhone(form.getPhone());
            student.setEmail(form.getEmail());
            student.setComments(form.getComments());
            student.setCurrentJob(form.getCurrentJob());
            student.setJobType(form.getJobType());
            studentRepository.save(student);
        }else{
            throw new DataIntegrityViolationException("Данного пользователя нет в базе данных");
        }

    }
}
