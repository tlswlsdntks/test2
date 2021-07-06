package kr.co.member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.member.domain.LoginDTO;
import kr.co.member.domain.MemberDTO;

public class MemberDAO {

	private DataSource dataFactory;

	public MemberDAO() {

		try {
			dataFactory = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void insert(MemberDTO memberDTO) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO member (id,password,name,birth) VALUES (?,?,?,?)";
		try {

			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPassword());
			pstmt.setString(3, memberDTO.getName());
			pstmt.setString(4, memberDTO.getBirth());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

	}

	public List<MemberDTO> list() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member";
		try {

			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new MemberDTO(rs.getString("id"), rs.getString("password"), rs.getString("name"),
						rs.getString("birth")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return list;
	}

	public MemberDTO read(String id) {
		MemberDTO dto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE id = ?";
		try {

			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new MemberDTO(rs.getString("id"), rs.getString("password"), rs.getString("name"),
						rs.getString("birth"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;
	}

	public MemberDTO updateui(String id) {

		MemberDTO dto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE id = ?";
		try {

			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new MemberDTO(rs.getString("id"), rs.getString("password"), rs.getString("name"),
						rs.getString("birth"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;
	}

	public void update(MemberDTO memberDTO) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE member SET password=?, name=?, birth=? WHERE id = ?";
		try {

			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDTO.getPassword());
			pstmt.setString(2, memberDTO.getName());
			pstmt.setString(3, memberDTO.getBirth());
			pstmt.setString(4, memberDTO.getId());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

	}

	public void delete(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "DELETE FROM member WHERE id = ?";
		try {

			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

	}

	public LoginDTO login(String id, String password) {

		LoginDTO login = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE id = ? AND password = ?";
		try {

			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				login = new LoginDTO(rs.getString("id"), rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return login;
	}

	public MemberDTO idCheck(String id) {

		MemberDTO dto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE id = ?";
		try {

			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new MemberDTO(rs.getString("id"), rs.getString("password"), rs.getString("name"),
						rs.getString("birth"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;
		
	}

}
