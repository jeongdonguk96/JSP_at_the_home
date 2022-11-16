package com.ezen.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.BoardVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// 최근 등록한 게시물이 먼저 나오도록 게시판 조회
	public List<BoardVO> selectAllBoards() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<>();
		BoardVO vo = null;
		String sql = "SELECT * FROM board ORDER BY num DESC";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			vo = new BoardVO();
			
			while(rs.next()) {
			vo.setNum(rs.getInt("num"));
			vo.setPass(rs.getString("pass"));
			vo.setName(rs.getString("name"));
			vo.setEmail(rs.getString("email"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			vo.setReadcount(rs.getInt("readcount"));
			vo.setWritedate(rs.getDate("writedate"));
			
			list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, null);
		}
		return list;
	}
	
	// 매개변수로 받은 VO 객체를 board테이블에 추가
	public void insertBoard(BoardVO vo) {

	}
	
	// 게시글 조회마다 글 번호를 증가시킨다.
	public void updateReadCount(int num) {

	}
	
	// 게시물 번호로 해당 게시물을 찾아 게시물 정보를 BoardVO 객체에 저장한다. 실패:null 반환
	public BoardVO selectOneBoardByNum(int num) {

	}
	
	// 매개변수로 받은 VO 객체 내의 코드를 조건으로 VO 객체에 저장된 정보로 테이블을 수정한다.
	public void updateBoard(BoardVO vo) {

	}
	
	// 게시글 번호와 비밀번호가 일치하는 게시글을 테이블에서 조회해 BoardVO 객체로 반환
	public BoardVO checkPassword(String pass, int num) {

	}
	
	// 게시글 번호에 해당하는 게시글 정보를 삭제
	public void deleteBoard(int num) {

	}
}










