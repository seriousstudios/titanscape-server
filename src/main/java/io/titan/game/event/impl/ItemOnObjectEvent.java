package io.titan.game.event.impl;

import io.titan.game.event.Event;
import io.titan.game.world.entity.item.Item;
import io.titan.game.world.entity.object.GameObject;

public final class ItemOnObjectEvent implements Event {

  private final Item item;

  private final GameObject gameObject;

  public ItemOnObjectEvent(Item item, GameObject gameObject) {
    this.item = item;
    this.gameObject = gameObject;
  }

  public Item getItem() {
    return item;
  }

  public GameObject getGameObject() {
    return gameObject;
  }

}
