package com.EmosewaPixel.PixelUtils.Items;

import com.EmosewaPixel.PixelUtils.PixelUtils;
import net.minecraft.item.Item;

public class ItemComponent extends Item {
    public ItemComponent(String name) {
        setUnlocalizedName(PixelUtils.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTab.tabMain);
    }
}
