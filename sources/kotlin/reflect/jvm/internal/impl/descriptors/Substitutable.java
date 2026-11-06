package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* JADX INFO: loaded from: classes5.dex */
public interface Substitutable {
    DeclarationDescriptorNonRoot substitute(TypeSubstitutor typeSubstitutor);
}
