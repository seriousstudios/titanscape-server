package plugin.buttons;

import com.google.common.collect.ImmutableSet;

import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.ButtonActionEvent;
import io.titan.game.world.Position;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.TeleportType;

@SubscribesTo(ButtonActionEvent.class)
public class SpellBookButtons extends ButtonClick {
	
	private static final ImmutableSet<Integer> buttons = ImmutableSet.of(1164);

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch(event.getButton()) {
		
		case 1164:
			player.teleport(Position.create(3207, 3428), TeleportType.NORMAL);
			break;
		
		
		}
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		return buttons.contains(event.getButton());
	}

}
