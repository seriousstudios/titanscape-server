package io.titan.net.packet.in;

import io.titan.game.event.impl.ItemOnItemEvent;
import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteModification;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_ON_ITEM)
public final class ItemOnItemPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int usedWithSlot = reader.readShort();
    final int itemUsedSlot = reader.readShort(ByteModification.ADDITION);

    final Item used = player.getInventory().get(itemUsedSlot);

    final Item with = player.getInventory().get(usedWithSlot);

    player.post(new ItemOnItemEvent(used, with));
  }

}

