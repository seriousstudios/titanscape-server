package io.titan.net.packet.in;

import io.titan.game.event.impl.ItemThirdClickEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_OPTION_3)
public final class ItemThirdOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();
    final int itemId11 = reader.readShort(ByteOrder.LITTLE);
    final int itemId1 = reader.readShort(ByteModification.ADDITION);
    final int itemId = reader.readShort(ByteModification.ADDITION);

    player.post(new ItemThirdClickEvent(itemId, itemId11, itemId1));
  }

}
