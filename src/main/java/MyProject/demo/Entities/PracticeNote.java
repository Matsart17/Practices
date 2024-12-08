package MyProject.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PracticeNote")
public class PracticeNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
