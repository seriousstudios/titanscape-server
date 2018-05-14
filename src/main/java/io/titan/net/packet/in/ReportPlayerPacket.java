package io.titan.net.packet.in;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

/**
 * The {@link IncomingPacket} responsible reporting another player.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(IncomingPacket.REPORT_PLAYER)
public final class ReportPlayerPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

  }
}
