package com.fading.items;

import com.fading.items.PollutionMeter;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ecomod.api.EcomodItems;
import ecomod.core.EcologyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PMItems
{
    public static Item pollution_meter;

    //Initializes the new Item with recipe
    public static void init()
    {
        pollution_meter = new PollutionMeter().setTextureName("pm:scanner");

        GameRegistry.registerItem(pollution_meter, pollution_meter.getUnlocalizedName());
        GameRegistry.addRecipe(new ItemStack(pollution_meter), new Object[]{"WWW",
                                                                            "WCW",
                                                                            "WWW", 'W', Blocks.wool, 'C', EcomodItems.CORE});

    }
}
