package io.titan.net.packet.out;

import java.util.Optional;

import io.titan.game.world.entity.mob.player.Player;
import io.titan.net.codec.game.GamePacketBuilder;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.Sendable;

public final class SetPrivacyOptionPacket implements Sendable {

  private final int publicChat;

  private final int privateChat;

  private final int tradeChat;

  public SetPrivacyOptionPacket(int publicChat, int privateChat, int tradeChat) {
    this.publicChat = publicChat;
    this.privateChat = privateChat;
    this.tradeChat = tradeChat;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(206);

    builder.write(publicChat).write(privateChat).write(tradeChat);

    return builder.toOutgoingPacket();
  }

}
