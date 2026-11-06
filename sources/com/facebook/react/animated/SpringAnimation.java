package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SpringAnimation extends AnimationDriver {
    public static final Companion Companion = new Companion(null);
    private int currentLoop;
    private final PhysicsState currentState;
    private double displacementFromRestThreshold;
    private double endValue;
    private double initialVelocity;
    private int iterations;
    private long lastTime;
    private double originalValue;
    private boolean overshootClampingEnabled;
    private double restSpeedThreshold;
    private double springDamping;
    private double springMass;
    private boolean springStarted;
    private double springStiffness;
    private double startValue;
    private double timeAccumulator;

    public SpringAnimation(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        PhysicsState physicsState = new PhysicsState(0.0d, 0.0d, 3, null);
        this.currentState = physicsState;
        physicsState.setVelocity(config.getDouble("initialVelocity"));
        resetConfig(config);
    }

    private static final class PhysicsState {
        private double position;
        private double velocity;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PhysicsState)) {
                return false;
            }
            PhysicsState physicsState = (PhysicsState) obj;
            return Double.compare(this.position, physicsState.position) == 0 && Double.compare(this.velocity, physicsState.velocity) == 0;
        }

        public int hashCode() {
            return (Double.hashCode(this.position) * 31) + Double.hashCode(this.velocity);
        }

        public String toString() {
            return "PhysicsState(position=" + this.position + ", velocity=" + this.velocity + ")";
        }

        public PhysicsState(double d, double d2) {
            this.position = d;
            this.velocity = d2;
        }

        public /* synthetic */ PhysicsState(double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2);
        }

        public final double getPosition() {
            return this.position;
        }

        public final double getVelocity() {
            return this.velocity;
        }

        public final void setPosition(double d) {
            this.position = d;
        }

        public final void setVelocity(double d) {
            this.velocity = d;
        }
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void resetConfig(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.springStiffness = config.getDouble("stiffness");
        this.springDamping = config.getDouble("damping");
        this.springMass = config.getDouble("mass");
        this.initialVelocity = this.currentState.getVelocity();
        this.endValue = config.getDouble("toValue");
        this.restSpeedThreshold = config.getDouble("restSpeedThreshold");
        this.displacementFromRestThreshold = config.getDouble("restDisplacementThreshold");
        this.overshootClampingEnabled = config.getBoolean("overshootClamping");
        int i = config.hasKey("iterations") ? config.getInt("iterations") : 1;
        this.iterations = i;
        this.hasFinished = i == 0;
        this.currentLoop = 0;
        this.timeAccumulator = 0.0d;
        this.springStarted = false;
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void runAnimationStep(long j) {
        ValueAnimatedNode valueAnimatedNode = this.animatedValue;
        if (valueAnimatedNode == null) {
            throw new IllegalArgumentException("Animated value should not be null");
        }
        long j2 = j / ((long) 1000000);
        if (!this.springStarted) {
            if (this.currentLoop == 0) {
                this.originalValue = valueAnimatedNode.nodeValue;
                this.currentLoop = 1;
            }
            this.currentState.setPosition(valueAnimatedNode.nodeValue);
            this.startValue = this.currentState.getPosition();
            this.lastTime = j2;
            this.timeAccumulator = 0.0d;
            this.springStarted = true;
        }
        advance((j2 - this.lastTime) / 1000.0d);
        this.lastTime = j2;
        valueAnimatedNode.nodeValue = this.currentState.getPosition();
        if (isAtRest()) {
            int i = this.iterations;
            if (i == -1 || this.currentLoop < i) {
                this.springStarted = false;
                valueAnimatedNode.nodeValue = this.originalValue;
                this.currentLoop++;
                return;
            }
            this.hasFinished = true;
        }
    }

    private final double getDisplacementDistanceForState(PhysicsState physicsState) {
        return Math.abs(this.endValue - physicsState.getPosition());
    }

    private final boolean isAtRest() {
        if (Math.abs(this.currentState.getVelocity()) <= this.restSpeedThreshold) {
            return getDisplacementDistanceForState(this.currentState) <= this.displacementFromRestThreshold || this.springStiffness == 0.0d;
        }
        return false;
    }

    private final boolean isOvershooting() {
        if (this.springStiffness <= 0.0d) {
            return false;
        }
        if (this.startValue >= this.endValue || this.currentState.getPosition() <= this.endValue) {
            return this.startValue > this.endValue && this.currentState.getPosition() < this.endValue;
        }
        return true;
    }

    private final void advance(double d) {
        double dSin;
        double dSin2;
        if (isAtRest()) {
            return;
        }
        this.timeAccumulator += d <= 0.064d ? d : 0.064d;
        double d2 = this.springDamping;
        double d3 = this.springMass;
        double d4 = this.springStiffness;
        double d5 = -this.initialVelocity;
        double dSqrt = d2 / (((double) 2) * Math.sqrt(d4 * d3));
        double dSqrt2 = Math.sqrt(d4 / d3);
        double dSqrt3 = Math.sqrt(1.0d - (dSqrt * dSqrt)) * dSqrt2;
        double d6 = this.endValue - this.startValue;
        double d7 = this.timeAccumulator;
        if (dSqrt < 1.0d) {
            double dExp = Math.exp((-dSqrt) * dSqrt2 * d7);
            double d8 = dSqrt2 * dSqrt;
            double d9 = d5 + (d8 * d6);
            double d10 = d7 * dSqrt3;
            dSin2 = this.endValue - ((((d9 / dSqrt3) * Math.sin(d10)) + (Math.cos(d10) * d6)) * dExp);
            dSin = ((d8 * dExp) * (((Math.sin(d10) * d9) / dSqrt3) + (Math.cos(d10) * d6))) - (dExp * ((Math.cos(d10) * d9) - ((dSqrt3 * d6) * Math.sin(d10))));
        } else {
            double dExp2 = Math.exp((-dSqrt2) * d7);
            double d11 = this.endValue - (((((dSqrt2 * d6) + d5) * d7) + d6) * dExp2);
            dSin = dExp2 * ((d5 * ((d7 * dSqrt2) - ((double) 1))) + (d7 * d6 * dSqrt2 * dSqrt2));
            dSin2 = d11;
        }
        this.currentState.setPosition(dSin2);
        this.currentState.setVelocity(dSin);
        if (isAtRest() || (this.overshootClampingEnabled && isOvershooting())) {
            if (this.springStiffness > 0.0d) {
                double d12 = this.endValue;
                this.startValue = d12;
                this.currentState.setPosition(d12);
            } else {
                double position = this.currentState.getPosition();
                this.endValue = position;
                this.startValue = position;
            }
            this.currentState.setVelocity(0.0d);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
