package com.superworldsun.superslegend.items.curios.head.masks;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.superworldsun.superslegend.registries.ItemInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nonnull;
import java.util.List;

public class MaskAllnightmask extends Item implements ICurioItem {
    public MaskAllnightmask(Properties properties) {
        super(properties);
    }

        /*@Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
        {
            return SupersLegendMain.MOD_ID + ":textures/armor/giantsmask_layer_1.png";
        }

    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
    {
        return (A) new ModelAllnightmask(0);
    }
*/

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
        World world = livingEntity.level;
        PlayerEntity player = (PlayerEntity) livingEntity;

        if (!world.isClientSide) {
            ItemStack stack0 = CuriosApi.getCuriosHelper().findEquippedCurio(ItemInit.MASK_ALLNIGHTMASK.get(), player).map(ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
            if (!stack0.isEmpty()) {
                player.addEffect(new EffectInstance(Effect.byId(16), 230, 0, false, false));
            }
        }
        if (player.isSleeping()) {
            player.stopSleeping();
            player.displayClientMessage(new TranslationTextComponent(TextFormatting.GRAY + "You feel restless"), true);
        }
    }

    @Override
    public @Nonnull
    Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@Nonnull EquipmentSlotType
                                                                                equipmentSlot) {
        return HashMultimap.create();
    }


    @Override
    public void appendHoverText(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.appendHoverText(stack, world, list, flag);
        list.add(new StringTextComponent(TextFormatting.WHITE + "Cant sleep huh?"));
        list.add(new StringTextComponent(TextFormatting.GREEN + "Grants nightvision"));
    }
}




