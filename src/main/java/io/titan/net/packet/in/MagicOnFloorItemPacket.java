package io.titan.net.packet.in;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

/**
 * The {@link IncomingPacket} responsible for using magic on ground items.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(181)
public class MagicOnFloorItemPacket implements Receivable {

  @SuppressWarnings("unused")
  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int itemY = reader.readShort(ByteOrder.LITTLE);
    final int itemId = reader.readShort(false);
    final int itemX = reader.readShort(ByteOrder.LITTLE);
    final int spellId = reader.readShort(false, ByteModification.ADDITION);

  }

}
