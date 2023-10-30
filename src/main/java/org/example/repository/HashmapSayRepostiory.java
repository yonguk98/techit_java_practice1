package org.example.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Say;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class HashmapSayRepostiory implements SayRepository {
    private Map<Integer, Say> storage;
    private ObjectMapper objectMapper;
    private int sequence = 1;
    public HashmapSayRepostiory(){
        objectMapper = new ObjectMapper();
        storage = new HashMap<>();
        try{
        storage = load();
        sequence = storage.keySet().stream().mapToInt(x->x).max().getAsInt()+1;
        }catch (Exception e){
            System.out.println("cannot find save.json, create new data");
        }
    }

    public void put(String writer, String content){
        storage.put(sequence,new Say(sequence,writer,content));
        System.out.println(sequence+"번 명언이 등록되었습니다.");
        sequence++;
    }

    public Collection<Say> list(){
        return storage.values();
    }

    public Say findById(int id){
        return storage.get(id);
    }

    public boolean isExistById(int id){
        return storage.containsKey(id);
    }

    public void update(int id, String writer, String content){
        Say data = findById(id);
        data.setWriter(writer);
        data.setText(content);
        storage.replace(id,data);
    }

    public void deleteById(int id){
        storage.remove(id);
    }

    public boolean save() {
        try {
        FileWriter fileWriter = new FileWriter("save.json");
        fileWriter.write(mapToJson());
        fileWriter.flush();
        fileWriter.close();
        return true;
        }catch (Exception e){
            System.out.println("save failed. try again");
            return false;
        }
    }
    // 명언 저장용 map 객체를 json 형식의 String 객체로 변환
    public String mapToJson() throws JsonProcessingException {
        List<Say> sayList = new ArrayList<>();
        for (Say data : storage.values()) {
            sayList.add(data);
        }
        return objectMapper.writeValueAsString(sayList);
    }
    //세이브 파일 읽기
    public Map<Integer,Say> load() throws IOException {
        // json file to String
        String path = "save.json";
        String jsonFile = Files.readString(Path.of(path));
        // json string to List<Obj>
        List<Say> list = objectMapper.readValue(jsonFile, new TypeReference<List<Say>>() {});

        // Object List to Map
        Map<Integer,Say> map = new HashMap<>();
        for (Say data : list) {
            map.put(data.getId(),data);
        }
        return map;
    }
}
