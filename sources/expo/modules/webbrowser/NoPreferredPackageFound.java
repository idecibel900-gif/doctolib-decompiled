package expo.modules.webbrowser;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes5.dex */
public final class NoPreferredPackageFound extends CodedException {
    public NoPreferredPackageFound() {
        super("PREFERRED_PACKAGE_NOT_FOUND", "Cannot determine preferred package without satisfying it", null);
    }
}
