package plugin.commands;

import io.titan.game.event.EventContext;
import io.titan.game.event.EventSubscriber;
import io.titan.game.event.impl.CommandEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerRights;

public abstract class Command implements EventSubscriber<CommandEvent> {
	
	@Override
	public void subscribe(EventContext ctx, Player player, CommandEvent event) {
	  
	  if (player == null) {
	    return;
	  }
	  
	  if (player.getRights().greaterOrEqual(rights())) {
	       execute(player, CommandParser.create(event.getInput()));
	  }	  

	}
	
	protected abstract boolean execute(Player player, CommandParser parser);
	
	@Override
	public abstract boolean test(CommandEvent event);
	
	protected abstract PlayerRights rights();

}
