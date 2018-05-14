package plugin.click.item;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ItemOnObjectEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ItemOnObjectEvent.class)
public final class ItemOnObject implements EventSubscriber<ItemOnObjectEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnObjectEvent event) {
		
	}

}
