package plugin.click.item;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ItemOnItemEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ItemOnItemEvent.class)
public final class ItemOnItem implements EventSubscriber<ItemOnItemEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnItemEvent event) {
		
	}

}
