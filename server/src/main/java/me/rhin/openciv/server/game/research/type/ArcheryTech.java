package me.rhin.openciv.server.game.research.type;

import me.rhin.openciv.server.game.research.TechProperty;
import me.rhin.openciv.server.game.research.ResearchTree;
import me.rhin.openciv.server.game.research.Technology;

public class ArcheryTech extends Technology {

	public ArcheryTech(ResearchTree researchTree) {
		super(researchTree, TechProperty.MILITARY, TechProperty.FOOD);
	}

	@Override
	public int getScienceCost() {
		return 35;
	}

	@Override
	public String getName() {
		return "Archery";
	}

}
