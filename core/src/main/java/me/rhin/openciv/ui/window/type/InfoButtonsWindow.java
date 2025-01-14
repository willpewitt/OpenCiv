package me.rhin.openciv.ui.window.type;

import me.rhin.openciv.ui.background.ColoredBackground;
import me.rhin.openciv.ui.button.type.OpenChatButton;
import me.rhin.openciv.ui.button.type.OpenDiplomacyButton;
import me.rhin.openciv.ui.button.type.OpenReligionInfoButton;
import me.rhin.openciv.ui.window.AbstractWindow;

public class InfoButtonsWindow extends AbstractWindow {

	private ColoredBackground background;
	private OpenChatButton chatButton;
	private OpenReligionInfoButton openReligionInfoButton;
	private OpenDiplomacyButton openDiplomacyButton;

	public InfoButtonsWindow() {
		super.setBounds(4, 28, 200, 60);

		// background = new ColoredBackground(TextureEnum.UI_BLACK.sprite(), 0, 0,
		// getWidth(), getHeight());
		// addActor(background);

		this.chatButton = new OpenChatButton(0, 0, 42, 42);
		addActor(chatButton);

		this.openReligionInfoButton = new OpenReligionInfoButton(52, 0, 42, 42);
		addActor(openReligionInfoButton);

		this.openDiplomacyButton = new OpenDiplomacyButton(104, 0, 42, 42);
		addActor(openDiplomacyButton);
	}

	@Override
	public boolean disablesInput() {
		return false;
	}

	@Override
	public boolean disablesCameraMovement() {
		return false;
	}

	@Override
	public boolean closesOtherWindows() {
		return false;
	}

	@Override
	public boolean closesGameDisplayWindows() {
		return false;
	}

	@Override
	public boolean isGameDisplayWindow() {
		return true;
	}

}
