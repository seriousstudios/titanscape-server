package io.astraeus.game.event.impl;

import io.astraeus.game.event.Event;

public final class WidgetContainerFourthOptionEvent implements Event {

  private final int widgetId;

  private final int itemSlot;

  private final int itemId;

  public WidgetContainerFourthOptionEvent(int widgetId, int itemId, int itemSlot) {
    this.widgetId = widgetId;
    this.itemId = itemId;
    this.itemSlot = itemSlot;
  }

  public int getWidgetId() {
    return widgetId;
  }

  public int getItemSlot() {
    return itemSlot;
  }

  public int getItemId() {
    return itemId;
  }

}
