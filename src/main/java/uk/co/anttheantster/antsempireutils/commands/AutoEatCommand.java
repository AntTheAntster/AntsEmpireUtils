package uk.co.anttheantster.antsempireutils.commands;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import uk.co.anttheantster.antsempireutils.utils.Settings;

public class AutoEatCommand {

    private static String prefix = "§fAuto§bEat ";

    public static int execute(CommandContext<CommandSourceStack> context) {
        Settings.autoEat = !Settings.autoEat;
        String status = Settings.autoEat ? "§aEnabled" : "§cDisabled";

        Minecraft.getInstance().player.displayClientMessage(Component.literal(prefix + status), false);

        return 1;
    }
}
