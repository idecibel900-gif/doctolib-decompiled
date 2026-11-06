package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class Result implements Serializable {
    public static final Companion Companion = new Companion(null);
    private final Object value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m5242boximpl(Object obj) {
        return new Result(obj);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Object m5243constructorimpl(Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5244equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.areEqual(obj, ((Result) obj2).m5251unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5245equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5247hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        return m5244equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5247hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m5251unboximpl() {
        return this.value;
    }

    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* JADX INFO: renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m5249isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* JADX INFO: renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m5248isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m5246exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    public String toString() {
        return m5250toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5250toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }
}
