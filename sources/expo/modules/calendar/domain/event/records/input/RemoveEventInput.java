package expo.modules.calendar.domain.event.records.input;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.Required;
import expo.modules.kotlin.types.Either;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR0\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lexpo/modules/calendar/domain/event/records/input/RemoveEventInput;", "Lexpo/modules/kotlin/records/Record;", DiagnosticsEntry.ID_KEY, "", "instanceStartDate", "Lexpo/modules/kotlin/types/Either;", "", "Lexpo/modules/calendar/extensions/DateTimeInput;", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/types/Either;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getInstanceStartDate$annotations", "getInstanceStartDate", "()Lexpo/modules/kotlin/types/Either;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RemoveEventInput implements Record {
    private final String id;
    private final Either<String, Long> instanceStartDate;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoveEventInput copy$default(RemoveEventInput removeEventInput, String str, Either either, int i, Object obj) {
        if ((i & 1) != 0) {
            str = removeEventInput.id;
        }
        if ((i & 2) != 0) {
            either = removeEventInput.instanceStartDate;
        }
        return removeEventInput.copy(str, either);
    }

    @Field
    @Required
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getInstanceStartDate$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final Either<String, Long> component2() {
        return this.instanceStartDate;
    }

    public final RemoveEventInput copy(String id, Either<String, Long> instanceStartDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new RemoveEventInput(id, instanceStartDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoveEventInput)) {
            return false;
        }
        RemoveEventInput removeEventInput = (RemoveEventInput) other;
        return Intrinsics.areEqual(this.id, removeEventInput.id) && Intrinsics.areEqual(this.instanceStartDate, removeEventInput.instanceStartDate);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        Either<String, Long> either = this.instanceStartDate;
        return iHashCode + (either == null ? 0 : either.hashCode());
    }

    public String toString() {
        return "RemoveEventInput(id=" + this.id + ", instanceStartDate=" + this.instanceStartDate + ")";
    }

    public RemoveEventInput(String id, Either<String, Long> either) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.instanceStartDate = either;
    }

    public final String getId() {
        return this.id;
    }

    public final Either<String, Long> getInstanceStartDate() {
        return this.instanceStartDate;
    }
}
