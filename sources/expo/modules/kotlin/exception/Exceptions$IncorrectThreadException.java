package expo.modules.kotlin.exception;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Exceptions$IncorrectThreadException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Exceptions$IncorrectThreadException(String currentThreadName, String expectedThreadName) {
        super("Expected to run on " + expectedThreadName + " thread, but was run on " + currentThreadName, null, 2, null);
        Intrinsics.checkNotNullParameter(currentThreadName, "currentThreadName");
        Intrinsics.checkNotNullParameter(expectedThreadName, "expectedThreadName");
    }
}
