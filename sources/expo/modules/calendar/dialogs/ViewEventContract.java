package expo.modules.calendar.dialogs;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import expo.modules.kotlin.activityresult.AppContextActivityResultContract;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewEventContract implements AppContextActivityResultContract {
    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public Intent createIntent(Context context, ViewedEventOptions input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, Long.parseLong(input.getId()));
        Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uriWithAppendedId);
        boolean startNewActivityTask = input.getStartNewActivityTask();
        Boolean boolValueOf = Boolean.valueOf(startNewActivityTask);
        if (!startNewActivityTask) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public ViewEventIntentResult parseResult(ViewedEventOptions input, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new ViewEventIntentResult(null, 1, null);
    }
}
