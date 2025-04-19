package io.github.nabit808.tORUtilities.utils;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class ScaleUtils {

    static double scaleMin = 0.4;
    static double scaleMax = 1.6;

    // Get player's scale
    public static double getScale(Player player){
        AttributeInstance scale = player.getAttribute(Attribute.SCALE);
        if (scale == null) return 1.0;
        return scale.getBaseValue();
    }

    // Set player's scale
    public static void setScale(Player player, double NewScale){
        AttributeInstance scale = player.getAttribute(Attribute.SCALE);
        if (scale == null) return;
        if (scaleMin < NewScale && NewScale < scaleMax)
            scale.setBaseValue(NewScale);
        else player.sendMessage("§4Scale exceeds range.");
    }

    // Add to player's scale
    public static void addScale(Player player, double NewScale){
        AttributeInstance scale = player.getAttribute(Attribute.SCALE);
        if (scale == null) return;
        if (scaleMin < scale.getBaseValue() + NewScale && scale.getBaseValue() + NewScale < scaleMax)
            scale.setBaseValue(scale.getBaseValue() + NewScale);
        else player.sendMessage("§4Scale exceeds range.");
    }

    // Subtract to player's scale
    public static void subScale(Player player, double NewScale){
        AttributeInstance scale = player.getAttribute(Attribute.SCALE);
        if (scale == null) return;
        if (scaleMin < scale.getBaseValue() - NewScale && scale.getBaseValue() - NewScale < scaleMax)
            scale.setBaseValue(scale.getBaseValue() - NewScale);
        else player.sendMessage("§4Scale exceeds range.");
    }
}
