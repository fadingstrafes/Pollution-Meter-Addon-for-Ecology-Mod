package com.fading.items;

import com.sun.org.apache.bcel.internal.generic.LAND;
import ecomod.api.EcomodAPI;
import ecomod.api.pollution.PollutionData;
import ecomod.common.commands.CommandGetPollution;
import ecomod.common.tiles.TileAdvancedFilter;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.command.CommandBase;
import net.minecraft.command.WrongUsageException;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import tv.twitch.chat.Chat;

public class PollutionMeter extends Item
{
    PollutionData Data;
    PollutionData northChunk;
    PollutionData southChunk;
    PollutionData westChunk;
    PollutionData eastChunk;

    //Creates a Pollution Meter Item
    public PollutionMeter()
    {
        super();
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setUnlocalizedName("pollution_meter");
        this.maxStackSize = 1;

    }

    //Triggers an event when the item right clicks
    @Override
    public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p)
    {
        //stops server side interaction so it doesn't crash the  server
        if (w.isRemote) return i;

        //Stores the Chunks around the player in variables for later use
        Data = EcomodAPI.getPollution(w, p.chunkCoordX, p.chunkCoordZ);
        northChunk = EcomodAPI.getPollution(w, p.chunkCoordX, p.chunkCoordZ - 1);
        southChunk = EcomodAPI.getPollution(w, p.chunkCoordX, p.chunkCoordZ + 1);
        westChunk = EcomodAPI.getPollution(w, p.chunkCoordX, p.chunkCoordZ - 1);
        eastChunk = EcomodAPI.getPollution(w, p.chunkCoordX, p.chunkCoordZ + 1);

        //Calculates the average of the 4 chunks touching the player is in
        Float averageAir = northChunk.getAirPollution() + southChunk.getAirPollution() + westChunk.getAirPollution() + eastChunk.getAirPollution();
        averageAir = averageAir / 4;
        Float averageWater = northChunk.getWaterPollution() + southChunk.getWaterPollution() + westChunk.getWaterPollution() + eastChunk.getWaterPollution();
        averageWater = averageWater / 4;
        Float averageSoil = northChunk.getSoilPollution() + southChunk.getSoilPollution() + westChunk.getSoilPollution() + eastChunk.getSoilPollution();
        averageSoil = averageSoil / 4;

        //Prints out the data on the pollution around the area and in the chunk of the player
        p.addChatMessage(new ChatComponentText("This Chunk: (Air: " + Data.getAirPollution() + " Water: " + Data.getWaterPollution() + " Soil: " + Data.getSoilPollution() + ")" ));
        p.addChatMessage(new ChatComponentText("Nearby: (Air: " + averageAir + " Water: " + averageWater + " Soil: " + averageSoil + ")"));



        return i;
    }
}
