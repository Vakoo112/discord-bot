/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dc.bot.dcbot.commands;

import dc.bot.dcbot.controllers.PlayerController;
import dc.bot.dcbot.model.Player;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 *
 * @author vako ("!joke".equals(message))
 */
public class Commands extends ListenerAdapter {

    public boolean bCanSendJoke = true;
    private PlayerController pc = new PlayerController();
    private final ChuckNorrisQuotes quotes = new ChuckNorrisQuotes();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!bCanSendJoke) {

            return;
        }
        if (!event.getAuthor().isBot()) {
            String message = "!joke";
            if (event.getMessage().getContentRaw().equals(message)) {

                ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

                executorService.scheduleWithFixedDelay(new Runnable() {
                    @Override
                    public void run() {
                        bCanSendJoke = true;
                    }
                }, 0, 30, TimeUnit.SECONDS);
                String exactQuote = quotes.getRandomQuote();
                event.getChannel().asTextChannel().sendMessage(exactQuote).queue();

                String id = event.getAuthor().getAvatarId();
                List<Player> search = pc.selectPlayer(id);
                if (search.isEmpty()) {
                    Player random = new Player();

                    random.setName(id);
                    random.setRole(event.getAuthor().getId());
                    random.setToken(1);
                    random.setUserid(event.getAuthor().getId());
                    int result = pc.createPlayer(random);
                    System.out.println("Result is " + result);

                } else if (!search.isEmpty()) {
                    List<Player> search1 = pc.selectPlayer(id);
                    Player pl = search1.get(0);
                    int valueofToken = pl.getToken().intValue();
                    int rise = valueofToken + 1;
                    pl.setToken(rise);
                    int playerUpdate = pc.updateToken(pl);
                    bCanSendJoke = false;

                } else {
                    System.out.println("cant find user");
                }

            }
        }
        if (event.getMessage().getContentRaw().equals("!token")) {
            String id = event.getAuthor().getAvatarId();
            List<Player> search1 = pc.selectPlayer(id);
            Player pl = search1.get(0);
            String valueOfToken = pl.getToken().toString();
            event.getChannel().asTextChannel().sendMessage("You have " + valueOfToken + " token").queue();
        }

    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equals("joke")) {
            event.reply(command).queue();
            event.getChannel().asTextChannel().sendMessage("jokee").queue();
        }
    }

}
