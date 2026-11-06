package androidx.compose.material3;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class FadeInFadeOutAnimationItem {
    private final Object key;
    private final Function3 transition;

    public final Object component1() {
        return this.key;
    }

    public final Function3 component2() {
        return this.transition;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FadeInFadeOutAnimationItem)) {
            return false;
        }
        FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) obj;
        return Intrinsics.areEqual(this.key, fadeInFadeOutAnimationItem.key) && Intrinsics.areEqual(this.transition, fadeInFadeOutAnimationItem.transition);
    }

    public int hashCode() {
        Object obj = this.key;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.transition.hashCode();
    }

    public String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.key + ", transition=" + this.transition + ')';
    }

    public FadeInFadeOutAnimationItem(Object obj, Function3 function3) {
        this.key = obj;
        this.transition = function3;
    }

    public final Object getKey() {
        return this.key;
    }
}
