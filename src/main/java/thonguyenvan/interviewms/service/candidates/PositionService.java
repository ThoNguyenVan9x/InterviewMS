package thonguyenvan.interviewms.service.candidates;


import thonguyenvan.interviewms.entity.candidates.Positions;

import java.util.List;

public interface PositionService {
    List<Positions> findAll();
    Positions findByPositionName(String positionName);
}
