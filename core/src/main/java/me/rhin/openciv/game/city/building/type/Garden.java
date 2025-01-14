package me.rhin.openciv.game.city.building.type;

import me.rhin.openciv.asset.TextureEnum;
import me.rhin.openciv.game.city.City;
import me.rhin.openciv.game.city.building.Building;
import me.rhin.openciv.game.research.type.TheologyTech;
import me.rhin.openciv.shared.stat.Stat;

public class Garden extends Building {

	public Garden(City city) {
		super(city);

		this.statLine.addValue(Stat.FOOD_GAIN, 1);
		this.statLine.addValue(Stat.MAINTENANCE, 1);
	}

	@Override
	public TextureEnum getTexture() {
		return TextureEnum.BUILDING_GARDEN;
	}

	@Override
	public boolean meetsProductionRequirements() {
		return city.getPlayerOwner().getResearchTree().hasResearched(TheologyTech.class);
	}

	@Override
	public String getDesc() {
		return "+1 Food in the city\n+10% Food gain in the city";
	}

	@Override
	public float getGoldCost() {
		return 250;
	}

	@Override
	public float getBuildingProductionCost() {
		return 120;
	}

	@Override
	public String getName() {
		return "Garden";
	}

}
