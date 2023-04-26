/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dc.bot.dcbot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 *
 * @author vako
 */
public class MessageSending extends ListenerAdapter  {
    
   /** @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(!event.getAuthor().isBot()){
          String messageSent = event.getMessage().getContentRaw();
          event.getChannel().sendMessage("this was sent" + messageSent).queue();
        }
    }
    *  */
}
