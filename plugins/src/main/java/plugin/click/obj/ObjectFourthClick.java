package plugin.click.obj;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ObjectFourthClickEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(ObjectFourthClickEvent.class)
public final class ObjectFourthClick implements EventSubscriber<ObjectFourthClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectFourthClickEvent event) {
		
	}

}
