package com.example.tuffspawner;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;

public class TuffSpawnerClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
			if (!stack.is(Items.TUFF)) {
				return;
			}

			Component spawner = Component.literal("Spawner").withStyle(ChatFormatting.LIGHT_PURPLE);
			Component skeleton = Component.literal("Skeleton").withStyle(ChatFormatting.YELLOW);
			Component blank = Component.literal(" ");
			Component interact = Component.literal("Interact with Spawn Egg:").withStyle(ChatFormatting.GRAY);
			Component sets = Component.literal(" Sets Mob Type").withStyle(ChatFormatting.BLUE);

			// Line 0 is the item name. Replace it, then insert the rest right below it
			// so any extra lines (like F3+H item id info) stay at the bottom.
			if (lines.isEmpty()) {
				lines.add(spawner);
			} else {
				lines.set(0, spawner);
			}
			lines.add(1, skeleton);
			lines.add(2, blank);
			lines.add(3, interact);
			lines.add(4, sets);
		});
	}
}
