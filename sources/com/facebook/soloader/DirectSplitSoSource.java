package com.facebook.soloader;

import android.os.StrictMode;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class DirectSplitSoSource extends SoSource {
    protected final String mSplitName;
    protected Manifest mManifest = null;
    protected Set mLibs = null;

    public DirectSplitSoSource(String str) {
        this.mSplitName = str;
    }

    @Override // com.facebook.soloader.SoSource
    protected void prepare(int i) throws IOException {
        InputStream inputStreamOpen = SoLoader.sApplicationContext.getAssets().open(this.mSplitName + ".soloader-manifest");
        try {
            this.mManifest = Manifest.read(inputStreamOpen);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            this.mLibs = new HashSet(this.mManifest.libs);
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        Set set = this.mLibs;
        if (set == null) {
            throw new IllegalStateException("prepare not called");
        }
        if (set.contains(str)) {
            return loadLibraryImpl(str, i);
        }
        return 0;
    }

    protected int loadLibraryImpl(String str, int i) {
        String libraryPath = getLibraryPath(str);
        libraryPath.getClass();
        System.load(libraryPath);
        return 1;
    }

    public String getLibraryPath(String str) {
        Set set = this.mLibs;
        if (set == null || this.mManifest == null) {
            throw new IllegalStateException("prepare not called");
        }
        if (!set.contains(str)) {
            return null;
        }
        return getSplitPath(this.mSplitName) + "!/lib/" + this.mManifest.arch + "/" + str;
    }

    static String getSplitPath(String str) {
        if ("base".equals(str)) {
            return SoLoader.sApplicationContext.getApplicationInfo().sourceDir;
        }
        String[] strArr = SoLoader.sApplicationContext.getApplicationInfo().splitSourceDirs;
        if (strArr == null) {
            throw new IllegalStateException("No splits avaiable");
        }
        String str2 = "split_" + str + ".apk";
        for (String str3 : strArr) {
            if (str3.endsWith(str2)) {
                return str3;
            }
        }
        throw new IllegalStateException("Could not find " + str + " split");
    }

    @Override // com.facebook.soloader.SoSource
    public String getName() {
        return "DirectSplitSoSource";
    }
}
