package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UnpackingSoSource extends DirectorySoSource implements AsyncInitSoSource {
    private String[] mAbis;
    protected final Context mContext;

    private static boolean forceRefresh(int i) {
        return (i & 2) != 0;
    }

    private static boolean rewriteStateAsync(int i) {
        return (i & 1) != 0;
    }

    protected abstract Unpacker makeUnpacker();

    protected UnpackingSoSource(Context context, String str, boolean z) {
        super(getSoStorePath(context, str), z ? 1 : 0);
        this.mContext = context;
    }

    protected UnpackingSoSource(Context context, String str) {
        this(context, str, true);
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    public Dso[] getDsosBaseApk() {
        Unpacker unpackerMakeUnpacker = makeUnpacker();
        try {
            Dso[] dsos = unpackerMakeUnpacker.getDsos();
            unpackerMakeUnpacker.close();
            return dsos;
        } catch (Throwable th) {
            if (unpackerMakeUnpacker != null) {
                try {
                    unpackerMakeUnpacker.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    protected static final class InputDso implements Closeable {
        private final InputStream content;
        private final Dso dso;

        public InputDso(Dso dso, InputStream inputStream) {
            this.dso = dso;
            this.content = inputStream;
        }

        public Dso getDso() {
            return this.dso;
        }

        public int available() {
            return this.content.available();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.content.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeState(File file, byte b, boolean z) throws IOException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.seek(0L);
                randomAccessFile.write(b);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (z) {
                    randomAccessFile.getFD().sync();
                }
                randomAccessFile.close();
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (SyncFailedException e) {
            LogUtil.w("fb-UnpackingSoSource", "state file sync failed", e);
        }
    }

    private void deleteSoFiles() throws IOException {
        File[] fileArrListFiles = this.soDirectory.listFiles(new FilenameFilter() { // from class: com.facebook.soloader.UnpackingSoSource.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return (str.equals("dso_state") || str.equals("dso_lock") || str.equals("dso_deps")) ? false : true;
            }
        });
        if (fileArrListFiles == null) {
            throw new IOException("unable to list directory " + this.soDirectory);
        }
        for (File file : fileArrListFiles) {
            LogUtil.v("fb-UnpackingSoSource", "Deleting " + file);
            SysUtil.dumbDelete(file);
        }
    }

    protected static abstract class Unpacker implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public abstract Dso[] getDsos();

        public abstract void unpack(File file);

        protected Unpacker() {
        }

        public void extractDso(InputDso inputDso, byte[] bArr, File file) {
            LogUtil.i("fb-UnpackingSoSource", "extracting DSO " + inputDso.getDso().name);
            File file2 = new File(file, inputDso.getDso().name);
            try {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                    try {
                        int iAvailable = inputDso.available();
                        if (iAvailable > 1) {
                            SysUtil.fallocateIfSupported(randomAccessFile.getFD(), iAvailable);
                        }
                        SysUtil.copyBytes(randomAccessFile, inputDso.content, Integer.MAX_VALUE, bArr);
                        randomAccessFile.setLength(randomAccessFile.getFilePointer());
                        if (!file2.setExecutable(true, false)) {
                            throw new IOException("cannot make file executable: " + file2);
                        }
                        randomAccessFile.close();
                        if (!file2.exists() || file2.setWritable(false)) {
                            return;
                        }
                        LogUtil.e("SoLoader", "Error removing " + file2 + " write permission from directory " + file + " (writable: " + file.canWrite() + ")");
                    } catch (Throwable th) {
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } catch (IOException e) {
                    LogUtil.e("fb-UnpackingSoSource", "error extracting dso  " + file2 + " due to: " + e);
                    SysUtil.dumbDelete(file2);
                    throw e;
                }
            } catch (Throwable th3) {
                if (file2.exists() && !file2.setWritable(false)) {
                    LogUtil.e("SoLoader", "Error removing " + file2 + " write permission from directory " + file + " (writable: " + file.canWrite() + ")");
                }
                throw th3;
            }
        }
    }

    protected boolean depsChanged(byte[] bArr, byte[] bArr2) {
        return !Arrays.equals(bArr, bArr2);
    }

    protected boolean depsChanged(byte[] bArr) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.soDirectory, "dso_deps"), "rw");
            try {
                if (randomAccessFile.length() != 0) {
                    int length = (int) randomAccessFile.length();
                    byte[] bArr2 = new byte[length];
                    if (randomAccessFile.read(bArr2) != length) {
                        LogUtil.v("fb-UnpackingSoSource", "short read of so store deps file: marking unclean");
                    } else {
                        boolean zDepsChanged = depsChanged(bArr2, bArr);
                        randomAccessFile.close();
                        return zDepsChanged;
                    }
                }
                randomAccessFile.close();
                return true;
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            LogUtil.w("fb-UnpackingSoSource", "failed to compare whether deps changed", e);
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0073  */
    private boolean refreshLocked(final FileLocker fileLocker, int i) throws IOException {
        byte b;
        final File file = new File(this.soDirectory, "dso_state");
        byte[] depsBlock = getDepsBlock();
        if (forceRefresh(i) || depsChanged(depsBlock)) {
            b = 0;
        } else {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                if (randomAccessFile.length() == 1) {
                    try {
                        b = randomAccessFile.readByte();
                        if (b == 1) {
                            LogUtil.v("fb-UnpackingSoSource", "dso store " + this.soDirectory + " regeneration not needed: state file clean");
                        } else {
                            b = 0;
                        }
                    } catch (IOException e) {
                        LogUtil.v("fb-UnpackingSoSource", "dso store " + this.soDirectory + " regeneration interrupted: " + e.getMessage());
                    }
                } else {
                    b = 0;
                }
                randomAccessFile.close();
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (b == 1) {
            return false;
        }
        final boolean z = (i & 4) == 0;
        LogUtil.v("fb-UnpackingSoSource", "so store dirty: regenerating");
        writeState(file, (byte) 0, z);
        deleteSoFiles();
        Unpacker unpackerMakeUnpacker = makeUnpacker();
        try {
            unpackerMakeUnpacker.unpack(this.soDirectory);
            unpackerMakeUnpacker.close();
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File(this.soDirectory, "dso_deps"), "rw");
            try {
                randomAccessFile2.write(depsBlock);
                randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                randomAccessFile2.close();
                Runnable runnable = new Runnable() { // from class: com.facebook.soloader.UnpackingSoSource.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtil.v("fb-UnpackingSoSource", "starting syncer worker");
                        try {
                            try {
                                if (z) {
                                    SysUtil.fsyncAll(UnpackingSoSource.this.soDirectory);
                                }
                                UnpackingSoSource.writeState(file, (byte) 1, z);
                            } finally {
                                LogUtil.v("fb-UnpackingSoSource", "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                                fileLocker.close();
                            }
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                };
                if (rewriteStateAsync(i)) {
                    new Thread(runnable, "SoSync:" + this.soDirectory.getName()).start();
                } else {
                    runnable.run();
                }
                return true;
            } catch (Throwable th3) {
                try {
                    randomAccessFile2.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Throwable th5) {
            if (unpackerMakeUnpacker != null) {
                try {
                    unpackerMakeUnpacker.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }

    @Override // com.facebook.soloader.AsyncInitSoSource
    public void waitUntilInitCompleted() throws Throwable {
        try {
            FileLocker orCreateLockOnDir = SysUtil.getOrCreateLockOnDir(this.soDirectory, new File(this.soDirectory, "dso_lock"));
            if (orCreateLockOnDir != null) {
                orCreateLockOnDir.close();
            }
        } catch (Exception e) {
            LogUtil.e("fb-UnpackingSoSource", "Encountered exception during wait for unpacking trying to acquire file lock for " + getClass().getName() + " (" + this.soDirectory + "): ", e);
        }
    }

    protected byte[] getDepsBlock() {
        Parcel parcelObtain = Parcel.obtain();
        Unpacker unpackerMakeUnpacker = makeUnpacker();
        try {
            Dso[] dsos = unpackerMakeUnpacker.getDsos();
            parcelObtain.writeInt(dsos.length);
            for (Dso dso : dsos) {
                parcelObtain.writeString(dso.name);
                parcelObtain.writeString(dso.hash);
            }
            unpackerMakeUnpacker.close();
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Throwable th) {
            if (unpackerMakeUnpacker != null) {
                try {
                    unpackerMakeUnpacker.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        if (!this.soDirectory.canWrite() && !this.soDirectory.setWritable(true)) {
            throw new IOException("error adding " + this.soDirectory.getCanonicalPath() + " write permission");
        }
        FileLocker fileLocker = null;
        try {
            try {
                FileLocker orCreateLockOnDir = SysUtil.getOrCreateLockOnDir(this.soDirectory, new File(this.soDirectory, "dso_lock"));
                try {
                    LogUtil.v("fb-UnpackingSoSource", "locked dso store " + this.soDirectory);
                    if (!this.soDirectory.canWrite() && !this.soDirectory.setWritable(true)) {
                        throw new IOException("error adding " + this.soDirectory.getCanonicalPath() + " write permission");
                    }
                    if (!refreshLocked(orCreateLockOnDir, i)) {
                        LogUtil.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.soDirectory);
                        fileLocker = orCreateLockOnDir;
                    }
                    if (fileLocker != null) {
                        LogUtil.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.soDirectory);
                        fileLocker.close();
                    } else {
                        LogUtil.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
                    }
                    if (!this.soDirectory.canWrite() || this.soDirectory.setWritable(false)) {
                        return;
                    }
                    throw new IOException("error removing " + this.soDirectory.getCanonicalPath() + " write permission");
                } catch (Throwable th) {
                    th = th;
                    fileLocker = orCreateLockOnDir;
                    if (fileLocker != null) {
                        LogUtil.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.soDirectory);
                        fileLocker.close();
                    } else {
                        LogUtil.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (this.soDirectory.canWrite() && !this.soDirectory.setWritable(false)) {
                    throw new IOException("error removing " + this.soDirectory.getCanonicalPath() + " write permission");
                }
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
