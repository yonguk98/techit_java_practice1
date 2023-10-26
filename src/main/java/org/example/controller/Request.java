package org.example.controller;

import org.example.model.Command;

public class Request {
    public Command findCmd(String input){
        for (Command value : Command.values()) {
            if(input.contains(value.getKr())){
                return value;
            }
        }
        return Command.None;
    }


    public int getIdParam(String input){
        if(findCmd(input)== Command.Delete || findCmd(input) == Command.Update){
            int eqIndex = input.indexOf("=");
            if(eqIndex==-1){
                return -1;
            }else{
                return Integer.parseInt(input.substring(eqIndex+1,input.length()));
            }
        }
        return -1;
    }

}
