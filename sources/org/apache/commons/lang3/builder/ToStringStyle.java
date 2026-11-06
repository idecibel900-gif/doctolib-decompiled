package org.apache.commons.lang3.builder;

import com.amazon.a.a.o.b.f;
import com.revenuecat.purchases.common.Constants;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringEscapeUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ToStringStyle implements Serializable {
    public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle();
    public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle();
    public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
    public static final ToStringStyle SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
    public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle();
    public static final ToStringStyle NO_CLASS_NAME_STYLE = new NoClassNameToStringStyle();
    public static final ToStringStyle JSON_STYLE = new JsonToStringStyle();
    private static final ThreadLocal REGISTRY = new ThreadLocal();
    private boolean useFieldNames = true;
    private boolean useClassName = true;
    private boolean useShortClassName = false;
    private boolean useIdentityHashCode = true;
    private String contentStart = "[";
    private String contentEnd = "]";
    private String fieldNameValueSeparator = f.b;
    private boolean fieldSeparatorAtStart = false;
    private boolean fieldSeparatorAtEnd = false;
    private String fieldSeparator = f.a;
    private String arrayStart = "{";
    private String arraySeparator = f.a;
    private boolean arrayContentDetail = true;
    private String arrayEnd = "}";
    private boolean defaultFullDetail = true;
    private String nullText = "<null>";
    private String sizeStartText = "<size=";
    private String sizeEndText = ">";
    private String summaryObjectStartText = "<";
    private String summaryObjectEndText = ">";

    static Map getRegistry() {
        return (Map) REGISTRY.get();
    }

    static boolean isRegistered(Object obj) {
        Map registry = getRegistry();
        return registry != null && registry.containsKey(obj);
    }

    static void register(Object obj) {
        if (obj != null) {
            if (getRegistry() == null) {
                REGISTRY.set(new WeakHashMap());
            }
            getRegistry().put(obj, null);
        }
    }

    static void unregister(Object obj) {
        Map registry;
        if (obj == null || (registry = getRegistry()) == null) {
            return;
        }
        registry.remove(obj);
        if (registry.isEmpty()) {
            REGISTRY.remove();
        }
    }

    protected ToStringStyle() {
    }

    public void appendStart(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            appendClassName(stringBuffer, obj);
            appendIdentityHashCode(stringBuffer, obj);
            appendContentStart(stringBuffer);
            if (this.fieldSeparatorAtStart) {
                appendFieldSeparator(stringBuffer);
            }
        }
    }

    public void appendEnd(StringBuffer stringBuffer, Object obj) {
        if (!this.fieldSeparatorAtEnd) {
            removeLastFieldSeparator(stringBuffer);
        }
        appendContentEnd(stringBuffer);
        unregister(obj);
    }

    protected void removeLastFieldSeparator(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        int length2 = this.fieldSeparator.length();
        if (length <= 0 || length2 <= 0 || length < length2) {
            return;
        }
        for (int i = 0; i < length2; i++) {
            if (stringBuffer.charAt((length - 1) - i) != this.fieldSeparator.charAt((length2 - 1) - i)) {
                return;
            }
        }
        stringBuffer.setLength(length - length2);
    }

    public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (obj == null) {
            appendNullText(stringBuffer, str);
        } else {
            appendInternal(stringBuffer, str, obj, isFullDetail(bool));
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendInternal(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        if (isRegistered(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character)) {
            appendCyclicObject(stringBuffer, str, obj);
            return;
        }
        register(obj);
        try {
            if (obj instanceof Collection) {
                if (z) {
                    appendDetail(stringBuffer, str, (Collection) obj);
                } else {
                    appendSummarySize(stringBuffer, str, ((Collection) obj).size());
                }
            } else if (obj instanceof Map) {
                if (z) {
                    appendDetail(stringBuffer, str, (Map) obj);
                } else {
                    appendSummarySize(stringBuffer, str, ((Map) obj).size());
                }
            } else if (obj instanceof long[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (long[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (long[]) obj);
                }
            } else if (obj instanceof int[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (int[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (int[]) obj);
                }
            } else if (obj instanceof short[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (short[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (short[]) obj);
                }
            } else if (obj instanceof byte[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (byte[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (byte[]) obj);
                }
            } else if (obj instanceof char[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (char[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (char[]) obj);
                }
            } else if (obj instanceof double[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (double[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (double[]) obj);
                }
            } else if (obj instanceof float[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (float[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (float[]) obj);
                }
            } else if (obj instanceof boolean[]) {
                if (z) {
                    appendDetail(stringBuffer, str, (boolean[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (boolean[]) obj);
                }
            } else if (obj.getClass().isArray()) {
                if (z) {
                    appendDetail(stringBuffer, str, (Object[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (Object[]) obj);
                }
            } else if (z) {
                appendDetail(stringBuffer, str, obj);
            } else {
                appendSummary(stringBuffer, str, obj);
            }
        } finally {
            unregister(obj);
        }
    }

    protected void appendCyclicObject(StringBuffer stringBuffer, String str, Object obj) {
        ObjectUtils.identityToString(stringBuffer, obj);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Collection collection) {
        stringBuffer.append(collection);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Map map) {
        stringBuffer.append(map);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.summaryObjectStartText);
        stringBuffer.append(getShortClassName(obj.getClass()));
        stringBuffer.append(this.summaryObjectEndText);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, long j) {
        stringBuffer.append(j);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(i);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, short s) {
        stringBuffer.append((int) s);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, byte b) {
        stringBuffer.append((int) b);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, char c) {
        stringBuffer.append(c);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, double d) {
        stringBuffer.append(d);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, float f) {
        stringBuffer.append(f);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, boolean z) {
        stringBuffer.append(z);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.arrayStart);
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj2 == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj2, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, Object[] objArr) {
        appendSummarySize(stringBuffer, str, objArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, jArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, long[] jArr) {
        appendSummarySize(stringBuffer, str, jArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, iArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, int[] iArr) {
        appendSummarySize(stringBuffer, str, iArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < sArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, sArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, short[] sArr) {
        appendSummarySize(stringBuffer, str, sArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, bArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, byte[] bArr) {
        appendSummarySize(stringBuffer, str, bArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < cArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, cArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, char[] cArr) {
        appendSummarySize(stringBuffer, str, cArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < dArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, dArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, double[] dArr) {
        appendSummarySize(stringBuffer, str, dArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < fArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, fArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, float[] fArr) {
        appendSummarySize(stringBuffer, str, fArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < zArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, zArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, boolean[] zArr) {
        appendSummarySize(stringBuffer, str, zArr.length);
    }

    protected void appendClassName(StringBuffer stringBuffer, Object obj) {
        if (!this.useClassName || obj == null) {
            return;
        }
        register(obj);
        if (this.useShortClassName) {
            stringBuffer.append(getShortClassName(obj.getClass()));
        } else {
            stringBuffer.append(obj.getClass().getName());
        }
    }

    protected void appendIdentityHashCode(StringBuffer stringBuffer, Object obj) {
        if (!isUseIdentityHashCode() || obj == null) {
            return;
        }
        register(obj);
        stringBuffer.append('@');
        stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    protected void appendContentStart(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentStart);
    }

    protected void appendContentEnd(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentEnd);
    }

    protected void appendNullText(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.nullText);
    }

    protected void appendFieldSeparator(StringBuffer stringBuffer) {
        stringBuffer.append(this.fieldSeparator);
    }

    protected void appendFieldStart(StringBuffer stringBuffer, String str) {
        if (!this.useFieldNames || str == null) {
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append(this.fieldNameValueSeparator);
    }

    protected void appendFieldEnd(StringBuffer stringBuffer, String str) {
        appendFieldSeparator(stringBuffer);
    }

    protected void appendSummarySize(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(this.sizeStartText);
        stringBuffer.append(i);
        stringBuffer.append(this.sizeEndText);
    }

    protected boolean isFullDetail(Boolean bool) {
        if (bool == null) {
            return this.defaultFullDetail;
        }
        return bool.booleanValue();
    }

    protected String getShortClassName(Class cls) {
        return ClassUtils.getShortClassName(cls);
    }

    protected void setUseClassName(boolean z) {
        this.useClassName = z;
    }

    protected void setUseShortClassName(boolean z) {
        this.useShortClassName = z;
    }

    protected boolean isUseIdentityHashCode() {
        return this.useIdentityHashCode;
    }

    protected void setUseIdentityHashCode(boolean z) {
        this.useIdentityHashCode = z;
    }

    protected void setUseFieldNames(boolean z) {
        this.useFieldNames = z;
    }

    protected String getArrayStart() {
        return this.arrayStart;
    }

    protected void setArrayStart(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayStart = str;
    }

    protected String getArrayEnd() {
        return this.arrayEnd;
    }

    protected void setArrayEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayEnd = str;
    }

    protected String getContentStart() {
        return this.contentStart;
    }

    protected void setContentStart(String str) {
        if (str == null) {
            str = "";
        }
        this.contentStart = str;
    }

    protected String getContentEnd() {
        return this.contentEnd;
    }

    protected void setContentEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.contentEnd = str;
    }

    protected void setFieldNameValueSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldNameValueSeparator = str;
    }

    protected void setFieldSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldSeparator = str;
    }

    protected void setFieldSeparatorAtStart(boolean z) {
        this.fieldSeparatorAtStart = z;
    }

    protected String getNullText() {
        return this.nullText;
    }

    protected void setNullText(String str) {
        if (str == null) {
            str = "";
        }
        this.nullText = str;
    }

    protected void setSizeStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeStartText = str;
    }

    protected void setSizeEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeEndText = str;
    }

    protected void setSummaryObjectStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectStartText = str;
    }

    protected void setSummaryObjectEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectEndText = str;
    }

    private static final class DefaultToStringStyle extends ToStringStyle {
        DefaultToStringStyle() {
        }
    }

    private static final class NoFieldNameToStringStyle extends ToStringStyle {
        NoFieldNameToStringStyle() {
            setUseFieldNames(false);
        }
    }

    private static final class ShortPrefixToStringStyle extends ToStringStyle {
        ShortPrefixToStringStyle() {
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
        }
    }

    private static final class SimpleToStringStyle extends ToStringStyle {
        SimpleToStringStyle() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setUseFieldNames(false);
            setContentStart("");
            setContentEnd("");
        }
    }

    private static final class MultiLineToStringStyle extends ToStringStyle {
        MultiLineToStringStyle() {
            setContentStart("[");
            setFieldSeparator(System.lineSeparator() + "  ");
            setFieldSeparatorAtStart(true);
            setContentEnd(System.lineSeparator() + "]");
        }
    }

    private static final class NoClassNameToStringStyle extends ToStringStyle {
        NoClassNameToStringStyle() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
        }
    }

    private static final class JsonToStringStyle extends ToStringStyle {
        JsonToStringStyle() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setContentStart("{");
            setContentEnd("}");
            setArrayStart("[");
            setArrayEnd("]");
            setFieldSeparator(f.a);
            setFieldNameValueSeparator(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            setNullText("null");
            setSummaryObjectStartText("\"<");
            setSummaryObjectEndText(">\"");
            setSizeStartText("\"<size=");
            setSizeEndText(">\"");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!isFullDetail(bool)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.append(stringBuffer, str, obj, bool);
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        protected void appendDetail(StringBuffer stringBuffer, String str, char c) {
            appendValueAsString(stringBuffer, String.valueOf(c));
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        protected void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
            if (obj == null) {
                appendNullText(stringBuffer, str);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Character)) {
                appendValueAsString(stringBuffer, obj.toString());
                return;
            }
            if ((obj instanceof Number) || (obj instanceof Boolean)) {
                stringBuffer.append(obj);
                return;
            }
            String string = obj.toString();
            if (isJsonObject(string) || isJsonArray(string)) {
                stringBuffer.append(obj);
            } else {
                appendDetail(stringBuffer, str, string);
            }
        }

        private boolean isJsonArray(String str) {
            return str.startsWith(getArrayStart()) && str.endsWith(getArrayEnd());
        }

        private boolean isJsonObject(String str) {
            return str.startsWith(getContentStart()) && str.endsWith(getContentEnd());
        }

        private void appendValueAsString(StringBuffer stringBuffer, String str) {
            stringBuffer.append('\"');
            stringBuffer.append(StringEscapeUtils.escapeJson(str));
            stringBuffer.append('\"');
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        protected void appendFieldStart(StringBuffer stringBuffer, String str) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            super.appendFieldStart(stringBuffer, "\"" + StringEscapeUtils.escapeJson(str) + "\"");
        }
    }
}
