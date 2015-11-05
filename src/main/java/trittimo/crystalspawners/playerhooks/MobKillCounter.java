package trittimo.crystalspawners.playerhooks;

import java.util.HashMap;

import com.sun.media.jfxmedia.events.PlayerEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import trittimo.crystalspawners.util.Reference;

public class MobKillCounter implements IExtendedEntityProperties {
	
	private EntityPlayer player;
	private HashMap<String, Integer> killCount = new HashMap<String, Integer>();
	
	public MobKillCounter(EntityPlayer player) {
		this.player = player;
	}
	
	public static boolean hasAttachedHandler(EntityPlayer player) {
		return player.getExtendedProperties(Reference.PlayerHook.KILL_COUNTER_PROP_NAME) != null;
	}
	
	public static void register(EntityPlayer player) {
		System.out.println("Registering " + player);
		player.registerExtendedProperties(Reference.PlayerHook.KILL_COUNTER_PROP_NAME, new MobKillCounter(player));
	}
	
	public void addEntityKill(Entity entity) {
		String entityName = EntityList.getEntityString(entity);
		Integer count;
		if (this.killCount.containsKey(entityName)) {
			count = this.killCount.get(entityName) + 1;
		} else {
			count = 1;
		}
		
		System.out.println("Kill of type " + entityName + " added with count " + count);
		
		this.killCount.put(entityName, count);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagList tagList = new NBTTagList();
		for (String key : killCount.keySet()) {
			Integer count = killCount.get(key);
			NBTTagCompound counter = new NBTTagCompound();
			counter.setInteger("Count", count);
			counter.setString("MobName", key);
			tagList.appendTag(counter);
		}
		compound.setTag("MobDeathCounter", tagList);
		
	}
	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagList tagList = compound.getTagList("MobDeathCounter", compound.getId());
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound item = tagList.getCompoundTagAt(i);
			this.killCount.put(item.getString("Mobname"), item.getInteger("Count"));
		}
		
	}
	
	@Override
	public void init(Entity entity, World world) {}
}