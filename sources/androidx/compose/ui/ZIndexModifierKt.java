package androidx.compose.ui;

/* JADX INFO: loaded from: classes.dex */
public abstract class ZIndexModifierKt {
    public static final Modifier zIndex(Modifier modifier, float f) {
        return modifier.then(new ZIndexElement(f));
    }
}
