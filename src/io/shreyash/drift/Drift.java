package io.shreyash.drift;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.*;
import com.google.appinventor.components.runtime.*;

import io.shreyash.drift.core.Gestures;
import io.shreyash.drift.core.Gestures.OnFingerGestureListener;
import io.shreyash.drift.core.GestureAnalyser;

@SimpleObject(external = true)

@DesignerComponent(category = ComponentCategory.EXTENSION, 
                    description = "Gesture handler extension for MIT App Inventor 2 and its clones like Kodular.", 
                    iconName = "", 
                    nonVisible = true, 
                    version = 1,
		    versionName = 1.0.0)

public class Drift extends AndroidNonvisibleComponent implements Component {

	public Drift(ComponentContainer container) {
		super(container.$form());
	}

	@SimpleFunction(description = "Registers a component to start detecting gestures on it. Parameter \"component\" can be any view component.")
	public void DetectGesturesOn(AndroidViewComponent component, final int id) {
		Gestures gestures = new Gestures();
		gestures.setConsumeTouchEvents(true);
		gestures.setOnFingerGestureListener(
                new OnFingerGestureListener() {
                    public boolean onSwipeUp(int fingers, long gestureDuration, double gestureDistance) {
                        int figs = fingers;
                        long dur = gestureDuration;
                        double dist = gestureDistance;
                        double vel = dist / ((double) dur);
                        Drift.this.SwipedUp(id, figs, dur, dist, vel);
                        return true;
                    }

                    public boolean onSwipeDown(int fingers, long gestureDuration, double gestureDistance) {
                        int figs = fingers;
                        long dur = gestureDuration;
                        double dist = gestureDistance;
                        double vel = dist / ((double) dur);
                        Drift.this.SwipedDown(id, figs, dur, dist, vel);
                        return true;
                    }

                    public boolean onSwipeLeft(int fingers, long gestureDuration, double gestureDistance) {
                        int figs = fingers;
                        long dur = gestureDuration;
                        double dist = gestureDistance;
                        double vel = dist / ((double) dur);
                        Drift.this.SwipedLeft(id, figs, dur, dist, vel);
                        return true;
                    }

                    public boolean onSwipeRight(int fingers, long gestureDuration, double gestureDistance) {
                        int figs = fingers;
                        long dur = gestureDuration;
                        double dist = gestureDistance;
                        double vel = dist / ((double) dur);
                        Drift.this.SwipedRight(id, figs, dur, dist, vel);
                        return true;
                    }

                    public boolean onPinch(int fingers, long gestureDuration, double gestureDistance) {
                        int figs = fingers;
                        long dur = gestureDuration;
                        double dist = gestureDistance;
                        double vel = dist / ((double) dur);
                        Drift.this.PinchedIn(id, figs, dur, dist, vel);
                        return true;
                    }

                    public boolean onUnpinch(int fingers, long gestureDuration, double gestureDistance) {
                        int figs = fingers;
                        long dur = gestureDuration;
                        double dist = gestureDistance;
                        double vel = dist / ((double) dur);
                        Drift.this.PinchedOut(id, figs, dur, dist, vel);
                        return true;
                    }

                    public boolean onDoubleTap(int fingers) {
                        int figs = fingers;
                        Drift.this.DoubleTapped(id, figs);
                        return true;
                    }
            });
		component.getView().setOnTouchListener(gestures);
	}

	@SimpleEvent(description = "")
	public void SwipedLeft(int id, int fingers, long duration, double distance, double speed) {
		EventDispatcher.dispatchEvent(this, "SwipedLeft", id, fingers, duration, distance, speed);
	}

	@SimpleEvent(description = "")
	public void SwipedRight(int id, int fingers, long duration, double distance, double speed) {
		EventDispatcher.dispatchEvent(this, "SwipedRight", id, fingers, duration, distance, speed);
	}

	@SimpleEvent(description = "")
	public void SwipedDown(int id, int fingers, long duration, double distance, double speed) {
		EventDispatcher.dispatchEvent(this, "SwipedDown", id, fingers, duration, distance, speed);
	}

	@SimpleEvent(description = "")
	public void SwipedUp(int id, int fingers, long duration, double distance, double speed) {
		EventDispatcher.dispatchEvent(this, "SwipedUp", id, fingers, duration, distance, speed);
	}

	@SimpleEvent(description = "")
	public void PinchedIn(int id, int fingers, long duration, double distance, double speed) {
		EventDispatcher.dispatchEvent(this, "PinchedIn", id, fingers, duration, distance, speed);
	}

	@SimpleEvent(description = "")
	public void PinchedOut(int id, int fingers, long duration, double distance, double speed) {
		EventDispatcher.dispatchEvent(this, "PinchedOut", id, fingers, duration, distance, speed);
	}

	@SimpleEvent(description = "")
	public void DoubleTapped(int id, int fingers) {
		EventDispatcher.dispatchEvent(this, "DoubleTapped", id, fingers);
	}
}
