package com.superworldsun.superslegend.items;

import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.songs.LearnedSongsProvider;
import com.superworldsun.superslegend.songs.OcarinaSong;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SongSheet extends Item
{
	private final Supplier<OcarinaSong> songSupplier;
	
	public SongSheet(Supplier<OcarinaSong> songSupplier)
	{
		super(new Item.Properties().tab(SupersLegendMain.RESOURCES).stacksTo(1));
		this.songSupplier = songSupplier;
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand)
	{
		Set<OcarinaSong> learnedSongs = LearnedSongsProvider.get(playerEntity).getLearnedSongs();
		
		if (!world.isClientSide)
		{
			if (!learnedSongs.contains(songSupplier.get()))
			{				
				learnedSongs.add(songSupplier.get());
				LearnedSongsProvider.sync((ServerPlayerEntity) playerEntity);
				playerEntity.sendMessage(new TranslationTextComponent("item.superslegend.song_sheet.learned", songSupplier.get().getLocalizedName()), UUID.randomUUID());
				return ActionResult.success(playerEntity.getItemInHand(hand));
			}
			else
			{
				playerEntity.sendMessage(new TranslationTextComponent("item.superslegend.song_sheet.already_know"), UUID.randomUUID());
			}
		}
		
		return ActionResult.fail(playerEntity.getItemInHand(hand));
	}
}
