package kotlin.reflect;

/* JADX INFO: loaded from: classes5.dex */
public interface KProperty extends KCallable {

    public interface Accessor {
        KProperty getProperty();
    }

    public interface Getter extends Accessor, KFunction {
    }

    Getter getGetter();

    boolean isConst();

    boolean isLateinit();
}
