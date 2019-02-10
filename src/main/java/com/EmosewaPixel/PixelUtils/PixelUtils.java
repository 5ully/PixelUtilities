package com.EmosewaPixel.PixelUtils;

import com.EmosewaPixel.PixelUtils.Items.Items;
import com.EmosewaPixel.PixelUtils.Mods.ExtremeReactors;
import com.EmosewaPixel.PixelUtils.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = PixelUtils.MODID, name = PixelUtils.NAME, version = PixelUtils.VERSION, dependencies = "required-after:bigreactors")
public class PixelUtils {
    public static final String MODID = "pixelutils";
    public static final String NAME = "PixelUtils";
    public static final String VERSION = "@VERSION@";

    private static Logger logger;

    @SidedProxy(clientSide = "com.EmosewaPixel.PixelUtils.proxy.ClientProxy", serverSide = "com.EmosewaPixel.PixelUtils.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        ExtremeReactors.init();
    }
}
