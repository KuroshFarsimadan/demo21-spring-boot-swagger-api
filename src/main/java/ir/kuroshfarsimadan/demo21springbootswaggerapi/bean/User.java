package ir.kuroshfarsimadan.demo21springbootswaggerapi.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "users")
@ApiModel(description = "All details about the Users. ")
public class User {

	@ApiModelProperty(notes = "User ID")
	private long id;

	@ApiModelProperty(notes = "Users age")
	private long age;

	@ApiModelProperty(notes = "Users first name")
	private String firstName;

	@ApiModelProperty(notes = "Users last name")
	private String lastName;

	@ApiModelProperty(notes = "Users email")
	private String email;

	public User() {

	}

	public User(long id, long age, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "age", nullable = false)
	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	@Column(name = "firstname", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastname", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}