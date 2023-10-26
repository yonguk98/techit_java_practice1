package org.example;

import org.example.controller.CmdController;
import org.example.controller.Request;
import org.example.model.Command;
import org.example.repository.SayRepostiory;
import org.example.service.SayService;

import java.util.Scanner;

public class App {
    public void run(){
        SayRepostiory sayRepostiory = new SayRepostiory();
        SayService sayService = new SayService(sayRepostiory);
        CmdController cmdController = new CmdController(sayService);

        System.out.println("== 명언 앱 ==");
        while(true){
            cmdController.start();
        }
    }
}
