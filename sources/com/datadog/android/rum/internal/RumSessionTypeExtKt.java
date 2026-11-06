package com.datadog.android.rum.internal;

import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.ViewEvent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RumSessionTypeExtKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RumSessionType.values().length];
            try {
                iArr[RumSessionType.SYNTHETICS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RumSessionType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ActionEvent.ActionEventSessionType toAction(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return ActionEvent.ActionEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return ActionEvent.ActionEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ResourceEvent.ResourceEventSessionType toResource(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return ResourceEvent.ResourceEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return ResourceEvent.ResourceEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ErrorEvent.ErrorEventSessionType toError(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return ErrorEvent.ErrorEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return ErrorEvent.ErrorEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ViewEvent.ViewEventSessionType toView(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return ViewEvent.ViewEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return ViewEvent.ViewEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final LongTaskEvent.LongTaskEventSessionType toLongTask(RumSessionType rumSessionType) {
        Intrinsics.checkNotNullParameter(rumSessionType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[rumSessionType.ordinal()];
        if (i == 1) {
            return LongTaskEvent.LongTaskEventSessionType.SYNTHETICS;
        }
        if (i == 2) {
            return LongTaskEvent.LongTaskEventSessionType.USER;
        }
        throw new NoWhenBranchMatchedException();
    }
}
