package com.superworldsun.superslegend.items.curios.head.masks;

import net.minecraft.item.Item;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class MaskMoonmask extends Item implements ICurioItem {

    public MaskMoonmask(Properties properties) {
        super(properties);
    }
    /*private boolean isLeggings = false;

    public MaskMoonmask(IArmorMaterial material, EquipmentSlotType slot, int type) {
        super(material, slot, (new Item.Properties().tab(SupersLegendMain.RESOURCES)));
        if (type == 2) {
            isLeggings = true;
        }
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return (!isLeggings ? SupersLegendMain.MOD_ID + ":textures/armor/moonmask_layer_1.png" : SupersLegendMain.MOD_ID + ":textures/armor/moonmask_layer_1.png");
    }*/
}