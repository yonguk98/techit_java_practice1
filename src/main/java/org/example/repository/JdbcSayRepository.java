package org.example.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.model.Say;

import java.io.IOException;
import java.sql.*;
import java.util.Collection;
import java.util.Map;

public class JdbcSayRepository implements SayRepository {
    public void connectToDb(){
        try{
            String url = "jdbc:mysql://localhost:3306/say_app";
            Connection conn = DriverManager.getConnection(url, "root", "0000");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from members;");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    @Override
    public void put(String writer, String content) {

    }

    @Override
    public Collection<Say> list() {
        return null;
    }

    @Override
    public Say findById(int id) {
        return null;
    }

    @Override
    public boolean isExistById(int id) {
        return false;
    }

    @Override
    public void update(int id, String writer, String content) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public String mapToJson() throws JsonProcessingException {
        return null;
    }

    @Override
    public Map<Integer, Say> load() throws IOException {
        return null;
    }
}
