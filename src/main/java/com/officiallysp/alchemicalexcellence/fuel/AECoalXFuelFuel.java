
package com.officiallysp.alchemicalexcellence.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import com.officiallysp.alchemicalexcellence.item.AECoalXItem;
import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceModElements;

@AlchemicalExcellenceModElements.ModElement.Tag
public class AECoalXFuelFuel extends AlchemicalExcellenceModElements.ModElement {
	public AECoalXFuelFuel(AlchemicalExcellenceModElements instance) {
		super(instance, 16);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(AECoalXItem.block, (int) (1)).getItem())
			event.setBurnTime(50000);
	}
}
