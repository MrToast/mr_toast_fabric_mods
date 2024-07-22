package com.example;

import com.example.item.ModCombat;
import com.example.item.ModIngredients;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "mr_toast_mods";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModIngredients.registerModItems();
		ModCombat.registerModItems();
	}
}