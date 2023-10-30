package org.example.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Say;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public interface SayRepository {
    public void put(String writer, String content);
    public Collection<Say> list();
    public Say findById(int id);

    public boolean isExistById(int id);

    public void update(int id, String writer, String content);

    public void deleteById(int id);

    public boolean save();

    public String mapToJson() throws JsonProcessingException;

    public Object load() throws IOException;
}
