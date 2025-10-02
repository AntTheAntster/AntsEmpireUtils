package uk.co.anttheantster.antsempireutils.managers;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import uk.co.anttheantster.antsempireutils.commands.*;

public class CommandHandler {


    @SubscribeEvent
    public static void registerCommands(RegisterClientCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("aeu")
                .then(Commands.literal("togglemessages")
                        .executes(ToggleMessagesCommand::execute)));

        dispatcher.register(Commands.literal("aeu")
                .then(Commands.literal("gapalert")
                        .executes(GapAlertCommand::execute)));

        dispatcher.register(Commands.literal("aeu")
                .then(Commands.literal("autoeat")
                        .executes(AutoEatCommand::execute)));
        dispatcher.register(Commands.literal("aeu")
                .then(Commands.literal("armouralert")
                        .executes(ArmourAlertCommand::execute)));
        dispatcher.register(Commands.literal("aeu")
                .then(Commands.literal("pvpmode")
                        .executes(PvpModeCommand::execute)));
        dispatcher.register(Commands.literal("aeu")
                .then(Commands.literal("autofish")
                        .executes(AutoFishCommand::execute)));
    }

}
