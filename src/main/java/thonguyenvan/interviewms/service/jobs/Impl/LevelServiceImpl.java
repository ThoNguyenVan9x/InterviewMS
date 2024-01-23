package thonguyenvan.interviewms.service.jobs.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thonguyenvan.interviewms.entity.jobs.Levels;
import thonguyenvan.interviewms.repository.job.LevelRepository;
import thonguyenvan.interviewms.service.jobs.LevelService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    @Override
    public List<Levels> findAll() {
        return (List<Levels>) levelRepository.findAll();
    }

    @Override
    public Levels findByLevelName(String levelName) {
        return levelRepository.findByLevelName(levelName);
    }
}
