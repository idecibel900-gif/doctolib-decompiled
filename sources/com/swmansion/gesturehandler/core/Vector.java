package com.swmansion.gesturehandler.core;

import android.view.VelocityTracker;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Vector {
    private final double magnitude;
    private final double unitX;
    private final double unitY;
    private final double x;
    private final double y;
    public static final Companion Companion = new Companion(null);
    private static final Vector VECTOR_LEFT = new Vector(-1.0d, 0.0d);
    private static final Vector VECTOR_RIGHT = new Vector(1.0d, 0.0d);
    private static final Vector VECTOR_UP = new Vector(0.0d, -1.0d);
    private static final Vector VECTOR_DOWN = new Vector(0.0d, 1.0d);
    private static final Vector VECTOR_RIGHT_UP = new Vector(1.0d, -1.0d);
    private static final Vector VECTOR_RIGHT_DOWN = new Vector(1.0d, 1.0d);
    private static final Vector VECTOR_LEFT_UP = new Vector(-1.0d, -1.0d);
    private static final Vector VECTOR_LEFT_DOWN = new Vector(-1.0d, 1.0d);
    private static final Vector VECTOR_ZERO = new Vector(0.0d, 0.0d);

    public Vector(double d, double d2) {
        this.x = d;
        this.y = d2;
        double dHypot = Math.hypot(d, d2);
        this.magnitude = dHypot;
        boolean z = dHypot > 0.1d;
        this.unitX = z ? d / dHypot : 0.0d;
        this.unitY = z ? d2 / dHypot : 0.0d;
    }

    public final double getMagnitude() {
        return this.magnitude;
    }

    private final double computeSimilarity(Vector vector) {
        return (this.unitX * vector.unitX) + (this.unitY * vector.unitY);
    }

    public final boolean isSimilar(Vector vector, double d) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        return computeSimilarity(vector) > d;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Vector fromDirection(int i) {
            switch (i) {
                case 1:
                    return Vector.VECTOR_RIGHT;
                case 2:
                    return Vector.VECTOR_LEFT;
                case 3:
                case 7:
                default:
                    return Vector.VECTOR_ZERO;
                case 4:
                    return Vector.VECTOR_UP;
                case 5:
                    return Vector.VECTOR_RIGHT_UP;
                case 6:
                    return Vector.VECTOR_LEFT_UP;
                case 8:
                    return Vector.VECTOR_DOWN;
                case 9:
                    return Vector.VECTOR_RIGHT_DOWN;
                case 10:
                    return Vector.VECTOR_LEFT_DOWN;
            }
        }

        public final Vector fromVelocity(VelocityTracker tracker) {
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            tracker.computeCurrentVelocity(1000);
            return new Vector(tracker.getXVelocity(), tracker.getYVelocity());
        }
    }
}
