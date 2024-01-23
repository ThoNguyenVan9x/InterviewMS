package thonguyenvan.interviewms.repository.candidates;

import org.springframework.data.repository.CrudRepository;
import thonguyenvan.interviewms.entity.candidates.Positions;

public interface PositionRepository extends CrudRepository<Positions,Integer> {
    Positions findByPositionName(String positionName);
}
