package uk.co.anttheantster.antsempireutils.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import uk.co.anttheantster.antsempireutils.keybind.Keybinds;
import uk.co.anttheantster.antsempireutils.utils.Settings;

public class GappleAlert {

    protected static Minecraft mc = Minecraft.getInstance();
    public boolean hasGap;
    private static final String gapAlert = "§cNo Gapple!";
    private static String prefix = "§fGapple§bAlert ";

    @SubscribeEvent
    public void playerTick(PlayerTickEvent.Post event) {
        if (Keybinds.gappleAlertKey.consumeClick()){
            Settings.gappleAlertEnabled = !Settings.gappleAlertEnabled;

            if (Settings.messagesEnabled){
                String status = Settings.gappleAlertEnabled ? "§aEnabled" : "§cDisabled";
                mc.player.displayClientMessage(Component.literal(prefix + status), false);
            }
        }

        if (mc.player == null || mc.level == null) { return; }

        if (!Settings.gappleAlertEnabled) { return; }

        if (hasGap) {
            if (!hasRegenV()){
                mc.gui.setTitle(Component.literal(gapAlert));
                mc.gui.setSubtitle(null);

                mc.gui.setTimes(10, 60, 10);

                hasGap = false;
            }
        } else {
            hasGap = hasRegenV();
        }
    }

    private boolean hasRegenV() {
        MobEffectInstance pEffects = mc.player.getEffect(MobEffects.REGENERATION);
        return  pEffects != null && pEffects.getAmplifier() == 1;
    }

}
