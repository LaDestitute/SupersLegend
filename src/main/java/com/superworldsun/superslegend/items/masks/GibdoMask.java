package com.superworldsun.superslegend.items.masks;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.items.custom.NonEnchantArmor;
import com.superworldsun.superslegend.registries.ArmourInit;
import com.superworldsun.superslegend.registries.ItemInit;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.MobEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.FORGE, modid = SupersLegendMain.MOD_ID, value = Dist.CLIENT)
public class GibdoMask extends NonEnchantArmor
{
	public GibdoMask()
	{
		super(ArmourInit.gibdomask, EquipmentSlotType.HEAD, new Item.Properties().tab(SupersLegendMain.RESOURCES));
	}
	
	@SubscribeEvent
	public static void onLivingSetAttackTarget(LivingSetAttackTargetEvent event)
	{
		if (event.getTarget() == null)
		{
			return;
		}
		
		// Only works on undead
		if (event.getEntityLiving().getMobType() != CreatureAttribute.UNDEAD)
		{
			return;
		}
		
		// Only works for mobs
		if (!(event.getEntityLiving() instanceof MobEntity))
		{
			return;
		}
		
		// Reset target if target has mask equipped
		if (event.getTarget().getItemBySlot(EquipmentSlotType.HEAD).getItem() == ItemInit.MASK_GIBDOMASK.get())
		{
			((MobEntity) event.getEntityLiving()).setTarget(null);
		}
	}
}
