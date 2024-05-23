package com.bussiness.webapp.user.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="BUSSINESS_USERS")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	
	@Size(min = 3, max = 25, message = "Username must be between 3 - 25 characters")
	@Column(nullable = false, unique = true, length=25)
	private String username;	
	
	
	@Size(min = 3, max = 75, message = "First Name must be between 3 - 75 characters")
	@Column(nullable = false, unique = false, length=75)
	private String first_name;
	
	
	@Size(min = 3, max = 75, message = "Last Name must be between 3 - 75 characters")
	@Column(nullable = false, unique = false, length=75)
	private String last_name;	
	
		
	@Column(nullable = false, unique = true, length = 80)
	private String email = "";	
	
	
	@Size(min = 3, max = 200, message = "Description must be between 3 - 200 characters")	
	@Column(nullable = false, unique = false, length = 200)
	private String something_about_you = "Let's Create A Better Future!";
	
	
	@Column(nullable = false, unique = false, length = 80)
	private String image = "default.jpg";
	
	
	@Column(nullable = false, unique = false, length = 80)
	private String password;
	
	
	@Column(nullable = false, unique = false)
	private boolean is_active = true;
	
	
	@Column(nullable = false, unique = false)
	private boolean is_superuser = false;	
	
	
	@Column(nullable = false, unique = false)
	private int total_amount = 0;	

	
	@Column(nullable = false, unique = false)
	private int total_profit = 0;	
	
	
	@Column(nullable = false, unique = false)
	private int total_loss = 0;	
	
	
	@Column(nullable = false, unique = false, length = 25)
	private String created_by = "";		
	

	@Column(nullable = false, unique = false, length = 25)
	private String updated_by = "";	
	
	
	@Column(nullable = false, unique = false)
	private LocalDateTime created_date = LocalDateTime.now();
	
	
	@Column(nullable = false, unique = false)
	private LocalDateTime updated_date = LocalDateTime.now();
	
	
	
	
	// Constructors
	
	/**
	 * 
	 */
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}		
	
	
	

	/**
	 * @param user_id
	 * @param username
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param something_about_you
	 * @param image
	 * @param password
	 * @param is_active
	 * @param is_superuser
	 * @param total_amount
	 * @param total_profit
	 * @param total_loss
	 * @param created_by
	 * @param updated_by
	 * @param created_date
	 * @param updated_date
	 */
	public UserEntity(long user_id,
			@Size(min = 3, max = 25, message = "Username must be between 3 - 25 characters") String username,
			@Size(min = 3, max = 75, message = "First Name must be between 3 - 75 characters") String first_name,
			@Size(min = 3, max = 75, message = "First Name must be between 3 - 75 characters") String last_name,
			String email,
			@Size(min = 3, max = 200, message = "First Name must be between 3 - 200 characters") String something_about_you,
			String image, String password, boolean is_active, boolean is_superuser, int total_amount,
			int total_profit, int total_loss, String created_by, String updated_by, LocalDateTime created_date,
			LocalDateTime updated_date) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.something_about_you = something_about_you;
		this.image = image;
		this.password = password;
		this.is_active = is_active;
		this.is_superuser = is_superuser;
		this.total_amount = total_amount;
		this.total_profit = total_profit;
		this.total_loss = total_loss;
		this.created_by = created_by;
		this.updated_by = updated_by;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}









	/**
	 * @return the user_id
	 */
	public long getUser_id() {
		return user_id;
	}
	

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}




	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}




	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}




	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}


	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}




	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}




	/**
	 * @return the something_about_you
	 */
	public String getSomething_about_you() {
		return something_about_you;
	}


	/**
	 * @param something_about_you the something_about_you to set
	 */
	public void setSomething_about_you(String something_about_you) {
		this.something_about_you = something_about_you;
	}




	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}


	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}




	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return the is_active
	 */
	public boolean isIs_active() {
		return is_active;
	}


	/**
	 * @param is_active the is_active to set
	 */
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}




	/**
	 * @return the is_superuser
	 */
	public boolean isIs_superuser() {
		return is_superuser;
	}


	/**
	 * @param is_superuser the is_superuser to set
	 */
	public void setIs_superuser(boolean is_superuser) {
		this.is_superuser = is_superuser;
	}


	
	
	/**
	 * @return the total_amount
	 */
	public int getTotal_amount() {
		return total_amount;
	}

	/**
	 * @param total_amount the total_amount to set
	 */
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}




	/**
	 * @return the total_profit
	 */
	public int getTotal_profit() {
		return total_profit;
	}

	/**
	 * @param total_profit the total_profit to set
	 */
	public void setTotal_profit(int total_profit) {
		this.total_profit = total_profit;
	}




	/**
	 * @return the total_loss
	 */
	public int getTotal_loss() {
		return total_loss;
	}

	/**
	 * @param total_loss the total_loss to set
	 */
	public void setTotal_loss(int total_loss) {
		this.total_loss = total_loss;
	}	
	


	/**
	 * @return the created_by
	 */
	public String getCreated_by() {
		return created_by;
	}

	/**
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}




	/**
	 * @return the updated_by
	 */
	public String getUpdated_by() {
		return updated_by;
	}


	/**
	 * @param updated_by the updated_by to set
	 */
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}




	/**
	 * @return the created_date
	 */
	public LocalDateTime getCreated_date() {
		return created_date;
	}


	/**
	 * @param created_date the created_date to set
	 */
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}




	/**
	 * @return the updated_date
	 */
	public LocalDateTime getUpdated_date() {
		return updated_date;
	}


	/**
	 * @param updated_date the updated_date to set
	 */
	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}




	@Override
	public String toString() {
		return this.user_id + "_" + this.username;
	}
	
}
