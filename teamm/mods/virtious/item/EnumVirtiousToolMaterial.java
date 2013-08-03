package teamm.mods.virtious.item;

import teamm.mods.virtious.lib.VirtiousBlocks;
import teamm.mods.virtious.lib.VirtiousItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum EnumVirtiousToolMaterial
{
    VIRTIANWOOD(0, 90, 2.0F, 0.0F, 15),
    AMBERWOOD(0, 40, 2.5F, 0.5F, 15),
    VIRTIANSTONE(1, 115, 4.5F, 1.5F, 9),
    DEEPSTONE(1, 180, 4.6F, 2.0F, 16),
    BRAZEUM(2, 750, 7.0F, 2.0F, 14),
    AQUIEUS(3, 1200, 7.4F, 2.5F, 20),
    PLUTHORIUM(4, 2341, 12.0F, 4.5F, 7);

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    private final int harvestLevel;

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    private final int maxUses;

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    private final float efficiencyOnProperMaterial;

    /** Damage versus entities. */
    private final float damageVsEntity;

    /** Defines the natural enchantability factor of the material. */
    private final int enchantability;

    //Added by forge for custom Armor materials.
    public Item customCraftingMaterial = null;

    private EnumVirtiousToolMaterial(int par3, int par4, float par5, float par6, int par7)
    {
        this.harvestLevel = par3;
        this.maxUses = par4;
        this.efficiencyOnProperMaterial = par5;
        this.damageVsEntity = par6;
        this.enchantability = par7;
    }

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    public int getMaxUses()
    {
        return this.maxUses;
    }

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    public float getEfficiencyOnProperMaterial()
    {
        return this.efficiencyOnProperMaterial;
    }

    /**
     * Damage versus entities.
     */
    public float getDamageVsEntity()
    {
        return this.damageVsEntity;
    }

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    public int getHarvestLevel()
    {
        return this.harvestLevel;
    }

    /**
     * Return the natural enchantability factor of the material.
     */
    public int getEnchantability()
    {
        return this.enchantability;
    }

    /**
     * Return the crafting material for this tool material, used to determine the item that can be used to repair a tool
     * with an anvil
     */
    public int getToolCraftingMaterial()
    {
        switch (this)
        {
            case VIRTIANWOOD:    return Block.planks.blockID;
            case AMBERWOOD:   return Block.planks.blockID;
            case VIRTIANSTONE:    return VirtiousBlocks.virtiancobblestone.blockID;
            case BRAZEUM:    return VirtiousItems.ingotBrazeum.itemID;
            case AQUIEUS: return VirtiousItems.shardAquieus.itemID;
            case PLUTHORIUM: return VirtiousItems.gemPluthorium.itemID;
            default:      return 0;
        }
    }
}
