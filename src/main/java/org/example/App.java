package org.example;

import org.example.controller.CmdController;
import org.example.controller.Request;
import org.example.model.Command;
import org.example.repository.SayRepostiory;

import java.util.Scanner;

public class App {
    public void run(){
        SayRepostiory sayRepostiory = new SayRepostiory();
        CmdController cmdController = new CmdController(sayRepostiory);
        Scanner scanner = new Scanner(System.in);
        Request request = new Request();

        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            String input = scanner.next();

            Command cmd = request.findCmd(input);
            int inputId = request.getIdParam(input);

            switch (cmd){
                case List -> cmdController.list();
                case Add -> cmdController.add();
                case Update -> cmdController.update(inputId);
                case Delete -> cmdController.delete(inputId);
                case Quit -> cmdController.exit();
                case None -> System.out.println("명령어를 다시 입력해주세요.");
            }
        }
    }
}
