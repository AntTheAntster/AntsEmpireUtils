package uk.co.anttheantster.antsempireutils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import uk.co.anttheantster.antsempireutils.managers.CommandHandler;
import uk.co.anttheantster.antsempireutils.modules.AutoEat;
import uk.co.anttheantster.antsempireutils.modules.AutoFish;
import uk.co.anttheantster.antsempireutils.modules.GappleAlert;
import uk.co.anttheantster.antsempireutils.modules.PvpMode;
import uk.co.anttheantster.antsempireutils.utils.VersionChecker;

@Mod(AntsEmpireUtils.MODID)
public class AntsEmpireUtils {
    public static final String version = "1.0";
    public static final String MODID = "antsempireutils";

    public AntsEmpireUtils(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            NeoForge.EVENT_BUS.register(VersionChecker.class);
            NeoForge.EVENT_BUS.register(new AutoFish());
            NeoForge.EVENT_BUS.register(new GappleAlert());
            NeoForge.EVENT_BUS.register(new AutoEat());
            NeoForge.EVENT_BUS.register(new PvpMode());

            registerCommands();
        }
    }

    private static void registerCommands(){
        NeoForge.EVENT_BUS.register(CommandHandler.class);
    }
}
