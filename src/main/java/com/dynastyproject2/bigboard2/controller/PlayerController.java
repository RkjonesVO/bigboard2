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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dynastyproject2.bigboard2.dao.PlayerDAO;
import com.dynastyproject2.bigboard2.model.Player;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerDAO playerDao;
	
	@GetMapping(value = "/addplayer")
	public String newPlayer(ModelMap model) {
		Player player = new Player();
		model.addAttribute("player", player);		
		return "addplayer";
	}	
	
	@PostMapping(value = "/save")
	public String savePlayer(@Valid Player player,
			BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "addplayer";
	}
		playerDao.save(player);
		return "redirect:/viewplayers";		
	}
	
	@GetMapping(value = "/viewplayers")
	public ModelAndView viewplayers() {
		List<Player> list = playerDao.getAllPlayers();
		return new ModelAndView("viewplayers","list",list);
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable int id,ModelMap model) {
		
		Player player = playerDao.getPlayerById(id);		
		model.addAttribute("player", player);
		System.out.println(player.getId());
		return "editplayer";		
	}
	
	@PostMapping(value = "/editsave")
	public ModelAndView editsave(@ModelAttribute("player") Player player) {	
				
		System.out.println("id is "+player.getId());
		playerDao.update(player);		
		return new ModelAndView("redirect:/viewplayers");
	}	
	
	@GetMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable int id) {
		playerDao.delete(id);
		return new ModelAndView("redirect:/viewplayers");
	}
	
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