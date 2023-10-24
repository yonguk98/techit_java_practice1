package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        //명언 저장 Map 객체 및 아이디 관리용 변수 선언
        Map<Integer,Say> storage = new HashMap<>();
        int sequence = 1;

        try {//세이브 파일이 존재하면 storage 및 sequence 업데이트
        storage = load();
        sequence = storage.keySet().stream().mapToInt(x->x).max().getAsInt()+1;
        } catch (IOException e) {
        }

        //어플 시작
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("명령) ");
            String cmd = scanner.next();

            //종료 명령
            if (cmd.equals("종료")) {
                save(mapToJson(storage,sequence));
                exit(0);
            }
            //등록 명령
            if (cmd.equals("등록")) {
                System.out.print("명언: ");
                String saying = scanner.next();
                System.out.print("작가: ");
                String writer = scanner.next();
                storage.put(sequence,new Say(sequence,writer,saying));
                System.out.println(sequence+"번 명언이 등록되었습니다.");
                sequence++;
            }
            //목록 명령
            if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언 ");
                System.out.println("-----------------");
                for (int i = 1; i <= sequence; i++) {
                    if(storage.containsKey(i)) {
                        Say temp = storage.get(i);
                        System.out.println(temp.getId() + " / " + temp.getWriter() + " / " + temp.getText());
                    }
                }
            }
            //삭제 명령, '?id=' 없을시 인식안함
            if (cmd.contains("삭제?id=")){
                int eqIdx = cmd.indexOf("=");
                int inputId = Integer.parseInt(cmd.substring(eqIdx+1,cmd.length()));

                if(storage.containsKey(inputId)){
                    storage.remove(inputId);
                }else{
                    System.out.println(inputId+"번 명언은 존재하지 않습니다.");
                }
            }
            //수정 명령, '?id=' 없을시 인식안함
            if (cmd.contains("수정?id=")){
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
    // json형식으로 작성된 문자열 파일을 저장
    public static void save(String  jsonData) throws IOException {
        FileWriter fileWriter = new FileWriter("./save.json");
        fileWriter.write(jsonData);
        fileWriter.flush();
        fileWriter.close();
    }
    // 명언 저장용 map 객체를 json 형식의 String 객체로 변환
    public static String mapToJson(Map<Integer,Say> map,int sequence) throws JsonProcessingException {
        List<Say> sayList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 1; i < sequence; i++) {
            if(map.containsKey(i)) {
                sayList.add(map.get(i));
            }
        }
        return objectMapper.writeValueAsString(sayList);
    }
    //세이브 파일 읽기
    public static Map<Integer,Say> load() throws IOException {
        String path = "./save.json";
        File jsonFile = new File(path);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map> list = objectMapper.readValue(jsonFile,List.class);

        Map<Integer,Say> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String ,Object> data = list.get(i);
            Say say = new Say((int)data.get("id"),(String) data.get("writer"),(String) data.get("text"));
            map.put((int)data.get("id"),say);
        }
        return map;
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