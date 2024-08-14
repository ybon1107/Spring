package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    final private BoardService service;

//    @GetMapping("")
//    public List<BoardDTO> getList(){
//        return service.getList();
//    }

    @GetMapping
    public ResponseEntity<List<BoardDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }

    @PostMapping
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO board) {
        return ResponseEntity.ok(service.create(board));
    }

    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(@PathVariable("no") int id, @RequestBody BoardDTO board) {
        return ResponseEntity.ok(service.update(board));
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(@PathVariable("no") Long no){
        service.delete(no);
        return ResponseEntity.ok().build();
    }
}
