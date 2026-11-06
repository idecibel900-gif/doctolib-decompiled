package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.runtime.Runtime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedRef;", "RefType", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "ref", "Lexpo/modules/kotlin/runtime/Runtime;", "runtime", "<init>", "(Ljava/lang/Object;Lexpo/modules/kotlin/runtime/Runtime;)V", "Ljava/lang/Object;", "getRef", "()Ljava/lang/Object;", "", "nativeRefType", "Ljava/lang/String;", "getNativeRefType", "()Ljava/lang/String;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SharedRef<RefType> extends SharedObject {
    private final String nativeRefType;
    private final Object ref;

    public /* synthetic */ SharedRef(Object obj, Runtime runtime, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : runtime);
    }

    public final Object getRef() {
        return this.ref;
    }

    public SharedRef(Object obj, Runtime runtime) {
        super(runtime);
        this.ref = obj;
        this.nativeRefType = "unknown";
    }

    public String getNativeRefType() {
        return this.nativeRefType;
    }
}
