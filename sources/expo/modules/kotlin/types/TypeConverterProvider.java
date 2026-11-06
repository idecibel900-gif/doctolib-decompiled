package expo.modules.kotlin.types;

import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public interface TypeConverterProvider {
    TypeConverter obtainTypeConverter(KType kType);
}
