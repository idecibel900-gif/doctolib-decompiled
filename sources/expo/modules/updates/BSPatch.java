package expo.modules.updates;

import com.facebook.jni.annotations.DoNotStrip;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0087 ¨\u0006\n"}, d2 = {"Lexpo/modules/updates/BSPatch;", "", "<init>", "()V", "applyPatch", "", "oldFilePath", "", "newFilePath", "patchFilePath", "expo-updates_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BSPatch {
    public static final BSPatch INSTANCE = new BSPatch();

    @DoNotStrip
    public static final native int applyPatch(String oldFilePath, String newFilePath, String patchFilePath);

    private BSPatch() {
    }

    static {
        System.loadLibrary("expo-updates");
    }
}
