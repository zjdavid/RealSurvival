package com.outlook.schooluniformsama.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import com.outlook.schooluniformsama.data.Data;
import com.outlook.schooluniformsama.data.player.PlayerData;
import com.outlook.schooluniformsama.util.Msg;

public class SleepEvent implements Listener{
	
	@EventHandler
	public void Sleep(PlayerBedEnterEvent e){
		if(!Data.playerData.containsKey(e.getPlayer().getUniqueId()))return;
		PlayerData pd = Data.playerData.get(e.getPlayer().getUniqueId());
		pd.getSleep().setHasSleep(true,e.getBed().getLocation());
		Msg.sendMsgToPlayer(e.getPlayer(), "Sleeping", true);
		return;
	}
	
	@EventHandler
	public void leaveSleep(PlayerBedLeaveEvent e){
		if(!Data.playerData.containsKey(e.getPlayer().getUniqueId()))return;
		PlayerData pd = Data.playerData.get(e.getPlayer().getUniqueId());
		pd.getSleep().setHasSleep(false,null);
		return;
	}
}
