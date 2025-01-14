package me.rhin.openciv.server.game.heritage.type.germany;

import me.rhin.openciv.server.game.AbstractPlayer;
import me.rhin.openciv.server.game.heritage.Heritage;

public class BarbarianHeritage extends Heritage {

	public BarbarianHeritage(AbstractPlayer player) {
		super(player);
	}

	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	public String getName() {
		return "Barbarian Heritage";
	}

	@Override
	public float getCost() {
		return 8;
	}

	@Override
	protected void onStudied() {
	}
}
