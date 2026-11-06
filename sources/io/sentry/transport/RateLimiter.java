package io.sentry.transport;

import com.amazon.a.a.o.b.f;
import com.revenuecat.purchases.common.Constants;
import io.sentry.DataCategory;
import io.sentry.Hint;
import io.sentry.ISentryLifecycleToken;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.clientreport.DiscardReason;
import io.sentry.hints.DiskFlushNotification;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.HintUtils;
import io.sentry.util.StringUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class RateLimiter implements Closeable {
    private final ICurrentDateProvider currentDateProvider;
    private final SentryOptions options;
    private final List rateLimitObservers;
    private final Map sentryRetryAfterLimit;
    private Timer timer;
    private final AutoClosableReentrantLock timerLock;

    public interface IRateLimitObserver {
        void onRateLimitChanged(RateLimiter rateLimiter);
    }

    public RateLimiter(ICurrentDateProvider iCurrentDateProvider, SentryOptions sentryOptions) {
        this.sentryRetryAfterLimit = new ConcurrentHashMap();
        this.rateLimitObservers = new CopyOnWriteArrayList();
        this.timer = null;
        this.timerLock = new AutoClosableReentrantLock();
        this.currentDateProvider = iCurrentDateProvider;
        this.options = sentryOptions;
    }

    public RateLimiter(SentryOptions sentryOptions) {
        this(CurrentDateProvider.getInstance(), sentryOptions);
    }

    public SentryEnvelope filter(SentryEnvelope sentryEnvelope, Hint hint) {
        ArrayList arrayList = null;
        for (SentryEnvelopeItem sentryEnvelopeItem : sentryEnvelope.getItems()) {
            if (isRetryAfter(sentryEnvelopeItem.getHeader().getType().getItemType())) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(sentryEnvelopeItem);
                this.options.getClientReportRecorder().recordLostEnvelopeItem(DiscardReason.RATELIMIT_BACKOFF, sentryEnvelopeItem);
            }
        }
        if (arrayList == null) {
            return sentryEnvelope;
        }
        this.options.getLogger().log(SentryLevel.WARNING, "%d envelope items will be dropped due rate limiting.", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        for (SentryEnvelopeItem sentryEnvelopeItem2 : sentryEnvelope.getItems()) {
            if (!arrayList.contains(sentryEnvelopeItem2)) {
                arrayList2.add(sentryEnvelopeItem2);
            }
        }
        if (arrayList2.isEmpty()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Envelope discarded due all items rate limited.", new Object[0]);
            markHintWhenSendingFailed(hint, false);
            return null;
        }
        return new SentryEnvelope(sentryEnvelope.getHeader(), arrayList2);
    }

    public boolean isActiveForCategory(DataCategory dataCategory) {
        Date date;
        Date date2 = new Date(this.currentDateProvider.getCurrentTimeMillis());
        Date date3 = (Date) this.sentryRetryAfterLimit.get(DataCategory.All);
        if (date3 != null && !date2.after(date3)) {
            return true;
        }
        if (DataCategory.Unknown.equals(dataCategory) || (date = (Date) this.sentryRetryAfterLimit.get(dataCategory)) == null) {
            return false;
        }
        return !date2.after(date);
    }

    public boolean isAnyRateLimitActive() {
        Date date = new Date(this.currentDateProvider.getCurrentTimeMillis());
        Iterator it = this.sentryRetryAfterLimit.keySet().iterator();
        while (it.hasNext()) {
            Date date2 = (Date) this.sentryRetryAfterLimit.get((DataCategory) it.next());
            if (date2 != null && !date.after(date2)) {
                return true;
            }
        }
        return false;
    }

    private void markHintWhenSendingFailed(Hint hint, final boolean z) {
        HintUtils.runIfHasType(hint, SubmissionResult.class, new HintUtils.SentryConsumer() { // from class: io.sentry.transport.RateLimiter$$ExternalSyntheticLambda0
            @Override // io.sentry.util.HintUtils.SentryConsumer
            public final void accept(Object obj) {
                ((SubmissionResult) obj).setResult(false);
            }
        });
        HintUtils.runIfHasType(hint, Retryable.class, new HintUtils.SentryConsumer() { // from class: io.sentry.transport.RateLimiter$$ExternalSyntheticLambda1
            @Override // io.sentry.util.HintUtils.SentryConsumer
            public final void accept(Object obj) {
                ((Retryable) obj).setRetry(z);
            }
        });
        HintUtils.runIfHasType(hint, DiskFlushNotification.class, new HintUtils.SentryConsumer() { // from class: io.sentry.transport.RateLimiter$$ExternalSyntheticLambda2
            @Override // io.sentry.util.HintUtils.SentryConsumer
            public final void accept(Object obj) {
                RateLimiter.m5239$r8$lambda$h_KEb4mnfaCN8ZqbMIdEyljip4(this.f$0, (DiskFlushNotification) obj);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$h_KEb4m-nfaCN8ZqbMIdEyljip4, reason: not valid java name */
    public static /* synthetic */ void m5239$r8$lambda$h_KEb4mnfaCN8ZqbMIdEyljip4(RateLimiter rateLimiter, DiskFlushNotification diskFlushNotification) {
        rateLimiter.getClass();
        diskFlushNotification.markFlushed();
        rateLimiter.options.getLogger().log(SentryLevel.DEBUG, "Disk flush envelope fired due to rate limit", new Object[0]);
    }

    private boolean isRetryAfter(String str) {
        Iterator it = getCategoryFromItemType(str).iterator();
        while (it.hasNext()) {
            if (isActiveForCategory((DataCategory) it.next())) {
                return true;
            }
        }
        return false;
    }

    private List getCategoryFromItemType(String str) {
        str.getClass();
        switch (str) {
            case "attachment":
                return Collections.singletonList(DataCategory.Attachment);
            case "replay_video":
                return Collections.singletonList(DataCategory.Replay);
            case "profile_chunk":
                return Arrays.asList(DataCategory.ProfileChunkUi, DataCategory.ProfileChunk);
            case "profile":
                return Collections.singletonList(DataCategory.Profile);
            case "feedback":
                return Collections.singletonList(DataCategory.Feedback);
            case "log":
                return Collections.singletonList(DataCategory.LogItem);
            case "span":
                return Collections.singletonList(DataCategory.Span);
            case "event":
                return Collections.singletonList(DataCategory.Error);
            case "trace_metric":
                return Collections.singletonList(DataCategory.TraceMetric);
            case "check_in":
                return Collections.singletonList(DataCategory.Monitor);
            case "session":
                return Collections.singletonList(DataCategory.Session);
            case "transaction":
                return Collections.singletonList(DataCategory.Transaction);
            default:
                return Collections.singletonList(DataCategory.Unknown);
        }
    }

    public void updateRetryAfterLimits(String str, String str2, int i) {
        if (str == null) {
            if (i == 429) {
                applyRetryAfterOnlyIfLonger(DataCategory.All, new Date(this.currentDateProvider.getCurrentTimeMillis() + parseRetryAfterOrDefault(str2)));
                return;
            }
            return;
        }
        for (String str3 : str.split(f.a, -1)) {
            String[] strArrSplit = str3.replace(" ", "").split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1);
            if (strArrSplit.length > 0) {
                long retryAfterOrDefault = parseRetryAfterOrDefault(strArrSplit[0]);
                if (strArrSplit.length > 1) {
                    String str4 = strArrSplit[1];
                    Date date = new Date(this.currentDateProvider.getCurrentTimeMillis() + retryAfterOrDefault);
                    if (str4 != null && !str4.isEmpty()) {
                        for (String str5 : str4.split(";", -1)) {
                            DataCategory dataCategoryValueOf = DataCategory.Unknown;
                            try {
                                String strCamelCase = StringUtils.camelCase(str5);
                                if (strCamelCase != null) {
                                    dataCategoryValueOf = DataCategory.valueOf(strCamelCase);
                                } else {
                                    this.options.getLogger().log(SentryLevel.ERROR, "Couldn't capitalize: %s", str5);
                                }
                            } catch (IllegalArgumentException e) {
                                this.options.getLogger().log(SentryLevel.INFO, e, "Unknown category: %s", str5);
                            }
                            if (!DataCategory.Unknown.equals(dataCategoryValueOf)) {
                                applyRetryAfterOnlyIfLonger(dataCategoryValueOf, date);
                            }
                        }
                    } else {
                        applyRetryAfterOnlyIfLonger(DataCategory.All, date);
                    }
                }
            }
        }
    }

    private void applyRetryAfterOnlyIfLonger(DataCategory dataCategory, Date date) {
        Date date2 = (Date) this.sentryRetryAfterLimit.get(dataCategory);
        if (date2 == null || date.after(date2)) {
            this.sentryRetryAfterLimit.put(dataCategory, date);
            notifyRateLimitObservers();
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.timerLock.acquire();
            try {
                if (this.timer == null) {
                    this.timer = new Timer(true);
                }
                this.timer.schedule(new TimerTask() { // from class: io.sentry.transport.RateLimiter.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        RateLimiter.this.notifyRateLimitObservers();
                    }
                }, date);
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
            } catch (Throwable th) {
                if (iSentryLifecycleTokenAcquire != null) {
                    try {
                        iSentryLifecycleTokenAcquire.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private long parseRetryAfterOrDefault(String str) {
        if (str == null) {
            return 60000L;
        }
        try {
            return (long) (Double.parseDouble(str) * 1000.0d);
        } catch (NumberFormatException unused) {
            return 60000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRateLimitObservers() {
        Iterator it = this.rateLimitObservers.iterator();
        while (it.hasNext()) {
            ((IRateLimitObserver) it.next()).onRateLimitChanged(this);
        }
    }

    public void addRateLimitObserver(IRateLimitObserver iRateLimitObserver) {
        this.rateLimitObservers.add(iRateLimitObserver);
    }

    public void removeRateLimitObserver(IRateLimitObserver iRateLimitObserver) {
        this.rateLimitObservers.remove(iRateLimitObserver);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.timerLock.acquire();
        try {
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
                this.timer = null;
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            this.rateLimitObservers.clear();
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
