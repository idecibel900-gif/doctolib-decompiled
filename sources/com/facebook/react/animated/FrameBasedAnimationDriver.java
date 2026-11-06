package com.facebook.react.animated;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.build.ReactBuildConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FrameBasedAnimationDriver extends AnimationDriver {
    public static final Companion Companion = new Companion(null);
    private int currentLoop;
    private double[] frames;
    private double fromValue;
    private int iterations;
    private int logCount;
    private long startFrameTimeNanos;
    private double toValue;

    public FrameBasedAnimationDriver(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.startFrameTimeNanos = -1L;
        this.frames = new double[0];
        this.iterations = 1;
        this.currentLoop = 1;
        resetConfig(config);
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void resetConfig(ReadableMap config) {
        int size;
        Intrinsics.checkNotNullParameter(config, "config");
        ReadableArray array = config.getArray("frames");
        if (array != null && this.frames.length != (size = array.size())) {
            double[] dArr = new double[size];
            for (int i = 0; i < size; i++) {
                dArr[i] = array.getDouble(i);
            }
            this.frames = dArr;
        }
        this.toValue = (config.hasKey("toValue") && config.getType("toValue") == ReadableType.Number) ? config.getDouble("toValue") : 0.0d;
        int i2 = (config.hasKey("iterations") && config.getType("iterations") == ReadableType.Number) ? config.getInt("iterations") : 1;
        this.iterations = i2;
        this.currentLoop = 1;
        this.hasFinished = i2 == 0;
        this.startFrameTimeNanos = -1L;
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void runAnimationStep(long j) {
        double d;
        ValueAnimatedNode valueAnimatedNode = this.animatedValue;
        if (valueAnimatedNode == null) {
            throw new IllegalArgumentException("Animated value should not be null");
        }
        if (this.startFrameTimeNanos < 0) {
            this.startFrameTimeNanos = j;
            if (this.currentLoop == 1) {
                this.fromValue = valueAnimatedNode.nodeValue;
            }
        }
        int iRound = (int) Math.round(((j - this.startFrameTimeNanos) / ((long) 1000000)) / 16.666666666666668d);
        if (iRound < 0) {
            String str = "Calculated frame index should never be lower than 0. Called with frameTimeNanos " + j + " and mStartFrameTimeNanos " + this.startFrameTimeNanos;
            if (ReactBuildConfig.DEBUG) {
                throw new IllegalStateException(str.toString());
            }
            if (this.logCount < 100) {
                FLog.w("ReactNative", str);
                this.logCount++;
                return;
            }
            return;
        }
        if (this.hasFinished) {
            return;
        }
        double[] dArr = this.frames;
        if (iRound >= dArr.length - 1) {
            int i = this.iterations;
            if (i == -1 || this.currentLoop < i) {
                double d2 = this.fromValue;
                d = d2 + (dArr[dArr.length - 1] * (this.toValue - d2));
                this.startFrameTimeNanos = -1L;
                this.currentLoop++;
            } else {
                d = this.toValue;
                this.hasFinished = true;
            }
        } else {
            double d3 = this.fromValue;
            d = d3 + (dArr[iRound] * (this.toValue - d3));
        }
        valueAnimatedNode.nodeValue = d;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
