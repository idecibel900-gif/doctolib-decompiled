package com.swmansion.enriched.markdown.utils.input;

import android.view.View;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BorderPropsApplicator {
    private static final Map COLOR_PROPS;
    public static final BorderPropsApplicator INSTANCE = new BorderPropsApplicator();
    private static final Map RADIUS_PROPS = MapsKt.mapOf(TuplesKt.to("borderRadius", BorderRadiusProp.BORDER_RADIUS), TuplesKt.to("borderTopLeftRadius", BorderRadiusProp.BORDER_TOP_LEFT_RADIUS), TuplesKt.to("borderTopRightRadius", BorderRadiusProp.BORDER_TOP_RIGHT_RADIUS), TuplesKt.to("borderBottomRightRadius", BorderRadiusProp.BORDER_BOTTOM_RIGHT_RADIUS), TuplesKt.to("borderBottomLeftRadius", BorderRadiusProp.BORDER_BOTTOM_LEFT_RADIUS));
    private static final Map WIDTH_PROPS;

    private BorderPropsApplicator() {
    }

    static {
        LogicalEdge logicalEdge = LogicalEdge.ALL;
        Pair pair = TuplesKt.to("borderWidth", logicalEdge);
        LogicalEdge logicalEdge2 = LogicalEdge.LEFT;
        Pair pair2 = TuplesKt.to("borderLeftWidth", logicalEdge2);
        LogicalEdge logicalEdge3 = LogicalEdge.RIGHT;
        Pair pair3 = TuplesKt.to("borderRightWidth", logicalEdge3);
        LogicalEdge logicalEdge4 = LogicalEdge.TOP;
        Pair pair4 = TuplesKt.to("borderTopWidth", logicalEdge4);
        LogicalEdge logicalEdge5 = LogicalEdge.BOTTOM;
        WIDTH_PROPS = MapsKt.mapOf(pair, pair2, pair3, pair4, TuplesKt.to("borderBottomWidth", logicalEdge5));
        COLOR_PROPS = MapsKt.mapOf(TuplesKt.to("borderColor", logicalEdge), TuplesKt.to("borderLeftColor", logicalEdge2), TuplesKt.to("borderRightColor", logicalEdge3), TuplesKt.to("borderTopColor", logicalEdge4), TuplesKt.to("borderBottomColor", logicalEdge5));
    }

    public final void apply(View view, ReactStylesDiffMap props) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        Iterator it = RADIUS_PROPS.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            BorderRadiusProp borderRadiusProp = (BorderRadiusProp) entry.getValue();
            if (props.hasKey(str)) {
                float f = props.getFloat(str, Float.NaN);
                BackgroundStyleApplicator.setBorderRadius(view, borderRadiusProp, Float.isNaN(f) ? null : new LengthPercentage(f, LengthPercentageType.POINT));
            }
        }
        for (Map.Entry entry2 : WIDTH_PROPS.entrySet()) {
            String str2 = (String) entry2.getKey();
            LogicalEdge logicalEdge = (LogicalEdge) entry2.getValue();
            if (props.hasKey(str2)) {
                BackgroundStyleApplicator.setBorderWidth(view, logicalEdge, Float.valueOf(props.getFloat(str2, Float.NaN)));
            }
        }
        for (Map.Entry entry3 : COLOR_PROPS.entrySet()) {
            String str3 = (String) entry3.getKey();
            LogicalEdge logicalEdge2 = (LogicalEdge) entry3.getValue();
            if (props.hasKey(str3)) {
                if (props.isNull(str3)) {
                    BackgroundStyleApplicator.setBorderColor(view, logicalEdge2, null);
                } else {
                    BackgroundStyleApplicator.setBorderColor(view, logicalEdge2, Integer.valueOf(props.getInt(str3, 0)));
                }
            }
        }
        if (props.hasKey("borderStyle")) {
            String string = props.getString("borderStyle");
            BackgroundStyleApplicator.setBorderStyle(view, string != null ? BorderStyle.Companion.fromString(string) : null);
        }
    }
}
