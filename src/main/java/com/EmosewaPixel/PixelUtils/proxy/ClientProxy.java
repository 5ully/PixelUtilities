package com.EmosewaPixel.PixelUtils.proxy;

import com.EmosewaPixel.PixelUtils.Items.RenderItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        RenderItems.preInit();
    }

    public void init(FMLInitializationEvent e) {
        super.init(e);
        RenderItems.init();
    }
}
