package plugin.click.obj;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.DoorEvent;
import io.titan.game.event.impl.ObjectFirstClickEvent;
import io.titan.game.world.entity.mob.player.Player;
import plugin.doors.DoorUtils;

@SubscribesTo(ObjectFirstClickEvent.class)
public final class ObjectFirstClick implements EventSubscriber<ObjectFirstClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectFirstClickEvent event) {
		if (DoorUtils.isDoor(event.getGameObject().getId())) {
			player.post(new DoorEvent(event.getGameObject()));
			return;
		}
		
		switch (event.getGameObject().getId()) {
		
		case 2213:
			player.getBank().open();
			break;
		
		}
		
	}

}
