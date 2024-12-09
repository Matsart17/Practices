package MyProject.demo.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
