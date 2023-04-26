/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dc.bot.dcbot.commands;

import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 *
 * @author vako
 */
public class Help extends ListenerAdapter {

  /**  @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        User user = event.getUser();
        String emoji = event.getReaction().getEmoji().getAsReactionCode();
        String channelMention = event.getChannel().getAsMention();
        String jumpLink = event.getJumpUrl();

        String message = user.getAsTag() + "Reacted to a message " + emoji + "in the channel" + channelMention + "channel";
        event.getGuild().getDefaultChannel().asTextChannel().sendMessage(message).queue();

    }
 */
/**    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User user = event.getAuthor();
        
        if (!event.getAuthor().isBot()) {
            String sent = event.getMessage().getContentRaw();
            String message = user.getAsTag() + "sent message" + sent;
            event.getGuild().getDefaultChannel().asTextChannel().sendMessage(message).queue();
        }
    }
*/
    @Override
    public void onChannelDelete(ChannelDeleteEvent event) {
        Channel channel = event.getChannel();

        String message = channel.getName() + " was deleted ";
        channel.delete().queue();
          event.getGuild().getDefaultChannel().asTextChannel().sendMessage(message).queue();
    }

    @Override
    public void onChannelCreate(ChannelCreateEvent event) {
        Channel channel = event.getChannel();
        
        String message = channel.getName() + " was created";
        event.getGuild().getDefaultChannel().asTextChannel().sendMessage(message).queue();
       
        
    }
    
}
