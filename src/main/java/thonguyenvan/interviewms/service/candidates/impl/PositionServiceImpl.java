package thonguyenvan.interviewms.service.candidates.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thonguyenvan.interviewms.entity.candidates.Positions;
import thonguyenvan.interviewms.repository.candidates.PositionRepository;
import thonguyenvan.interviewms.service.candidates.PositionService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    @Override
    public List<Positions>  findAll() {
       return (List<Positions>) positionRepository.findAll();
    }

    @Override
    public Positions findByPositionName(String positionName) {
        return positionRepository.findByPositionName(positionName);
    }
}
