package com.superworldsun.superslegend.registries;

import com.superworldsun.superslegend.SupersLegendMain;
import com.superworldsun.superslegend.entities.*;
import com.superworldsun.superslegend.entities.projectiles.arrows.*;
import com.superworldsun.superslegend.entities.projectiles.bombs.*;
import com.superworldsun.superslegend.entities.projectiles.boomerang.*;
import com.superworldsun.superslegend.entities.projectiles.hooks.*;
import com.superworldsun.superslegend.entities.projectiles.magic.*;
import com.superworldsun.superslegend.entities.projectiles.mastersword.MasterSwordSwordEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit
{
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, SupersLegendMain.MOD_ID);


	public static final RegistryObject<EntityType<PelletEntity>> PELLET = ENTITIES.register("pellet",
			() -> EntityType.Builder.<PelletEntity>of(PelletEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/pellet").toString()));
	
	public static final RegistryObject<EntityType<FireArrowEntity>> FIRE_ARROW = ENTITIES.register("fire_arrow",
			() -> EntityType.Builder.<FireArrowEntity>of(FireArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/arrows").toString()));
	
	public static final RegistryObject<EntityType<IceArrowEntity>> ICE_ARROW = ENTITIES.register("ice_arrow",
			() -> EntityType.Builder.<IceArrowEntity>of(IceArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/arrows").toString()));
	
	public static final RegistryObject<EntityType<ShockArrowEntity>> SHOCK_ARROW = ENTITIES.register("shock_arrow",
			() -> EntityType.Builder.<ShockArrowEntity>of(ShockArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/arrows").toString()));
	
	public static final RegistryObject<EntityType<BombArrowEntity>> BOMB_ARROW = ENTITIES.register("bomb_arrow",
			() -> EntityType.Builder.<BombArrowEntity>of(BombArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/arrows").toString()));
	
	public static final RegistryObject<EntityType<AncientArrowEntity>> ANCIENT_ARROW = ENTITIES.register("ancient_arrow",
			() -> EntityType.Builder.<AncientArrowEntity>of(AncientArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/arrows").toString()));
	
	public static final RegistryObject<EntityType<SilverArrowEntity>> SILVER_ARROW = ENTITIES.register("silver_arrow",
			() -> EntityType.Builder.<SilverArrowEntity>of(SilverArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/arrows").toString()));
	
	public static final RegistryObject<EntityType<IceBeamEntity>> ICE_BEAM = ENTITIES.register("ice_beam",
			() -> EntityType.Builder.<IceBeamEntity>of(IceBeamEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/arrows").toString()));
	
	public static final RegistryObject<EntityType<MagicFireArrowEntity>> MAGIC_FIRE_ARROW = ENTITIES.register("magic_fire_arrow",
			() -> EntityType.Builder.<MagicFireArrowEntity>of(MagicFireArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/arrows").toString()));
	
	public static final RegistryObject<EntityType<MagicIceArrowEntity>> MAGIC_ICE_ARROW = ENTITIES.register("magic_ice_arrow",
			() -> EntityType.Builder.<MagicIceArrowEntity>of(MagicIceArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/arrows").toString()));
	
	public static final RegistryObject<EntityType<MagicLightArrowEntity>> MAGIC_LIGHT_ARROW = ENTITIES.register("magic_light_arrow",
			() -> EntityType.Builder.<MagicLightArrowEntity>of(MagicLightArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/projectiles/arrows").toString()));

	public static final RegistryObject<EntityType<HookshotEntity>> HOOKSHOT_ENTITY = ENTITIES.register("hookshot",
			() -> EntityType.Builder.<HookshotEntity>of(HookshotEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/hookshot").toString()));

	public static final RegistryObject<EntityType<BoomerangEntity>> REGULAR_BOOMERANG = ENTITIES.register("boomerang",
			() -> EntityType.Builder.<BoomerangEntity>of(RegularBoomerang::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/boomerang").toString()));

	public static final RegistryObject<EntityType<MagicBoomerangEntity>> MAGIC_BOOMERANG = ENTITIES.register("magic_boomerang",
			() -> EntityType.Builder.<MagicBoomerangEntity>of(MagicBoomerang::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/magic_boomerang").toString()));

	public static final RegistryObject<EntityType<WWBoomerangEntity>> WW_BOOMERANG = ENTITIES.register("ww_boomerang",
			() -> EntityType.Builder.<WWBoomerangEntity>of(WWBoomerang::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/ww_boomerang").toString()));

	public static final RegistryObject<EntityType<GaleBoomerangEntity>> GALE_BOOMERANG = ENTITIES.register("gale_boomerang",
			() -> EntityType.Builder.<GaleBoomerangEntity>of(GaleBoomerang::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/gale_boomerang").toString()));

	public static final RegistryObject<EntityType<MasterSwordSwordEntity>> MASTERSWORD_SWORD_ENTITY = ENTITIES.register("mastersword_sword",
			() -> EntityType.Builder.<MasterSwordSwordEntity>of(MasterSwordSwordEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/mastersword").toString()));

	public static final RegistryObject<EntityType<LongshotEntity>> LONGSHOT_ENTITY = ENTITIES.register("longshot",
			() -> EntityType.Builder.<LongshotEntity>of(LongshotEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/hookshot").toString()));

	public static final RegistryObject<EntityType<ClawshotEntity>> CLAWSHOT_ENTITY = ENTITIES.register("clawshot",
			() -> EntityType.Builder.<ClawshotEntity>of(ClawshotEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/clawshot").toString()));

	public static final RegistryObject<EntityType<SpinnerEntity>> SPINNER = ENTITIES.register("spinner",
			() -> EntityType.Builder.<SpinnerEntity>of(SpinnerEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/spinner").toString()));

	public static final RegistryObject<EntityType<HeartEntity>> HEART = ENTITIES.register("heart",
			() -> EntityType.Builder.<HeartEntity>of(HeartEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/heart").toString()));

	public static final RegistryObject<EntityType<MagicJarEntity>> MAGIC_JAR = ENTITIES.register("magic_jar",
			() -> EntityType.Builder.<MagicJarEntity>of(MagicJarEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/magic_jar").toString()));

	public static final RegistryObject<EntityType<LargeMagicJarEntity>> LARGE_MAGIC_JAR = ENTITIES.register("large_magic_jar",
			() -> EntityType.Builder.<LargeMagicJarEntity>of(LargeMagicJarEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/large_magic_jar").toString()));

	public static final RegistryObject<EntityType<EntityBomb>> BOMB = ENTITIES.register("bomb",
			() -> EntityType.Builder.<EntityBomb>of(EntityBomb::new,
					EntityClassification.MISC).sized(0.25F, 0.25F).build("bomb"));
  
  public static final RegistryObject<EntityType<FaroresWindEntity>> FARORES_WIND = ENTITIES.register("farores_wind",
			() -> EntityType.Builder.<FaroresWindEntity>of(FaroresWindEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/farores_wind").toString()));
	
	public static final RegistryObject<EntityType<FireballEntity>> FIREBALL = ENTITIES.register("fireball", FireballEntity::createEntityType);
	public static final RegistryObject<EntityType<IceballEntity>> ICEBALL = ENTITIES.register("iceball", IceballEntity::createEntityType);

	//MOBS

	public static final RegistryObject<EntityType<TPBokoblinEntity>> TP_BOKOBLIN = ENTITIES.register("tp_bokoblin",
			() -> EntityType.Builder.<TPBokoblinEntity>of(TPBokoblinEntity::new, EntityClassification.MONSTER).sized(1.0F, 3.0F)
					.build(new ResourceLocation(SupersLegendMain.MOD_ID, "textures/entity/tp_bokoblin").toString()));

}
