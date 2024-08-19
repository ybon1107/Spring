package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;

@Controller
@Log4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    final private BoardService service;

    @GetMapping("/list")
    public void list(
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            Model model) {

        if (startDate != null && endDate != null) {
            log.info("날짜 필터링 기능 사용");
            model.addAttribute("list", service.getListDateFilter(startDate, endDate));
        } else {
            log.info("일반 리스트 기능 사용");
            model.addAttribute("list", service.getList());
        }
    }
    @GetMapping({ "/get", "/update" })
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("/get or update");
        model.addAttribute("board", service.get(no));
    }
    @PostMapping("/update")
    public String update(BoardDTO board,
                         RedirectAttributes ra) {
        log.info("update:" + board);
        if (service.update(board)) {
            ra.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }
    @GetMapping("/create")
    public void create() {
        log.info("create");
    }
    @PostMapping("/create")
    public String create(BoardDTO board) {
        log.info("create: " + board);
        service.create(board);
        return "redirect:/board/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no,
                         RedirectAttributes ra) {
        if (service.delete(no)) {
            ra.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }

    @GetMapping("/download/{no}")
    @ResponseBody // view를 사용하지 않고, 직접 내보냄
    public void download(@PathVariable("no") Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attach = service.getAttachment(no);
        File file = new File(attach.getPath());
        UploadFiles.download(response, file, attach.getFilename());
    }

}
