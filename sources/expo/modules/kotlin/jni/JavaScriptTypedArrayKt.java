package expo.modules.kotlin.jni;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JavaScriptTypedArrayKt {
    private static int nextValue = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nextValue() {
        int i = nextValue;
        nextValue = i + 1;
        return i;
    }
}
