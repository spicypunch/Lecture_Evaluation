package com.jm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jm.dto.BoardVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards() {
		String sql = "select * from board order by num desc";

		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVO bVo = new BoardVO();

//				bVo.setStu_id(rs.getInt("stu_id"));
				bVo.setNum(rs.getInt("num"));
				bVo.setTitle(rs.getString("title"));
				bVo.setName(rs.getString("name"));
				bVo.setScore(rs.getDouble("score"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));

				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertBoard(BoardVO bVo) {
		String sql = "insert into board(num, title, name, score, content, stu_id) values(board_seq.nextval, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getName());
			pstmt.setDouble(3, bVo.getScore());
			pstmt.setString(4, bVo.getContent());
			pstmt.setInt(5, bVo.getStu_id());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(String num) {
		String sql = "update board set readcount = readcount+1 where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public BoardVO selectOneBoardByNum(String num) {
		String sql = "select * from board where num = ?";

		BoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bVo = new BoardVO();

				bVo.setNum(rs.getInt("num"));
				bVo.setTitle(rs.getString("title"));
				bVo.setName(rs.getString("name"));
				bVo.setScore(rs.getDouble("score"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	public void updateBoard(BoardVO bVo) {
		String sql = "update board set title=?, score=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getTitle());
			pstmt.setDouble(2, bVo.getScore());
			pstmt.setString(3, bVo.getContent());
			pstmt.setInt(4, bVo.getNum());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void deleteBoard(String num) {
		String sql = "delete board where num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BoardVO> selectMyBoards(String stu_id) {
		String sql = "select * from board where stu_id =?";

		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO bVo = new BoardVO();

				bVo.setNum(rs.getInt("num"));
				bVo.setTitle(rs.getString("title"));
				bVo.setName(rs.getString("name"));
				bVo.setScore(rs.getDouble("score"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));

				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<BoardVO> searchBoardsbyName(String option, String search) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			if (option.equals("title")) {
				String sql = "select * from board where title like ?";
				System.out.println(sql);
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + search + "%");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					BoardVO bVo = new BoardVO();

					bVo.setNum(rs.getInt("num"));
					bVo.setTitle(rs.getString("title"));
					bVo.setName(rs.getString("name"));
					bVo.setScore(rs.getDouble("score"));
					bVo.setContent(rs.getString("content"));
					bVo.setReadcount(rs.getInt("readcount"));
					bVo.setWritedate(rs.getTimestamp("writedate"));

					list.add(bVo);
				}
			} else if (option.equals("writerId")) {
				String sql = "select * from board where name = ?";
				System.out.println(sql);
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, search);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					BoardVO bVo = new BoardVO();

					bVo.setNum(rs.getInt("num"));
					bVo.setTitle(rs.getString("title"));
					bVo.setName(rs.getString("name"));
					bVo.setScore(rs.getDouble("score"));
					bVo.setContent(rs.getString("content"));
					bVo.setReadcount(rs.getInt("readcount"));
					bVo.setWritedate(rs.getTimestamp("writedate"));

					list.add(bVo);
				}
			} else if (option.equals("content")) {
				String sql = "select * from board where (title like ? or content like ?)";
				System.out.println(sql);
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + search + "%");
				pstmt.setString(2, "%" + search + "%");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					BoardVO bVo = new BoardVO();

					bVo.setNum(rs.getInt("num"));
					bVo.setTitle(rs.getString("title"));
					bVo.setName(rs.getString("name"));
					bVo.setScore(rs.getDouble("score"));
					bVo.setContent(rs.getString("content"));
					bVo.setReadcount(rs.getInt("readcount"));
					bVo.setWritedate(rs.getTimestamp("writedate"));

					list.add(bVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
//	public List<BoardVO> selectAllMember(int page){
//		List<BoardVO> list = new ArrayList<BoardVO>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;        
//        int startNum = (page-1)*10+1;
//        int endNum = page*10;
//        String sql = "select * from(select rownum, board.* from board) where rownum >= ? where rownum <= ?";
//        try{
//            conn = DBManager.getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, startNum);
//            pstmt.setInt(2, endNum);
//            rs = pstmt.executeQuery();
//            while(rs.next()){
//                BoardVO bVo = new BoardVO();
//                bVo.setNum(rs.getInt("num"));
//				bVo.setTitle(rs.getString("title"));
//				bVo.setName(rs.getString("name"));
//				bVo.setScore(rs.getDouble("score"));
//				bVo.setContent(rs.getString("content"));
//				bVo.setReadcount(rs.getInt("readcount"));
//				bVo.setWritedate(rs.getTimestamp("writedate"));
//                list.add(bVo);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            DBManager.close(conn, pstmt, rs);
//        }
//        return list;
//    }

}