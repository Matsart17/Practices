package MyProject.demo.Practice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PracticeRepository extends JpaRepository<Practice, Long> {
}
