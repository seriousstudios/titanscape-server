package io.titan.game.event.impl;

import io.titan.game.event.Event;
import io.titan.game.world.entity.object.GameObject;

public final class DoorEvent implements Event {

  private GameObject door;

  public DoorEvent(GameObject door) {
    this.door = door;
  }

  public GameObject getDoor() {
    return door;
  }

}
