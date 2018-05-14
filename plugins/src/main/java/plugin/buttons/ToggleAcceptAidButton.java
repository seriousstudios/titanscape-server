package plugin.buttons;

import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ButtonActionEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.packet.out.SetWidgetConfigPacket;

@SubscribesTo(ButtonActionEvent.class)
public final class ToggleAcceptAidButton extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()) {
		
		case 12464:
	        player.attr().toggle(Player.ACCEPT_AID_KEY);
	        player.queuePacket(new SetWidgetConfigPacket(427, player.attr().get(Player.ACCEPT_AID_KEY)));
			break;
		
		}
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		return event.getButton() == 12464;
	}

}
