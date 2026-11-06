package expo.modules.image;

import com.bumptech.glide.load.Option;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CustomOptions {
    public static final CustomOptions INSTANCE = new CustomOptions();
    private static final Option tintColor;

    private CustomOptions() {
    }

    static {
        Option optionMemory = Option.memory("ExpoTintColor");
        Intrinsics.checkNotNullExpressionValue(optionMemory, "memory(...)");
        tintColor = optionMemory;
    }

    public final Option getTintColor() {
        return tintColor;
    }
}
