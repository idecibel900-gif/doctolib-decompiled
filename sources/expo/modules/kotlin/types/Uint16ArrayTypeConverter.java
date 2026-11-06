package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.typedarray.Uint16Array;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Uint16ArrayTypeConverter extends BaseTypeArrayConverter {

    /* JADX INFO: renamed from: expo.modules.kotlin.types.Uint16ArrayTypeConverter$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, Uint16Array.class, "<init>", "<init>(Lexpo/modules/kotlin/jni/JavaScriptTypedArray;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Uint16Array invoke(JavaScriptTypedArray p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new Uint16Array(p0);
        }
    }

    public Uint16ArrayTypeConverter() {
        super(AnonymousClass1.INSTANCE);
    }
}
