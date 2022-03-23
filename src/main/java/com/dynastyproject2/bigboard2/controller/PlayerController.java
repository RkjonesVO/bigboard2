package com.dynastyproject2.bigboard2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dynastyproject2.bigboard2.dao.PlayerDAO;
import com.dynastyproject2.bigboard2.model.Player;

/**
 * This is the Controller class.  It directs operations based
 * on which access point is requested.
 * 
 *
 */
@Controller
public class PlayerController {
	
	
	/**
	 * @playerDao is the local object created to perform the different 
	 * MySQL queries.
	 */
	@Autowired
	private PlayerDAO playerDao;
	
	/**
	 * This method takes the user to the addplayer.jsp
	 * @param model is the model view for all the players.  
	 * @returns to the addplayer.jsp view, with the new
	 * player added
	 */
	@GetMapping(value = "/addplayer")
	public String newPlayer(ModelMap model) {
		Player player = new Player();
		model.addAttribute("player", player);		
		return "addplayer";
	}	
	
	
	/**
	 * This is the method that saves the player to the database
	 * @param player is the player to be added to the database
	 * @param result is the raw data entered by the user.  If there are 
	 * any errors, it redirects the user back to the addplayer.jsp. If 
	 * there are no errors, it adds the new entry and redirects
	 * to the viewplayers.jsp.
	 * @param model is the model created from the MySQL info
	 *
	 */
	@PostMapping(value = "/save")
	public String savePlayer(@Valid Player player,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "addplayer";
	}
		playerDao.save(player);
		return "redirect:/viewplayers";		
	}
	
	
	/**
	 * The ModelAndView method is what coordinates the collected data
	 * and the visual representation of said data.
	 * The viewplayers method retrieves all the players from the database
	 * and displays them in a table format in the viewplayers.jsp.
	 * @return
	 */
	@GetMapping(value = "/viewplayers")
	public ModelAndView viewplayers() {
		List<Player> list = playerDao.getAllPlayers();
		return new ModelAndView("viewplayers","list",list);
	}
	
	
	/**
	 * The edit method matches the editplayer.jsp to the 
	 * selected player to be edited by way of id.
	 * @param id is the id of the player selected to be edited
	 * @param model is the model made of the MySQL data
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable int id,ModelMap model) {
		
		Player player = playerDao.getPlayerById(id);		
		model.addAttribute("player", player);
		return "editplayer";		
	}
	
	
	/**
	 * The editsave method is accessed when the user presses "update" in
	 * the editplayer.jsp.  
	 * @param player is the player selected to be updated
	 * @returns a new view based on the changes just made.
	 */
	@PostMapping(value = "/editsave")
	public ModelAndView editsave(@ModelAttribute("player") Player player) {	
				
		playerDao.update(player);		
		return new ModelAndView("redirect:/viewplayers");
	}	
	
	
	/**
	 * The delete method deletes a player from the database
	 * based on which id is selected
	 * @param id is the id of the player selected to be deleted.
	 * 
	 */
	@GetMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable int id) {
		playerDao.delete(id);
		return new ModelAndView("redirect:/viewplayers");
	}
	
	
	/**
	 * 
	 * initializePositions is a method that adds all 
	 * possible positions.  They can be accessed
	 * within the editplayer.jsp. 
	 */
	@ModelAttribute("positions")
	public List<String> initializePositions() {
		
		List<String> positions = new ArrayList<String>();
		positions.add("QB");
		positions.add("RB");
		positions.add("WR");
		positions.add("TE");
		positions.add("ATH");
		return positions;
	}
	
	/**
	 * initializeTeams is a method that adds all possible 
	 * NFL football teams.  They can be accessed
	 * within the editplayer.jsp.
	 * 
	 */
	@ModelAttribute("teams")
	public List<String> initializeTeams() {

		List<String> teams = new ArrayList<String>();
		teams.add("Green Bay Packers");
		teams.add("Chicago Bears");
		teams.add("Detroit Lions");
		teams.add("Minnesota Vikings");
		teams.add("Las Vegas Raiders");
		teams.add("Denver Broncos");
		teams.add("Los Angeles Chargers");
		teams.add("Kansas City Chiefs");
		teams.add("Dallas Cowboys");
		teams.add("New York Giants");
		teams.add("Washington Commanders");
		teams.add("Philadelphia Eagles");
		teams.add("New Orleans Saints");
		teams.add("Atlanta Falcons");
		teams.add("Carolina Panthers");
		teams.add("Tampa Bay Buccaneers");
		teams.add("Seattle Seahawks");
		teams.add("Los Angeles Rams");
		teams.add("San Francisco 49ers");
		teams.add("Arizona Cardinals");
		teams.add("New England Patriots");
		teams.add("New York Jets");
		teams.add("Buffalo Bills");
		teams.add("Miami Dolphins");
		teams.add("Pittsburgh Steelers");
		teams.add("Cleveland Browns");
		teams.add("Cinncinatti Bengals");
		teams.add("Baltimore Ravens");
		teams.add("Indianappolis Colts");
		teams.add("Houston Texans");
		teams.add("Tennessee Titans");
		teams.add("Jacksonville Jaguars");
		return teams;
	}
	
	
	
}