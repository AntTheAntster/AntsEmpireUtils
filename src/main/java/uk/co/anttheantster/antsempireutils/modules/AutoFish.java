package uk.co.anttheantster.antsempireutils.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import uk.co.anttheantster.antsempireutils.keybind.Keybinds;
import uk.co.anttheantster.antsempireutils.utils.Settings;

public class AutoFish {
    protected static final Minecraft mc = Minecraft.getInstance();
    private static final int ROD_CAST_DELAY = 300;
    private int castRodTimer = 0;
    private long lastCasted = 00;
    private final String fishPrefix = "§fAuto§bFish ";

    @SubscribeEvent
    public void onTick(PlayerTickEvent.Post e) {
        LocalPlayer player = mc.player;
        if (Keybinds.autoFishKey.consumeClick()){
            Settings.fishEnabled = !Settings.fishEnabled;
            if (!Settings.fishEnabled){
                //AutoFisher turned off
            } else {
                //AutoFish turned on
            }

            String status = Settings.fishEnabled ? "§aEnabled" : "§cDisabled";
            String message = fishPrefix + status;

            if (Settings.messagesEnabled){
                player.displayClientMessage(Component.literal(message), false);
            }
        }
    }


}
