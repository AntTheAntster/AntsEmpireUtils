package uk.co.anttheantster.antsempireutils.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import uk.co.anttheantster.antsempireutils.keybind.Keybinds;
import uk.co.anttheantster.antsempireutils.utils.Settings;

public class PvpMode {

    protected static Minecraft mc = Minecraft.getInstance();
    private static final String message = "§fPVP§bMode §aEnabled";

    @SubscribeEvent
    public static void onTick(PlayerTickEvent.Post event){
        if (Keybinds.pvpModeKey.consumeClick()){
            mc.gui.setTitle(Component.literal(message));
            mc.gui.setSubtitle(null);

            mc.gui.setTimes(10, 60, 10);

            enableMode();
        }
    }

    public static void enableMode(){
        Settings.fishEnabled = false;
        Settings.gappleAlertEnabled = true;
        Settings.armourAlertEnabled = true;
        Settings.autoEat = false;
    }

}
