package io.titan.game.world.entity.mob.player.update.mask;

import io.titan.game.world.entity.Graphic;
import io.titan.game.world.entity.mob.player.Player;
import io.titan.game.world.entity.mob.player.update.PlayerUpdateBlock;
import io.titan.game.world.entity.mob.update.UpdateFlag;
import io.titan.net.codec.ByteOrder;
import io.titan.net.codec.game.GamePacketBuilder;

/**
 * The {@link PlayerUpdateBlock} implementation that updates a players graphics.
 * 
 * @author Freyr
 */
public class PlayerGraphicUpdateBlock extends PlayerUpdateBlock {

  /**
   * Creates a new {@link PlayerGraphicUpdateBlock}.
   */
  public PlayerGraphicUpdateBlock() {
    super(0x100, UpdateFlag.GRAPHICS);
  }

  @Override
  public void encode(Player entity, GamePacketBuilder builder) {
    final Graphic graphic = entity.getGraphic();
    builder.writeShort(graphic.getId(), ByteOrder.LITTLE);
    builder.writeInt(graphic.getHeight() << 16 | graphic.getDelay());
  }

}
