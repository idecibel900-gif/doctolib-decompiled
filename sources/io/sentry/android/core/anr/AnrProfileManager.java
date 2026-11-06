package io.sentry.android.core.anr;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.cache.tape.ObjectQueue;
import io.sentry.cache.tape.QueueFile;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class AnrProfileManager implements AutoCloseable {
    private final ObjectQueue queue;

    public AnrProfileManager(SentryOptions sentryOptions, File file) {
        QueueFile queueFileBuild;
        ILogger logger = sentryOptions.getLogger();
        try {
            try {
                queueFileBuild = new QueueFile.Builder(file).size(120).build();
            } catch (IOException unused) {
                if (!file.delete()) {
                    throw new IOException("Could not delete file");
                }
                queueFileBuild = new QueueFile.Builder(file).size(120).build();
            }
        } catch (IOException e) {
            logger.log(SentryLevel.ERROR, "Failed to create stacktrace queue", e);
            queueFileBuild = null;
        }
        if (queueFileBuild == null) {
            this.queue = ObjectQueue.createEmpty();
        } else {
            this.queue = ObjectQueue.create(queueFileBuild, new ObjectQueue.Converter() { // from class: io.sentry.android.core.anr.AnrProfileManager.1
                @Override // io.sentry.cache.tape.ObjectQueue.Converter
                public AnrStackTrace from(byte[] bArr) {
                    return AnrStackTrace.deserialize(new DataInputStream(new ByteArrayInputStream(bArr)));
                }

                @Override // io.sentry.cache.tape.ObjectQueue.Converter
                public void toStream(AnrStackTrace anrStackTrace, OutputStream outputStream) throws IOException {
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                    try {
                        anrStackTrace.serialize(dataOutputStream);
                        dataOutputStream.flush();
                        outputStream.flush();
                        dataOutputStream.close();
                    } catch (Throwable th) {
                        try {
                            dataOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            });
        }
    }

    public void clear() {
        this.queue.clear();
    }

    public void add(AnrStackTrace anrStackTrace) {
        this.queue.add(anrStackTrace);
    }

    public AnrProfile load() {
        return new AnrProfile(this.queue.asList());
    }

    @Override // java.lang.AutoCloseable
    public void close() throws IOException {
        this.queue.close();
    }
}
