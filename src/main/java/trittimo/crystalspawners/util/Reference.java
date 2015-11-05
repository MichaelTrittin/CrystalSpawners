package trittimo.crystalspawners.util;

import net.minecraft.init.Items;

public class Reference {
	public static final String MODID = "crystalspawners";
	public static final String MODNAME = "Crystal Spawners";
	
	public static final class Proxy {
		public static final String CLIENT_SIDE = "trittimo.crystalspawners.proxies.ClientProxy";
		public static final String SERVER_SIDE = "trittimo.crystalspawners.proxies.CommonProxy";
	}
	
	public static class Recipe {
		public static ItemEntityPair recipes[] = {
			new ItemEntityPair(Items.ender_pearl.getUnlocalizedName(), "Enderman"),
			new ItemEntityPair(Items.string.getUnlocalizedName(), "Spider"),
			new ItemEntityPair(Items.blaze_rod.getUnlocalizedName(), "Blaze")
			// TODO Add more entities
		};
		
		public static class ItemEntityPair {
			public String itemName;
			public String entityName;
			
			public ItemEntityPair(String itemName, String entityName) {
				this.itemName = itemName;
				this.entityName = entityName;
			}
		}
	}
	
	public static final class PlayerHook {
		public static final String KILL_COUNTER_PROP_NAME = "MobKillCounter";
	}
}