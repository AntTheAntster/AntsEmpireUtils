package uk.co.anttheantster.antsempireutils.commands;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import uk.co.anttheantster.antsempireutils.modules.PvpMode;
import uk.co.anttheantster.antsempireutils.utils.Settings;

public class PvpModeCommand {
    private static String message = "§fPVP§bMode §aEnabled!";

    public static int execute(CommandContext<CommandSourceStack> context) {
        PvpMode.enableMode();

        Minecraft.getInstance().player.displayClientMessage(Component.literal(message), false);

        return 1;
    }
}
