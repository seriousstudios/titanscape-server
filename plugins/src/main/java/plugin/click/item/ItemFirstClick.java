package plugin.click.item;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ItemFirstClickEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ItemFirstClickEvent.class)
public final class ItemFirstClick implements EventSubscriber<ItemFirstClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemFirstClickEvent event) {
		
	}

}
