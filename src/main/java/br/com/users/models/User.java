package br.com.users.models;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_user")
public class User implements Serializable{   
    //
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
        
        @Column(unique=true)
	private String username;
	private String password;
	private boolean is_enable;
	private Date register_date;
	private String name;
	private String surname;
        
        @Column(unique=true)
	private String email;
        
        @Column(unique=true)
	private String phone;
	
		
	public User(Long id, String username, String password, boolean is_enable, Date register_date, String name,
			String surname, String email, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.is_enable = is_enable;
		this.register_date = register_date;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public boolean isIs_enable() {
		return is_enable;
	}
	public void setIs_enable(boolean is_enable) {
		this.is_enable = is_enable;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	
}
