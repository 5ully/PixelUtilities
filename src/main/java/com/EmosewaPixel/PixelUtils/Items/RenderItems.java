package com.EmosewaPixel.PixelUtils.Items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class RenderItems {
    public static void preInit() {
        for (int i = 0; i < Items.itemcomponent.length; i++)
            registerItemRenderer(Items.itemcomponent[i], Items.stats.get(i).texture);
    }

    public static void init() {
        for (Item item : Items.itemcomponent)
            Minecraft.getMinecraft().getItemColors().registerItemColorHandler((ItemStack stack, int tintIndex) -> {
                int i;
                for (i = 0; i < Items.itemcomponent.length; i++)
                    if (stack.getItem() == Items.itemcomponent[i]) {
                        break;
                    }
                return Items.stats.get(i).color;
            }, item);
    }

    private static void registerItemRenderer(Item item, ResourceLocation texture) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(texture, "inventory"));
    }
}
