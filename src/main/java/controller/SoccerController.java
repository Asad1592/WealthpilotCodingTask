package controller;


import domain.Soccer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SoccerService;

@RestController
@RequestMapping("/soccers")
public class SoccerController {

    private final SoccerService soccerService;

    public SoccerController(SoccerService soccerService){
        this.soccerService=soccerService;
    }

    @GetMapping("/list")

    public Iterable<Soccer> list(){
        return soccerService.list();
    }
}
