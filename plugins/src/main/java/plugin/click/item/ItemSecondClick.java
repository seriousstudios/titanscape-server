package plugin.click.item;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ItemSecondClickEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ItemSecondClickEvent.class)
public final class ItemSecondClick implements EventSubscriber<ItemSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemSecondClickEvent event) {
		
	}

}
