package MyProject.demo.Practice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PracticeService {
    @Autowired
    private PracticeRepository practiceRepository;

    public boolean practiceExitsById(long id) {
        return practiceRepository.existsById(id);
    }

    public Practice getPracticeById(long id) {
        return practiceRepository.getReferenceById(id);
    }

    public List<Practice> getAllPractices() {
        return practiceRepository.findAll();
    }

    public Practice addPractice(Practice practice) {
            return practiceRepository.save(practice);
    }

    public Practice updatePracticeById(Practice practice, long id) {
        if (practiceExitsById(id)) {
            practice.setId(id);
            return practiceRepository.save(practice);
        } else {
            throw new DataIntegrityViolationException("Практики с id="+id+" не существует");
        }
    }

    public void deletePracticeById(long id) {
        if (practiceExitsById(id)) {
            practiceRepository.deleteById(id);
        } else {
            throw new DataIntegrityViolationException("Практики с id="+id+" не существует");
        }
    }

    public Practice convertDTOtoPractice(PracticeDTO practiceDTO) {
        Practice practice = new Practice();
        practice.setDescription(practiceDTO.getDescription());
        practice.setRelevance(practiceDTO.getRelevance());
        practice.setDirector(practiceDTO.getDirector());
        practice.setPosition(practiceDTO.getPosition());
        practice.setWork(practiceDTO.getWork());
        practice.setStarting(practiceDTO.getStarting());
        practice.setEnding(practiceDTO.getEnding());
        practice.setReportPassed(practiceDTO.isReportPassed());
        practice.setFutureWork(practiceDTO.isFutureWork());
        practice.setNextYear(practiceDTO.isNextYear());
        practice.setPayed(practiceDTO.isPayed());
        return practice;
    }
}
