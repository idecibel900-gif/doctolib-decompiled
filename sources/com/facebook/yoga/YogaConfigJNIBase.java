package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public abstract class YogaConfigJNIBase extends YogaConfig {
    long mNativePointer;

    private YogaConfigJNIBase(long j) {
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.mNativePointer = j;
    }

    YogaConfigJNIBase() {
        this(YogaNative.jni_YGConfigNewJNI());
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setPointScaleFactor(float f) {
        YogaNative.jni_YGConfigSetPointScaleFactorJNI(this.mNativePointer, f);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setErrata(YogaErrata yogaErrata) {
        YogaNative.jni_YGConfigSetErrataJNI(this.mNativePointer, yogaErrata.intValue());
    }
}
