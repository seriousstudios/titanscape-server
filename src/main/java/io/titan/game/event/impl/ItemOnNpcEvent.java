package io.titan.game.event.impl;

import io.titan.game.event.Event;
import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.mob.npc.Npc;

public final class ItemOnNpcEvent implements Event {

  private final Item item;

  private final Npc npc;

  public ItemOnNpcEvent(Item item, Npc npc) {
    this.item = item;
    this.npc = npc;
  }

  public Item getItem() {
    return item;
  }

  public Npc getNpc() {
    return npc;
  }

}
