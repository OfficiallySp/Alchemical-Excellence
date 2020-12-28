
package com.officiallysp.alchemicalexcellence.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.List;

import com.officiallysp.alchemicalexcellence.itemgroup.AECreativetabItemGroup;
import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceModElements;

@AlchemicalExcellenceModElements.ModElement.Tag
public class MysticalStoneItem extends AlchemicalExcellenceModElements.ModElement {
	@ObjectHolder("alchemical_excellence:mystical_stone")
	public static final Item block = null;
	public MysticalStoneItem(AlchemicalExcellenceModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AECreativetabItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("mystical_stone");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(this);
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
			return 0F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Discharged"));
		}
	}
}
