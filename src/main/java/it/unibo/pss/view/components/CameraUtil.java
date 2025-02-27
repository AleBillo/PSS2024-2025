package it.unibo.pss.view.components;

import it.unibo.pss.view.geometry.GeometryRenderer;
import javafx.geometry.Point2D;

// utility class for camera operations
public final class CameraUtil {
	private CameraUtil() { }

	// compute the camera offset
	public static Point2D computeCameraOffset(GeometryRenderer renderer, Camera camera, double canvasWidth, double canvasHeight, int gridCols, int gridRows) {
		Point2D baseOffset = renderer.computeCenterOffset(canvasWidth, canvasHeight, gridCols, gridRows);
		return camera.applyCamera(baseOffset);
	}
}
