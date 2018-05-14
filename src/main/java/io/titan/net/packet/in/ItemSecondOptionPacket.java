package io.titan.net.packet.in;

import io.titan.game.event.impl.ItemSecondClickEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_OPTION_2)
public final class ItemSecondOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();
    final int itemId = reader.readShort(ByteModification.ADDITION);

    player.post(new ItemSecondClickEvent(itemId, -1));
  }

}
