package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UnconvertedValue extends DeferredValue {
    private final WeakReference contextHolder;
    private Object convertedValue;
    private final TypeConverter typeConverter;
    private final Object unconvertedValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnconvertedValue(Object unconvertedValue, TypeConverter typeConverter, AppContext appContext) {
        super(null);
        Intrinsics.checkNotNullParameter(unconvertedValue, "unconvertedValue");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        this.unconvertedValue = unconvertedValue;
        this.typeConverter = typeConverter;
        this.contextHolder = new WeakReference(appContext);
    }

    public final Object getConvertedValue() {
        if (this.convertedValue == null) {
            this.convertedValue = this.typeConverter.convert(this.unconvertedValue, (AppContext) this.contextHolder.get(), true);
        }
        Object obj = this.convertedValue;
        Intrinsics.checkNotNull(obj);
        return obj;
    }
}
