package com.dynastyproject2.bigboard2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


import com.dynastyproject2.bigboard2.model.Player;


/**
 * 
 * The PlayerDAO class contains all the functions to access Player info from the
 * MySQL database, based on which method is called from the Controller class.
 *
 */
@Repository
@Service
public class PlayerDAO {
	
	
	/**
	 * This creates a template to reconfigure the retrieved queries
	 */
	private JdbcTemplate template;
	
	
	/**
	 *This links the player database to the template used for the 
	 *views. 
	 * @param dataSource is the template used for all internal
	 * queries.
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}	

	/**
	 * This method saves a new player to the database
	 * 
	 * @param savePlayer is the player added from the addplayer.jsp view.
	 * It is accessed by the "add new player" option in the viewplayers.jsp
	 * view.
	 */
	public void save(Player savePlayer) {
		
		String sql="insert into player(position,name,team,points) values('"+savePlayer.getPosition()+"','"+savePlayer.getName()+"','"+savePlayer.getTeam()+"','"+savePlayer.getPoints()+"')";
		System.out.println(sql);
		template.update(sql);
	}	
	
	
	/**
	 * This method selects every entry in the database and adds them
	 * to the template.  It first grabs all the raw data, then matches
	 * all of the raw data to its corresponding player.
	 * 
	 * @resultSet is all of the raw data from MySQL.
	 * @list is a list of all the players
	 * @nextPlayer is each individual player object in the database.
	 * @returns a list of all players
	 * 
	 */
	public List<Player> getAllPlayers() {
		
		return template.query("select * from player",new ResultSetExtractor<List<Player>>() {
			
			public List<Player> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				
				List<Player> list = new ArrayList<Player>();
				
				while(resultSet.next()){
				
				Player nextPlayer = new Player();
				
				nextPlayer.setId(resultSet.getInt(1));
				nextPlayer.setPosition(resultSet.getString(2));
				nextPlayer.setName(resultSet.getString(3));
				nextPlayer.setTeam(resultSet.getString(4));
				nextPlayer.setPoints(resultSet.getInt(5));
				
				list.add(nextPlayer);
			}								
				return list;
	}
		});
	}
	
	
	/**
	 * This method retrieves a particular player based on which 
	 * is selected from the viewplayers.jsp.
	 * 
	 * 
	 * @param id is the id of the particular player selected to edit.
	 * @retrievedPlayer is the player accessed by the id.  Its raw
	 * data is then extracted from MySQL and reconfigured for the views.
	 */
	public Player getPlayerById(int id) {
		
		return template.query("select * from player where ID="+id,new ResultSetExtractor<Player>() {
			
			public Player extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				
				Player retrievedPlayer = new Player();
				while(resultSet.next()) {
					
					retrievedPlayer.setId(resultSet.getInt(1));
					retrievedPlayer.setPosition(resultSet.getString(2));
					retrievedPlayer.setName(resultSet.getString(3));
					retrievedPlayer.setTeam(resultSet.getString(4));
					retrievedPlayer.setPoints(resultSet.getInt(5));
				}
				return retrievedPlayer;
			}
		});		
	}
	
	/**
	 * This method takes a player and updates info based on the 
	 * editplayer.jsp information provided by the user
	 * 
	 * @param player is the player selected from the "edit" option
	 * in the viewplayers.jsp view 
	 */
	public void update(Player player) {
		String sql="update Player set position='"+player.getPosition()+"',name='"+player.getName()+"',team='"+player.getTeam()+"',points='"+player.getPoints()+"' where ID ="+player.getId()+"";
		template.update(sql);
		System.out.println(sql);
	}	
	
	/**
	 * this method deletes the selected Player from the database
	 * @param id is the id of the player to be deleted.
	 */
	public void delete(int id) {
	
		String sql="delete from Player where ID="+id+"";
		template.update(sql);		
	}
	
}

	
