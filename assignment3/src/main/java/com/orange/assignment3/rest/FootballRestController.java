package com.orange.assignment3.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orange.assignment3.common.*;

import java.util.ArrayList;

@RestController
public class FootballRestController {

    private League league;

    @Autowired
    public FootballRestController(@Value("${league.name}") String leagueName, @Value("${team1.name}") String t1name,  @Value("${team2.name}") String t2name, @Value("${striker1.name}") String st1name, @Value("${striker1.num}") int st1num, @Value("${defender1.name}") String def1name, @Value("${defender1.num}") int def1num, @Value("${goalkeeper1.name}") String gk1name, @Value("${goalkeeper1.num}") int gk1num, @Value("${striker2.name}") String st2name, @Value("${striker2.num}") int st2num, @Value("${defender2.name}") String def2name, @Value("${defender2.num}") int def2num, @Value("${goalkeeper2.name}") String gk2name, @Value("${goalkeeper2.num}") int gk2num, @Qualifier("striker") Player striker1, @Qualifier("defender") Player defender1, @Qualifier("goalkeeper") Player goalkeeper1,
                                  @Qualifier("striker") Player striker2, @Qualifier("defender") Player defender2, @Qualifier("goalkeeper") Player goalkeeper2) {
        striker1.setName(st1name);
        striker1.setShirtNum(st1num);

        defender1.setName(def1name);
        defender1.setShirtNum(def1num);

        goalkeeper1.setName(gk1name);
        goalkeeper1.setShirtNum(gk1num);
        Team t = new Team(t1name, striker1, defender1, goalkeeper1, new ArrayList<>());

        striker2.setName(st2name);
        striker2.setShirtNum(st2num);

        defender2.setName(def2name);
        defender2.setShirtNum(def2num);

        goalkeeper2.setName(gk2name);
        goalkeeper2.setShirtNum(gk2num);
        Team t2 = new Team(t2name, striker2, defender2, goalkeeper2, new ArrayList<>());

        t.addPlayers();
        t2.addPlayers();
        league = new League(leagueName, t, t2);
    }

    @GetMapping("/footballgame")
    public String getInfo(){
        String leagueInfo = league.toString();
        return leagueInfo + "\n\n" + league.simMatch();
    }
}
