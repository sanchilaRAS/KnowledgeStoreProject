package com.spring.backend.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "note_title")
    private String note_title;

   // @Column(name = "species_img")
   // private String species_img;

    @Column(name = "note_desc", columnDefinition = "text")
    private String note_desc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "ac_fid"), name = "ac_fid")
    private AuthorProfile authorProfile;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "notes_subjects",
        joinColumns = { @JoinColumn(name = "notes_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    private Set<Subjects> subjects = new HashSet<>();

    



    public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Notes(String note_title,  String note_desc, AuthorProfile authorProfile) {
		super();
		this.note_title = note_title;
		this.note_desc = note_desc;
		this.authorProfile = authorProfile;
	}



	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



	public String getNote_title() {
		return note_title;
	}



	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}



	public String getNote_desc() {
		return note_desc;
	}



	public void setNote_desc(String note_desc) {
		this.note_desc = note_desc;
	}



	public AuthorProfile getAuthorProfile() {
		return authorProfile;
	}



	public void setAuthorProfile(AuthorProfile authorProfile) {
		this.authorProfile = authorProfile;
	}



	public Set<Subjects> getSubjects() {
		return subjects;
	}



	public void setSubjects(Set<Subjects> subjects) {
		this.subjects = subjects;
	}



  

	
}
