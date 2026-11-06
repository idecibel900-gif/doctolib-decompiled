package com.swmansion.enriched.markdown.spoiler;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SpoilerParticleDrawable {
    private float accumulatedPrimaryBirths;
    private float accumulatedSecondaryBirths;
    private final int colorBlue;
    private final int colorGreen;
    private final int colorRed;
    private final float densityFactor;
    private float height;
    private boolean isRevealing;
    private int particleCount;
    private float primaryBirthRate;
    private Function0 revealCallback;
    private boolean revealFinished;
    private float secondaryBirthRate;
    private final float speedFactor;
    private float width;
    public static final Companion Companion = new Companion(null);
    private static final float TWO_PI = 6.2831855f;
    private static final DotType PRIMARY_DOT = new DotType(1.6f, 8.0f, 0.25f, -0.25f, 0.013f);
    private static final DotType SECONDARY_DOT = new DotType(1.2f, 12.0f, 0.18f, -0.3f, 0.007f);
    private float[] particleData = new float[576];
    private final Paint paint = new Paint(1);
    private long revealStartTime = -1;
    private float overallAlpha = 1.0f;

    public SpoilerParticleDrawable(int i, float f, float f2) {
        this.colorRed = Color.red(i);
        this.colorGreen = Color.green(i);
        this.colorBlue = Color.blue(i);
        this.densityFactor = f / 8.0f;
        this.speedFactor = f2 / 20.0f;
    }

    public final float getOverallAlpha() {
        return this.overallAlpha;
    }

    public final void setSize(float f, float f2) {
        float f3 = this.width;
        boolean z = f3 <= 0.0f || this.height <= 0.0f;
        if (f == f3 && f2 == this.height) {
            return;
        }
        this.width = f;
        this.height = f2;
        float f4 = f * f2;
        this.primaryBirthRate = Math.max(3.0f, PRIMARY_DOT.getDensityFactor() * f4 * this.densityFactor);
        this.secondaryBirthRate = Math.max(1.5f, f4 * SECONDARY_DOT.getDensityFactor() * this.densityFactor);
        if (!z || f <= 0.0f || f2 <= 0.0f || this.isRevealing || this.particleCount != 0) {
            return;
        }
        seedInitialParticles();
    }

    public final void startReveal(Function0 onComplete) {
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        if (this.isRevealing) {
            return;
        }
        this.isRevealing = true;
        this.revealStartTime = -1L;
        this.revealCallback = onComplete;
        int i = this.particleCount;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 9;
            float[] fArr = this.particleData;
            int i4 = i3 + 2;
            fArr[i4] = fArr[i4] * 10.0f;
            int i5 = i3 + 3;
            fArr[i5] = fArr[i5] * 10.0f;
            int i6 = i3 + 5;
            fArr[i6] = fArr[i6] * 6.0f;
        }
    }

    public final void update(float f, long j) {
        if (this.revealFinished) {
            return;
        }
        if (!this.isRevealing) {
            spawnParticles(f);
        }
        updateAndCompact(f);
        if (this.isRevealing) {
            if (this.revealStartTime < 0) {
                this.revealStartTime = j;
            }
            float fCoerceIn = RangesKt.coerceIn((j - this.revealStartTime) / 450, 0.0f, 1.0f);
            float f2 = 1.0f - fCoerceIn;
            this.overallAlpha = f2 * f2;
            if (fCoerceIn >= 1.0f) {
                this.revealFinished = true;
                this.particleCount = 0;
                Function0 function0 = this.revealCallback;
                if (function0 != null) {
                    function0.invoke();
                }
                this.revealCallback = null;
            }
        }
    }

    public final void draw(Canvas canvas, float f, float f2) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.width <= 0.0f || this.height <= 0.0f || this.particleCount == 0) {
            return;
        }
        canvas.save();
        canvas.clipRect(f, f2, this.width + f, this.height + f2);
        int i = this.particleCount;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 9;
            int iCoerceIn = RangesKt.coerceIn((int) (this.particleData[i3 + 4] * this.overallAlpha * 255.0f), 0, 255);
            if (iCoerceIn > 0) {
                this.paint.setColor(Color.argb(iCoerceIn, this.colorRed, this.colorGreen, this.colorBlue));
                float[] fArr = this.particleData;
                canvas.drawCircle(fArr[i3] + f, fArr[i3 + 1] + f2, fArr[i3 + 6] * 3.0f, this.paint);
            }
        }
        canvas.restore();
    }

    private final void updateAndCompact(float f) {
        int i = this.particleCount;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * 9;
            float[] fArr = this.particleData;
            float f2 = fArr[i4 + 8] + f;
            float fCoerceIn = RangesKt.coerceIn(fArr[i4 + 4] + (fArr[i4 + 5] * f), 0.0f, 1.0f);
            float[] fArr2 = this.particleData;
            if (f2 < fArr2[i4 + 7] && fCoerceIn > 0.0f) {
                int i5 = i2 * 9;
                if (i5 != i4) {
                    System.arraycopy(fArr2, i4, fArr2, i5, 9);
                }
                float[] fArr3 = this.particleData;
                fArr3[i5] = fArr3[i5] + (fArr3[i5 + 2] * f);
                int i6 = i5 + 1;
                fArr3[i6] = fArr3[i6] + (fArr3[i5 + 3] * f);
                fArr3[i5 + 4] = fCoerceIn;
                fArr3[i5 + 8] = f2;
                i2++;
            }
        }
        this.particleCount = i2;
    }

    private final void seedInitialParticles() {
        for (int i = 0; i < 30; i++) {
            spawnParticles(0.016f);
            int i2 = this.particleCount;
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 * 9;
                float[] fArr = this.particleData;
                int i5 = i4 + 8;
                fArr[i5] = fArr[i5] + 0.016f;
                fArr[i4] = fArr[i4] + (fArr[i4 + 2] * 0.016f);
                int i6 = i4 + 1;
                fArr[i6] = fArr[i6] + (fArr[i4 + 3] * 0.016f);
                int i7 = i4 + 4;
                fArr[i7] = RangesKt.coerceIn(fArr[i7] + (fArr[i4 + 5] * 0.016f), 0.0f, 1.0f);
            }
        }
        updateAndCompact(0.0f);
    }

    private final void spawnParticles(float f) {
        this.accumulatedPrimaryBirths += this.primaryBirthRate * f;
        this.accumulatedSecondaryBirths += this.secondaryBirthRate * f;
        while (true) {
            float f2 = this.accumulatedPrimaryBirths;
            if (f2 < 1.0f) {
                break;
            }
            this.accumulatedPrimaryBirths = f2 - 1.0f;
            emitParticle(PRIMARY_DOT);
        }
        while (true) {
            float f3 = this.accumulatedSecondaryBirths;
            if (f3 < 1.0f) {
                return;
            }
            this.accumulatedSecondaryBirths = f3 - 1.0f;
            emitParticle(SECONDARY_DOT);
        }
    }

    private final void emitParticle(DotType dotType) {
        ensureCapacity(this.particleCount + 1);
        int i = this.particleCount * 9;
        Random.Default r1 = Random.Default;
        float fNextFloat = r1.nextFloat() * TWO_PI;
        float velocity = dotType.getVelocity() * this.speedFactor * (((r1.nextFloat() - 0.5f) * 0.5f * 2.0f) + 1.0f);
        this.particleData[i] = r1.nextFloat() * this.width;
        this.particleData[i + 1] = r1.nextFloat() * this.height;
        double d = fNextFloat;
        this.particleData[i + 2] = ((float) Math.cos(d)) * velocity;
        this.particleData[i + 3] = ((float) Math.sin(d)) * velocity;
        this.particleData[i + 4] = RangesKt.coerceIn((r1.nextFloat() * 0.2f * 2.0f) + 0.8f, 0.0f, 1.0f);
        this.particleData[i + 5] = dotType.getAlphaSpeed();
        this.particleData[i + 6] = dotType.getScale() * (((r1.nextFloat() - 0.5f) * 0.3f * 2.0f) + 1.0f);
        this.particleData[i + 7] = dotType.getLifetime() * (((r1.nextFloat() - 0.5f) * 0.3f * 2.0f) + 1.0f);
        this.particleData[i + 8] = 0.0f;
        this.particleCount++;
    }

    private final void ensureCapacity(int i) {
        int i2 = i * 9;
        float[] fArr = this.particleData;
        if (i2 <= fArr.length) {
            return;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, RangesKt.coerceAtLeast(fArr.length * 2, i2));
        Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
        this.particleData = fArrCopyOf;
    }

    private static final class DotType {
        private final float alphaSpeed;
        private final float densityFactor;
        private final float lifetime;
        private final float scale;
        private final float velocity;

        public DotType(float f, float f2, float f3, float f4, float f5) {
            this.lifetime = f;
            this.velocity = f2;
            this.scale = f3;
            this.alphaSpeed = f4;
            this.densityFactor = f5;
        }

        public final float getLifetime() {
            return this.lifetime;
        }

        public final float getVelocity() {
            return this.velocity;
        }

        public final float getScale() {
            return this.scale;
        }

        public final float getAlphaSpeed() {
            return this.alphaSpeed;
        }

        public final float getDensityFactor() {
            return this.densityFactor;
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
