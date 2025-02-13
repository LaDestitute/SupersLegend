package com.superworldsun.superslegend.items.items;

import com.superworldsun.superslegend.entities.projectiles.arrows.FireArrowEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class ArrowFire extends ArrowItem
{

    public ArrowFire(Properties builder)
    {
        super(builder);
    }

    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        FireArrowEntity entityFireArrow = new FireArrowEntity(worldIn, shooter);
        return entityFireArrow;
    }

    @Override
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("An arrow with a hot touch"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    /*public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.arrows.player.PlayerEntity player) {
        @SuppressWarnings("unused")
		ItemStack itemStack = (new ItemStack(ItemList.heros_bow));
        return true;
     }*/
}
