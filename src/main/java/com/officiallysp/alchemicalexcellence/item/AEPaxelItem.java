
package com.officiallysp.alchemicalexcellence.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.officiallysp.alchemicalexcellence.procedures.AEPaxelBlockDestroyedWithToolProcedure;
import com.officiallysp.alchemicalexcellence.itemgroup.AEModItemGroup;
import com.officiallysp.alchemicalexcellence.AlchemicalExcellenceModElements;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableMultimap;

@AlchemicalExcellenceModElements.ModElement.Tag
public class AEPaxelItem extends AlchemicalExcellenceModElements.ModElement {
	@ObjectHolder("alchemical_excellence:ae_paxel")
	public static final Item block = null;
	public AEPaxelItem(AlchemicalExcellenceModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("The Ultimate Multitool"));
				list.add(new StringTextComponent("Mines as a pickaxe, axe, and shovel"));
				list.add(new StringTextComponent("Chance on mine: XP bonus, earthquake, or full repair"));
			}
		}.setRegistryName("ae_paxel"));
	}
	private static class ItemToolCustom extends Item {
		protected ItemToolCustom() {
			super(new Item.Properties().group(AEModItemGroup.tab).maxDamage(4096).isImmuneToFire()
					.addToolType(ToolType.PICKAXE, 5).addToolType(ToolType.AXE, 5).addToolType(ToolType.SHOVEL, 5));
		}

		@Override
		public Set<ToolType> getToolTypes(ItemStack stack) {
			return ImmutableSet.of(ToolType.PICKAXE, ToolType.AXE, ToolType.SHOVEL);
		}

		@Override
		public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
			if (equipmentSlot == EquipmentSlotType.MAINHAND) {
				ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
				builder.putAll(super.getAttributeModifiers(equipmentSlot));
				builder.put(Attributes.ATTACK_DAMAGE,
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 7f, AttributeModifier.Operation.ADDITION));
				builder.put(Attributes.ATTACK_SPEED,
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -2.8, AttributeModifier.Operation.ADDITION));
				return builder.build();
			}
			return super.getAttributeModifiers(equipmentSlot);
		}

		@Override
		public boolean canHarvestBlock(BlockState state) {
			return 5 >= state.getHarvestLevel();
		}

		@Override
		public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
			return 20f;
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			stack.damageItem(1, attacker, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
			stack.damageItem(1, entityLiving, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entityLiving);
			$_dependencies.put("itemstack", stack);
			$_dependencies.put("x", pos.getX());
			$_dependencies.put("y", pos.getY());
			$_dependencies.put("z", pos.getZ());
			$_dependencies.put("world", worldIn);
			AEPaxelBlockDestroyedWithToolProcedure.executeProcedure($_dependencies);
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 25;
		}
	}
}
