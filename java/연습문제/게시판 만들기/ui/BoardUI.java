package boardapp.view.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import boardapp.model.dbimp.BoardDAOImpl;
import boardapp.model.dto.BoardDTO;

public class BoardUI extends JFrame {
    private BoardDAOImpl dao = new BoardDAOImpl();
    private JTable table;
    private DefaultTableModel model;

    public BoardUI() {
        setTitle("📋 게시판");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 테이블 컬럼 정의
        String[] columns = {"ID", "제목", "작성자", "날짜", "조회수"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // 하단 버튼
        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("추가");
        JButton viewBtn = new JButton("보기");
        JButton delBtn = new JButton("삭제");
        buttonPanel.add(addBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(delBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // 버튼 이벤트
        addBtn.addActionListener(e -> showAddDialog());
        viewBtn.addActionListener(e -> showViewDialog());
        delBtn.addActionListener(e -> deletePost());

        refreshTable();
    }

    // 게시글 추가
    private void showAddDialog() {
        JTextField titleField = new JTextField();
        JTextField writerField = new JTextField();
        JTextArea contentArea = new JTextArea(5, 20);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("제목:"));
        panel.add(titleField);
        panel.add(new JLabel("작성자:"));
        panel.add(writerField);
        panel.add(new JLabel("내용:"));
        panel.add(new JScrollPane(contentArea));

        int result = JOptionPane.showConfirmDialog(this, panel, "게시글 추가", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            BoardDTO post = new BoardDTO(0, titleField.getText(), writerField.getText(),
                                         contentArea.getText(), null, 0);
            dao.addPost(post);
            refreshTable();
        }
    }

    // 게시글 보기 + 수정
    private void showViewDialog() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "먼저 게시글을 선택하세요.");
            return;
        }

        int postId = Integer.parseInt(model.getValueAt(row, 0).toString());
        dao.increaseViewCount(postId);
        BoardDTO post = dao.getPost(postId);

        JTextField titleField = new JTextField(post.getTitle());
        JTextField writerField = new JTextField(post.getWriter());
        JTextArea contentArea = new JTextArea(post.getContent(), 5, 20);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("제목:"));
        panel.add(titleField);
        panel.add(new JLabel("작성자:"));
        panel.add(writerField);
        panel.add(new JLabel("내용:"));
        panel.add(new JScrollPane(contentArea));

        int result = JOptionPane.showConfirmDialog(this, panel, "게시글 보기/수정", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            post.setTitle(titleField.getText());
            post.setWriter(writerField.getText());
            post.setContent(contentArea.getText());
            dao.updatePost(post);
            refreshTable();
        }
    }

    // 게시글 삭제
    private void deletePost() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "삭제할 게시글을 선택하세요.");
            return;
        }

        int postId = Integer.parseInt(model.getValueAt(row, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dao.deletePost(postId);
            refreshTable();
        }
    }

    // 테이블 데이터 갱신
    private void refreshTable() {
        model.setRowCount(0);
        for (BoardDTO post : dao.getAllPosts()) {
            model.addRow(new Object[]{
                post.getId(),
                post.getTitle(),
                post.getWriter(),
                post.getDate(),
                post.getViewCount()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BoardUI().setVisible(true));
    }
}
