package expo.modules.kotlin.records;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
    String key() default "";
}
