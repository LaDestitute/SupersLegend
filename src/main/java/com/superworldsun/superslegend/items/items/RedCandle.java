package com.superworldsun.superslegend.items.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

public class RedCandle extends Item {
   public RedCandle(Properties builder) {
      super(builder);
   }

   /**
    * Called when this item is used when targeting a Block
    */

   @Nonnull
   public ActionResultType useOn(ItemUseContext context) {
       PlayerEntity playerentity = context.getPlayer();
       World world = context.getLevel();
       BlockPos blockpos = context.getClickedPos();
       BlockState blockstate = world.getBlockState(blockpos);
       if (CampfireBlock.canLight(blockstate) && Objects.requireNonNull(playerentity).getFoodData().getFoodLevel()>= 1) {
           world.playSound(playerentity, blockpos, SoundEvents.FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
           world.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.TRUE), 11);
           context.getItemInHand().hurtAndBreak(1, playerentity, (p_219999_1_) -> p_219999_1_.broadcastBreakEvent(context.getHand()));

           return ActionResultType.sidedSuccess(world.isClientSide());
       } else {
           //noinspection SpellCheckingInspection
           BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
           if (AbstractFireBlock.canBePlacedAt(world, blockpos1, context.getHorizontalDirection() ) && Objects.requireNonNull(playerentity).getFoodData().getFoodLevel()>= 1) {
               world.playSound(playerentity, blockpos1, SoundEvents.FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
               //noinspection SpellCheckingInspection
               BlockState blockstate1 = AbstractFireBlock.getState(world, blockpos1);
               playerentity.getCooldowns().addCooldown(this, 11);
               world.setBlock(blockpos1, blockstate1, 11);
               ItemStack itemstack = context.getItemInHand();
               if (playerentity instanceof ServerPlayerEntity) {
                   CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerentity, blockpos1, itemstack);
                   itemstack.hurtAndBreak(1, playerentity, (p_219998_1_) -> p_219998_1_.broadcastBreakEvent(context.getHand()));
               }

               return ActionResultType.sidedSuccess(world.isClientSide());
           } else {
               return ActionResultType.FAIL;
           }
       }
   }

   /**
    * Checks the passed block state for a campfire block, if it is not waterlogged and not lit.
    */
   @SuppressWarnings("unused")
   public static boolean isUnlitCampfire(BlockState state) {
      return state.getBlock() == Blocks.CAMPFIRE && !state.getValue(BlockStateProperties.WATERLOGGED) && !state.getValue(BlockStateProperties.LIT);
   }

	public void appendHoverText(@Nonnull ItemStack stack, World world,@Nonnull List<ITextComponent> list,@Nonnull ITooltipFlag flag)
	{
		super.appendHoverText(stack, world, list, flag);
		list.add(new StringTextComponent(TextFormatting.RED + "You can start a fire"));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Right-click to use"));
	}
}