package me.rhin.openciv.game.research.type;

import com.badlogic.gdx.graphics.g2d.Sprite;

import me.rhin.openciv.asset.TextureEnum;
import me.rhin.openciv.game.research.ResearchTree;
import me.rhin.openciv.game.research.Technology;
import me.rhin.openciv.game.research.TreePosition;

public class OpticsTech extends Technology {

	public OpticsTech(ResearchTree researchTree) {
		super(researchTree, new TreePosition(2, 9));

		requiredTechs.add(SailingTech.class);
	}

	@Override
	public int getScienceCost() {
		return 85;
	}

	@Override
	public String getName() {
		return "Optics";
	}

	@Override
	public Sprite getIcon() {
		return TextureEnum.BUILDING_LIGHTHOUSE.sprite();
	}

	@Override
	public String getDesc() {
		return "- Unlocks lighthouse\n- Allows units to traverse\nshallow water";
	}

}
