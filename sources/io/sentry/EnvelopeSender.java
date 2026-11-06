package io.sentry;

import io.sentry.hints.Flushable;
import io.sentry.hints.Retryable;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class EnvelopeSender extends DirectoryProcessor implements IEnvelopeSender {
    private final ILogger logger;
    private final IScopes scopes;
    private final ISerializer serializer;

    @Override // io.sentry.DirectoryProcessor
    public /* bridge */ /* synthetic */ void processDirectory(File file) {
        super.processDirectory(file);
    }

    public EnvelopeSender(IScopes iScopes, ISerializer iSerializer, ILogger iLogger, long j, int i) {
        super(iScopes, iLogger, j, i);
        this.scopes = (IScopes) Objects.requireNonNull(iScopes, "Scopes are required.");
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required.");
    }

    @Override // io.sentry.DirectoryProcessor
    protected void processFile(final File file, Hint hint) {
        ILogger iLogger;
        HintUtils.SentryConsumer sentryConsumer;
        if (!file.isFile()) {
            this.logger.log(SentryLevel.DEBUG, "'%s' is not a file.", file.getAbsolutePath());
            return;
        }
        if (!isRelevantFileName(file.getName())) {
            this.logger.log(SentryLevel.DEBUG, "File '%s' doesn't match extension expected.", file.getAbsolutePath());
            return;
        }
        try {
            if (!file.getParentFile().canWrite()) {
                this.logger.log(SentryLevel.WARNING, "File '%s' cannot be deleted so it will not be processed.", file.getAbsolutePath());
                return;
            }
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        SentryEnvelope sentryEnvelopeDeserializeEnvelope = this.serializer.deserializeEnvelope(bufferedInputStream);
                        if (sentryEnvelopeDeserializeEnvelope == null) {
                            this.logger.log(SentryLevel.ERROR, "Failed to deserialize cached envelope %s", file.getAbsolutePath());
                        } else {
                            this.scopes.captureEnvelope(sentryEnvelopeDeserializeEnvelope, hint);
                        }
                        HintUtils.runIfHasTypeLogIfNot(hint, Flushable.class, this.logger, new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda0
                            @Override // io.sentry.util.HintUtils.SentryConsumer
                            public final void accept(Object obj) {
                                EnvelopeSender.m5136$r8$lambda$QRCAIu5kPXDCPCIYLoYoQgOnDo(this.f$0, (Flushable) obj);
                            }
                        });
                        bufferedInputStream.close();
                        HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, this.logger, new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda1
                            @Override // io.sentry.util.HintUtils.SentryConsumer
                            public final void accept(Object obj) {
                                EnvelopeSender.$r8$lambda$icDMUdwm9PAOxbTcQc2wGHKaS34(this.f$0, file, (Retryable) obj);
                            }
                        });
                    } catch (Throwable th) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e) {
                    this.logger.log(SentryLevel.ERROR, e, "File '%s' cannot be found.", file.getAbsolutePath());
                    iLogger = this.logger;
                    sentryConsumer = new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda1
                        @Override // io.sentry.util.HintUtils.SentryConsumer
                        public final void accept(Object obj) {
                            EnvelopeSender.$r8$lambda$icDMUdwm9PAOxbTcQc2wGHKaS34(this.f$0, file, (Retryable) obj);
                        }
                    };
                    HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, iLogger, sentryConsumer);
                }
            } catch (IOException e2) {
                this.logger.log(SentryLevel.ERROR, e2, "I/O on file '%s' failed.", file.getAbsolutePath());
                iLogger = this.logger;
                sentryConsumer = new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda1
                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        EnvelopeSender.$r8$lambda$icDMUdwm9PAOxbTcQc2wGHKaS34(this.f$0, file, (Retryable) obj);
                    }
                };
                HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, iLogger, sentryConsumer);
            } catch (Throwable th3) {
                this.logger.log(SentryLevel.ERROR, th3, "Failed to capture cached envelope %s", file.getAbsolutePath());
                HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, this.logger, new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda2
                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        EnvelopeSender.m5137$r8$lambda$rblxRvPBTezXpDolBT4Y4XXYXU(this.f$0, th3, file, (Retryable) obj);
                    }
                });
                iLogger = this.logger;
                sentryConsumer = new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda1
                    @Override // io.sentry.util.HintUtils.SentryConsumer
                    public final void accept(Object obj) {
                        EnvelopeSender.$r8$lambda$icDMUdwm9PAOxbTcQc2wGHKaS34(this.f$0, file, (Retryable) obj);
                    }
                };
                HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, iLogger, sentryConsumer);
            }
        } catch (Throwable th4) {
            HintUtils.runIfHasTypeLogIfNot(hint, Retryable.class, this.logger, new HintUtils.SentryConsumer() { // from class: io.sentry.EnvelopeSender$$ExternalSyntheticLambda1
                @Override // io.sentry.util.HintUtils.SentryConsumer
                public final void accept(Object obj) {
                    EnvelopeSender.$r8$lambda$icDMUdwm9PAOxbTcQc2wGHKaS34(this.f$0, file, (Retryable) obj);
                }
            });
            throw th4;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$QRCAIu5kP-XDCPCIYLoYoQgOnDo, reason: not valid java name */
    public static /* synthetic */ void m5136$r8$lambda$QRCAIu5kPXDCPCIYLoYoQgOnDo(EnvelopeSender envelopeSender, Flushable flushable) {
        envelopeSender.getClass();
        if (flushable.waitFlush()) {
            return;
        }
        envelopeSender.logger.log(SentryLevel.WARNING, "Timed out waiting for envelope submission.", new Object[0]);
    }

    /* JADX INFO: renamed from: $r8$lambda$rbl-xRvPBTezXpDolBT4Y4XXYXU, reason: not valid java name */
    public static /* synthetic */ void m5137$r8$lambda$rblxRvPBTezXpDolBT4Y4XXYXU(EnvelopeSender envelopeSender, Throwable th, File file, Retryable retryable) {
        envelopeSender.getClass();
        retryable.setRetry(false);
        envelopeSender.logger.log(SentryLevel.INFO, th, "File '%s' won't retry.", file.getAbsolutePath());
    }

    public static /* synthetic */ void $r8$lambda$icDMUdwm9PAOxbTcQc2wGHKaS34(EnvelopeSender envelopeSender, File file, Retryable retryable) {
        envelopeSender.getClass();
        if (!retryable.isRetry()) {
            envelopeSender.safeDelete(file, "after trying to capture it");
            envelopeSender.logger.log(SentryLevel.DEBUG, "Deleted file %s.", file.getAbsolutePath());
        } else {
            envelopeSender.logger.log(SentryLevel.INFO, "File not deleted since retry was marked. %s.", file.getAbsolutePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.sentry.DirectoryProcessor
    public boolean isRelevantFileName(String str) {
        return str.endsWith(".envelope");
    }

    @Override // io.sentry.IEnvelopeSender
    public void processEnvelopeFile(String str, Hint hint) {
        Objects.requireNonNull(str, "Path is required.");
        processFile(new File(str), hint);
    }

    private void safeDelete(File file, String str) {
        try {
            if (file.delete()) {
                return;
            }
            this.logger.log(SentryLevel.ERROR, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        } catch (Throwable th) {
            this.logger.log(SentryLevel.ERROR, th, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        }
    }
}
