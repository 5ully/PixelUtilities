package com.EmosewaPixel.PixelUtils.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTab {
    public static CreativeTabs tabMain = new CreativeTabs(
            "pixelutils.tabMain") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.itemcomponent[0]);
        }
    };
}