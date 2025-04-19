package io.github.nabit808.tORUtilities.commands;

import io.github.nabit808.tORUtilities.utils.ScaleUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Command can only be used on players");
            return true;
        }

        Player player = (Player) sender;

        switch (args.length) {
            case 1:
                if (args[0].equals("get"))
                    return getSize(player);
                else
                    return reSize(player, args[0]);
            case 2:
                switch (args[0]){
                    case "add":
                        return addSize(player, args[1]);
                    case "set":
                        return reSize(player, args[1]);
                    case "sub":
                        return subSize(player, args[1]);
                }
            default:
                return false;
        }
    }

    private boolean getSize(Player player){
        player.sendMessage("§aYour current scale is: " + ScaleUtils.getScale(player));
        return true;
    }

    private boolean reSize(Player player, String size){
        ScaleUtils.setScale(player, Double.parseDouble(size));
        player.sendMessage("§aYour current scale is: " + ScaleUtils.getScale(player));
        return true;
    }

    private boolean addSize(Player player, String size){
        ScaleUtils.addScale(player, Double.parseDouble(size));
        player.sendMessage("§aYour current scale is: " + ScaleUtils.getScale(player));
        return true;
    }

    private boolean subSize(Player player, String size){
        ScaleUtils.subScale(player, Double.parseDouble(size));
        player.sendMessage("§aYour current scale is: " + ScaleUtils.getScale(player));
        return true;
    }
}
