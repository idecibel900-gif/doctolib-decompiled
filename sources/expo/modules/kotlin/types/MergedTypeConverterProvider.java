package expo.modules.kotlin.types;

import expo.modules.kotlin.exception.MissingTypeConverter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class MergedTypeConverterProvider implements TypeConverterProvider {
    private final List providers;

    public MergedTypeConverterProvider(List providers) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        this.providers = providers;
    }

    @Override // expo.modules.kotlin.types.TypeConverterProvider
    public TypeConverter obtainTypeConverter(KType type) throws MissingTypeConverter {
        Intrinsics.checkNotNullParameter(type, "type");
        Iterator it = this.providers.iterator();
        while (it.hasNext()) {
            try {
                return ((TypeConverterProvider) it.next()).obtainTypeConverter(type);
            } catch (MissingTypeConverter unused) {
            }
        }
        throw new MissingTypeConverter(type);
    }
}
