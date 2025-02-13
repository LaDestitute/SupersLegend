package com.superworldsun.superslegend.items.curios.rings;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutableTriple;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.items.RingItem;
import com.superworldsun.superslegend.registries.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;

@Mod.EventBusSubscriber(modid = SupersLegendMain.MOD_ID)
public class RedRing extends RingItem
{	
	public RedRing()
	{
		super(new Item.Properties());
	}
	
	@SubscribeEvent
	public static void livingDamageEvent(LivingDamageEvent event)
	{
		// Check if is player doing the damage.
		if (event.getSource().getDirectEntity() instanceof PlayerEntity)
		{			
			// Get Player.
			PlayerEntity player = (PlayerEntity) event.getSource().getDirectEntity();			
			// Get the Ring as an ItemStack
			ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(ItemInit.RED_RING.get(), player).map(ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
			
			// Check if player is wearing it. Check if Sword Item.
			if (!stack.isEmpty() && player.getMainHandItem().getItem() instanceof SwordItem)
			{
				event.setAmount(event.getAmount() * 2);
			}
		}
	}
	
	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.appendHoverText(stack, world, list, flag);
		list.add(new StringTextComponent(TextFormatting.RED + "Sword damage x2"));
	}
	
}