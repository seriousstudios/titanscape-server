package plugin.commands.impl;

import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.CommandEvent;
import io.titan.game.world.entity.mob.Animation;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerRights;
import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public final class AnimationCommand extends Command {

	@Override
	protected boolean execute(Player player, CommandParser parser) {
		if (parser.hasNext(1)) {
			
			int id = parser.nextInt();
			
			player.startAnimation(Animation.create(id));
			
			return true;			
		}
		return false;
	}
	
	@Override
	public boolean test(CommandEvent event) {
		return event.getName().equalsIgnoreCase("anim") || event.getName().equalsIgnoreCase("animation");		
	}

	@Override
	protected PlayerRights rights() {
		return PlayerRights.DEVELOPER;
	}


}
