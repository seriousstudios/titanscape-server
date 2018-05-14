package io.titan.net.packet.in;

import io.titan.game.event.impl.MagicOnItemEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

/**
 * The {@link IncomingPacket} responsible for using magic on inventory items.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(IncomingPacket.MAGIC_ON_ITEMS)
public final class MagicOnItemPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int slot = reader.readShort();
    final int itemId = reader.readShort(ByteModification.ADDITION);
    final int childId = reader.readShort();
    final int spellId = reader.readShort(ByteModification.ADDITION);

    player.post(new MagicOnItemEvent(itemId, slot, childId, spellId));
  }

}
