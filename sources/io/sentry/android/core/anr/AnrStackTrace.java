package io.sentry.android.core.anr;

import io.sentry.util.StringUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class AnrStackTrace implements Comparable {
    public final StackTraceElement[] stack;
    public final long timestampMs;

    public AnrStackTrace(long j, StackTraceElement[] stackTraceElementArr) {
        this.timestampMs = j;
        this.stack = stackTraceElementArr;
    }

    @Override // java.lang.Comparable
    public int compareTo(AnrStackTrace anrStackTrace) {
        return Long.compare(this.timestampMs, anrStackTrace.timestampMs);
    }

    public void serialize(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(1);
        dataOutputStream.writeLong(this.timestampMs);
        dataOutputStream.writeInt(this.stack.length);
        for (StackTraceElement stackTraceElement : this.stack) {
            dataOutputStream.writeUTF(StringUtils.getOrEmpty(stackTraceElement.getClassName()));
            dataOutputStream.writeUTF(StringUtils.getOrEmpty(stackTraceElement.getMethodName()));
            String fileName = stackTraceElement.getFileName();
            dataOutputStream.writeBoolean(fileName == null);
            if (fileName == null) {
                fileName = "";
            }
            dataOutputStream.writeUTF(fileName);
            dataOutputStream.writeInt(stackTraceElement.getLineNumber());
        }
    }

    public static AnrStackTrace deserialize(DataInputStream dataInputStream) throws IOException {
        try {
            if (dataInputStream.readShort() == 1) {
                long j = dataInputStream.readLong();
                int i = dataInputStream.readInt();
                if (i >= 0 && i <= 1000) {
                    StackTraceElement[] stackTraceElementArr = new StackTraceElement[i];
                    for (int i2 = 0; i2 < i; i2++) {
                        String utf = dataInputStream.readUTF();
                        String utf2 = dataInputStream.readUTF();
                        boolean z = dataInputStream.readBoolean();
                        String utf3 = dataInputStream.readUTF();
                        if (z) {
                            utf3 = null;
                        }
                        stackTraceElementArr[i2] = new StackTraceElement(utf, utf2, utf3, dataInputStream.readInt());
                    }
                    return new AnrStackTrace(j, stackTraceElementArr);
                }
            }
        } catch (EOFException unused) {
        }
        return null;
    }
}
