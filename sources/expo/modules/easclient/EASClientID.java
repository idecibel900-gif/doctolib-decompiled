package expo.modules.easclient;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EASClientID {
    public static final Companion Companion = new Companion(null);
    private final Context context;
    private final Lazy uuid$delegate;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final double deterministicUniformValue(UUID uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            return UnsignedKt.ulongToDouble(ULong.m5297constructorimpl(uuid.getLeastSignificantBits())) / UnsignedKt.ulongToDouble(-1L);
        }
    }

    public EASClientID(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.uuid$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.easclient.EASClientID$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EASClientID.uuid_delegate$lambda$1(this.f$0);
            }
        });
    }

    public final UUID getUuid() {
        Object value = this.uuid$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (UUID) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UUID uuid_delegate$lambda$1(EASClientID eASClientID) {
        SharedPreferences sharedPreferences = eASClientID.context.getSharedPreferences("dev.expo.EASSharedPreferences", 0);
        String string = sharedPreferences.getString("eas-client-id", null);
        if (string == null) {
            string = UUID.randomUUID().toString();
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("eas-client-id", string);
            editorEdit.apply();
        }
        return UUID.fromString(string);
    }
}
