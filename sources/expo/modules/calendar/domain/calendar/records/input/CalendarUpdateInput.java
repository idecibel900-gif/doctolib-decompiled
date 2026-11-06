package expo.modules.calendar.domain.calendar.records.input;

import android.content.ContentValues;
import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.Required;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014JH\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0006\u0010\u0014R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0016\u0010\f\u001a\u0004\b\b\u0010\u0014¨\u0006&"}, d2 = {"Lexpo/modules/calendar/domain/calendar/records/input/CalendarUpdateInput;", "Lexpo/modules/kotlin/records/Record;", DiagnosticsEntry.ID_KEY, "", "name", b.S, "isVisible", "", "isSynced", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getName$annotations", "getName", "getTitle$annotations", "getTitle", "isVisible$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isSynced$annotations", "toContentValues", "Landroid/content/ContentValues;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lexpo/modules/calendar/domain/calendar/records/input/CalendarUpdateInput;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CalendarUpdateInput implements Record {
    private final String id;
    private final Boolean isSynced;
    private final Boolean isVisible;
    private final String name;
    private final String title;

    public static /* synthetic */ CalendarUpdateInput copy$default(CalendarUpdateInput calendarUpdateInput, String str, String str2, String str3, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = calendarUpdateInput.id;
        }
        if ((i & 2) != 0) {
            str2 = calendarUpdateInput.name;
        }
        if ((i & 4) != 0) {
            str3 = calendarUpdateInput.title;
        }
        if ((i & 8) != 0) {
            bool = calendarUpdateInput.isVisible;
        }
        if ((i & 16) != 0) {
            bool2 = calendarUpdateInput.isSynced;
        }
        Boolean bool3 = bool2;
        String str4 = str3;
        return calendarUpdateInput.copy(str, str2, str4, bool, bool3);
    }

    @Field
    @Required
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getTitle$annotations() {
    }

    @Field
    public static /* synthetic */ void isSynced$annotations() {
    }

    @Field
    public static /* synthetic */ void isVisible$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getIsVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getIsSynced() {
        return this.isSynced;
    }

    public final CalendarUpdateInput copy(String id, String name, String title, Boolean isVisible, Boolean isSynced) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new CalendarUpdateInput(id, name, title, isVisible, isSynced);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarUpdateInput)) {
            return false;
        }
        CalendarUpdateInput calendarUpdateInput = (CalendarUpdateInput) other;
        return Intrinsics.areEqual(this.id, calendarUpdateInput.id) && Intrinsics.areEqual(this.name, calendarUpdateInput.name) && Intrinsics.areEqual(this.title, calendarUpdateInput.title) && Intrinsics.areEqual(this.isVisible, calendarUpdateInput.isVisible) && Intrinsics.areEqual(this.isSynced, calendarUpdateInput.isSynced);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isVisible;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isSynced;
        return iHashCode4 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "CalendarUpdateInput(id=" + this.id + ", name=" + this.name + ", title=" + this.title + ", isVisible=" + this.isVisible + ", isSynced=" + this.isSynced + ")";
    }

    public CalendarUpdateInput(String id, String str, String str2, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.name = str;
        this.title = str2;
        this.isVisible = bool;
        this.isSynced = bool2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isVisible() {
        return this.isVisible;
    }

    public final Boolean isSynced() {
        return this.isSynced;
    }

    public final ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        String str = this.name;
        if (str != null) {
            contentValues.put("name", str);
        }
        String str2 = this.title;
        if (str2 != null) {
            contentValues.put("calendar_displayName", str2);
        }
        Boolean bool = this.isVisible;
        if (bool != null) {
            contentValues.put("visible", bool);
        }
        Boolean bool2 = this.isSynced;
        if (bool2 != null) {
            contentValues.put("sync_events", bool2);
        }
        return contentValues;
    }
}
