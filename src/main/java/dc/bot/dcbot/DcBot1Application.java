package dc.bot.dcbot;

import dc.bot.dcbot.commands.Help;
import dc.bot.dcbot.commands.MessageSending;
import dc.bot.dcbot.commands.BotJokeService;
import dc.bot.dcbot.commands.Commands;
import dc.bot.dcbot.util.EmailSenderService;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DcBot1Application {


    @Autowired
    private EmailSenderService emailSenderService;
    public static String prefix = "-";

    public static void main(String[] args) throws LoginException {
        SpringApplication.run(DcBot1Application.class, args);
        
        JDA bot = JDABuilder.createDefault("******")
                .setActivity(Activity.playing("example")).enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new MessageSending(),
                        new Help()).addEventListeners(new Commands(), new BotJokeService())
                .build();
        
    }
    
    /**
     *
     * @EventListener(ApplicationReadyEvent.class) public void triggerMail() {
     * emailSenderService.SendSimpleEmail("", "this was sent", "subject"); }
     */
}
