package com.facebook.soloader;

import android.os.StrictMode;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DirectorySoSource extends SoSource {
    protected final List denyList;
    protected int flags;
    protected final File soDirectory;

    public DirectorySoSource(File file, int i) {
        this(file, i, new String[0]);
    }

    public void setExplicitDependencyResolution() {
        this.flags |= 1;
    }

    public DirectorySoSource(File file, int i, String[] strArr) {
        this.soDirectory = file;
        this.flags = i;
        this.denyList = Arrays.asList(strArr);
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
    }

    protected int loadLibraryFrom(String str, int i, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.sSoFileLoader == null) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
        if (this.denyList.contains(str)) {
            LogUtil.d("SoLoader", str + " is on the denyList, skip loading from " + file.getCanonicalPath());
            return 0;
        }
        File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            LogUtil.v("SoLoader", str + " file not found on " + file.getCanonicalPath());
            return 0;
        }
        String canonicalPath = soFileByName.getCanonicalPath();
        LogUtil.d("SoLoader", str + " file found at " + canonicalPath);
        if ((i & 1) != 0 && (this.flags & 2) != 0) {
            LogUtil.d("SoLoader", str + " loaded implicitly");
            return 2;
        }
        if ((this.flags & 1) != 0) {
            ElfFileChannel elfFileChannel = new ElfFileChannel(soFileByName);
            try {
                NativeDeps.loadDependencies(str, elfFileChannel, i, threadPolicy);
                elfFileChannel.close();
            } catch (Throwable th) {
                try {
                    elfFileChannel.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } else {
            LogUtil.d("SoLoader", "Not resolving dependencies for " + str);
        }
        try {
            SoLoader.sSoFileLoader.load(canonicalPath, i);
            return 1;
        } catch (UnsatisfiedLinkError e) {
            throw SoLoaderULErrorFactory.create(str, e);
        }
    }

    public File getSoFileByName(String str) {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    public String getName() {
        return "DirectorySoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            name = this.soDirectory.getName();
        }
        return getName() + "[root = " + name + " flags = " + this.flags + ']';
    }
}
