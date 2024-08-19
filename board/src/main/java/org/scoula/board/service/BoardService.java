package org.scoula.board.service;

import org.apache.ibatis.annotations.Param;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;

import java.util.Date;
import java.util.List;

public interface BoardService
{
    public List<BoardDTO> getListDateFilter(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    public List<BoardDTO> getList();
    public BoardDTO get(Long no);
    public void create(BoardDTO board);
    public boolean update(BoardDTO board);
    public boolean delete(Long no);
    public BoardAttachmentVO getAttachment(Long no);
    public boolean deleteAttachment(Long no);
}
