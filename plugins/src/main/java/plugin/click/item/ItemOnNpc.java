package plugin.click.item;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ItemOnNpcEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ItemOnNpcEvent.class)
public final class ItemOnNpc implements EventSubscriber<ItemOnNpcEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnNpcEvent event) {
		
	}

}
