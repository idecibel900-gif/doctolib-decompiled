package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DecayAnimation extends AnimationDriver {
    private int currentLoop;
    private double deceleration;
    private double fromValue;
    private int iterations;
    private double lastValue;
    private long startFrameTimeMillis;
    private double velocity;

    public DecayAnimation(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.startFrameTimeMillis = -1L;
        this.iterations = 1;
        this.currentLoop = 1;
        resetConfig(config);
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void resetConfig(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.velocity = config.getDouble("velocity");
        this.deceleration = config.getDouble("deceleration");
        this.startFrameTimeMillis = -1L;
        this.fromValue = 0.0d;
        this.lastValue = 0.0d;
        int i = config.hasKey("iterations") ? config.getInt("iterations") : 1;
        this.iterations = i;
        this.currentLoop = 1;
        this.hasFinished = i == 0;
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void runAnimationStep(long j) {
        ValueAnimatedNode valueAnimatedNode = this.animatedValue;
        if (valueAnimatedNode == null) {
            throw new IllegalArgumentException("Animated value should not be null");
        }
        long j2 = j / ((long) 1000000);
        if (this.startFrameTimeMillis == -1) {
            this.startFrameTimeMillis = j2 - ((long) 16);
            double d = this.fromValue;
            if (d == this.lastValue) {
                this.fromValue = valueAnimatedNode.nodeValue;
            } else {
                valueAnimatedNode.nodeValue = d;
            }
            this.lastValue = valueAnimatedNode.nodeValue;
        }
        double d2 = this.fromValue;
        double d3 = this.velocity;
        double d4 = 1;
        double d5 = this.deceleration;
        double dExp = d2 + ((d3 / (d4 - d5)) * (d4 - Math.exp((-(d4 - d5)) * (j2 - this.startFrameTimeMillis))));
        if (Math.abs(this.lastValue - dExp) < 0.1d) {
            int i = this.iterations;
            if (i == -1 || this.currentLoop < i) {
                this.startFrameTimeMillis = -1L;
                this.currentLoop++;
            } else {
                this.hasFinished = true;
                return;
            }
        }
        this.lastValue = dExp;
        valueAnimatedNode.nodeValue = dExp;
    }
}
