package uk.co.anttheantster.antsempireutils.keybind;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import uk.co.anttheantster.antsempireutils.AntsEmpireUtils;

@EventBusSubscriber(modid = AntsEmpireUtils.MODID, value = Dist.CLIENT)
public class Keybinds {
    private Keybinds() {}

    private static final String CATEGORY = "AntsEmpireUtils Keybinds";

    public static final KeyMapping autoFishKey = new KeyMapping(
            "key.antsempireutils.autofish", KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_V, -1), CATEGORY
    );
    public static final KeyMapping gappleAlertKey = new KeyMapping(
            "key.antsempireutils.gapplealert", KeyConflictContext.IN_GAME,
            InputConstants.UNKNOWN, CATEGORY
    );
    public static final KeyMapping pvpModeKey = new KeyMapping(
            "key.antsempireutils.pvpmode", KeyConflictContext.IN_GAME,
            InputConstants.UNKNOWN, CATEGORY
    );
    public static final KeyMapping autoEatKey = new KeyMapping(
            "key.antsempireutils.autoeat", KeyConflictContext.IN_GAME,
            InputConstants.UNKNOWN, CATEGORY
    );
    public static final KeyMapping armourAlertKey = new KeyMapping(
            "key.antsempireutils.armouralert", KeyConflictContext.IN_GAME,
            InputConstants.UNKNOWN, CATEGORY
    );

    @SubscribeEvent
    public static void registerKeybinds(RegisterKeyMappingsEvent event) {
        event.register(autoFishKey);
        event.register(gappleAlertKey);
        event.register(pvpModeKey);
        event.register(autoEatKey);
    }
}
