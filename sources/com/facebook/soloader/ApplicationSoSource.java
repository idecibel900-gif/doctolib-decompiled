package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class ApplicationSoSource extends SoSource implements RecoverableSoSource {
    private final int flags;
    private DirectorySoSource soSource;

    public ApplicationSoSource(Context context, int i) {
        this.flags = i;
        this.soSource = new DirectorySoSource(getNativeLibDirFromContext(context), i);
    }

    private static File getNativeLibDirFromContext(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        return this.soSource.loadLibrary(str, i, threadPolicy);
    }

    @Override // com.facebook.soloader.SoSource
    protected void prepare(int i) {
        this.soSource.prepare(i);
    }

    @Override // com.facebook.soloader.SoSource
    public String getName() {
        return "ApplicationSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        return getName() + "[" + this.soSource.toString() + "]";
    }

    @Override // com.facebook.soloader.RecoverableSoSource
    public SoSource recover(Context context) {
        this.soSource = new DirectorySoSource(getNativeLibDirFromContext(context), this.flags | 1);
        return this;
    }
}
