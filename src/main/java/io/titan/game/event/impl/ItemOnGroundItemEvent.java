package io.titan.game.event.impl;

import io.titan.game.event.Event;
import io.titan.game.world.Position;
import io.titan.game.world.entity.item.Item;

public final class ItemOnGroundItemEvent implements Event {

  private final Item used;

  private final Item groundItem;

  private final Position position;

  public ItemOnGroundItemEvent(Item used, Item groundItem, Position position) {
    this.used = used;
    this.groundItem = groundItem;
    this.position = position;
  }

  public Item getUsed() {
    return used;
  }

  public Item getGroundItem() {
    return groundItem;
  }

  public Position getPosition() {
    return position;
  }

}
