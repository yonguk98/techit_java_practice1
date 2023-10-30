package org.example.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JdbcSayRepositoryTest {
    @Test
    @DisplayName("서버 연결 확인")
    public void connectTest(){
        JdbcSayRepository jdbcSayRepository = new JdbcSayRepository();
        jdbcSayRepository.connectToDb();
    }

    @Test
    @DisplayName("")
    void put() {
    }

    @Test
    void list() {
    }

    @Test
    void findById() {
    }

    @Test
    void isExistById() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void save() {
    }

    @Test
    void mapToJson() {
    }

    @Test
    void load() {
    }
}