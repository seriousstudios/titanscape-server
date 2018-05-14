package plugin.buttons;

import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ButtonActionEvent;
import io.titan.game.sound.Volume;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.packet.out.SetWidgetConfigPacket;

@SubscribesTo(ButtonActionEvent.class)
public final class AreaSoundVolumeButton extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()) {
		case 19150:
            player.attr().put(Player.AREA_SOUND_VOLUME_KEY, Volume.SILENT);
            player.queuePacket(new SetWidgetConfigPacket(170, player.attr().get(Player.AREA_SOUND_VOLUME_KEY).getCode()));
			break;
			
		case 19151:
            player.attr().put(Player.AREA_SOUND_VOLUME_KEY, Volume.QUIET);
            player.queuePacket(new SetWidgetConfigPacket(170, player.attr().get(Player.AREA_SOUND_VOLUME_KEY).getCode()));
			break;
			
		case 19152:
            player.attr().put(Player.AREA_SOUND_VOLUME_KEY, Volume.NORMAL);
            player.queuePacket(new SetWidgetConfigPacket(170, player.attr().get(Player.AREA_SOUND_VOLUME_KEY).getCode()));
			break;
			
		case 19153:
            player.attr().put(Player.AREA_SOUND_VOLUME_KEY, Volume.HIGH);
            player.queuePacket(new SetWidgetConfigPacket(170, player.attr().get(Player.AREA_SOUND_VOLUME_KEY).getCode()));
			break;
			
		case 19154:
            player.attr().put(Player.AREA_SOUND_VOLUME_KEY, Volume.LOUD);
            player.queuePacket(new SetWidgetConfigPacket(170, player.attr().get(Player.AREA_SOUND_VOLUME_KEY).getCode()));
			break;
		}
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		switch(event.getButton()) {
		case 19150:
		case 19151:
		case 19152:
		case 19153:
		case 19154:
			return true;		
		}
		return false;
	}

}
