package io.titan.net.codec.game;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.titan.net.codec.IsaacCipher;
import io.titan.net.packet.OutgoingPacket;
import io.titan.net.packet.PacketHeader;

/**
 * The {@link MessageToByteEncoder} implementation that encodes outgoing {@link OutgoingPacket}s so
 * they can be sent to a users client.
 * 
 * @author Seven
 */
public class GamePacketEncoder extends MessageToByteEncoder<OutgoingPacket> {

  /**
   * The encryptor used to encrypt the {@link OutgoingPacket}.
   */
  private final IsaacCipher encryptor;

  /**
   * Creates a new {@link GamePacketEncoder}.
   * 
   * @param encryptor The encrypting {@link IsaacCipher}.
   */
  public GamePacketEncoder(IsaacCipher encryptor) {
    this.encryptor = encryptor;
  }

  @Override
  protected void encode(ChannelHandlerContext ctx, OutgoingPacket packet, ByteBuf out)
      throws Exception {

    out.writeByte((packet.getOpcode() + encryptor.getKey()) & 0xFF);

    if (packet.getHeader() == PacketHeader.VARIABLE_BYTE) {
      out.writeByte(packet.getSize());
    } else if (packet.getHeader() == PacketHeader.VARIABLE_SHORT) {
      out.writeShort(packet.getSize());
    }
    out.writeBytes(packet.getPayload());
  }

}
