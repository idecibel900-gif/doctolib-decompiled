package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.typedarray.Float32Array;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Float32ArrayTypeConverter extends BaseTypeArrayConverter {

    /* JADX INFO: renamed from: expo.modules.kotlin.types.Float32ArrayTypeConverter$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, Float32Array.class, "<init>", "<init>(Lexpo/modules/kotlin/jni/JavaScriptTypedArray;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Float32Array invoke(JavaScriptTypedArray p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new Float32Array(p0);
        }
    }

    public Float32ArrayTypeConverter() {
        super(AnonymousClass1.INSTANCE);
    }
}
