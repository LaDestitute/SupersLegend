package com.superworldsun.superslegend.entities.projectiles.boomerang;

import com.superworldsun.superslegend.config.SupersLegendConfig;
import com.superworldsun.superslegend.registries.EntityTypeInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class GaleBoomerang extends GaleBoomerangEntity {

    public GaleBoomerang(EntityType<GaleBoomerangEntity> type, World world) {
        super(type, world);
        this.timeBeforeTurnAround = SupersLegendConfig.getInstance().GaleBoomerangRange.get() <= 0 ? 20 : SupersLegendConfig.getInstance().GaleBoomerangRange.get();
    }

    public GaleBoomerang(World worldIn, PlayerEntity entity, ItemStack itemstack, Hand hand) {
        super(EntityTypeInit.GALE_BOOMERANG.get(), worldIn, entity, itemstack, hand);
        this.timeBeforeTurnAround = SupersLegendConfig.getInstance().GaleBoomerangRange.get() <= 0 ? 20 : SupersLegendConfig.getInstance().GaleBoomerangRange.get();
    }

    @Override
    protected int getDamage(Entity hitEntity, PlayerEntity player) {
        if (SupersLegendConfig.getInstance().GaleBoomerangDamage.get() > 0) {
            return SupersLegendConfig.getInstance().GaleBoomerangDamage.get();
        }

        return 0;
    }

    @Override
    public DamageSource causeNewDamage(GaleBoomerangEntity entityboomerang, Entity entity) {
        return (new IndirectEntityDamageSource("boomerang", entityboomerang, entity)).setProjectile();
    }

    @Override
    public void beforeTurnAround(PlayerEntity player) {
        // Following is diamond boomerang only
        // Follows where the entity is looking
        if (!isBouncing && SupersLegendConfig.getInstance().GaleBoomerangFollows.get()) {
            double x = -MathHelper.sin((player.yRot * 3.141593F) / 180F);
            double z = MathHelper.cos((player.yRot * 3.141593F) / 180F);

            double motionX = 0.5D * x * (double) MathHelper.cos((player.xRot / 180F) * 3.141593F);
            double motionY = -0.5D * (double) MathHelper.sin((player.xRot / 180F) * 3.141593F);
            double motionZ = 0.5D * z * (double) MathHelper.cos((player.xRot / 180F) * 3.141593F);
            this.setDeltaMovement(motionX, motionY, motionZ);
        }
    }
}