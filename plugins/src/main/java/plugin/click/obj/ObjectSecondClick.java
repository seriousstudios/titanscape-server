package plugin.click.obj;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ObjectSecondClickEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ObjectSecondClickEvent.class)
public final class ObjectSecondClick implements EventSubscriber<ObjectSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectSecondClickEvent event) {
		
	}

}
