package plugin.buttons;

import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ButtonActionEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.packet.out.SetWidgetConfigPacket;

@SubscribesTo(ButtonActionEvent.class)
public final class ToggleChatEffectButton extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()) {
		
		case 915:
	        player.attr().toggle(Player.CHAT_EFFECTS_KEY);
	        player.queuePacket(new SetWidgetConfigPacket(172, player.attr().get(Player.CHAT_EFFECTS_KEY)));
			break;
		
		}
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		return event.getButton() == 915;
	}

}
