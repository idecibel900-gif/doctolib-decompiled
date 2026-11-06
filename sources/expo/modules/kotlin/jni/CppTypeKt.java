package expo.modules.kotlin.jni;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CppTypeKt {
    private static int nextValue;

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nextValue() {
        int i = nextValue;
        int i2 = 1 << i;
        nextValue = i + 1;
        return i2;
    }
}
