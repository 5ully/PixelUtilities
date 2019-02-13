package com.EmosewaPixel.PixelUtils.Mods;

import com.EmosewaPixel.PixelUtils.PixelUtils;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

@Mod.EventBusSubscriber(modid = PixelUtils.MODID)
public class EnderIOEvents {

    private static final Random RANDOM = new Random();
    private static final Map<BlockPos, Long> fires = new HashMap<>();

    @SubscribeEvent
    public static void on(BlockEvent.NeighborNotifyEvent event) {
        final World world = event.getWorld();
        BlockPos posIdx = event.getPos();
        if (world.provider.getDimension() != 0)
            posIdx = posIdx.up(world.provider.getDimension() * 256);
        BlockPos pos = event.getPos();
        final long worldTime = world.getTotalWorldTime();
        int meta = world.getBlockState(pos.down()).getBlock().getMetaFromState(world.getBlockState(pos.down()));
        if (meta > 1 && meta < 8)
            checks(meta, pos, worldTime, world, posIdx, event.getState());
    }

    private static void spawnInfinityPowder(final @Nonnull World world, final @Nonnull BlockPos pos) {
        double d0 = RANDOM.nextFloat() * 0.5F + 0.25D;
        double d1 = RANDOM.nextFloat() * 0.5F + 0.25D;
        double d2 = RANDOM.nextFloat() * 0.5F + 0.25D;
        EntityItem entityitem = new EntityItem(world, pos.getX() + d0, pos.getY() + d1, pos.getZ() + d2,
                new ItemStack(Item.getByNameOrId("enderio:item_material"), 1, 20));
        entityitem.setDefaultPickupDelay();
        entityitem.attackEntityFrom(DamageSource.IN_FIRE, -100);
        entityitem.setFire(10);
        world.spawnEntity(entityitem);
        world.playSound(null, pos, SoundEvents.ENTITY_FIREWORK_LARGE_BLAST, SoundCategory.BLOCKS, 1.0F, RANDOM.nextFloat() * 0.4F + 0.8F);
    }

    private static void checks(int meta, BlockPos pos, long worldTime, World world, BlockPos posIdx, IBlockState state) {
        if (fires.containsKey(posIdx)) {
            if (world.isAirBlock(pos) && world.getBlockState(pos.down()).getBlock().getRegistryName().toString().equals("extrautils2:compressedcobblestone") && worldTime > fires.get(posIdx) && RANDOM.nextFloat() <= (0.1 * (meta - 1))) {
                spawnInfinityPowder(world, pos);
            }
            fires.remove(posIdx);
        } else if (state.getBlock() instanceof BlockFire && world.getBlockState(pos.down()).getBlock().getRegistryName().toString().equals("extrautils2:compressedcobblestone")) {
            if (fires.size() > 100) {
                Iterator<Long> iterator = fires.values().iterator();
                while (iterator.hasNext()) {
                    if (iterator.next() < worldTime || fires.size() > 500) {
                        iterator.remove();
                    }
                }
            }
            fires.put(posIdx, worldTime + 260);
        }
    }

    @SuppressWarnings("null")
    @SubscribeEvent
    public static void onWorldTick(@Nonnull TickEvent.WorldTickEvent event) {
        if (!fires.isEmpty() && !event.world.getGameRules().getBoolean("doFireTick")) {
            final int yOffset = event.world.provider.getDimension() * 256;
            final long worldTime = event.world.getTotalWorldTime();
            for (Map.Entry<BlockPos, Long> fire : fires.entrySet()) {
                final BlockPos posIdx = fire.getKey();
                final BlockPos pos = posIdx.down(yOffset);
                if (pos.getY() >= 0 && pos.getY() <= 255 && worldTime > fire.getValue()) {
                    if (event.world.getBlockState(pos).getBlock() instanceof BlockFire) {
                        event.world.setBlockToAir(pos);
                    } else {
                        fires.remove(posIdx);
                    }
                    return;
                }
            }
        }
    }
}
