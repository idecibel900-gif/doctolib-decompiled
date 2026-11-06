package expo.modules.kotlin.uuidv5;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidNamespaceException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidNamespaceException(String namespace) {
        super("Namespace: `" + namespace + "` is not a valid namespace. Namespace should be a valid UUID string", null, 2, null);
        Intrinsics.checkNotNullParameter(namespace, "namespace");
    }
}
