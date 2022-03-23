package com.dynastyproject2.bigboard2.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.persistence.*;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Player class serves as a model for each individual Player object. 
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "player")
public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	
	/**
	 * The id of each player.  Note that it auto-increments.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	/**
	 * The position of the player (QB, RB, WR, TE, or ATH)
	 */
	@NotNull
	@Column
	private String position;
	
	/**
	 * The name of the player
	 */
	@NotNull
	@Column
	private String name;
	
	
	/**
	 * The team of the player.
	 */
	@NotNull
	@Column
	private String team;
	
	/**
	 * The points scored in 2021 for the player
	 */
	@NotNull
	@Range(min=0, max=600)
	private int points;

	/**
	 * Below are all of the getters and setters for the different Player fields.
	 * 
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
