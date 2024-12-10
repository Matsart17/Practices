package MyProject.demo.User;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String login);
    MyUser getMyUserByUsername(String username);
    MyUser getMyUserByUsernameAndPassword(String username, String password);
    UserDetails getUserDetailsByUsername(String username, Limit limit);
}
