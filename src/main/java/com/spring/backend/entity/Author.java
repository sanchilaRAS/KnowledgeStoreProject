package com.spring.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "authorname")
    private String authorname;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorprofile_id")
    private AuthorProfile authorProfile;

    public Author() {

    }

    public Author(String authorname, String email, AuthorProfile authorProfile) {
        this.authorname = authorname;
        this.email = email;
        this.authorProfile = authorProfile;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AuthorProfile getAuthorProfile() {
		return authorProfile;
	}

	public void setAuthorProfile(AuthorProfile authorProfile) {
		this.authorProfile = authorProfile;
	}

   


}
