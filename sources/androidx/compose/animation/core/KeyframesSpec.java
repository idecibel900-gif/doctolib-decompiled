package androidx.compose.animation.core;

import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class KeyframesSpec implements DurationBasedAnimationSpec {
    private final KeyframesSpecConfig config;

    public KeyframesSpec(KeyframesSpecConfig keyframesSpecConfig) {
        this.config = keyframesSpecConfig;
    }

    public static final class KeyframesSpecConfig extends KeyframesSpecBaseConfig {
        public KeyframesSpecConfig() {
            super(null);
        }

        public KeyframeEntity at(Object obj, int i) {
            KeyframeEntity keyframeEntity = new KeyframeEntity(obj, null, 0, 6, null);
            getKeyframes$animation_core_release().set(i, keyframeEntity);
            return keyframeEntity;
        }
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public VectorizedKeyframesSpec vectorize(TwoWayConverter twoWayConverter) {
        long[] jArr;
        int[] iArr;
        MutableIntList mutableIntList = new MutableIntList(this.config.getKeyframes$animation_core_release().getSize() + 2);
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(this.config.getKeyframes$animation_core_release().getSize());
        MutableIntObjectMap keyframes$animation_core_release = this.config.getKeyframes$animation_core_release();
        int[] iArr2 = keyframes$animation_core_release.keys;
        Object[] objArr = keyframes$animation_core_release.values;
        long[] jArr2 = keyframes$animation_core_release.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr2[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8;
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    int i4 = 0;
                    while (i4 < i3) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            int i6 = iArr2[i5];
                            KeyframeEntity keyframeEntity = (KeyframeEntity) objArr[i5];
                            mutableIntList.add(i6);
                            mutableIntObjectMap.set(i6, new VectorizedKeyframeSpecElementInfo((AnimationVector) twoWayConverter.getConvertToVector().invoke(keyframeEntity.getValue$animation_core_release()), keyframeEntity.getEasing$animation_core_release(), keyframeEntity.m74getArcMode9TMq4$animation_core_release(), null));
                        }
                        j >>= i2;
                        i4++;
                        i2 = i2;
                        jArr2 = jArr2;
                        iArr2 = iArr2;
                    }
                    jArr = jArr2;
                    iArr = iArr2;
                    if (i3 != i2) {
                        break;
                    }
                } else {
                    jArr = jArr2;
                    iArr = iArr2;
                }
                if (i == length) {
                    break;
                }
                i++;
                jArr2 = jArr;
                iArr2 = iArr;
            }
        }
        if (!this.config.getKeyframes$animation_core_release().contains(0)) {
            mutableIntList.add(0, 0);
        }
        if (!this.config.getKeyframes$animation_core_release().contains(this.config.getDurationMillis())) {
            mutableIntList.add(this.config.getDurationMillis());
        }
        mutableIntList.sort();
        return new VectorizedKeyframesSpec(mutableIntList, mutableIntObjectMap, this.config.getDurationMillis(), this.config.getDelayMillis(), EasingKt.getLinearEasing(), ArcMode.Companion.m72getArcLinear9TMq4(), null);
    }

    public static final class KeyframeEntity extends KeyframeBaseEntity {
        private int arcMode;

        public /* synthetic */ KeyframeEntity(Object obj, Easing easing, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, easing, i);
        }

        public /* synthetic */ KeyframeEntity(Object obj, Easing easing, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i2 & 2) != 0 ? EasingKt.getLinearEasing() : easing, (i2 & 4) != 0 ? ArcMode.Companion.m72getArcLinear9TMq4() : i, null);
        }

        /* JADX INFO: renamed from: getArcMode--9T-Mq4$animation_core_release, reason: not valid java name */
        public final int m74getArcMode9TMq4$animation_core_release() {
            return this.arcMode;
        }

        private KeyframeEntity(Object obj, Easing easing, int i) {
            super(obj, easing, null);
            this.arcMode = i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof KeyframeEntity)) {
                return false;
            }
            KeyframeEntity keyframeEntity = (KeyframeEntity) obj;
            return Intrinsics.areEqual(keyframeEntity.getValue$animation_core_release(), getValue$animation_core_release()) && Intrinsics.areEqual(keyframeEntity.getEasing$animation_core_release(), getEasing$animation_core_release()) && ArcMode.m69equalsimpl0(keyframeEntity.arcMode, this.arcMode);
        }

        public int hashCode() {
            Object value$animation_core_release = getValue$animation_core_release();
            return ((((value$animation_core_release != null ? value$animation_core_release.hashCode() : 0) * 31) + ArcMode.m70hashCodeimpl(this.arcMode)) * 31) + getEasing$animation_core_release().hashCode();
        }
    }
}
