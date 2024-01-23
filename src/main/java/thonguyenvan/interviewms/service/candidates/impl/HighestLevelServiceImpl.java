package thonguyenvan.interviewms.service.candidates.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thonguyenvan.interviewms.entity.candidates.HighestLevel;
import thonguyenvan.interviewms.repository.candidates.HighestLevelRepository;
import thonguyenvan.interviewms.service.candidates.HighestLevelService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HighestLevelServiceImpl implements HighestLevelService {
    private final HighestLevelRepository highestLevelRepository;
    @Override
    public List<HighestLevel> findAll() {
        return (List<HighestLevel>) highestLevelRepository.findAll();
    }

    @Override
    public HighestLevel findByHighestLevelName(String highestLevelName) {
        return highestLevelRepository.findByHighestLevelName(highestLevelName);
    }
}
