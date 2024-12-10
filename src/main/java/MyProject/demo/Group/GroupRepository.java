package MyProject.demo.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Object getGroupById(Group studentGroup);
    Group getGroupByGroupName(String groupName);
}
