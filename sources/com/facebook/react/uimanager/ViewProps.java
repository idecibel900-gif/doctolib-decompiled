package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.google.firebase.messaging.Constants;
import java.util.HashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewProps {
    public static final ViewProps INSTANCE = new ViewProps();
    public static final int[] BORDER_SPACING_TYPES = {8, 4, 5, 1, 3, 0, 2};
    public static final int[] PADDING_MARGIN_SPACING_TYPES = {8, 7, 6, 4, 5, 1, 3, 0, 2};
    private static final HashSet LAYOUT_ONLY_PROPS = new HashSet(CollectionsKt.listOf((Object[]) new String[]{"alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "rowGap", "columnGap", "gap", "flexShrink", "flexWrap", "justifyContent", "alignContent", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "position", "right", "top", "bottom", "left", "start", "end", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd"}));

    private ViewProps() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final boolean isLayoutOnly(ReadableMap map, String prop) {
        ReadableType type;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(prop, "prop");
        if (LAYOUT_ONLY_PROPS.contains(prop)) {
            return true;
        }
        if (Intrinsics.areEqual("pointerEvents", prop)) {
            String string = map.getString(prop);
            return Intrinsics.areEqual("auto", string) || Intrinsics.areEqual("box-none", string);
        }
        switch (prop.hashCode()) {
            case -1989576717:
                return prop.equals("borderRightColor") && map.getType("borderRightColor") == ReadableType.Number && map.getInt("borderRightColor") == 0;
            case -1971292586:
                if (prop.equals("borderRightWidth")) {
                    return map.isNull("borderRightWidth") || map.getDouble("borderRightWidth") == 0.0d;
                }
                return false;
            case -1470826662:
                return prop.equals("borderTopColor") && map.getType("borderTopColor") == ReadableType.Number && map.getInt("borderTopColor") == 0;
            case -1452542531:
                if (prop.equals("borderTopWidth")) {
                    return map.isNull("borderTopWidth") || map.getDouble("borderTopWidth") == 0.0d;
                }
                return false;
            case -1308858324:
                return prop.equals("borderBottomColor") && map.getType("borderBottomColor") == ReadableType.Number && map.getInt("borderBottomColor") == 0;
            case -1290574193:
                if (prop.equals("borderBottomWidth")) {
                    return map.isNull("borderBottomWidth") || map.getDouble("borderBottomWidth") == 0.0d;
                }
                return false;
            case -1267206133:
                if (prop.equals("opacity")) {
                    return map.isNull("opacity") || map.getDouble("opacity") == 1.0d;
                }
                return false;
            case -242276144:
                return prop.equals("borderLeftColor") && map.getType("borderLeftColor") == ReadableType.Number && map.getInt("borderLeftColor") == 0;
            case -223992013:
                if (prop.equals("borderLeftWidth")) {
                    return map.isNull("borderLeftWidth") || map.getDouble("borderLeftWidth") == 0.0d;
                }
                return false;
            case 306963138:
                return prop.equals("borderBlockStartColor") && map.getType("borderBlockStartColor") == ReadableType.Number && map.getInt("borderBlockStartColor") == 0;
            case 529642498:
                if (prop.equals("overflow")) {
                    return map.isNull("overflow") || Intrinsics.areEqual("visible", map.getString("overflow"));
                }
                return false;
            case 684610594:
                return prop.equals("borderBlockColor") && map.getType("borderBlockColor") == ReadableType.Number && map.getInt("borderBlockColor") == 0;
            case 741115130:
                if (prop.equals("borderWidth")) {
                    return map.isNull("borderWidth") || map.getDouble("borderWidth") == 0.0d;
                }
                return false;
            case 762983977:
                return prop.equals("borderBlockEndColor") && map.getType("borderBlockEndColor") == ReadableType.Number && map.getInt("borderBlockEndColor") == 0;
            case 1349188574:
                if (prop.equals("borderRadius")) {
                    if (!map.hasKey("backgroundColor") || (((type = map.getType("backgroundColor")) != ReadableType.Number || map.getInt("backgroundColor") == 0) && type == ReadableType.Null)) {
                        return !map.hasKey("borderWidth") || map.isNull("borderWidth") || map.getDouble("borderWidth") == 0.0d;
                    }
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
