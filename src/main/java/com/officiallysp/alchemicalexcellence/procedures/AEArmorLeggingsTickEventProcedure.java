package com.officiallysp.alchemicalexcellence.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceModElements;
import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceMod;

@AlchemicalExcellenceModElements.ModElement.Tag
public class AEArmorLeggingsTickEventProcedure extends AlchemicalExcellenceModElements.ModElement {
	public AEArmorLeggingsTickEventProcedure(AlchemicalExcellenceModElements instance) {
		super(instance, 41);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemicalExcellenceMod.LOGGER.warn("Failed to load dependency entity for procedure AEArmorLeggingsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 1, (int) 1));
	}
}
