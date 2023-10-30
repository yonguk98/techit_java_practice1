package org.example;

import org.example.controller.CmdController;
import org.example.repository.HashmapSayRepostiory;
import org.example.repository.SayRepository;
import org.example.service.SayService;

public class App {
    private final SayRepository sayRepository;
    private SayService sayService;
    private CmdController cmdController;

    public App(){
        sayRepository = new HashmapSayRepostiory();
        sayService = new SayService(sayRepository);
        cmdController = new CmdController(sayService);
    }
    public void run(){
        System.out.println("== 명언 앱 ==");
        while(true){
            cmdController.start();
        }
    }
}
