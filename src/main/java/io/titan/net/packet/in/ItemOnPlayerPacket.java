package io.titan.net.packet.in;

import io.titan.game.event.impl.ItemOnPlayerEvent;
import io.titan.game.world.World;
import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.ByteOrder;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_ON_PLAYER)
public final class ItemOnPlayerPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final int playerIndex = packet.getReader().readShort(false);
    final int itemSlot = packet.getReader().readShort(ByteOrder.LITTLE);

    final Item used = player.getInventory().get(itemSlot);

    final Player usedWith = World.getPlayers().get(playerIndex);

    player.post(new ItemOnPlayerEvent(used, usedWith));

  }

}
