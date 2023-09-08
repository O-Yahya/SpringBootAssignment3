package com.orange.assignment3.common;

import jakarta.annotation.PostConstruct;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Team {

    private String name;
    private Player player1;
    private Player player2;
    private Player player3;
    private List<Player> playerList;

    public void addPlayers(){
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
    }
}
