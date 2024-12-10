package MyProject.demo.User;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<MyUser> getAllUsers() {
        return myUserRepository.findAll();

    }

    public MyUser getUserById(long id) {
        return myUserRepository.getReferenceById(id);
    }

    public MyUser createUser(MyUser myUser) {
        if(myUserRepository.getMyUserByUsername(myUser.getUsername()) != null) {
            throw new UsernameNotFoundException("Username already exists");
        }return myUserRepository.save(myUser);
    }

    public MyUser deleteUser(long id) {
        MyUser myUser = getUserById(id);
        myUserRepository.deleteById(id);
        return myUser;
    }

    public MyUser updateUser(MyUser myUser, long id) {
        myUser.setId(id);
        return myUserRepository.save(myUser);
    }

    public MyUser convertDTOToUser(UserDTO userDTO) {
        MyUser myUser = new MyUser();
        myUser.setUsername(userDTO.getUsername());
        myUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        myUser.setRole(userDTO.getRole());
        return myUser;
    }
    // Дополнительные функции
    public MyUser getUserByUsername(String username) {
        return myUserRepository.getMyUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return myUserRepository.getUserDetailsByUsername(username, Limit.unlimited());
    }
}
