package com.DragonFire.render;

import com.DragonFire.DragonFire;
import com.DragonFire.block.DFBlocks;
import com.DragonFire.entity.living.EntityDraug;
import com.DragonFire.entity.living.EntityMummy;
import com.DragonFire.entity.projectile.EntityDynamite;
import com.DragonFire.entity.projectile.EntityEnderArrow;
import com.DragonFire.entity.projectile.EntityExplosiveArrow;
import com.DragonFire.entity.projectile.EntityTikiSpear;
import com.DragonFire.item.DFItems;
import com.DragonFire.item.drink.QuickDrink;
import com.DragonFire.item.tool.Dynamite;
import com.DragonFire.render.entity.*;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public final class DFRendering {
    public static void items() {
        //Armor
        reg(
            DFItems.RABBIT_BOOTS,
            DFItems.EMERALD_HELMET, DFItems.EMERALD_CHESTPLATE, DFItems.EMERALD_LEGGINGS, DFItems.EMERALD_BOOTS,
            DFItems.COPPER_HELMET, DFItems.COPPER_CHESTPLATE, DFItems.COPPER_LEGGINGS, DFItems.COPPER_BOOTS,
            DFItems.DYABLE_BACKPACK
        );
        
        //Tools and Weapons
        reg(
            DFItems.ENDER_BOW, DFItems.ENDER_ARROW,
            DFItems.NETHER_ROD, DFItems.VILLAGER_HOE,
            DFItems.EMERALD_SWORD, DFItems.EMERALD_AXE, DFItems.EMERALD_PICKAXE, DFItems.EMERALD_SHOVEL, DFItems.EMERALD_HOE,
            DFItems.COPPER_SWORD, DFItems.COPPER_AXE, DFItems.COPPER_PICKAXE, DFItems.COPPER_SHOVEL, DFItems.COPPER_HOE,
            DFItems.OCEANIC_SHOVEL, DFItems.DYNAMITE, DFItems.NUCLEAR_DYNAMITE, DFItems.EXPLOSIVE_ARROW,
            DFItems.MUSHROOM_PICKAXE, DFItems.GLASS_DAGGER, DFItems.PHILOSOPHERS_SWORD, DFItems.TREE_AXE
        );
        
        //Food
        reg(
            DFItems.POTION_COOKIE, DFItems.DIAMOND_APPLE,
            DFItems.RAW_CALAMARI, DFItems.RAW_BACON,
            DFItems.FRIED_EGG, DFItems.COOKED_CALAMARI, DFItems.COOKED_BACON, 
            DFItems.PINEAPPLE_SLICE, DFItems.CHOCOLATE_BAR, DFItems.CHEESE, DFItems.SLIME_JELLY, DFItems.SANDWICH, DFItems.SUGAR_COOKIE,
            DFItems.APPLE_PIE, DFItems.SEA_WEED, DFItems.DRIED_SEA_WEED
        );
        
        //Drinks
        reg(DFItems.BEER, DFItems.SPOILED_MILK);
        
        //Mob Drops
        reg(DFItems.BAT_WING, DFItems.MUMMY_RAG, DFItems.WITHERED_BONE);
        
        //Nuggets, Ingots, Gems, etc...
        reg(DFItems.COPPER_NUGGET, DFItems.COPPER_INGOT);
        
        //Other
        reg(DFItems.RADIOACTIVE_MUSHROOM);
    }
    
    public static void specialItems() {
        reg(DFItems.GLASS_FRAGMENT, 0, "glass_fragment/black");
        reg(DFItems.GLASS_FRAGMENT, 1, "glass_fragment/red");
        reg(DFItems.GLASS_FRAGMENT, 2, "glass_fragment/green");
        reg(DFItems.GLASS_FRAGMENT, 3, "glass_fragment/brown");
        reg(DFItems.GLASS_FRAGMENT, 4, "glass_fragment/blue");
        reg(DFItems.GLASS_FRAGMENT, 5, "glass_fragment/purple");
        reg(DFItems.GLASS_FRAGMENT, 6, "glass_fragment/cyan");
        reg(DFItems.GLASS_FRAGMENT, 7, "glass_fragment/silver");
        reg(DFItems.GLASS_FRAGMENT, 8, "glass_fragment/gray");
        reg(DFItems.GLASS_FRAGMENT, 9, "glass_fragment/pink");
        reg(DFItems.GLASS_FRAGMENT, 10, "glass_fragment/lime");
        reg(DFItems.GLASS_FRAGMENT, 11, "glass_fragment/yellow");
        reg(DFItems.GLASS_FRAGMENT, 12, "glass_fragment/light_blue");
        reg(DFItems.GLASS_FRAGMENT, 13, "glass_fragment/magenta");
        reg(DFItems.GLASS_FRAGMENT, 14, "glass_fragment/orange");
        reg(DFItems.GLASS_FRAGMENT, 15, "glass_fragment/white");
        reg(DFItems.GLASS_FRAGMENT, 16, "glass_fragment/obsidian");
        reg(DFItems.GLASS_FRAGMENT, 17, "glass_fragment/clear");
    }
    
    public static void blocks() {
        reg(
            DFBlocks.MUMMY_HEAD, 
            DFBlocks.CHOCOLATE_CAKE, DFBlocks.PIZZA, 
            DFBlocks.PLAYER_PLATE, DFBlocks.NUCLEAR_TNT,
            DFBlocks.NETHER_BRICK_FURNACE,
            DFBlocks.COPPER_ORE, DFBlocks.COPPER_BLOCK, DFBlocks.NETHER_GOLD_ORE, DFBlocks.CHARCOAL_BLOCK,
            DFBlocks.ENDER_PEARL_BLOCK, DFBlocks.OBSIDIAN_GLASS
        );
    }
    
    public static void entities() {
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderArrow.class, RenderEnderArrow::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTikiSpear.class, RenderTikiSpear::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, RenderMummy::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, RenderDynamite::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveArrow.class, RenderExplosiveArrow::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDraug.class, RenderDraug::new);
    }
    
    private static void reg(Block... bb) {
        Item[] ii = new Item[bb.length];
        for(int i = 0; i < bb.length; i++) {
            Block b = bb[i];
            Item ib = Item.getItemFromBlock(b);
            ii[i] = ib;
        } reg(ii);
    }
    
    private static void reg(Item... ii) {
        for(Item i : ii) {
            ResourceLocation rl = i.getRegistryName();
            String path = rl.getResourcePath();
            
            if(i instanceof ItemBlock) path = "block/" + path;
            else if(i instanceof ItemArmor) path = "armor/" + path;
            else if(isTool(i)) path = "tool/" + path;
            else if(isFood(i)) path = "food/" + path;
            
            reg(i, 0, path);
        }
    }
    
    private static void reg(Item i, int meta, String name) {
        ResourceLocation rl = new ResourceLocation(DragonFire.MODID, name);
        ModelResourceLocation mrl = new ModelResourceLocation(rl, "inventory");
        ModelLoader.setCustomModelResourceLocation(i, meta, mrl);
    }
    
    private static boolean isTool(Item i) {
        if(i == null || i == Items.AIR) return false;
        else if(i instanceof ItemTool) return true;
        else if(i instanceof ItemHoe) return true;
        else if(i instanceof ItemSword) return true;
        else if(i instanceof ItemBow) return true;
        else if(i instanceof ItemFishingRod) return true;
        else if(i instanceof Dynamite) return true;
        else return false;
    }
    
    private static boolean isFood(Item i) {
        if(i == null || i == Items.AIR) return false;
        else if(i instanceof ItemFood) return true;
        else if(i instanceof QuickDrink) return true;
        else return false;
    }
}