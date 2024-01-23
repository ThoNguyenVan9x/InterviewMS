package thonguyenvan.interviewms.service.candidates;


import thonguyenvan.interviewms.entity.candidates.Recruiters;

import java.util.List;

public interface RecruiterService {
    List<Recruiters> findAll();
    Recruiters findByRecruiterName(String recruiterName);
    Recruiters save(Recruiters recruiters);
    Integer findIdByUserName(String userName);
    Recruiters findById(Integer id);

}
