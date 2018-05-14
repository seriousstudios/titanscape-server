package io.titan.net.packet.in;

import io.titan.game.event.impl.ButtonActionEvent;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.PlayerRights;
import io.titan.net.codec.game.ByteBufReader;
import io.titan.net.packet.IncomingPacket;
import io.titan.net.packet.Receivable;
import io.titan.net.packet.out.ServerMessagePacket;

/**
 * The {@link IncomingPacket} responsible for clicking buttons on the client.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(IncomingPacket.BUTTON_CLICK)
public class ButtonClickPacket implements Receivable {

  @Override
  public void handlePacket(final Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int button = reader.readShort();

    if (player.getRights().greaterOrEqual(PlayerRights.DEVELOPER)
        && player.attr().get(Player.DEBUG_KEY)) {
      player.queuePacket(new ServerMessagePacket(String.format("[button= %d]", button)));
    }

    player.post(new ButtonActionEvent(button));
  }

}
