package plugin.click.magic;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.MagicOnItemEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(MagicOnItemEvent.class)
public final class MagicOnItem implements EventSubscriber<MagicOnItemEvent> {

	@Override
	public void subscribe(EventContext context, Player player, MagicOnItemEvent event) {
		
	}

}
