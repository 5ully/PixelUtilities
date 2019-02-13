package com.EmosewaPixel.PixelUtils.proxy;

import com.EmosewaPixel.PixelUtils.Items.Items;
import com.EmosewaPixel.PixelUtils.Items.OreDicts;
import com.EmosewaPixel.PixelUtils.Mods.EnderIOEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        Items.init();
    }

    public void init(FMLInitializationEvent e) {
        OreDicts.init();
        MinecraftForge.EVENT_BUS.register(new EnderIOEvents());
    }
}
