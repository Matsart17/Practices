package MyProject.demo.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface GroupRepository extends JpaRepository<Group, Long> {
}
