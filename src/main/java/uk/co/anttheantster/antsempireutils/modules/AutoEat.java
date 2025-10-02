package uk.co.anttheantster.antsempireutils.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import uk.co.anttheantster.antsempireutils.keybind.Keybinds;
import uk.co.anttheantster.antsempireutils.utils.Settings;

public class AutoEat {
    protected static Minecraft mc = Minecraft.getInstance();

    private static final String prefix = "§fAuto§bEat ";
    private static boolean queueCommand = false;

    @SubscribeEvent
    public void onTick(PlayerTickEvent.Post event) {
        if (Keybinds.autoEatKey.consumeClick()){
            Settings.autoEat =  !Settings.autoEat;
            if (Settings.messagesEnabled){
                String status = Settings.autoEat ? "§aEnabled" : "§cDisabled";
                mc.player.displayClientMessage(Component.literal(prefix + status), false);
            }
        }

        if (mc.player == null || mc.level == null){ return; }

        if (!Settings.autoEat){ return; }

        if (mc.player.getFoodData().getFoodLevel() < 18){
            if (!queueCommand){
                mc.player.connection.sendCommand("eat");
                queueCommand = true; //Prevent multiple "/eat"'s from being sent to the server from tick inconsistencies
                if (Settings.messagesEnabled){
                    mc.player.displayClientMessage(Component.literal(prefix + "§eEaten!"), false);
                }
            } else {
                queueCommand = false;
            }
        }
    }
}
