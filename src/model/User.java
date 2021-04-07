package model;



public class User {
public enum Role {user, admin};
	
	private int id;
	private String username;
	private String password;
	private String datumRegistracije;
	private Role role;
	private boolean blokiran;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatumRegistracije() {
		return datumRegistracije;
	}
	public void setDatumRegistracije(String datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public boolean isBlokiran() {
		return blokiran;
	}
	public void setBlokiran(boolean blokiran) {
		this.blokiran = blokiran;
	}
	public User(int id, String username, String password, String datumRegistracije, Role role, boolean blokiran) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.datumRegistracije = datumRegistracije;
		this.role = role;
		this.blokiran = blokiran;
	}
	public User() {
	
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", datumRegistracije="
				+ datumRegistracije + ", role=" + role + ", blokiran=" + blokiran + "]";
	}

	
}
