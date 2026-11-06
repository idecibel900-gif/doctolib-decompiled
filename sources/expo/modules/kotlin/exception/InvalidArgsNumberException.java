package expo.modules.kotlin.exception;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/exception/InvalidArgsNumberException;", "Lexpo/modules/kotlin/exception/CodedException;", "received", "", "expected", "required", "<init>", "(III)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InvalidArgsNumberException extends CodedException {
    /* JADX WARN: Illegal instructions before constructor call */
    public InvalidArgsNumberException(int i, int i2, int i3) {
        String str;
        if (i3 < i2) {
            str = "Received " + i + " arguments, but " + i2 + " was expected and at least " + i3 + " is required";
        } else {
            str = "Received " + i + " arguments, but " + i2 + " was expected";
        }
        super(str, null, 2, null);
    }
}
