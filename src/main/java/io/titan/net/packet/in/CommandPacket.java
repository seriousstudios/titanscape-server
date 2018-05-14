package io.titan.net.packet.in;

import io.titan.game.event.impl.CommandEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.IncomingPacket.IncomingPacketOpcode;

/**
 * The {@link IncomingPacket} responsible for handling user commands send from the client.
 * 
 * @author Vult-R
 */
@IncomingPacketOpcode(IncomingPacket.PLAYER_COMMAND)
public final class CommandPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

    final String input = packet.getReader().getRS2String().trim().toLowerCase();

    player.post(new CommandEvent(input.split(" ")[0], input));

  }

}
