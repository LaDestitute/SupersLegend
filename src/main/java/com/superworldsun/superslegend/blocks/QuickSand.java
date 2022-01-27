package com.superworldsun.superslegend.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class QuickSand extends FallingBlock {
    public QuickSand(Properties properties) {
        super(properties);
    }


    //TODO Entities dont take damage, when inside the block.
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.makeStuckInBlock(state, new Vector3d(0.75D, (double)0.10F, 0.75D));
        if(entityIn.isInWall())
        {
            entityIn.hurt(DamageSource.IN_WALL,4f);
        }
    }

}