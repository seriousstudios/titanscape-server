package plugin.click.npc;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.NpcThirdClickEvent;
import io.titan.game.world.entity.mob.player.Player;

@SubscribesTo(NpcThirdClickEvent.class)
public final class NpcThirdClick implements EventSubscriber<NpcThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, NpcThirdClickEvent event) {
		
	}

}
