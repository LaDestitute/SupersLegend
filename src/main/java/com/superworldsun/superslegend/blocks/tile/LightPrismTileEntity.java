package com.superworldsun.superslegend.blocks.tile;

import com.superworldsun.superslegend.blocks.LightPrismBlock;
import com.superworldsun.superslegend.light.AbstractLightEmitter;
import com.superworldsun.superslegend.light.BlockLightEmitter;
import com.superworldsun.superslegend.light.ILightReceiver;
import com.superworldsun.superslegend.registries.BlockInit;
import com.superworldsun.superslegend.registries.TileEntityInit;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntityType.Builder;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;

public class LightPrismTileEntity extends TileEntity implements ITickableTileEntity, ILightReceiver
{
	public final AbstractLightEmitter lightEmitter = new BlockLightEmitter(this::getLevel, this::getLightDirecion, this::getBlockPos);
	private float rotation;
	public float targetRotation;
	private boolean isLit;
	
	public LightPrismTileEntity()
	{
		super(TileEntityInit.LIGHT_PRISM.get());
	}
	
	@Override
	public void tick()
	{
		if (rotation < targetRotation)
		{
			rotation += Math.PI / 45;
			
			if (rotation > targetRotation)
			{
				rotation = targetRotation;
			}
		}
		
		if (rotation > Math.PI * 2)
		{
			rotation -= Math.PI * 2;
			targetRotation -= Math.PI * 2;
		}
		
		lightEmitter.tick();
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox()
	{
		return INFINITE_EXTENT_AABB;
	}
	
	@Override
	public void receiveLight()
	{
		isLit = true;
		level.setBlockAndUpdate(worldPosition, level.getBlockState(worldPosition).setValue(LightPrismBlock.LIT, true));
	}
	
	@Override
	public void stopReceivingLight()
	{
		isLit = false;
		
		if (lightEmitter.litObject instanceof ILightReceiver)
		{
			((ILightReceiver) lightEmitter.litObject).stopReceivingLight();
		}
		
		if (level.getBlockState(worldPosition).getBlock() instanceof LightPrismBlock)
		{
			level.setBlockAndUpdate(worldPosition, level.getBlockState(worldPosition).setValue(LightPrismBlock.LIT, false));
		}
	}
	
	@Override
	public boolean isLit()
	{
		return isLit;
	}
	
	@Override
	public CompoundNBT save(CompoundNBT compound)
	{
		compound.putFloat("targetRotation", targetRotation);
		compound.putFloat("rotation", rotation);
		return super.save(compound);
	}
	
	@Override
	public void load(BlockState state, CompoundNBT compound)
	{
		targetRotation = compound.getFloat("targetRotation");
		rotation = compound.getFloat("rotation");
		super.load(state, compound);
	}
	
	@Override
	public SUpdateTileEntityPacket getUpdatePacket()
	{
		return new SUpdateTileEntityPacket(worldPosition, 0, getUpdateTag());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet)
	{
		load(level.getBlockState(packet.getPos()), packet.getTag());
	}
	
	@Override
	public CompoundNBT getUpdateTag()
	{
		return save(new CompoundNBT());
	}
	
	private Vector3d getLightDirecion()
	{
		if (level.getBlockState(worldPosition).getValue(LightPrismBlock.LIT))
		{
			return new Vector3d(0, 0, 1).yRot(rotation);
		}
		else
		{
			return Vector3d.ZERO;
		}
	}
	
	public static TileEntityType<LightPrismTileEntity> createType()
	{
		return Builder.of(LightPrismTileEntity::new, BlockInit.LIGHT_PRISM.get()).build(null);
	}
}
