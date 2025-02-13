package com.superworldsun.superslegend.items.curios.head.masks;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.registries.ItemInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;

@EventBusSubscriber(bus = Bus.FORGE, modid = SupersLegendMain.MOD_ID)
public class MaskMaskofTruth extends Item implements ICurioItem {
    private static final String[] COW_SPEECHES = {"Mooooooo", "Moo Moo"};
    private static final String[] PIG_SPEECHES = {"Oink", "Oink oink"};

    public MaskMaskofTruth(Properties properties) {
        super(properties);
    }

    @SubscribeEvent
    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (event.getPlayer().level.isClientSide) {
            return;
        }

        ItemStack stack0 = CuriosApi.getCuriosHelper().findEquippedCurio(ItemInit.MASK_MASKOFTRUTH.get(), (LivingEntity) event.getEntity()).map(ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
        if (stack0.isEmpty()) {
            return;
        }

        if (event.getHand() == Hand.OFF_HAND) {
            return;
        }

        if (event.getTarget().getType() == EntityType.COW) {
            sendRandomMessage(event.getPlayer(), event.getTarget(), SoundEvents.COW_AMBIENT, COW_SPEECHES);
        } else if (event.getTarget().getType() == EntityType.PIG) {
            sendRandomMessage(event.getPlayer(), event.getTarget(), SoundEvents.PIG_AMBIENT, PIG_SPEECHES);
        }
    }

    private static void sendRandomMessage(PlayerEntity player, Entity target, SoundEvent sound, String[] speeches) {
        int line = player.getRandom().nextInt(speeches.length);
        player.sendMessage(new StringTextComponent(speeches[line]), UUID.randomUUID());
        target.playSound(sound, 1.0F, 1.0F);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.appendHoverText(stack, world, list, flag);
        list.add(new StringTextComponent(TextFormatting.GRAY + "A mask that is said to see that which is hidden"));
    }
}