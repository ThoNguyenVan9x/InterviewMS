package thonguyenvan.interviewms.repository.interview.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import thonguyenvan.interviewms.entity.interview.Interviewer;
import thonguyenvan.interviewms.repository.interview.InterviewerRepositoryCustom;

public class InterviewerRepositoryCustomImpl implements InterviewerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Interviewer findByInterviewerName(String interviewerName) {
        return (Interviewer) entityManager.createQuery("select i from Interviewer i where i.interviewerName = :name")
                .setParameter("name", interviewerName)
                .getSingleResult();
    }
}
