package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RumEventMeta {
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ RumEventMeta(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getType();

    private RumEventMeta() {
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", getType());
        return jsonObject;
    }

    public static final class View extends RumEventMeta {
        private final long documentVersion;
        private final Boolean hasAccessibility;
        private final String type;
        private final String viewId;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof View)) {
                return false;
            }
            View view = (View) obj;
            return Intrinsics.areEqual(this.viewId, view.viewId) && this.documentVersion == view.documentVersion && Intrinsics.areEqual(this.hasAccessibility, view.hasAccessibility);
        }

        public int hashCode() {
            int iHashCode = ((this.viewId.hashCode() * 31) + Long.hashCode(this.documentVersion)) * 31;
            Boolean bool = this.hasAccessibility;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "View(viewId=" + this.viewId + ", documentVersion=" + this.documentVersion + ", hasAccessibility=" + this.hasAccessibility + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final long getDocumentVersion() {
            return this.documentVersion;
        }

        public final Boolean getHasAccessibility() {
            return this.hasAccessibility;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public View(String viewId, long j, Boolean bool) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            this.viewId = viewId;
            this.documentVersion = j;
            this.hasAccessibility = bool;
            this.type = "view";
        }

        @Override // com.datadog.android.rum.internal.domain.event.RumEventMeta
        public String getType() {
            return this.type;
        }

        @Override // com.datadog.android.rum.internal.domain.event.RumEventMeta
        public JsonObject toJson() {
            JsonObject json = super.toJson();
            json.addProperty("viewId", this.viewId);
            json.addProperty("documentVersion", Long.valueOf(this.documentVersion));
            json.addProperty("hasAccessibility", this.hasAccessibility);
            return json;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumEventMeta fromJson(String jsonString, InternalLogger internalLogger) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
            try {
                JsonObject asJsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                final String asString = asJsonObject.get("type").getAsString();
                if (Intrinsics.areEqual(asString, "view")) {
                    String viewId = asJsonObject.get("viewId").getAsString();
                    long asLong = asJsonObject.get("documentVersion").getAsLong();
                    JsonElement jsonElement = asJsonObject.get("hasAccessibility");
                    boolean asBoolean = jsonElement == null ? false : jsonElement.getAsBoolean();
                    Intrinsics.checkNotNullExpressionValue(viewId, "viewId");
                    return new View(viewId, asLong, Boolean.valueOf(asBoolean));
                }
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMeta$Companion$fromJson$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, "Unknown RUM event meta type value [%s]", Arrays.copyOf(new Object[]{asString}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return null;
            } catch (ClassCastException e) {
                throw new JsonParseException("Unable to parse json into RUM event meta", e);
            } catch (IllegalStateException e2) {
                throw new JsonParseException("Unable to parse json into RUM event meta", e2);
            } catch (NullPointerException e3) {
                throw new JsonParseException("Unable to parse json into RUM event meta", e3);
            } catch (NumberFormatException e4) {
                throw new JsonParseException("Unable to parse json into RUM event meta", e4);
            }
        }
    }
}
