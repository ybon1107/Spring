package org.scoula.board.service;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.dto.BoardDTO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class} )
@Log4j

class BoardServiceTest {
    @Autowired
    private BoardService service;
    @Test
    void getList() {
        for(BoardDTO board: service.getList()){
            log.info(board);
        }
    }

    @Test
    void get() {
        log.info("로그 확인 : "+service.get(7L));
    }

    @Test
    void create() {
        BoardDTO board = new BoardDTO();
        board.setWriter("이예본");
        board.setContent("이예본 개천재");
        board.setTitle("자서전");
        service.create(board);
        log.info("생성된 게시물의 번호 : "+board.getNo());
    }

    @Test
    void update() {
        BoardDTO board = service.get(6L);
        board.setTitle("사실 바보임");
        log.info("update Result : " + service.update(board));

    }

    @Test
    void delete() {
        // 게시물 번호의 존재 여부를 확인하고 테스트할 것
        log.info("delete RESULT: " + service.delete(2L));
    }
}