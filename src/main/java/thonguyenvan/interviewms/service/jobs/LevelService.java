package thonguyenvan.interviewms.service.jobs;


import thonguyenvan.interviewms.entity.jobs.Levels;

import java.util.List;

public interface LevelService {

  List<Levels> findAll();

  Levels findByLevelName(String levelName);
}
