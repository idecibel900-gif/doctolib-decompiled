package expo.modules.webbrowser;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes5.dex */
public final class PackageManagerNotFoundException extends CodedException {
    public PackageManagerNotFoundException() {
        super("Package Manager not found", null, 2, null);
    }
}
