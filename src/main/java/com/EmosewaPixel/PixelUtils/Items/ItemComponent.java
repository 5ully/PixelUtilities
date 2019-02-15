package com.EmosewaPixel.PixelUtils.Items;

import com.EmosewaPixel.PixelUtils.PixelUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemComponent extends Item {
    private boolean isGlowing;
    public ItemComponent(String name, boolean isGlowing) {
        setUnlocalizedName(PixelUtils.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTab.tabMain);
        this.isGlowing=isGlowing;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return isGlowing || stack.isItemEnchanted();
    }
}
