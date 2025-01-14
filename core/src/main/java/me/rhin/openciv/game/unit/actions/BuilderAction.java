package me.rhin.openciv.game.unit.actions;

import me.rhin.openciv.Civilization;
import me.rhin.openciv.game.unit.Unit;
import me.rhin.openciv.listener.BuilderActListener.BuilderActEvent;

public abstract class BuilderAction extends AbstractAction {

	public BuilderAction(Unit unit) {
		super(unit);
	}

	@Override
	public boolean act(float delta) {
		//TODO: Include movement cost & other redundant code here.
		
		Civilization.getInstance().getEventManager().fireEvent(new BuilderActEvent(this));
		return true;
	}
	
}
