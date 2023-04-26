/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dc.bot.dcbot.services;

import dc.bot.dcbot.dao.DaoClass;
import dc.bot.dcbot.model.Player;
import java.util.List;

/**
 *
 * @author vako
 */
public class PlayerService {
    private DaoClass pd = new DaoClass();
    
    	public int createPlayer(Player newPlayer) {
		System.out.println("Service layer send Player to DB to be created..");
		return pd.createPlayer(newPlayer);
	}
        
         public List<Player> selectPlayer(String name)  {
         System.out.println("Service layer send request to db to find userid in db..");
         return pd.selectPlayer(name);
         }
         
         public int updateToken(Player p){
            System.out.println("Service layer send request to update token");
             return pd.updateToken(p);
         }
}
