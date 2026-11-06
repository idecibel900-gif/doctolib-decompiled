package expo.modules.kotlin.types;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TypeConverterProviderKt {
    public static final TypeConverterProvider mergeWith(TypeConverterProvider typeConverterProvider, TypeConverterProvider otherProvider) {
        Intrinsics.checkNotNullParameter(typeConverterProvider, "<this>");
        Intrinsics.checkNotNullParameter(otherProvider, "otherProvider");
        return new MergedTypeConverterProvider(CollectionsKt.listOf((Object[]) new TypeConverterProvider[]{typeConverterProvider, otherProvider}));
    }

    public static final TypeConverterProvider mergeWithDefault(TypeConverterProvider typeConverterProvider) {
        TypeConverterProvider typeConverterProviderMergeWith;
        return (typeConverterProvider == null || (typeConverterProviderMergeWith = mergeWith(typeConverterProvider, TypeConverterProviderImpl.INSTANCE)) == null) ? TypeConverterProviderImpl.INSTANCE : typeConverterProviderMergeWith;
    }
}
