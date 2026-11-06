package com.google.firebase.installations;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* JADX INFO: loaded from: classes4.dex */
class CrossProcessLock {
    private static final String TAG = "CrossProcessLock";
    private final FileChannel channel;
    private final FileLock lock;

    private CrossProcessLock(FileChannel fileChannel, FileLock fileLock) {
        this.channel = fileChannel;
        this.lock = fileLock;
    }

    static CrossProcessLock acquire(Context context, String str) {
        FileChannel channel;
        FileLock fileLockLock;
        try {
            channel = new RandomAccessFile(new File(context.getFilesDir(), str), "rw").getChannel();
            try {
                fileLockLock = channel.lock();
                try {
                    return new CrossProcessLock(channel, fileLockLock);
                } catch (IOException | Error | OverlappingFileLockException unused) {
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            } catch (IOException | Error | OverlappingFileLockException unused4) {
                fileLockLock = null;
            }
        } catch (IOException | Error | OverlappingFileLockException unused5) {
            channel = null;
            fileLockLock = null;
        }
    }

    void releaseAndClose() {
        try {
            this.lock.release();
            this.channel.close();
        } catch (IOException unused) {
        }
    }
}
