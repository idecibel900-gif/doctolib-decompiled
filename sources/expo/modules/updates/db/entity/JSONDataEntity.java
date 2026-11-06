package expo.modules.updates.db.entity;

import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class JSONDataEntity {
    private long id;
    private String key;
    private Date lastUpdated;
    private String scopeKey;
    private String value;

    public JSONDataEntity(String key, String value, Date lastUpdated, String scopeKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(lastUpdated, "lastUpdated");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        this.key = key;
        this.value = value;
        this.lastUpdated = lastUpdated;
        this.scopeKey = scopeKey;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public final Date getLastUpdated() {
        return this.lastUpdated;
    }

    public final String getScopeKey() {
        return this.scopeKey;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }
}
