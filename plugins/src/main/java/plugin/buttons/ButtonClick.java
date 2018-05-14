package plugin.buttons;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.impl.ButtonActionEvent;
import io.titan.game.world.entity.mob.player.Player;

public abstract class ButtonClick implements EventSubscriber<ButtonActionEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ButtonActionEvent event) {
		execute(player, event);
	}
	
	protected abstract void execute(Player player, ButtonActionEvent event);
	
	public abstract boolean test(ButtonActionEvent event);

}
