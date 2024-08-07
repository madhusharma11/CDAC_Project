package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@Setter
//@Getter
//@ToString
@MappedSuperclass
public class BaseEntity {
	
	
	
	@CreationTimestamp
	@Column(name = "creation_date")
	private LocalDate creationDate;

	
	@UpdateTimestamp // adds the current date every time the entity is updated
	@Column(name = "updated_on")
	private LocalDate updatedOn;


	public LocalDate getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}


	public LocalDate getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

}
