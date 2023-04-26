/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dc.bot.dcbot.dao;

import dc.bot.dcbot.util.JDBCUtils;
import dc.bot.dcbot.model.Player;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author vako
 */
public class DaoClass {
    
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	public int createPlayer(Player newPlayer) {
		try {
			String sql = "INSERT INTO player( name,  role, token, userid ) VALUES ('" + 
							newPlayer.getName() + "','" + 
							newPlayer.getRole()+ "','" + newPlayer.getToken()+ "','" + newPlayer.getUserid()+ "');";
			int p = qr.update(sql);
			return p;
							
			
		} 
		catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Create exception");
		}
	}
        
       public List<Player> selectPlayer(String name) {
		try {
			String sql = "SELECT * FROM player where name='"+name+"';" ;
			List<Player> list = qr.query(sql, new BeanListHandler<>(Player.class));
			return list;
		}
		catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Select all exception!");
		}
	} 
  
   	public int updateToken(Player p) {
		try {
			String sql = "UPDATE player SET token="+ p.getToken() + " where name='"+p.getName() + "';";   
			int play = qr.update(sql);
			return play;
		} 
		catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("Update player money exception");
		}
		
	}
         
}
