package com.officiallysp.alchemicalexcellence.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceModElements;
import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceMod;

@AlchemicalExcellenceModElements.ModElement.Tag
public class AEShovelBlockDestroyedWithToolProcedure extends AlchemicalExcellenceModElements.ModElement {
	public AEShovelBlockDestroyedWithToolProcedure(AlchemicalExcellenceModElements instance) {
		super(instance, 48);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemicalExcellenceMod.LOGGER.warn("Failed to load dependency entity for procedure AEShovelBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AlchemicalExcellenceMod.LOGGER.warn("Failed to load dependency x for procedure AEShovelBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AlchemicalExcellenceMod.LOGGER.warn("Failed to load dependency y for procedure AEShovelBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AlchemicalExcellenceMod.LOGGER.warn("Failed to load dependency z for procedure AEShovelBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AlchemicalExcellenceMod.LOGGER.warn("Failed to load dependency world for procedure AEShovelBlockDestroyedWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.1)) {
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 1, Explosion.Mode.BREAK);
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.bell")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.bell")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("MiniQuake Activated"), (true));
			}
		}
	}
}
