package expo.modules.haptics.arguments;

/* JADX INFO: loaded from: classes4.dex */
public abstract class HapticsSelectionTypeKt {
    private static final HapticsVibrationType HapticsSelectionType = new HapticsVibrationType(new long[]{0, 50}, new int[]{0, 30}, new long[]{0, 70});

    public static final HapticsVibrationType getHapticsSelectionType() {
        return HapticsSelectionType;
    }
}
