
package com.officiallysp.alchemicalexcellence.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import com.officiallysp.alchemicalexcellence.itemgroup.AEModItemGroup;
import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceModElements;

@AlchemicalExcellenceModElements.ModElement.Tag
public class NulliteStoneItem extends AlchemicalExcellenceModElements.ModElement {
	@ObjectHolder("alchemical_excellence:ae_nullitestone")
	public static final Item block = null;
	public NulliteStoneItem(AlchemicalExcellenceModElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AEModItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("ae_nullitestone");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
