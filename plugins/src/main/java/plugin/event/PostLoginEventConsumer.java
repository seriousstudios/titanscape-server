package plugin.event;

import io.titan.Configuration;
import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.world.entity.mob.Movement;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerOption;
import io.titan.game.world.entity.mob.player.Players;
import io.titan.game.world.entity.mob.player.event.PostLoginEvent;
import io.titan.net.packet.out.ResetCameraPositionPacket;
import io.titan.net.packet.out.ServerMessagePacket;
import io.titan.net.packet.out.SetPlayerOptionPacket;
import io.titan.net.packet.out.SetPlayerSlotPacket;
import io.titan.net.packet.out.SetPrivacyOptionPacket;
import io.titan.net.packet.out.SetRunEnergyPacket;
import io.titan.net.packet.out.SetSpecialAmountPacket;
import io.titan.net.packet.out.SetWidgetConfigPacket;

@SubscribesTo(PostLoginEvent.class)
public final class PostLoginEventConsumer implements EventSubscriber<PostLoginEvent> {

	@Override
	public void subscribe(EventContext context, Player player, PostLoginEvent event) {
		event.getPlayer().queuePacket(new SetPlayerSlotPacket());
		event.getPlayer().queuePacket(new ResetCameraPositionPacket());
		event.getPlayer().queuePacket(new SetPrivacyOptionPacket(0, 0, 0));
		event.getPlayer().queuePacket(new SetSpecialAmountPacket());
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(172, event.getPlayer().attr().get(Player.AUTO_RETALIATE_KEY) ? 1 : 0));
		event.getPlayer().queuePacket(new SetPlayerOptionPacket(PlayerOption.FOLLOW));
		event.getPlayer().queuePacket(new SetPlayerOptionPacket(PlayerOption.TRADE_REQUEST));
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(152, event.getPlayer().attr().get(Movement.RUNNING_KEY) ? 1 : 0));
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(429, event.getPlayer().attr().get(Movement.RUNNING_KEY) ? 1 : 0));
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(171, event.getPlayer().attr().get(Player.MOUSE_BUTTON_KEY) ? 1 : 0));
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(172, event.getPlayer().attr().get(Player.CHAT_EFFECTS_KEY) ? 1 : 0));
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(287, event.getPlayer().attr().get(Player.SPLIT_CHAT_KEY) ? 1 : 0));
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(427, event.getPlayer().attr().get(Player.ACCEPT_AID_KEY) ? 1 : 0));
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(166, event.getPlayer().attr().get(Player.BRIGHTNESS_KEY).getCode()));
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(168, event.getPlayer().attr().get(Player.MUSIC_VOLUME_KEY).getCode()));
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(169, event.getPlayer().attr().get(Player.SOUND_EFFECT_VOLUME_KEY).getCode()));
		event.getPlayer().queuePacket(new SetWidgetConfigPacket(170, event.getPlayer().attr().get(Player.AREA_SOUND_VOLUME_KEY).getCode()));
		Players.createSideBarInterfaces(event.getPlayer(), true);
		event.getPlayer().getSkills().calculateLevels();
		event.getPlayer().getSkills().refresh();
		event.getPlayer().getInventory().refresh();
		event.getPlayer().getEquipment().refresh();
		event.getPlayer().getBank().refresh();
		event.getPlayer().getPlayerRelation().updateLists(true);
		event.getPlayer().getPlayerRelation().sendFriends();
		event.getPlayer().queuePacket(new SetRunEnergyPacket());
		event.getPlayer().getPlayerRelation().updateLists(true);
		Players.resetPlayerAnimation(event.getPlayer());
		event.getPlayer().attr().put(Player.SAVE_KEY, true);
		
		event.getPlayer().queuePacket(new ServerMessagePacket(String.format("Welcome to %s.", Configuration.SERVER_NAME)));		
	}

}
