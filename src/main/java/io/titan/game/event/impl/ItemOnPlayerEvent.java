package io.titan.game.event.impl;

import io.titan.game.event.Event;
import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.mob.player.Player;

public final class ItemOnPlayerEvent implements Event {

  private final Item used;

  private final Player usedWith;

  public ItemOnPlayerEvent(Item used, Player usedWith) {
    this.used = used;
    this.usedWith = usedWith;
  }

  public Item getUsed() {
    return used;
  }

  public Player getUsedWith() {
    return usedWith;
  }

}
