package com.orange.assignment3.common;

import jakarta.annotation.PostConstruct;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class League {

    private String name;
    private Team team1;
    private Team team2;

    public String simMatch(){
        Random r = new Random();
        Team winner = team2;
        Team loser = team1;

        if (r.nextInt(10) % 2 == 0){
            winner = team1;
            loser = team2;
        }

        int winnerGoals = r.nextInt(8);
        int loserGoals = r.nextInt(winnerGoals+1);

        List<String> scorers = new ArrayList<>();
        for (int i = 0; i<winnerGoals; i++){
            scorers.add(winner.getPlayerList().get(r.nextInt(winner.getPlayerList().size())).getName());
        }
        for (int i = 0; i<loserGoals; i++){
            scorers.add(loser.getPlayerList().get(r.nextInt(loser.getPlayerList().size())).getName());
        }

        return winner.getName() + " V " + loser.getName() + "\nWinner: " + winner.getName() + "\n" + winnerGoals + " - " + loserGoals + "\nScorers:\n" + scorers;
    }
}
