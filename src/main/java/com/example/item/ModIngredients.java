package com.example.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static com.example.ExampleMod.MOD_ID;
import static com.mojang.text2speech.Narrator.LOGGER;
import static net.minecraft.item.ItemGroups.INGREDIENTS;

public class ModIngredients {
    private static final Item JOSHY = registerItem(
            "joshy",
            new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    public static void registerModItems() {
        LOGGER.info("Registering ModIngredients for: " + MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(INGREDIENTS).register(ModIngredients::addItemsToGroup);
    }

    static void addItemsToGroup(FabricItemGroupEntries entries) {
        entries.add(JOSHY);
    }
}
