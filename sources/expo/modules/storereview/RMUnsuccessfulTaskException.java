package expo.modules.storereview;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class RMUnsuccessfulTaskException extends CodedException {
    public RMUnsuccessfulTaskException() {
        super("Android ReviewManager task was not successful", null, 2, null);
    }
}
