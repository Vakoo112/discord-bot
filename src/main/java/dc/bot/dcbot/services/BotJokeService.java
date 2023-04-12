/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dc.bot.dcbot.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 *
 * @author vako
 */

public class BotJokeService extends ListenerAdapter {
   
   private final ChuckNorrisQuotes quotes = new ChuckNorrisQuotes();

    
    @Override
    public void onMessageDelete(MessageDeleteEvent event) {
        
         event.getGuild().getDefaultChannel().asTextChannel().sendMessage(quotes.getRandomQuote()).queue();
    }
    
}
