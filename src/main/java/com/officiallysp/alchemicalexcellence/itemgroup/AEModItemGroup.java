
package com.officiallysp.alchemicalexcellence.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.officiallysp.alchemicalexcellence.item.MysticalStoneItem;
import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceModElements;

@AlchemicalExcellenceModElements.ModElement.Tag
public class AEModItemGroup extends AlchemicalExcellenceModElements.ModElement {
	public AEModItemGroup(AlchemicalExcellenceModElements instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabae_modtab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MysticalStoneItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
