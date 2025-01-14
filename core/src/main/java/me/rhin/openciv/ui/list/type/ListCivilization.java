package me.rhin.openciv.ui.list.type;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import me.rhin.openciv.Civilization;
import me.rhin.openciv.asset.TextureEnum;
import me.rhin.openciv.game.civilization.CivType;
import me.rhin.openciv.shared.packet.type.ChooseCivPacket;
import me.rhin.openciv.ui.label.CustomLabel;
import me.rhin.openciv.ui.list.ContainerList;
import me.rhin.openciv.ui.list.ListObject;

public class ListCivilization extends ListObject {

	private CivType civType;
	private Sprite hoveredBackgroundSprite;
	private Sprite backgroundSprite;
	private Sprite civSprite;
	private CustomLabel civNameLabel;
	
	public ListCivilization(final CivType civType, ContainerList containerList, float width, float height) {
		super(width, height, containerList, "Civilization");

		this.civType = civType;
		backgroundSprite = TextureEnum.UI_DARK_GRAY.sprite();
		backgroundSprite.setSize(width, height);

		this.hoveredBackgroundSprite = TextureEnum.UI_GRAY.sprite();
		this.hoveredBackgroundSprite.setSize(width, height);

		this.civSprite = civType.getIcon().sprite();
		civSprite.setSize(32, 32);

		this.civNameLabel = new CustomLabel(civType.getName());
	}
	
	@Override
	protected void onClicked(InputEvent event) {
		ChooseCivPacket chooseCivPacket = new ChooseCivPacket();
		chooseCivPacket.setCivName(civType.name());
		Civilization.getInstance().getNetworkManager().sendPacket(chooseCivPacket);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (hovered)
			hoveredBackgroundSprite.draw(batch);
		else
			backgroundSprite.draw(batch);

		civSprite.draw(batch);
		civNameLabel.draw(batch, parentAlpha);
		// FIXME: Ordering looks weird..
		super.draw(batch, parentAlpha);
	}

	@Override
	public void setPosition(float x, float y) {
		super.setPosition(x, y);
		backgroundSprite.setPosition(x, y);
		hoveredBackgroundSprite.setPosition(x, y);
		civSprite.setPosition(x + getHeight() / 2 - 16, y + 5);
		civNameLabel.setPosition(x + 40, y + 16);
	}

}
