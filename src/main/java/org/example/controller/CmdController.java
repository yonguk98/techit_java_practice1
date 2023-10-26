package org.example.controller;

import org.example.model.Command;
import org.example.service.SayService;

import java.util.Scanner;

public class CmdController {

    SayService sayService;
    Scanner scanner;
    Request request;
    public CmdController(SayService sayService){
        this.sayService = sayService;
        this.scanner = new Scanner(System.in);
        this.request = new Request();
    }

    public void start(){
        System.out.print("명령) ");
        String input = scanner.next();

        Command cmd = request.findCmd(input);
        int inputId = request.getIdParam(input);

                switch (cmd){
            case List -> sayService.list();
            case Add -> sayService.add();
            case Update -> sayService.update(inputId);
            case Delete -> sayService.delete(inputId);
            case Quit -> sayService.exit();
            case None -> System.out.println("명령어를 다시 입력해주세요.");
        }
    }
}
