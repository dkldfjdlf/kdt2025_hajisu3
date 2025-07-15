package boardapp.model.dbimp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import boardapp.model.dao.BoardDAO;
import boardapp.model.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {
    private List<BoardDTO> postList;
    private int nextId;

    public BoardDAOImpl() {
        postList = new ArrayList<>();
        nextId = 1;
    }

    @Override
    public List<BoardDTO> getAllPosts() {
        return new ArrayList<>(postList); // 복사본 반환
    }

    @Override
    public BoardDTO getPost(int id) {
        for (BoardDTO post : postList) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    @Override
    public void addPost(BoardDTO post) {
        post.setId(nextId++);
        post.setDate(getCurrentDate());
        post.setViewCount(0);
        postList.add(post);
    }

    @Override
    public void updatePost(BoardDTO updatedPost) {
        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i).getId() == updatedPost.getId()) {
                postList.set(i, updatedPost);
                return;
            }
        }
    }

    @Override
    public void deletePost(int id) {
        postList.removeIf(post -> post.getId() == id);
    }

    @Override
    public void increaseViewCount(int id) {
        for (BoardDTO post : postList) {
            if (post.getId() == id) {
                post.setViewCount(post.getViewCount() + 1);
                return;
            }
        }
    }

    private String getCurrentDate() {
        return new SimpleDateFormat("yyyy.MM.dd").format(new Date());
    }
}