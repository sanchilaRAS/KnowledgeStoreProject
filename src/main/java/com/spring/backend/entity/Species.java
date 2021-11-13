package com.spring.backend.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "species")
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "species_name")
    private String species_name;

    @Column(name = "species_img")
    private String species_img;

    @Column(name = "species_desc", columnDefinition = "text")
    private String species_desc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "uc_fid"), name = "uc_fid")
    private UserProfile userProfile;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "species_tags",
        joinColumns = { @JoinColumn(name = "species_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();

    public Species() {

    }



    public Species(String species_name, String species_img, String species_desc, UserProfile userProfile) {
		super();
		this.species_name = species_name;
		this.species_img = species_img;
		this.species_desc = species_desc;
		this.userProfile = userProfile;
	}



	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getspecies_name() {
        return species_name;
    }

    public void setspecies_name(String species_name) {
        this.species_name = species_name;
    }

    public String getspecies_img() {
        return species_img;
    }

    public void setspecies_img(String species_img) {
        this.species_img = species_img;
    }

    public String getspecies_desc() {
        return species_desc;
    }

    public void setspecies_desc(String species_desc) {
        this.species_desc = species_desc;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

	public String getSpecies_name() {
		return species_name;
	}

	public void setSpecies_name(String species_name) {
		this.species_name = species_name;
	}

	public String getSpecies_img() {
		return species_img;
	}

	public void setSpecies_img(String species_img) {
		this.species_img = species_img;
	}

	public String getSpecies_desc() {
		return species_desc;
	}

	public void setSpecies_desc(String species_desc) {
		this.species_desc = species_desc;
	}
    
}
