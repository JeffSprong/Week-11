package entity;

public class Member {
	private int memberId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String favoriteAlbum;

	public Member(int memberId, String firstName, String lastName,
			String emailAddress, String favoriteAlbum) {
		this.setMemberId(memberId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmailAddress(emailAddress);
		this.setFavoriteAlbum(favoriteAlbum);
			
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFavoriteAlbum() {
		return favoriteAlbum;
	}

	public void setFavoriteAlbum(String favoriteAlbum) {
		this.favoriteAlbum = favoriteAlbum;
	}
}
