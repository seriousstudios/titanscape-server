package plugin.doors;

import com.google.gson.JsonObject;

import io.titan.game.world.Direction;
import io.titan.game.world.Position;
import io.titan.game.world.entity.object.GameObjectType;
import io.titan.util.GsonParser;

public final class DoorParser extends GsonParser {

    public DoorParser() {
		super("./data/object/doors");
	}

	@Override
	public void parse(JsonObject data) {
		int id = data.get("id").getAsInt();
		GameObjectType type = GameObjectType.valueOf(data.get("type").getAsString());
		Position position = builder.fromJson(data.get("position"), Position.class);		
		boolean open = data.get("open").getAsBoolean();
		Direction orientation = Direction.valueOf(data.get("orientation").getAsString());

		Doors.getDoors().add(new Door(id, type, position, open, orientation));
	}

}