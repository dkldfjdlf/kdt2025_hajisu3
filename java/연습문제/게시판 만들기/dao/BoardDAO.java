package boardapp.model.dao;

import java.util.List;

import boardapp.model.dto.BoardDTO;

public interface BoardDAO {
    List<BoardDTO> getAllPosts();         // 게시글 전체 가져오기
    BoardDTO getPost(int id);             // ID로 게시글 하나 가져오기
    void addPost(BoardDTO post);          // 게시글 추가
    void updatePost(BoardDTO post);       // 게시글 수정
    void deletePost(int id);              // 게시글 삭제
    void increaseViewCount(int id);       // 조회수 증가
}
