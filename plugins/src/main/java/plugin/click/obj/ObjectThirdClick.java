package plugin.click.obj;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ObjectThirdClickEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ObjectThirdClickEvent.class)
public final class ObjectThirdClick implements EventSubscriber<ObjectThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectThirdClickEvent event) {
		
	}

}
