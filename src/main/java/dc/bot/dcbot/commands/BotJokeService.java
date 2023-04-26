/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dc.bot.dcbot.commands;

import dc.bot.dcbot.controllers.PlayerController;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import java.awt.Color;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Service;

/**
 *
 * @author vako
 */
@RequiredArgsConstructor
@Service
public class BotJokeService extends ListenerAdapter {

    private PlayerController pc = new PlayerController();
    private final ChuckNorrisQuotes quotes = new ChuckNorrisQuotes();

    @Override
    public void onMessageDelete(MessageDeleteEvent event) {

        event.getGuild().getDefaultChannel().asTextChannel().sendMessage(quotes.getRandomQuote()).queue();

    }
    
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();


/**
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (!event.getAuthor().isBot()) {
            String token = "!token";
            if ("!token".equals(token)) {
                String id = event.getAuthor().getAvatarId();
                List<Player> search1 = pc.selectPlayer(id);
                Player pl = search1.get(0);
                String valueOfToken = pl.getToken().toString();
                event.getChannel().asTextChannel().sendMessage("You have " + valueOfToken + " token").queue();
            }

        }
    }
 */
    
   

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        String emoji = event.getReaction().getEmoji().getAsReactionCode();

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("This is a tilte", null);
        embed.setDescription("User reacted " + emoji);
        embed.setTimestamp(Instant.now());
        embed.addField("Phrase 1)", "Stuff", false);
        embed.addField("Phrase 2)", "Stuff", false);

        embed.setColor(Color.RED);

        embed.setFooter("Bot created by person", event.getGuild().getOwner().getUser().getAvatarUrl());
        event.getChannel().sendMessage("message").setEmbeds(embed.build()).queue();
        embed.clear();
    }
 

}
