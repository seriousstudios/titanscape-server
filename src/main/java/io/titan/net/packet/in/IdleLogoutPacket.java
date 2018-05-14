package io.titan.net.packet.in;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.IncomingPacket.IncomingPacketOpcode;

/**
 * The {@link IncomingPacket} responsible logging out a player after a certain amount of time.
 * 
 * @author SeVen
 */
@IncomingPacketOpcode(IncomingPacket.IDLE_LOGOUT)
public final class IdleLogoutPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

  }
}
