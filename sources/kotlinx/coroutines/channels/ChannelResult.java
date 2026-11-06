package kotlinx.coroutines.channels;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ChannelResult {
    public static final Companion Companion = new Companion(null);
    private static final Failed failed = new Failed();
    private final Object holder;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ChannelResult m5452boximpl(Object obj) {
        return new ChannelResult(obj);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Object m5453constructorimpl(Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5454equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && Intrinsics.areEqual(obj, ((ChannelResult) obj2).m5461unboximpl());
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5457hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        return m5454equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m5457hashCodeimpl(this.holder);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m5461unboximpl() {
        return this.holder;
    }

    private /* synthetic */ ChannelResult(Object obj) {
        this.holder = obj;
    }

    /* JADX INFO: renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m5459isSuccessimpl(Object obj) {
        return !(obj instanceof Failed);
    }

    /* JADX INFO: renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m5458isClosedimpl(Object obj) {
        return obj instanceof Closed;
    }

    /* JADX INFO: renamed from: getOrNull-impl, reason: not valid java name */
    public static final Object m5456getOrNullimpl(Object obj) {
        if (obj instanceof Failed) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m5455exceptionOrNullimpl(Object obj) {
        Closed closed = obj instanceof Closed ? (Closed) obj : null;
        if (closed != null) {
            return closed.cause;
        }
        return null;
    }

    public static class Failed {
        public String toString() {
            return "Failed";
        }
    }

    public static final class Closed extends Failed {
        public final Throwable cause;

        public Closed(Throwable th) {
            this.cause = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Closed) && Intrinsics.areEqual(this.cause, ((Closed) obj).cause);
        }

        public int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: success-JP2dKIU, reason: not valid java name */
        public final Object m5464successJP2dKIU(Object obj) {
            return ChannelResult.m5453constructorimpl(obj);
        }

        /* JADX INFO: renamed from: failure-PtdJZtk, reason: not valid java name */
        public final Object m5463failurePtdJZtk() {
            return ChannelResult.m5453constructorimpl(ChannelResult.failed);
        }

        /* JADX INFO: renamed from: closed-JP2dKIU, reason: not valid java name */
        public final Object m5462closedJP2dKIU(Throwable th) {
            return ChannelResult.m5453constructorimpl(new Closed(th));
        }
    }

    public String toString() {
        return m5460toStringimpl(this.holder);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5460toStringimpl(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
