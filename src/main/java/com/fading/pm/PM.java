package com.fading.pm;

import com.fading.items.PMItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = PM.MODID, version = PM.VERSION)
public class PM {
    public static final String MODID = "pm";
    public static final String VERSION = "1.0";
    public static Item pollution_meter;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {


    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        //Executes our init method in PMItems
        PMItems.init();
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
