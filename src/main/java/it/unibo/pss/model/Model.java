package it.unibo.pss.model;

import java.util.ArrayList;
import java.util.List;
import it.unibo.pss.controller.model.ModelObserver;
import it.unibo.pss.model.entity.EntityGenerator;
import it.unibo.pss.model.world.World;
import it.unibo.pss.model.world.WorldGenerator;
import javafx.animation.AnimationTimer;

public class Model {

	private final World grid;
	private final List<ModelObserver> observers = new ArrayList<>();
	private static final int ENTITY_COUNT = 20;
	private AnimationTimer timer;
	private long lastUpdate = 0;
	private static final long UPDATE_INTERVAL = 500_000_000; // 500ms in nanoseconds

	public Model(int width, int height) {
		this.grid = WorldGenerator.generateGrid(width, height);
		EntityGenerator.generateEntities(grid, ENTITY_COUNT);
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (now - lastUpdate >= UPDATE_INTERVAL) {
					updateSimulation();
					lastUpdate = now;
				}
			}
		};
		timer.start();
	}

	public World getGrid() {
		return grid;
	}

	/** Adds an observer. */
	public void addObserver(ModelObserver observer) {
		observers.add(observer);
	}

	/** Removes an observer. */
	public void removeObserver(ModelObserver observer) {
		observers.remove(observer);
	}

	/** Notifies observers when the model updates. */
	private void notifyObservers() {
		observers.forEach(ModelObserver::onModelUpdated);
	}

	/** Updates the simulation logic and notifies observers. */
	private void updateSimulation() {
		// TODO: Implement simulation update logic
		notifyObservers();
	}
}
