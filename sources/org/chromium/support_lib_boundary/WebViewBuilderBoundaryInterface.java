package org.chromium.support_lib_boundary;

import android.content.Context;
import android.webkit.WebView;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes5.dex */
public interface WebViewBuilderBoundaryInterface {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Baseline {
        public static final int DEFAULT = 0;
    }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConfigField {
        public static final int BASELINE = 0;
        public static final int JAVASCRIPT_INTERFACE = 1;
    }

    WebView build(Context context, Consumer<BiConsumer<Integer, Object>> consumer);

    public static class Config implements Consumer<BiConsumer<Integer, Object>> {
        public int baseline = 0;
        List mJavascriptInterfaceObjects = new ArrayList();
        List mJavascriptInterfaceNames = new ArrayList();
        List mJavascriptInterfaceSitePatterns = new ArrayList();

        public void addJavascriptInterface(Object obj, String str, List<String> list) {
            this.mJavascriptInterfaceObjects.add(obj);
            this.mJavascriptInterfaceNames.add(str);
            this.mJavascriptInterfaceSitePatterns.add(list);
        }

        @Override // java.util.function.Consumer
        public void accept(BiConsumer<Integer, Object> biConsumer) {
            biConsumer.accept(0, Integer.valueOf(this.baseline));
            biConsumer.accept(1, new Object[]{this.mJavascriptInterfaceObjects, this.mJavascriptInterfaceNames, this.mJavascriptInterfaceSitePatterns});
        }
    }
}
