package thonguyenvan.interviewms.service.candidates;


import thonguyenvan.interviewms.entity.candidates.HighestLevel;

import java.util.List;

public interface HighestLevelService {
    List<HighestLevel> findAll();
    HighestLevel findByHighestLevelName(String highestLevelName);
}
