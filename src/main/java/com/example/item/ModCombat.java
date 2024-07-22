package com.example.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.example.ExampleMod.MOD_ID;
import static com.mojang.text2speech.Narrator.LOGGER;
import static net.minecraft.item.ItemGroups.COMBAT;

public class ModCombat {
    private static final Item FIRE_CHESTPLATE = registerItem(
            "fire_chestplate",
            new ArmorItem(
                    ArmorMaterials.NETHERITE,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
                            .fireproof()
                            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50)))
    );

    private static final Item FIRE_SWORD = registerItem(
            "fire_sword",
            new SwordItem(
                    ToolMaterials.NETHERITE,
                    new Item.Settings()
                            .fireproof()
                            .attributeModifiers(
                                    SwordItem.createAttributeModifiers(
                                            ToolMaterials.NETHERITE, 99, 99F))
            )
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    public static void registerModItems() {
        LOGGER.info("Registering ModCombats for: " + MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(COMBAT).register(ModCombat::addItemsToGroup);
    }

    static void addItemsToGroup(FabricItemGroupEntries entries) {
        entries.add(FIRE_CHESTPLATE);
        entries.add(FIRE_SWORD);
    }

//    private static final Item DRAGON_HEAD = Items.register(
//            new VerticallyAttachableBlockItem(
//                    Blocks.DRAGON_HEAD,
//                    Blocks.DRAGON_WALL_HEAD,
//                    new Item.Settings().rarity(Rarity.UNCOMMON), Direction.DOWN)
//    );
//
//    public static final Item ENCHANTED_GOLDEN_APPLE = Items.register(
//            "enchanted_golden_apple",
//            new Item(
//                    new Item.Settings().rarity(Rarity.EPIC)
//                            .food(FoodComponents.ENCHANTED_GOLDEN_APPLE)
//                            .component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true))
//    );
//
//    public static final Item MACE = Items.register(
//            "mace",
//            new MaceItem(
//                    new Item.Settings()
//                            .rarity(Rarity.EPIC)
//                            .maxDamage(500)
//                            .component(DataComponentTypes.TOOL, MaceItem.createToolComponent())
//                            .attributeModifiers(MaceItem.createAttributeModifiers())
//            )
//    );
//    public static final Item SHIELD = Items.register(
//            "shield", new ShieldItem(new Item.Settings().maxDamage(336).component(DataComponentTypes.BANNER_PATTERNS, BannerPatternsComponent.DEFAULT))
//    );
}
