package org.example;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        System.out.println("== 명언 앱 ==");
        int sequence=1;
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Say> storage = new HashMap<>();
        while(true) {
            System.out.print("명령) ");
            String cmd = scanner.next();
            if (cmd.equals("종료")) {
                exit(0);
            }
            if (cmd.equals("등록")) {
                System.out.print("명언: ");
                String saying = scanner.next();
                System.out.print("작가: ");
                String writer = scanner.next();
                storage.put(sequence,new Say(sequence,writer,saying));
                System.out.println(sequence+"번 명언이 등록되었습니다.");
                sequence++;
            }
            if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언 ");
                System.out.println("-----------------");
                for (int i = 1; i < sequence; i++) {
                    if(storage.containsKey(i)) {
                        Say temp = storage.get(i);
                        System.out.println(temp.getId() + " / " + temp.getWriter() + " / " + temp.getText());
                    }
                }
            }
            if (cmd.contains("삭제")){
                int eqIdx = cmd.indexOf("=");
                int inputId = Integer.parseInt(cmd.substring(eqIdx+1,cmd.length()));

                if(storage.containsKey(inputId)){
                    storage.remove(inputId);
                }else{
                    System.out.println(inputId+"번 명언은 존재하지 않습니다.");
                }
            }
            if (cmd.contains("수정")){
                int eqIdx = cmd.indexOf("=");
                int inputId = Integer.parseInt(cmd.substring(eqIdx+1,cmd.length()));

                if(storage.containsKey(inputId)) {
                    Say data = storage.get(inputId);

                    System.out.println("명언(기존): " + data.getText());
                    System.out.print("명언: ");
                    String inputText = scanner.next();

                    System.out.println("작가(기존): " + data.getText());
                    System.out.print("작가: ");
                    String inputWriter = scanner.next();

                    data.setText(inputText);
                    data.setWriter(inputWriter);

                    storage.replace(inputId,data);
                }
            }
        }
    }
}
class Say{
    private int id = -1;
    private String writer = "미등록";
    private String text = "미등록";

    public Say(int id, String writer, String text) {
        this.id = id;
        this.writer = writer;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getText() {
        return text;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setText(String text) {
        this.text = text;
    }
}