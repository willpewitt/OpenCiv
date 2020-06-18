package me.rhin.openciv.game.city;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import me.rhin.openciv.Civilization;
import me.rhin.openciv.game.city.building.Building;
import me.rhin.openciv.game.map.tile.Tile;
import me.rhin.openciv.game.player.Player;
import me.rhin.openciv.listener.BuildingConstructedListener;
import me.rhin.openciv.shared.packet.type.BuildingConstructedPacket;
import me.rhin.openciv.ui.label.CustomLabel;
import me.rhin.openciv.ui.window.type.CityInfoWindow;

public class City extends Actor implements BuildingConstructedListener {

	private Tile tile;
	private Player playerOwner;
	private ArrayList<Building> buildings;
	private CustomLabel nameLabel;

	public City(Tile tile, Player playerOwner, String name) {
		this.playerOwner = playerOwner;
		this.buildings = new ArrayList<>();
		setName(name);
		this.nameLabel = new CustomLabel(name);
		nameLabel.setPosition(tile.getX() + tile.getWidth() / 2 - nameLabel.getWidth() / 2,
				tile.getY() + tile.getHeight() + 5);
		// Civilization.getInstance().getScreenManager().getCurrentScreen().getStage().addActor(nameLabel);

		this.setPosition(nameLabel.getX(), nameLabel.getY());
		this.setSize(nameLabel.getWidth(), nameLabel.getHeight());

		Civilization.getInstance().getScreenManager().getCurrentScreen().getStage().addActor(this);

		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (!Civilization.getInstance().getWindowManager().allowsInput()) {
					return;
				}

				City cityActor = (City) event.getListenerActor();
				cityActor.onClick();
			}
		});

		Civilization.getInstance().getEventManager().addListener(BuildingConstructedListener.class, this);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		nameLabel.draw(batch, parentAlpha);
	}

	public void onClick() {
		if (!playerOwner.equals(Civilization.getInstance().getGame().getPlayer()))
			return;
		// TODO: Unselect selected unit
		Civilization.getInstance().getGame().getPlayer().unselectUnit();
		Civilization.getInstance().getWindowManager().toggleWindow(new CityInfoWindow(this));
	}

	@Override
	public void onBuildingConstructed(BuildingConstructedPacket packet) {
		if (!this.getName().equals(packet.getCityName()))
			return;

		// FIXME: The reflection done here makes GWT incompatible.
		String buildingClassName = "me.rhin.openciv.game.city.building.type." + packet.getBuildingName();
		try {
			Class<? extends Building> buildingClass = (Class<? extends Building>) Class.forName(buildingClassName);

			Constructor<?> ctor = buildingClass.getConstructor(City.class);
			Building building = (Building) ctor.newInstance(new Object[] { this });

			buildings.add(building);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Gdx.app.log(Civilization.LOG_TAG, "Adding building " + packet.getBuildingName() + " to city " + getName());
	}
}
