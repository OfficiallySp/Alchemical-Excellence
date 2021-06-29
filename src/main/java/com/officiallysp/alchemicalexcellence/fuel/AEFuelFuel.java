
package com.officiallysp.alchemicalexcellence.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import com.officiallysp.alchemicalexcellence.item.AECoalItem;
import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceModElements;

@AlchemicalExcellenceModElements.ModElement.Tag
public class AEFuelFuel extends AlchemicalExcellenceModElements.ModElement {
	public AEFuelFuel(AlchemicalExcellenceModElements instance) {
		super(instance, 47);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(AECoalItem.block, (int) (1)).getItem())
			event.setBurnTime(15000);
	}
}
