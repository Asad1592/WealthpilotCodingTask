package service;


import domain.Soccer;
import org.springframework.stereotype.Service;
import repository.TeamsRepository;

import java.util.List;

@Service
public class SoccerService {
    private final TeamsRepository teamsRepository;

    public SoccerService(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }
    public Iterable<Soccer> list(){
    return teamsRepository.findAll();
    }

    public Iterable<Soccer>save(List<Soccer> soccers){
        return teamsRepository.saveAll(soccers);
    }


}
