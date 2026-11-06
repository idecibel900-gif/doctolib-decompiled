package kotlin.reflect;

/* JADX INFO: loaded from: classes5.dex */
public interface KMutableProperty extends KProperty {

    public interface Setter extends KProperty.Accessor, KFunction {
    }

    Setter getSetter();
}
