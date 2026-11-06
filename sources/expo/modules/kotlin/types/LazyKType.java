package expo.modules.kotlin.types;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class LazyKType implements KType {
    private KType _kType;
    private final KClass classifier;
    private final boolean isMarkedNullable;
    private final Function0 kTypeProvider;

    public LazyKType(KClass classifier, boolean z, Function0 kTypeProvider) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(kTypeProvider, "kTypeProvider");
        this.classifier = classifier;
        this.isMarkedNullable = z;
        this.kTypeProvider = kTypeProvider;
    }

    public /* synthetic */ LazyKType(KClass kClass, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, (i & 2) != 0 ? false : z, function0);
    }

    @Override // kotlin.reflect.KType
    public KClass getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    private final KType getKType() {
        if (this._kType == null) {
            this._kType = (KType) this.kTypeProvider.invoke();
        }
        KType kType = this._kType;
        Intrinsics.checkNotNull(kType);
        return kType;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List getAnnotations() {
        return getKType().getAnnotations();
    }

    @Override // kotlin.reflect.KType
    public List getArguments() {
        return getKType().getArguments();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyKType)) {
            return Intrinsics.areEqual(getKType(), obj);
        }
        LazyKType lazyKType = (LazyKType) obj;
        return Intrinsics.areEqual(getClassifier(), lazyKType.getClassifier()) && isMarkedNullable() == lazyKType.isMarkedNullable();
    }

    public int hashCode() {
        return (getClassifier().hashCode() * 31) + Boolean.hashCode(isMarkedNullable());
    }

    public String toString() {
        return getKType().toString();
    }
}
