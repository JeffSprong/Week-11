package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.MemberDao;
import entity.Member;

public class Menu {
	

	private MemberDao memberDao = new MemberDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Members",
			"Display a Member",
			"Create Member",
			"Delete Member"
			);
	
	public void start() throws SQLException {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
		
		try {
			if (selection.equals("1")) {
				displayMembers();
			} else if (selection.equals("2")) {
				getMember();
			} else if (selection.equals("3")) {
				createMember();
			} else if (selection.equals("4")) {
				deleteMember();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			System.out.println("Press enter to continue....");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}

	private void printMenu() {
		System.out.println("----------BAND FANCLUB----------");
		System.out.println("Select an Option:\n------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ")" + options.get(i));
		}
	}
	
	private void displayMembers() throws SQLException {
		List<Member> members = memberDao.getMembers();
		for (Member member : members) {
			System.out.println(member.getMemberId() + ": Name: " + member.getFirstName() + " " + member.getLastName()
					+ " Email: " + member.getEmailAddress() + " Favorite Album: " +
					member.getFavoriteAlbum());
		}
	}
	
	private void getMember() throws SQLException {
		System.out.println("Enter member id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Member member = memberDao.getMembersByMemberId(id);
		System.out.println(member.getMemberId() +  ": Name: " + member.getFirstName() + " " + member.getLastName()
		+ " Email: " + member.getEmailAddress() + " Favorite Album: " +
		member.getFavoriteAlbum());
	}
	
	private void createMember() throws SQLException {
		System.out.println("Enter the first name of the new member:");
		String firstName = scanner.nextLine();
		System.out.println("Enter the last name of the new member:");
		String lastName = scanner.nextLine();
		System.out.println("Enter the email address of the new member:");
		String emailAddress = scanner.nextLine();
		System.out.println("Enter the new member's favorite album:");
		String favoriteAlbum = scanner.nextLine();
		memberDao.createNewMember(firstName, lastName, emailAddress, favoriteAlbum);
	}
	
	private void deleteMember() throws SQLException {
		System.out.println("Enter member id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		memberDao.deleteMemberById(id);
	}
}
