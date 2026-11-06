package expo.modules.application;

import android.content.pm.PackageManager;
import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ApplicationPackageNameNotFoundException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationPackageNameNotFoundException(PackageManager.NameNotFoundException cause) {
        super("Unable to get install time of this application. Could not get package info or package name.", cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
