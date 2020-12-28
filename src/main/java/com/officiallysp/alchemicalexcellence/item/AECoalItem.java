
package com.officiallysp.alchemicalexcellence.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import com.officiallysp.alchemicalexcellence.itemgroup.AECreativetabItemGroup;
import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceModElements;

@AlchemicalExcellenceModElements.ModElement.Tag
public class AECoalItem extends AlchemicalExcellenceModElements.ModElement {
	@ObjectHolder("alchemical_excellence:ae_coal")
	public static final Item block = null;
	public AECoalItem(AlchemicalExcellenceModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AECreativetabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("ae_coal");
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
