package uk.co.anttheantster.antsempireutils.commands;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import uk.co.anttheantster.antsempireutils.utils.Settings;

public class ArmourAlertCommand {

    private static String prefix = "§fArmour§bAlert ";

    public static int execute(CommandContext<CommandSourceStack> context) {
        Settings.armourAlertEnabled = !Settings.armourAlertEnabled;
        String status = Settings.armourAlertEnabled ? "§aEnabled" : "§cDisabled";

        Minecraft.getInstance().player.displayClientMessage(Component.literal(prefix + status), false);

        return 1;
    }
}
