package plugin.commands.impl;

import io.titan.game.event.SubscribesTo;
import io.titan.game.event.impl.CommandEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerRights;
import io.titan.net.packet.out.ServerMessagePacket;
import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public final class DebugCommand extends Command {

	@Override
	protected boolean execute(Player player, CommandParser parser) {
        player.attr().toggle(Player.DEBUG_KEY);
        player.queuePacket(new ServerMessagePacket("[debug= ${player.attr().get(Player.DEBUG_KEY)}]"));
		return false;
	}

	@Override
	public boolean test(CommandEvent event) {
		return event.getName().equalsIgnoreCase("debug");
	}

	@Override
	protected PlayerRights rights() {
		return PlayerRights.DEVELOPER;
	}

}
