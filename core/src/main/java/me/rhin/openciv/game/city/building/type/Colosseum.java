package me.rhin.openciv.game.city.building.type;

import me.rhin.openciv.Civilization;
import me.rhin.openciv.asset.TextureEnum;
import me.rhin.openciv.game.city.City;
import me.rhin.openciv.game.city.building.Building;
import me.rhin.openciv.game.research.type.ConstructionTech;
import me.rhin.openciv.shared.stat.Stat;

public class Colosseum extends Building {

	public Colosseum(City city) {
		super(city);

		this.statLine.addValue(Stat.MORALE_CITY, 10);
		this.statLine.addValue(Stat.MAINTENANCE, 1);
	}

	@Override
	public float getBuildingProductionCost() {
		return 100;
	}

	@Override
	public float getGoldCost() {
		return 300;
	}

	@Override
	public String getName() {
		return "Colosseum";
	}

	@Override
	public boolean meetsProductionRequirements() {
		return Civilization.getInstance().getGame().getPlayer().getResearchTree().hasResearched(ConstructionTech.class);
	}

	@Override
	public TextureEnum getTexture() {
		return TextureEnum.BUILDING_COLOSSEUM;
	}

	@Override
	public String getDesc() {
		return "Provides the city +10 morale";
	}

}
