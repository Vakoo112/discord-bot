package dc.bot.dcbot;

import dc.bot.dcbot.commands.Help;
import dc.bot.dcbot.commands.MessageSending;
import dc.bot.dcbot.services.BotJokeService;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DcBot1Application {
   
    public static String prefix = "-";
    
	public static void main(String[] args) throws LoginException {
		SpringApplication.run(DcBot1Application.class, args);
                JDA bot = JDABuilder.createDefault("MTA5NTM4ODg2NzI5MDQ4NDc4Ng.GdI8_c.WVyV7gwHBCDdOlXVcV8mji7h3ZaP090X1phGGE")
                        .setActivity(Activity.playing("example"))
                        .addEventListeners(new MessageSending(),
                                new Help(), new BotJokeService())
                        .build();
        }

    }

   
        

