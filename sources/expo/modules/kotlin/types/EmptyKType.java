package expo.modules.kotlin.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class EmptyKType implements KType {
    private final KClass classifier;
    private final boolean isMarkedNullable;

    public EmptyKType(KClass classifier, boolean z) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        this.classifier = classifier;
        this.isMarkedNullable = z;
    }

    @Override // kotlin.reflect.KType
    public KClass getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    public List getArguments() {
        return CollectionsKt.emptyList();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmptyKType)) {
            return false;
        }
        EmptyKType emptyKType = (EmptyKType) obj;
        return Intrinsics.areEqual(getClassifier(), emptyKType.getClassifier()) && isMarkedNullable() == emptyKType.isMarkedNullable();
    }

    public int hashCode() {
        return (getClassifier().hashCode() * 31) + Boolean.hashCode(isMarkedNullable());
    }
}
