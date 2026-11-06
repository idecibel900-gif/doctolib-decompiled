package expo.modules.kotlin.types;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class ReturnTypeProvider {
    public static final ReturnTypeProvider INSTANCE = new ReturnTypeProvider();
    private static final Map types = new LinkedHashMap();

    private ReturnTypeProvider() {
    }

    public final Map getTypes() {
        return types;
    }
}
