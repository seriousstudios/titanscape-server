package plugin.click.obj;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ObjectFifthClickEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ObjectFifthClickEvent.class)
public final class ObjectFifthClick implements EventSubscriber<ObjectFifthClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectFifthClickEvent event) {
		
	}

}
