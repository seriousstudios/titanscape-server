package plugin.doors;

import java.util.ArrayList;
import java.util.List;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.DoorEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(DoorEvent.class)
public final class Doors implements EventSubscriber<DoorEvent> {

	/**
	 * The list of door objects spawned in the game world.
	 */
	private static final List<Door> doors = new ArrayList<>();
	
	static {
		new DoorParser().run();
	}

	@Override
	public void subscribe(EventContext context, Player player, DoorEvent event) {
		DoorUtils.handleDoor(player, event.getDoor());		
	}
	
	public static List<Door> getDoors() {
		return doors;
	}

}
