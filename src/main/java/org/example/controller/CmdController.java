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

//    SayRepostiory sayRepostiory;
//    Scanner scanner;
//    public CmdController(SayRepostiory sayRepostiory){
//        this.sayRepostiory = sayRepostiory;
//        this.scanner = new Scanner(System.in);
//    }
//
//    public void exit(){
//        if(sayRepostiory.save()){
//            System.out.println("save success, application close");
//            System.exit(0);
//        }
//    }
//
//    public void add(){
//        System.out.print("명언: ");
//        String content = scanner.next();
//        System.out.print("작가: ");
//        String writer = scanner.next();
//        sayRepostiory.put(writer,content);
//    }
//
//    public void list(){
//        System.out.println("번호 / 작가 / 명언 ");
//        System.out.println("-----------------");
//        for (Say data : sayRepostiory.list()) {
//            System.out.println(data.getId() + " / " + data.getWriter() + " / " + data.getText());
//        }
//    }
//
//    public void update(int inputId){
//        Say findData = sayRepostiory.findById(inputId);
//        if(findData!=null) {
//            System.out.println("명언(기존): " + findData.getText());
//            System.out.print("명언: ");
//            String inputContent = scanner.next();
//
//            System.out.println("작가(기존): " + findData.getText());
//            System.out.print("작가: ");
//            String inputWriter = scanner.next();
//
//            sayRepostiory.update(inputId,inputWriter,inputContent);
//        }
//    }
//
//    public void delete(int inputId){
//        if(sayRepostiory.isExistById(inputId)) {
//            sayRepostiory.deleteById(inputId);
//        }else{
//            System.out.println(inputId+"번 명언은 존재하지 않습니다.");
//        }
//    }
}
