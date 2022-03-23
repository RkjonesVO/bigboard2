package com.dynastyproject2.bigboard2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


import com.dynastyproject2.bigboard2.model.Player;

@Service
public class PlayerDAO {
	
	private JdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	

	public void save(Player savePlayer) {
		
		String sql="insert into player(position,name,team,points) values('"+savePlayer.getPosition()+"','"+savePlayer.getName()+"','"+savePlayer.getTeam()+"','"+savePlayer.getPoints()+"')";
		System.out.println(sql);
		template.update(sql);

	}	

	
	public List<Player> getAllPlayers() {
		
		return template.query("select * from player",new ResultSetExtractor<List<Player>>() {
			
			public List<Player> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				
				List<Player> list = new ArrayList<Player>();
				
				while(resultSet.next()){
				
				Player newPlayer = new Player();
				
				newPlayer.setId(resultSet.getInt(1));
				newPlayer.setPosition(resultSet.getString(2));
				newPlayer.setName(resultSet.getString(3));
				newPlayer.setTeam(resultSet.getString(4));
				newPlayer.setPoints(resultSet.getInt(5));
				
				list.add(newPlayer);
			}						
		
				return list;
	}
		});
	}
	
	public Player getPlayerById(int id) {
		
		return template.query("select * from player where ID="+id,new ResultSetExtractor<Player>() {

			
			public Player extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				
				Player newPlayer = new Player();
				while(resultSet.next()) {
					
					newPlayer.setId(resultSet.getInt(1));
					newPlayer.setPosition(resultSet.getString(2));
					newPlayer.setName(resultSet.getString(3));
					newPlayer.setTeam(resultSet.getString(4));
					newPlayer.setPoints(resultSet.getInt(5));
				}
				return newPlayer;
			}
		});		
	}

	
	public void update(Player player) {
		String sql="update Player set position='"+player.getPosition()+"',name='"+player.getName()+"',team='"+player.getTeam()+"',points='"+player.getPoints()+"' where ID ="+player.getId()+"";
		template.update(sql);
		System.out.println(sql);
	}
	
	
	public void delete(int id) {
	
		String sql="delete from Player where ID="+id+"";
		template.update(sql);		
	}
	
}

	
