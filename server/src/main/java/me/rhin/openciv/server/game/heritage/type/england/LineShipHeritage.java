package me.rhin.openciv.server.game.heritage.type.england;

import me.rhin.openciv.server.game.Player;
import me.rhin.openciv.server.game.heritage.Heritage;

public class LineShipHeritage extends Heritage {

	public LineShipHeritage(Player player) {
		super(player);
	}

	@Override
	public int getLevel() {
		return 1;
	}

	@Override
	public String getName() {
		return "Ship of the Line";
	}

	@Override
	public float getCost() {
		return 40;
	}
	
	@Override
	protected void onStudied() {
		
	}
}
