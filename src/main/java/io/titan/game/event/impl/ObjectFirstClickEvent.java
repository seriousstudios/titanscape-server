package io.titan.game.event.impl;

import io.titan.game.event.Event;
import io.titan.game.world.entity.object.GameObject;

public final class ObjectFirstClickEvent implements Event {

  private final GameObject gameObject;

  public ObjectFirstClickEvent(GameObject gameObject) {
    this.gameObject = gameObject;
  }

  public GameObject getGameObject() {
    return gameObject;
  }

}
