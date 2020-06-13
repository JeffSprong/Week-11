package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Member;

public class MemberDao {
	
	private Connection connection;
	private final String GET_MEMBERS_QUERY = "SELECT * FROM members";
	private final String GET_MEMBERS_BY_MEMBER_ID_QUERY = "SELECT * FROM members WHERE id = ?";
	private final String CREATE_NEW_MEMBER_QUERY = "INSERT INTO members(first_name, last_name, email_address, favorite_album) VALUES(?,?,?,?)";
	private final String DELETE_MEMBER_BY_ID_QUERY = "DELETE FROM members WHERE id = ?";
	
	
	public MemberDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Member> getMembers() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_MEMBERS_QUERY).executeQuery();
		List<Member> members = new ArrayList<Member>();
		
		while (rs.next()) {
			members.add(populateMember(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		return members;
	}
	
	public Member getMembersByMemberId(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_MEMBERS_BY_MEMBER_ID_QUERY);
		ps.setInt(1,  id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		return populateMember(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
	}
	
	private Member populateMember(int id, String firstName, String lastName, String emailAddress, String favoriteAlbum) {
		return new Member(id, firstName, lastName, emailAddress, favoriteAlbum);
	}
	
	public void createNewMember(String firstName, String lastName, String emailAddress, String favoriteAlbum) throws SQLException {

		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_MEMBER_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, emailAddress);
		ps.setString(4, favoriteAlbum);
		ps.executeUpdate();
		
	}
	
	public void deleteMemberById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_MEMBER_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

}
