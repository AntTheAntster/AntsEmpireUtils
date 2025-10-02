package uk.co.anttheantster.antsempireutils.commands;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import uk.co.anttheantster.antsempireutils.utils.Settings;

public class ToggleMessagesCommand {
    private static String prefix = "§fToggle§bMessages ";

    public static int execute(CommandContext<CommandSourceStack> context) {
        Settings.messagesEnabled = !Settings.messagesEnabled;
        String status = Settings.messagesEnabled ? "§aEnabled" : "§cDisabled";

        Minecraft.getInstance().player.displayClientMessage(Component.literal(prefix + status), false);

        return 1;
    }

}
