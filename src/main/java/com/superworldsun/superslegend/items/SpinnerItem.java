package com.superworldsun.superslegend.items;

import com.superworldsun.superslegend.entities.SpinnerEntity;
import com.superworldsun.superslegend.registries.EntityTypeInit;
import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.RailShape;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpinnerItem extends Item
{
    public SpinnerItem(Properties tab) {
        super(new Item.Properties());
        DispenserBlock.registerBehavior(this, DISPENSER_BEHAVIOR);
    }

    public ActionResultType useOn(ItemUseContext context) {

        World world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);

        if (!blockstate.is(BlockTags.RAILS)) {
            return ActionResultType.FAIL;
        }
        ItemStack stack = context.getItemInHand();
        if (!world.isClientSide()) {
            RailShape railshape = blockstate.getBlock() instanceof AbstractRailBlock ? ((AbstractRailBlock) blockstate.getBlock()).getRailDirection(blockstate, world, blockpos, null) : RailShape.NORTH_SOUTH;
            double d0 = 0.0D;
            if (railshape.isAscending()) {
                d0 = 0.5D;
            }
            createMinecart(stack, world, (double) blockpos.getX() + 0.5D, (double) blockpos.getY() + 0.0625D + d0, (double) blockpos.getZ() + 0.5D);
        }
        stack.shrink(1);
        return ActionResultType.SUCCESS;
    }

    void createMinecart(ItemStack stack, World world, double posX, double posY, double posZ) {

        SpinnerEntity minecart = new SpinnerEntity(world, posX, posY, posZ);
        if (stack.hasCustomHoverName()) {
            minecart.setCustomName(stack.getDisplayName());
        }
        world.addFreshEntity(minecart);
    }

    // Old body of CreateMinecart:
    //AbstractMinecartEntity minecart = factory.createMinecart(world, posX, posY, posZ);
    //if (stack.hasDisplayName()) {
    //    minecart.setCustomName(stack.getDisplayName());
    //}
    //world.addEntity(minecart)

    private static final IDispenseItemBehavior DISPENSER_BEHAVIOR = new DefaultDispenseItemBehavior() {

        private final DefaultDispenseItemBehavior behaviourDefaultDispenseItem = new DefaultDispenseItemBehavior();

        /**
         * Dispense the specified stack, play the dispense sound and spawn particles.
         */
        public ItemStack execute(IBlockSource source, ItemStack stack) {

            Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
            World world = source.getLevel();

            double d0 = source.getPos().getX() + (double) direction.getStepX() * 1.125D;
            double d1 = Math.floor(source.getPos().getY()) + (double) direction.getStepY();
            double d2 = source.getPos().getZ() + (double) direction.getStepZ() * 1.125D;

            BlockPos blockpos = source.getPos().offset(direction.getStepX(), direction.getStepY(), direction.getStepZ());
            BlockState blockstate = world.getBlockState(blockpos);
            RailShape railshape = blockstate.getBlock() instanceof AbstractRailBlock ? ((AbstractRailBlock) blockstate.getBlock()).getRailDirection(blockstate, world, blockpos, null) : RailShape.NORTH_SOUTH;
            double d3;
            if (blockstate.is(BlockTags.RAILS)) {
                if (railshape.isAscending()) {
                    d3 = 0.6D;
                } else {
                    d3 = 0.1D;
                }
            } else {
                if (!blockstate.isAir(world, blockpos) || !world.getBlockState(blockpos.below()).is(BlockTags.RAILS)) {
                    return this.behaviourDefaultDispenseItem.dispense(source, stack);
                }
                BlockState state = world.getBlockState(blockpos.below());
                RailShape shape = state.getBlock() instanceof AbstractRailBlock ? ((AbstractRailBlock) state.getBlock()).getRailDirection(state, world, blockpos.below(), null) : RailShape.NORTH_SOUTH;
                if (direction != Direction.DOWN && shape.isAscending()) {
                    d3 = -0.4D;
                } else {
                    d3 = -0.9D;
                }
            }
            if (stack.getItem() instanceof SpinnerItem) {
                ((SpinnerItem) stack.getItem()).createMinecart(stack, world, d0, d1 + d3, d2);
                stack.shrink(1);
            }
            return stack;
        }
    };

}
