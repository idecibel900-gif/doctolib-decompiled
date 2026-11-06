package io.sentry;

import com.adjust.sdk.Constants;
import io.sentry.util.AutoClosableReentrantLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class Hint {
    private static final Map PRIMITIVE_MAPPINGS;
    private final Map internalStorage = new HashMap();
    private final List attachments = new ArrayList();
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();
    private Attachment screenshot = null;
    private Attachment viewHierarchy = null;
    private Attachment threadDump = null;
    private Attachment tombstone = null;
    private ReplayRecording replayRecording = null;

    static {
        HashMap map = new HashMap();
        PRIMITIVE_MAPPINGS = map;
        map.put("boolean", Boolean.class);
        map.put("char", Character.class);
        map.put("byte", Byte.class);
        map.put("short", Short.class);
        map.put("int", Integer.class);
        map.put(Constants.LONG, Long.class);
        map.put("float", Float.class);
        map.put("double", Double.class);
    }

    public void set(String str, Object obj) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            this.internalStorage.put(str, obj);
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

    public Object get(String str) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Object obj = this.internalStorage.get(str);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return obj;
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

    public Object getAs(String str, Class cls) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Object obj = this.internalStorage.get(str);
            if (cls.isInstance(obj)) {
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                    return obj;
                }
            } else {
                if (!isCastablePrimitive(obj, cls)) {
                    if (iSentryLifecycleTokenAcquire != null) {
                        iSentryLifecycleTokenAcquire.close();
                    }
                    return null;
                }
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
            }
            return obj;
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

    public void addAttachment(Attachment attachment) {
        if (attachment != null) {
            this.attachments.add(attachment);
        }
    }

    public void addAttachments(List list) {
        if (list != null) {
            this.attachments.addAll(list);
        }
    }

    public List getAttachments() {
        return new ArrayList(this.attachments);
    }

    public void clear() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Iterator it = this.internalStorage.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getKey() == null || !((String) entry.getKey()).startsWith("sentry:")) {
                    it.remove();
                }
            }
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

    public void setScreenshot(Attachment attachment) {
        this.screenshot = attachment;
    }

    public Attachment getScreenshot() {
        return this.screenshot;
    }

    public void setViewHierarchy(Attachment attachment) {
        this.viewHierarchy = attachment;
    }

    public Attachment getViewHierarchy() {
        return this.viewHierarchy;
    }

    public void setThreadDump(Attachment attachment) {
        this.threadDump = attachment;
    }

    public Attachment getThreadDump() {
        return this.threadDump;
    }

    public void setTombstone(Attachment attachment) {
        this.tombstone = attachment;
    }

    public Attachment getTombstone() {
        return this.tombstone;
    }

    public ReplayRecording getReplayRecording() {
        return this.replayRecording;
    }

    public void setReplayRecording(ReplayRecording replayRecording) {
        this.replayRecording = replayRecording;
    }

    private boolean isCastablePrimitive(Object obj, Class cls) {
        Class cls2 = (Class) PRIMITIVE_MAPPINGS.get(cls.getCanonicalName());
        return obj != null && cls.isPrimitive() && cls2 != null && cls2.isInstance(obj);
    }
}
