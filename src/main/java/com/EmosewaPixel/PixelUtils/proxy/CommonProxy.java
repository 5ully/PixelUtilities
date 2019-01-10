package com.EmosewaPixel.PixelUtils.proxy;

import com.EmosewaPixel.PixelUtils.Items.Items;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        Items.init();
    }

    public void init(FMLInitializationEvent e) {

    }
}
