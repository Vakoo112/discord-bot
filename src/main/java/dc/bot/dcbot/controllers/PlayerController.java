/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dc.bot.dcbot.controllers;

import dc.bot.dcbot.model.Player;
import dc.bot.dcbot.services.PlayerService;
import java.util.List;

/**
 *
 * @author vako
 */
public class PlayerController {
    private PlayerService service = new PlayerService();
    
    public int createPlayer(Player newPlayer) {
		System.out.println("Creating new player..");
		return service.createPlayer(newPlayer);
	}
    
        public List<Player> selectPlayer(String name)  {
         System.out.println("Searching userid in db..");
         return service.selectPlayer(name);
         }
        
         public int updateToken(Player p){
            System.out.println("Service layer send request to update token");
               return service.updateToken(p);
         }
}
