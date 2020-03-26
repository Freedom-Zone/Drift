package io.shreyash.drift.core;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import io.shreyash.drift.core.GestureAnalyser.GestureType;

public class Gestures implements OnTouchListener {

    public static final long GESTURE_SPEED_FAST = 500;
    public static final long GESTURE_SPEED_MEDIUM = 1000;
    public static final long GESTURE_SPEED_SLOW = 1500;
    private static final String TAG = "Gestures";
    private boolean consumeTouchEvents;
    private boolean debug;

    private GestureAnalyser gestureAnalyser;
    private OnFingerGestureListener onFingerGestureListener;
    protected boolean[] tracking;

    public interface OnFingerGestureListener {
        boolean onDoubleTap(int i);

        boolean onPinch(int i, long j, double d);

        boolean onSwipeDown(int i, long j, double d);

        boolean onSwipeLeft(int i, long j, double d);

        boolean onSwipeRight(int i, long j, double d);

        boolean onSwipeUp(int i, long j, double d);

        boolean onUnpinch(int i, long j, double d);
    }

    public Gestures() {
        this.debug = true;
        this.consumeTouchEvents = false;
        this.tracking = new boolean[]{false, false, false, false, false};
        this.gestureAnalyser = new GestureAnalyser();
    }

    public Gestures(int swipeSlopeIntolerance, int doubleTapMaxDelayMillis, int doubleTapMaxDownMillis) {
        this.debug = true;
        this.consumeTouchEvents = false;
        this.tracking = new boolean[]{false, false, false, false, false};
        this.gestureAnalyser = new GestureAnalyser(swipeSlopeIntolerance, doubleTapMaxDelayMillis, doubleTapMaxDownMillis);
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean getConsumeTouchEvents() {
        return this.consumeTouchEvents;
    }

    public void setConsumeTouchEvents(boolean consumeTouchEvents) {
        this.consumeTouchEvents = consumeTouchEvents;
    }

    public void setOnFingerGestureListener(OnFingerGestureListener omfg) {
        this.onFingerGestureListener = omfg;
    }

    public boolean onTouch(View view, MotionEvent ev) {
        if (this.debug) {
            Log.d(TAG, "onTouch");
        }
        switch (ev.getAction() & 255) {
            case 0:
                if (this.debug) {
                    Log.d(TAG, "ACTION_DOWN");
                }
                startTracking(0);
                this.gestureAnalyser.trackGesture(ev);
                return this.consumeTouchEvents;
            case 1:
                if (this.debug) {
                    Log.d(TAG, "ACTION_UP");
                }
                if (this.tracking[0]) {
                    doCallBack(this.gestureAnalyser.getGesture(ev));
                }
                stopTracking(0);
                this.gestureAnalyser.untrackGesture();
                return this.consumeTouchEvents;
            case 2:
                if (this.debug) {
                    Log.d(TAG, "ACTION_MOVE");
                }
                return this.consumeTouchEvents;
            case 3:
                if (!this.debug) {
                    return true;
                }
                Log.d(TAG, "ACTION_CANCEL");
                return true;
            case 5:
                if (this.debug) {
                    Log.d(TAG, "ACTION_POINTER_DOWN num" + ev.getPointerCount());
                }
                startTracking(ev.getPointerCount() - 1);
                this.gestureAnalyser.trackGesture(ev);
                return this.consumeTouchEvents;
            case 6:
                if (this.debug) {
                    Log.d(TAG, "ACTION_POINTER_UP num" + ev.getPointerCount());
                }
                if (this.tracking[1]) {
                    doCallBack(this.gestureAnalyser.getGesture(ev));
                }
                stopTracking(ev.getPointerCount() - 1);
                this.gestureAnalyser.untrackGesture();
                return this.consumeTouchEvents;
            default:
                return this.consumeTouchEvents;
        }
    }

    private void doCallBack(GestureType mGt) {
        switch (mGt.getGestureFlag()) {
            case 11:
                this.onFingerGestureListener.onSwipeUp(1, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 12:
                this.onFingerGestureListener.onSwipeDown(1, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 13:
                this.onFingerGestureListener.onSwipeLeft(1, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 14:
                this.onFingerGestureListener.onSwipeRight(1, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 21:
                this.onFingerGestureListener.onSwipeUp(2, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 22:
                this.onFingerGestureListener.onSwipeDown(2, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 23:
                this.onFingerGestureListener.onSwipeLeft(2, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 24:
                this.onFingerGestureListener.onSwipeRight(2, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 25:
                this.onFingerGestureListener.onPinch(2, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 26:
                this.onFingerGestureListener.onUnpinch(2, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 31:
                this.onFingerGestureListener.onSwipeUp(3, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 32:
                this.onFingerGestureListener.onSwipeDown(3, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 33:
                this.onFingerGestureListener.onSwipeLeft(3, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 34:
                this.onFingerGestureListener.onSwipeRight(3, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 35:
                this.onFingerGestureListener.onPinch(3, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 36:
                this.onFingerGestureListener.onUnpinch(3, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 41:
                this.onFingerGestureListener.onSwipeUp(4, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 42:
                this.onFingerGestureListener.onSwipeDown(4, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 43:
                this.onFingerGestureListener.onSwipeLeft(4, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 44:
                this.onFingerGestureListener.onSwipeRight(4, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 45:
                this.onFingerGestureListener.onPinch(4, mGt.getGestureDuration(), mGt.getGestureDistance());
                return;
            case 46:
                this.onFingerGestureListener.onUnpinch(4, mGt.getGestureDuration(), mGt.getGestureDistance());
                break;
            case 107:
                break;
            default:
                return;
        }
        this.onFingerGestureListener.onDoubleTap(1);
    }

    private void startTracking(int nthPointer) {
        for (int i = 0; i <= nthPointer; i++) {
            this.tracking[i] = true;
        }
    }

    private void stopTracking(int nthPointer) {
        for (int i = nthPointer; i < this.tracking.length; i++) {
            this.tracking[i] = false;
        }
    }
}
