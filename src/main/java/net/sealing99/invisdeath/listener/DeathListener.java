package net.sealing99.invisdeath.listener;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffectType;

public class DeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player victim = event.getEntity();
        Player killer = victim.getKiller();

        if (killer == null) {
            return;
        }

        if (!killer.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
            return;
        }

        Component message = event.deathMessage();

        if (message != null) {
            message = message.replaceText(builder -> builder
                    .matchLiteral(killer.getName())
                    .replacement("")
            );

            message = message.append(Component.text("aaaaaaaa")
                    .decorate(TextDecoration.OBFUSCATED));

            event.deathMessage(message);
        }
    }
}
