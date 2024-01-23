package thonguyenvan.interviewms.repository.candidates;

import org.springframework.data.repository.CrudRepository;
import thonguyenvan.interviewms.entity.candidates.HighestLevel;

public interface HighestLevelRepository extends CrudRepository<HighestLevel,Integer> {
    HighestLevel findByHighestLevelName(String highestLevelName);
}
