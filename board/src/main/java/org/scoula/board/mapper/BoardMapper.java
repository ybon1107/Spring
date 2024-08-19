package org.scoula.board.mapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
public interface BoardMapper {

    public List<BoardVO> getListDateFilter(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    public List<BoardVO> getList();

    public BoardVO get(Long no);

    public void create(BoardVO board);

    public int update(BoardVO board);

    public int delete(Long no);

    public void createAttachment(BoardAttachmentVO attach);
    public List<BoardAttachmentVO> getAttachmentList(Long bno);
    public BoardAttachmentVO getAttachment(Long no);
    public int deleteAttachment(Long no);


}
