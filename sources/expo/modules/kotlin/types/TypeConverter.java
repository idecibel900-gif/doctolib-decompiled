package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.ExpectedType;

/* JADX INFO: loaded from: classes4.dex */
public interface TypeConverter {
    Object convert(Object obj, AppContext appContext, boolean z);

    ExpectedType getCppRequiredTypes();

    boolean isTrivial();

    public static final class DefaultImpls {
        public static boolean isTrivial(TypeConverter typeConverter) {
            return true;
        }

        public static /* synthetic */ Object convert$default(TypeConverter typeConverter, Object obj, AppContext appContext, boolean z, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
            }
            if ((i & 2) != 0) {
                appContext = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return typeConverter.convert(obj, appContext, z);
        }
    }
}
