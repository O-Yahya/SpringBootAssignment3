package com.orange.assignment3.common;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Scope("prototype")
public class Defender implements Player{

    private String name;
    private int shirtNum;
    private final String position = "DEF";

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setShirtNum(int shirtNum) {
        this.shirtNum = shirtNum;
    }

    @Override
    public int getShirtNum() {
        return shirtNum;
    }

    @Override
    public String toString(){
        return "\nPlayer name: " + getName() + " Shirt number: " + getShirtNum() + "\n";
    }
}
