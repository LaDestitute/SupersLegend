package com.superworldsun.superslegend.items.armors;

import com.superworldsun.superslegend.items.custom.NonEnchantArmor;
import com.superworldsun.superslegend.registries.ArmourInit;
import com.superworldsun.superslegend.registries.ItemInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ArmorClimbingGearEffects extends NonEnchantArmor {


    public ArmorClimbingGearEffects(EquipmentSlotType slot, Properties properties) {
        super(ArmourInit.CLIMBING, slot, properties);
    }

    public void appendHoverText(ItemStack stack, World world, java.util.List<ITextComponent> list, ITooltipFlag flag)
	{
		super.appendHoverText(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.DARK_GREEN + "Going up"));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Wearing the set grants the ability to climb any surface"));
        list.add(new StringTextComponent(TextFormatting.RED + "Dosent work well in rain"));
	}

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) 
    {
        boolean isHelmetOn = player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ItemInit.CLIMBERS_BANDANNA.get();
        boolean isChestplateOn = player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ItemInit.CLIMBING_GEAR.get();
        boolean isLeggingsOn = player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ItemInit.CLIMBING_PANTS.get();
        boolean isBootsOn = player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ItemInit.CLIMBING_BOOTS.get();
            if(isHelmetOn&isChestplateOn || isHelmetOn&isLeggingsOn || isHelmetOn&isBootsOn ||
                    isChestplateOn&isLeggingsOn || isChestplateOn&isBootsOn || isLeggingsOn&isBootsOn) {
                if (!player.isSpectator() && player.horizontalCollision && player.zza > 0 && !player.isInWaterOrRain()) {
                    player.setDeltaMovement(player.getDeltaMovement().x(), 0.05, player.getDeltaMovement().z());
                    player.fallDistance = 0F;
                }
            }
            if(isHelmetOn&isChestplateOn&isLeggingsOn&isBootsOn)
            {
                if (!player.isSpectator() && player.horizontalCollision && player.zza > 0 && !player.isInWaterOrRain()) {
                    player.setDeltaMovement(player.getDeltaMovement().x(), 0.1, player.getDeltaMovement().z());
                    player.fallDistance = 0F;
                }
            }
    }
    //player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ItemInit.ANCIENT_BOOTS.get()

}