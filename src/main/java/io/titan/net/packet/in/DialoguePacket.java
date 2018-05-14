package io.titan.net.packet.in;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.IncomingPacket.IncomingPacketOpcode;

/**
 * The {@link IncomingPacket} responsible for dialogues.
 * 
 * @author SeVen
 */
@IncomingPacketOpcode(40)
public final class DialoguePacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

    player.getDialogueFactory().execute();

  }
}
