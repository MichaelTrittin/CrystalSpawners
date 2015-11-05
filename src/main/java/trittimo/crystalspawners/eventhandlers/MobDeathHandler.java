package trittimo.crystalspawners.eventhandlers;

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
import trittimo.crystalspawners.playerhooks.MobKillCounter;
import trittimo.crystalspawners.util.Reference;

public class MobDeathHandler {
	
	@SubscribeEvent
	public void onPlayerKill(LivingDeathEvent event) {
		if (!(event.entity instanceof EntityPlayer)) {
			Entity source = event.source.getEntity();
			if (source instanceof EntityPlayer) {
				MobKillCounter handler = (MobKillCounter) ((EntityPlayer) source).getExtendedProperties(
						Reference.PlayerHook.KILL_COUNTER_PROP_NAME);
				handler.addEntityKill(event.entity);
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityConstructed(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer && !MobKillCounter.hasAttachedHandler((EntityPlayer) event.entity)) {
			MobKillCounter.register((EntityPlayer) event.entity);
		}
	}
}