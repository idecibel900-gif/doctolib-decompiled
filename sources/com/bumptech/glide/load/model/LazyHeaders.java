package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyHeaders implements Headers {
    private volatile Map combinedHeaders;
    private final Map headers;

    LazyHeaders(Map map) {
        this.headers = Collections.unmodifiableMap(map);
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map getHeaders() {
        if (this.combinedHeaders == null) {
            synchronized (this) {
                try {
                    if (this.combinedHeaders == null) {
                        this.combinedHeaders = Collections.unmodifiableMap(generateHeaders());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.combinedHeaders;
    }

    private Map generateHeaders() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.headers.entrySet()) {
            String strBuildHeaderValue = buildHeaderValue((List) entry.getValue());
            if (!TextUtils.isEmpty(strBuildHeaderValue)) {
                map.put((String) entry.getKey(), strBuildHeaderValue);
            }
        }
        return map;
    }

    private String buildHeaderValue(List list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String strBuildHeader = ((LazyHeaderFactory) list.get(i)).buildHeader();
            if (!TextUtils.isEmpty(strBuildHeader)) {
                sb.append(strBuildHeader);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.headers + '}';
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.headers.equals(((LazyHeaders) obj).headers);
        }
        return false;
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public static final class Builder {
        private static final Map DEFAULT_HEADERS;
        private static final String DEFAULT_USER_AGENT;
        private boolean copyOnModify = true;
        private Map headers = DEFAULT_HEADERS;
        private boolean isUserAgentDefault = true;

        static {
            String sanitizedUserAgent = getSanitizedUserAgent();
            DEFAULT_USER_AGENT = sanitizedUserAgent;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(sanitizedUserAgent)) {
                map.put("User-Agent", Collections.singletonList(new StringHeaderFactory(sanitizedUserAgent)));
            }
            DEFAULT_HEADERS = Collections.unmodifiableMap(map);
        }

        public Builder addHeader(String str, String str2) {
            return addHeader(str, new StringHeaderFactory(str2));
        }

        public Builder addHeader(String str, LazyHeaderFactory lazyHeaderFactory) {
            if (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(str)) {
                return setHeader(str, lazyHeaderFactory);
            }
            copyIfNecessary();
            getFactories(str).add(lazyHeaderFactory);
            return this;
        }

        public Builder setHeader(String str, LazyHeaderFactory lazyHeaderFactory) {
            copyIfNecessary();
            if (lazyHeaderFactory == null) {
                this.headers.remove(str);
            } else {
                List factories = getFactories(str);
                factories.clear();
                factories.add(lazyHeaderFactory);
            }
            if (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(str)) {
                this.isUserAgentDefault = false;
            }
            return this;
        }

        private List getFactories(String str) {
            List list = (List) this.headers.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.headers.put(str, arrayList);
            return arrayList;
        }

        private void copyIfNecessary() {
            if (this.copyOnModify) {
                this.copyOnModify = false;
                this.headers = copyHeaders();
            }
        }

        public LazyHeaders build() {
            this.copyOnModify = true;
            return new LazyHeaders(this.headers);
        }

        private Map copyHeaders() {
            HashMap map = new HashMap(this.headers.size());
            for (Map.Entry entry : this.headers.entrySet()) {
                map.put((String) entry.getKey(), new ArrayList((Collection) entry.getValue()));
            }
            return map;
        }

        static String getSanitizedUserAgent() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }
    }

    static final class StringHeaderFactory implements LazyHeaderFactory {
        private final String value;

        StringHeaderFactory(String str) {
            this.value = str;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String buildHeader() {
            return this.value;
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.value + "'}";
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.value.equals(((StringHeaderFactory) obj).value);
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }
    }
}
