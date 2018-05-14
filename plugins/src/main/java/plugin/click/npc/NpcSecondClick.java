package plugin.click.npc;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.NpcSecondClickEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(NpcSecondClickEvent.class)
public final class NpcSecondClick implements EventSubscriber<NpcSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, NpcSecondClickEvent event) {
		
	}

}
