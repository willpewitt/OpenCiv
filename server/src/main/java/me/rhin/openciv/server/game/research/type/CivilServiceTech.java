package me.rhin.openciv.server.game.research.type;

import me.rhin.openciv.server.game.research.ResearchTree;
import me.rhin.openciv.server.game.research.TechProperty;
import me.rhin.openciv.server.game.research.Technology;

public class CivilServiceTech extends Technology {

	public CivilServiceTech(ResearchTree researchTree) {
		super(researchTree, TechProperty.MILITARY, TechProperty.MORALE);

		requiredTechs.add(HorsebackRidingTech.class);
		requiredTechs.add(CurrencyTech.class);
		requiredTechs.add(DramaPoetryTech.class);
	}

	@Override
	public int getScienceCost() {
		return 175;
	}

	@Override
	public String getName() {
		return "Civil Service";
	}

}
