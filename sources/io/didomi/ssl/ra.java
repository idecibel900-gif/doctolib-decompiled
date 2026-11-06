package io.didomi.ssl;

import android.os.Build;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.events.Event;
import io.didomi.ssl.events.PreferencesClickAgreeToAllEvent;
import io.didomi.ssl.events.PreferencesClickAgreeToAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickCategoryAgreeEvent;
import io.didomi.ssl.events.PreferencesClickCategoryDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickDisagreeToAllEvent;
import io.didomi.ssl.events.PreferencesClickDisagreeToAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickPurposeAgreeEvent;
import io.didomi.ssl.events.PreferencesClickPurposeDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickResetAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickSaveChoicesEvent;
import io.didomi.ssl.models.UserStatus;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import io.didomi.ssl.view.mobile.DidomiToggle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bC\b\u0017\u0018\u00002\u00020\u0001By\b\u0007\u0012\u0006\u0010q\u001a\u00020o\u0012\u0006\u0010v\u001a\u00020r\u0012\u0006\u0010y\u001a\u00020w\u0012\u0006\u0010|\u001a\u00020z\u0012\u0006\u0010\u007f\u001a\u00020}\u0012\b\u0010\u0084\u0001\u001a\u00030\u0080\u0001\u0012\b\u0010\u0089\u0001\u001a\u00030\u0085\u0001\u0012\b\u0010\u008c\u0001\u001a\u00030\u008a\u0001\u0012\b\u0010\u0091\u0001\u001a\u00030\u008d\u0001\u0012\b\u0010\u0096\u0001\u001a\u00030\u0092\u0001\u0012\b\u0010\u009b\u0001\u001a\u00030\u0097\u0001\u0012\b\u0010\u009e\u0001\u001a\u00030\u009c\u0001¢\u0006\u0006\b¬\u0002\u0010\u00ad\u0002J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0006\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0011H\u0002J\u0010\u0010\t\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0006\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140!2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020\u0012H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010&\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0014J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010\u0013\u001a\u00020\u0012J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020+0\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020+0\u00022\u0006\u0010\f\u001a\u00020\u0005J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0006\u001a\u00020\u00192\u0006\u00100\u001a\u00020/J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u00020\u0014J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00122\u0006\u00101\u001a\u00020\u0014J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030!J\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030!J\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000304J\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000304J\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000304J\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000304J\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001704J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001704J\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001704J\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001704J\u000e\u0010=\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010>\u001a\u00020\u0005J\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010@\u001a\u00020\u0005J\u0010\u0010%\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010B\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010=\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010C\u001a\u00020\u0005J\b\u0010\u001d\u001a\u00020\u0019H\u0004J\u000e\u0010,\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010D\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003J\u0010\u0010E\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003J\u0006\u0010F\u001a\u00020\u0019J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005J\u0006\u0010H\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010I\u001a\u00020\u0005J\b\u0010J\u001a\u00020\u0019H\u0017J\u0006\u0010K\u001a\u00020\u0019J\u000e\u0010M\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\nJ\u000e\u0010O\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010O\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0003J\u0010\u0010\b\u001a\u00020\u00192\b\u0010P\u001a\u0004\u0018\u00010\nJ\u000e\u0010R\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010S\u001a\u00020\u0012J\u000e\u0010T\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010U\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010V\u001a\u00020\u0019J\b\u0010W\u001a\u00020\u0019H\u0014J\u0006\u0010X\u001a\u00020\u0019J\b\u0010Y\u001a\u00020\u0019H\u0014J\u0006\u0010Z\u001a\u00020\u0019J\u0006\u0010[\u001a\u00020\u0019J\u0006\u0010\\\u001a\u00020\u0019J\u0016\u0010,\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\b\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\nJ\u0016\u0010\t\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\nJ\u000e\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010_\u001a\u00020\u0019J\u0006\u0010`\u001a\u00020\u0019J\u0006\u0010a\u001a\u00020\u0019J\u0006\u0010b\u001a\u00020\u0019J\u0006\u0010c\u001a\u00020\u0005J\u0006\u0010d\u001a\u00020\u0005J\u0006\u0010f\u001a\u00020eJ\u0006\u0010g\u001a\u00020eJ\b\u0010h\u001a\u00020\u0019H\u0007J\b\u0010R\u001a\u00020\u0019H\u0007J\b\u0010\u001e\u001a\u00020\u0019H\u0007J\b\u0010A\u001a\u00020\u0019H\u0007J\b\u0010\"\u001a\u00020\u0019H\u0007J\b\u0010=\u001a\u00020\u0019H\u0007J\b\u0010O\u001a\u00020\u0019H\u0007J\b\u0010i\u001a\u00020\u0019H\u0007J\b\u0010 \u001a\u00020\u0019H\u0007J\b\u0010$\u001a\u00020\u0019H\u0007J\b\u0010%\u001a\u00020\u0019H\u0007J$\u0010\u0006\u001a\u00020\u00192\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030*2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002H\u0014J\u0010\u0010k\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003H\u0004J\u0010\u0010l\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0003H\u0004J\b\u0010m\u001a\u00020\u0019H\u0004J\u0006\u0010n\u001a\u00020\u0019R\u0014\u0010q\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010pR\u001a\u0010v\u001a\u00020r8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001a\u0010s\u001a\u0004\bt\u0010uR\u0014\u0010y\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010xR\u0014\u0010|\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010{R\u0014\u0010\u007f\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010~R\u001f\u0010\u0084\u0001\u001a\u00030\u0080\u00018\u0004X\u0084\u0004¢\u0006\u000f\n\u0005\b \u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001f\u0010\u0089\u0001\u001a\u00030\u0085\u00018\u0004X\u0084\u0004¢\u0006\u000f\n\u0005\b$\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0017\u0010\u008c\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001d\u0010\u008b\u0001R\u001c\u0010\u0091\u0001\u001a\u00030\u008d\u00018\u0006¢\u0006\u000f\n\u0005\b\"\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010\u0096\u0001\u001a\u00030\u0092\u00018\u0006¢\u0006\u000f\n\u0005\b\u001e\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001c\u0010\u009b\u0001\u001a\u00030\u0097\u00018\u0006¢\u0006\u000f\n\u0005\b=\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0017\u0010\u009e\u0001\u001a\u00030\u009c\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bO\u0010\u009d\u0001R\u001f\u0010¢\u0001\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b%\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001R\u001f\u0010¤\u0001\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bA\u0010\u009f\u0001\u001a\u0006\b£\u0001\u0010¡\u0001R\u001f\u0010¦\u0001\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bR\u0010\u009f\u0001\u001a\u0006\b¥\u0001\u0010¡\u0001R'\u0010ª\u0001\u001a\u00020\u00058DX\u0084\u0084\u0002¢\u0006\u0017\n\u0005\b\u001c\u0010\u009f\u0001\u0012\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\b§\u0001\u0010¡\u0001R\u001f\u0010¬\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\bE\u0010\u009f\u0001\u001a\u0006\b«\u0001\u0010¡\u0001R-\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\bk\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0005\b\u001a\u0010°\u0001R\u001e\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bl\u0010\u00ad\u0001R$\u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030!8\u0004X\u0084\u0004¢\u0006\u000f\n\u0005\b\u001f\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R$\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030!8\u0004X\u0084\u0004¢\u0006\u000f\n\u0005\bM\u0010³\u0001\u001a\u0006\b·\u0001\u0010µ\u0001R,\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170!8\u0006X\u0087\u0004¢\u0006\u0017\n\u0005\bU\u0010³\u0001\u0012\u0006\bº\u0001\u0010©\u0001\u001a\u0006\b¹\u0001\u0010µ\u0001R#\u0010Q\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030¼\u00018\u0006¢\u0006\u000f\n\u0005\bT\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001R#\u0010S\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00120¼\u00018\u0006¢\u0006\u000f\n\u0005\bD\u0010½\u0001\u001a\u0006\bÀ\u0001\u0010¿\u0001R \u0010Ã\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bÁ\u0001\u0010\u009f\u0001\u001a\u0006\bÂ\u0001\u0010¡\u0001R \u0010Æ\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bÄ\u0001\u0010\u009f\u0001\u001a\u0006\bÅ\u0001\u0010¡\u0001R(\u0010Ë\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÇ\u0001\u0010È\u0001\u001a\u0006\bÉ\u0001\u0010¡\u0001\"\u0005\b\u001a\u0010Ê\u0001R\u0019\u0010Í\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010È\u0001R$\u0010Ï\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0¼\u00018\u0006¢\u0006\u000f\n\u0005\b(\u0010½\u0001\u001a\u0006\bÎ\u0001\u0010¿\u0001R$\u0010P\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0¼\u00018\u0006¢\u0006\u0010\n\u0006\bÐ\u0001\u0010½\u0001\u001a\u0006\bÑ\u0001\u0010¿\u0001R%\u0010Ô\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0¼\u00018\u0006¢\u0006\u0010\n\u0006\bÒ\u0001\u0010½\u0001\u001a\u0006\bÓ\u0001\u0010¿\u0001R\u001c\u0010Ø\u0001\u001a\u0005\u0018\u00010Õ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R \u0010Û\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bÙ\u0001\u0010\u009f\u0001\u001a\u0006\bÚ\u0001\u0010¡\u0001R\u001f\u0010Ý\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\bt\u0010\u009f\u0001\u001a\u0006\bÜ\u0001\u0010¡\u0001R \u0010ß\u0001\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b´\u0001\u0010\u009f\u0001\u001a\u0006\bÞ\u0001\u0010¡\u0001R!\u0010ä\u0001\u001a\u00030à\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bá\u0001\u0010\u009f\u0001\u001a\u0006\bâ\u0001\u0010ã\u0001R/\u0010è\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010å\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÅ\u0001\u0010\u009f\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001R\u001f\u0010ê\u0001\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b8\u0010\u009f\u0001\u001a\u0006\bé\u0001\u0010¡\u0001R \u0010î\u0001\u001a\u00030ë\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b6\u0010\u009f\u0001\u001a\u0006\bì\u0001\u0010í\u0001R\u001e\u0010ï\u0001\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b3\u0010È\u0001\u001a\u0006\bÈ\u0001\u0010¡\u0001R$\u0010ñ\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140å\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bð\u0001\u0010ç\u0001R\u0016\u0010ó\u0001\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bT\u0010ò\u0001R\u001d\u0010ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bÌ\u0001\u0010¯\u0001R\u001d\u0010õ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bÄ\u0001\u0010¯\u0001R\u001d\u0010ö\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bÇ\u0001\u0010¯\u0001R\u001c\u0010÷\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u001f\u0010¯\u0001R\u001c\u0010ø\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bU\u0010¯\u0001R\u0017\u0010ù\u0001\u001a\u00020\u00148BX\u0082\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010ò\u0001R\u0017\u0010û\u0001\u001a\u00020\u00148BX\u0082\u0004¢\u0006\b\u001a\u0006\bú\u0001\u0010ò\u0001R\u001d\u0010ý\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170!8DX\u0084\u0004¢\u0006\b\u001a\u0006\bü\u0001\u0010µ\u0001R\u0014\u0010ÿ\u0001\u001a\u00020\u00058F¢\u0006\b\u001a\u0006\bþ\u0001\u0010¡\u0001R\u0014\u0010\u0081\u0002\u001a\u00020\u00058F¢\u0006\b\u001a\u0006\b\u0080\u0002\u0010¡\u0001R\u0014\u0010\u0082\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\bÐ\u0001\u0010ò\u0001R\u0013\u0010\u0083\u0002\u001a\u00020\u00148F¢\u0006\u0007\u001a\u0005\bE\u0010ò\u0001R\u0014\u0010\u0084\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\bá\u0001\u0010ò\u0001R\u0014\u0010\u0086\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b\u0085\u0002\u0010ò\u0001R\u0014\u0010\u0088\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b\u0087\u0002\u0010ò\u0001R\u0017\u0010\u008a\u0002\u001a\u00020\u00148VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0002\u0010ò\u0001R\u0014\u0010\u008c\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b\u008b\u0002\u0010ò\u0001R\u0014\u0010\u008e\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b\u008d\u0002\u0010ò\u0001R\u001a\u0010\u0090\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028F¢\u0006\b\u001a\u0006\b\u008f\u0002\u0010¯\u0001R\u0017\u0010\u0092\u0002\u001a\u00020\u00148VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0091\u0002\u0010ò\u0001R\u0014\u0010\u0094\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b\u0093\u0002\u0010ò\u0001R\u0014\u0010\u0096\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b\u0095\u0002\u0010ò\u0001R\u0014\u0010\u0098\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b\u0097\u0002\u0010ò\u0001R\u0013\u0010\u0099\u0002\u001a\u00020\u00148F¢\u0006\u0007\u001a\u0005\bD\u0010ò\u0001R\u0013\u0010\u009a\u0002\u001a\u00020\u00148F¢\u0006\u0007\u001a\u0005\bk\u0010ò\u0001R\u0014\u0010\u009c\u0002\u001a\u00020e8F¢\u0006\b\u001a\u0006\bÙ\u0001\u0010\u009b\u0002R\u0013\u0010\u009d\u0002\u001a\u00020\u00148F¢\u0006\u0007\u001a\u0005\bl\u0010ò\u0001R\u0014\u0010\u009e\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\bÁ\u0001\u0010ò\u0001R\u0014\u0010 \u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b\u009f\u0002\u0010ò\u0001R\u0014\u0010¢\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b¡\u0002\u0010ò\u0001R\u0013\u0010£\u0002\u001a\u00020\u00148F¢\u0006\u0007\u001a\u0005\bM\u0010ò\u0001R\u0014\u0010¥\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b¤\u0002\u0010ò\u0001R\u0014\u0010§\u0002\u001a\u00020\u00148F¢\u0006\b\u001a\u0006\b¦\u0002\u0010ò\u0001R\u0014\u0010©\u0002\u001a\u00020\n8F¢\u0006\b\u001a\u0006\bÖ\u0001\u0010¨\u0002R\u0014\u0010«\u0002\u001a\u00020\u00058F¢\u0006\b\u001a\u0006\bª\u0002\u0010¡\u0001¨\u0006®\u0002"}, d2 = {"Lio/didomi/sdk/ra;", "Landroidx/lifecycle/ViewModel;", "", "Lio/didomi/sdk/Purpose;", Didomi.VIEW_PURPOSES, "", "a", "Lio/didomi/sdk/w9;", "c", "d", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "state", "accessibilityAnnounceState", "Lio/didomi/sdk/q9;", "Lio/didomi/sdk/m1;", "dataProcessing", "Lio/didomi/sdk/p9$a;", "Lio/didomi/sdk/v9;", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "category", "", "", "count", "Lio/didomi/sdk/Vendor;", "vendor", "", "b", "purpose", "p", "h", "j", "t", "f", "", "i", "purposeCategory", "g", "m", "u1", "r1", "C", "C0", "", "Lio/didomi/sdk/o9;", "e", "O0", "j1", "Lio/didomi/sdk/events/Event;", "event", DiagnosticsEntry.ID_KEY, "U", "N", "", "T", "M", "S", "L", "V", "O", "W", "P", "k", "m1", "n1", "s1", "n", "X0", "t1", "x", "q", "V0", "isMainScreen", "q1", "P0", "v1", "k1", "item", "u", "value", "l", "selectedPurposeLegIntState", "selectedPurpose", "o", "selectedCategory", "w", "v", "Y0", "o1", "b1", "p1", "h1", "c1", "i1", "consentStatus", "legIntState", "a1", "e1", "Z0", "d1", "S0", "R0", "Lio/didomi/sdk/a;", "u0", "w0", "l1", "W0", "categories", "r", "s", "f1", "g1", "Lio/didomi/sdk/apiEvents/a;", "Lio/didomi/sdk/apiEvents/a;", "apiEventsRepository", "Lio/didomi/sdk/e0;", "Lio/didomi/sdk/e0;", "H", "()Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/r0;", "Lio/didomi/sdk/r0;", "consentRepository", "Lio/didomi/sdk/v0;", "Lio/didomi/sdk/v0;", "contextHelper", "Lio/didomi/sdk/b6;", "Lio/didomi/sdk/b6;", "eventsRepository", "Lio/didomi/sdk/n7;", "Lio/didomi/sdk/n7;", "c0", "()Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/jh;", "Lio/didomi/sdk/jh;", "L0", "()Lio/didomi/sdk/jh;", "userChoicesInfoProvider", "Lio/didomi/sdk/sh;", "Lio/didomi/sdk/sh;", "userStatusRepository", "Lio/didomi/sdk/eh;", "Lio/didomi/sdk/eh;", "F0", "()Lio/didomi/sdk/eh;", "uiProvider", "Lio/didomi/sdk/zh;", "Lio/didomi/sdk/zh;", "M0", "()Lio/didomi/sdk/zh;", "vendorRepository", "Lio/didomi/sdk/u7;", "Lio/didomi/sdk/u7;", "e0", "()Lio/didomi/sdk/u7;", "logoProvider", "Lio/didomi/sdk/a8;", "Lio/didomi/sdk/a8;", "navigationManager", "Lkotlin/Lazy;", "G0", "()Z", "useCcpa", "H0", "useGdpr", "I0", "useMixedRegulation", "U0", "isTcf2_2$annotations", "()V", "isTcf2_2", "Y", "excludeBulkConsentButtons", "Ljava/util/List;", "getRequiredPurposes", "()Ljava/util/List;", "(Ljava/util/List;)V", "requiredPurposes", "requiredCategories", "Ljava/util/Set;", "I", "()Ljava/util/Set;", "consentPurposes", "k0", "requiredPurposesLegInt", "m0", "getRequiredVendorsLegInt$annotations", "requiredVendorsLegInt", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "t0", "()Landroidx/lifecycle/MutableLiveData;", "r0", "y", "J0", "usePurposeTitleInPurposeCategory", "z", "K", "disableButtonsUntilScroll", "A", "Z", "getHasScrolledToTheBottom", "(Z)V", "hasScrolledToTheBottom", "B", "shouldAddRoomForIcon", "v0", "selectedPurposeConsentState", "D", "x0", "E", "s0", "selectedCategoryState", "Lio/didomi/sdk/b7;", "F", "Lio/didomi/sdk/b7;", "initialPurposesHolder", "G", "getCanCloseWhenConsentIsMissing", "canCloseWhenConsentIsMissing", "B0", "showWhenConsentIsMissing", "z0", "shouldBeCancelable", "Lio/didomi/sdk/l$f$a;", "J", "g0", "()Lio/didomi/sdk/l$f$a;", "preferencesContent", "", "E0", "()Ljava/util/Map;", "translatableSaveTitle", "K0", "useSaveAndCloseFromConfig", "Lio/didomi/sdk/oa;", "j0", "()Lio/didomi/sdk/oa;", "regulationResources", "hasNonEssentialPurposes", "f0", "nameMacroForSelectedPurpose", "()Ljava/lang/String;", "accessibilityPurposeActionDescription", "accessibilityStateDescription", "accessibilityStateActionDescription", "accessibilityStateBulkActionDescription", "accessibilityConsentStateActionDescription", "accessibilityLIStateActionDescription", "allPurposesText", "y0", "sensitivePersonalInfoButtonLabel", "l0", "requiredVendorsConsent", "A0", "shouldConsentBeCollected", "T0", "isSpecialFeature", "agreeButtonLabel", "accessibilityAgreeButtonActionDescription", "consentToggleText", "R", "disagreeButtonLabel", "Q", "disagreeButtonAccessibilityActionDescription", "X", "essentialPurposeText", "d0", "legitimateInterestToggleText", "h0", "purposeDescriptionLegal", "a0", "illustrations", "b0", "illustrationsHeaderLabel", "i0", "purposesMessageRawText", "q0", "scrollIndicatorText", "n0", "saveAndCloseButtonTitle", "accessibilitySaveButtonActionDescription", "accessibilityCloseDescription", "()Lio/didomi/sdk/a;", "closeDetailsButtonAccessibility", "accessibilityClosePurposesActionDescription", "accessibilitySavePurposeDetailActionDescription", "p0", "saveButtonLabel", "D0", com.amazon.a.a.o.b.S, "accessibilityHintForPurposes", "N0", "vendorsButtonLabel", "o0", "saveButtonDescriptionText", "()Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "bulkActionState", "Q0", "isSaveButtonEnabled", "<init>", "(Lio/didomi/sdk/apiEvents/a;Lio/didomi/sdk/e0;Lio/didomi/sdk/r0;Lio/didomi/sdk/v0;Lio/didomi/sdk/b6;Lio/didomi/sdk/n7;Lio/didomi/sdk/jh;Lio/didomi/sdk/sh;Lio/didomi/sdk/eh;Lio/didomi/sdk/zh;Lio/didomi/sdk/u7;Lio/didomi/sdk/a8;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class ra extends ViewModel {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private boolean hasScrolledToTheBottom;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private boolean shouldAddRoomForIcon;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData selectedPurposeConsentState;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData selectedPurposeLegIntState;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData selectedCategoryState;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private InitialPurposesHolder initialPurposesHolder;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private final Lazy canCloseWhenConsentIsMissing;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private final Lazy showWhenConsentIsMissing;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private final Lazy shouldBeCancelable;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private final Lazy preferencesContent;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private final Lazy translatableSaveTitle;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private final Lazy useSaveAndCloseFromConfig;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private final Lazy regulationResources;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private final boolean hasNonEssentialPurposes;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final io.didomi.ssl.apiEvents.a apiEventsRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final r0 consentRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final v0 contextHelper;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final b6 eventsRepository;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final n7 languagesHelper;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final jh userChoicesInfoProvider;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final sh userStatusRepository;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final eh uiProvider;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final zh vendorRepository;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final u7 logoProvider;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final a8 navigationManager;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final Lazy useCcpa;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy useGdpr;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final Lazy useMixedRegulation;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Lazy isTcf2_2;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Lazy excludeBulkConsentButtons;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private List<Purpose> requiredPurposes;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private List<PurposeCategory> requiredCategories;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final Set<Purpose> consentPurposes;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final Set<Purpose> requiredPurposesLegInt;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final Set<Vendor> requiredVendorsLegInt;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private final MutableLiveData selectedPurpose;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private final MutableLiveData selectedCategory;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private final Lazy usePurposeTitleInPurposeCategory;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    private final Lazy disableButtonsUntilScroll;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DidomiToggle.b.values().length];
            try {
                iArr[DidomiToggle.b.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DidomiToggle.b.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DidomiToggle.b.ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(ra.this.getConfigurationRepository().b().getPreferences().getCanCloseWhenConsentIsMissing());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(ra.this.getConfigurationRepository().b().getPreferences().getDisableButtonsUntilScroll());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0 {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(!ra.this.H0());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class e<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((m1) t).getName(), ((m1) t2).getName());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class f extends Lambda implements Function0 {
        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(Intrinsics.areEqual(io.didomi.ssl.m.d(ra.this.getConfigurationRepository().b()), "2.2"));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/l$f$a;", "a", "()Lio/didomi/sdk/l$f$a;"}, k = 3, mv = {1, 8, 0})
    static final class g extends Lambda implements Function0 {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppConfiguration.Preferences.Content invoke() {
            return ra.this.getConfigurationRepository().b().getPreferences().getContent();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/oa;", "a", "()Lio/didomi/sdk/oa;"}, k = 3, mv = {1, 8, 0})
    static final class h extends Lambda implements Function0 {
        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final oa invoke() {
            if (ra.this.G0()) {
                return w.a;
            }
            return ra.this.I0() ? v7.a : e6.a;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class i extends Lambda implements Function0 {
        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            AppConfiguration.Preferences preferences = ra.this.getConfigurationRepository().b().getPreferences();
            return Boolean.valueOf(preferences.getShowWhenConsentIsMissing() && !preferences.getCanCloseWhenConsentIsMissing());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class j extends Lambda implements Function0 {
        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(ra.this.getConfigurationRepository().b().getPreferences().getShowWhenConsentIsMissing());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "a", "()Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
    static final class k extends Lambda implements Function0 {
        k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, String> invoke() {
            return ra.this.K0() ? ra.this.g0().h() : ra.this.g0().g();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class l extends Lambda implements Function0 {
        l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(f0.g(ra.this.getConfigurationRepository()));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class m extends Lambda implements Function0 {
        m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(f0.i(ra.this.getConfigurationRepository()));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class n extends Lambda implements Function0 {
        n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(f0.k(ra.this.getConfigurationRepository()));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class o extends Lambda implements Function0 {
        o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(f0.l(ra.this.getConfigurationRepository()));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class p extends Lambda implements Function0 {
        p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            Map<String, String> mapH = ra.this.g0().h();
            return Boolean.valueOf((mapH == null || mapH.isEmpty() || ra.this.H0()) ? false : true);
        }
    }

    public ra(io.didomi.ssl.apiEvents.a apiEventsRepository, e0 configurationRepository, r0 consentRepository, v0 contextHelper, b6 eventsRepository, n7 languagesHelper, jh userChoicesInfoProvider, sh userStatusRepository, eh uiProvider, zh vendorRepository, u7 logoProvider, a8 navigationManager) {
        Intrinsics.checkNotNullParameter(apiEventsRepository, "apiEventsRepository");
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(consentRepository, "consentRepository");
        Intrinsics.checkNotNullParameter(contextHelper, "contextHelper");
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(userChoicesInfoProvider, "userChoicesInfoProvider");
        Intrinsics.checkNotNullParameter(userStatusRepository, "userStatusRepository");
        Intrinsics.checkNotNullParameter(uiProvider, "uiProvider");
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        Intrinsics.checkNotNullParameter(navigationManager, "navigationManager");
        this.apiEventsRepository = apiEventsRepository;
        this.configurationRepository = configurationRepository;
        this.consentRepository = consentRepository;
        this.contextHelper = contextHelper;
        this.eventsRepository = eventsRepository;
        this.languagesHelper = languagesHelper;
        this.userChoicesInfoProvider = userChoicesInfoProvider;
        this.userStatusRepository = userStatusRepository;
        this.uiProvider = uiProvider;
        this.vendorRepository = vendorRepository;
        this.logoProvider = logoProvider;
        this.navigationManager = navigationManager;
        this.useCcpa = LazyKt.lazy(new l());
        this.useGdpr = LazyKt.lazy(new m());
        this.useMixedRegulation = LazyKt.lazy(new n());
        this.isTcf2_2 = LazyKt.lazy(new f());
        this.excludeBulkConsentButtons = LazyKt.lazy(new d());
        this.requiredPurposes = ai.c(vendorRepository);
        this.requiredCategories = vendorRepository.e();
        Set<Purpose> setL = vendorRepository.l();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setL) {
            if (!ca.a((Purpose) obj)) {
                arrayList.add(obj);
            }
        }
        this.consentPurposes = CollectionsKt.toSet(arrayList);
        Set<Purpose> setN = this.vendorRepository.n();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setN) {
            if (!ca.a((Purpose) obj2)) {
                arrayList2.add(obj2);
            }
        }
        this.requiredPurposesLegInt = CollectionsKt.toSet(arrayList2);
        this.requiredVendorsLegInt = this.vendorRepository.t();
        this.selectedPurpose = new MutableLiveData();
        this.selectedCategory = new MutableLiveData();
        this.usePurposeTitleInPurposeCategory = LazyKt.lazy(new o());
        this.disableButtonsUntilScroll = LazyKt.lazy(new c());
        this.selectedPurposeConsentState = new MutableLiveData();
        this.selectedPurposeLegIntState = new MutableLiveData();
        this.selectedCategoryState = new MutableLiveData();
        this.canCloseWhenConsentIsMissing = LazyKt.lazy(new b());
        this.showWhenConsentIsMissing = LazyKt.lazy(new j());
        this.shouldBeCancelable = LazyKt.lazy(new i());
        this.preferencesContent = LazyKt.lazy(new g());
        this.translatableSaveTitle = LazyKt.lazy(new k());
        this.useSaveAndCloseFromConfig = LazyKt.lazy(new p());
        this.regulationResources = LazyKt.lazy(new h());
        this.hasNonEssentialPurposes = a(this.requiredPurposes);
    }

    private final List<String> A() {
        return CollectionsKt.listOf((Object[]) new String[]{n7.a(this.languagesHelper, "reset_all_data_processing", null, null, null, 14, null), n7.a(this.languagesHelper, "disable_all_data_processing", null, null, null, 14, null), n7.a(this.languagesHelper, "enable_all_data_processing", null, null, null, 14, null)});
    }

    private final List<String> B() {
        return CollectionsKt.listOf((Object[]) new String[]{n7.a(this.languagesHelper, "disabled", null, null, null, 14, null), n7.a(this.languagesHelper, "enabled", null, null, null, 14, null), n7.a(this.languagesHelper, "unspecified", null, null, null, 14, null)});
    }

    private final String E() {
        return n7.a(this.languagesHelper, f0.f(this.configurationRepository) ? "you_allow" : "bulk_action_on_purposes_mobile", null, null, null, 14, null);
    }

    private final Map<String, String> E0() {
        return (Map) this.translatableSaveTitle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G0() {
        return ((Boolean) this.useCcpa.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H0() {
        return ((Boolean) this.useGdpr.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I0() {
        return ((Boolean) this.useMixedRegulation.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K0() {
        return ((Boolean) this.useSaveAndCloseFromConfig.getValue()).booleanValue();
    }

    private final Map<String, String> f0() {
        Purpose purpose = (Purpose) this.selectedPurpose.getValue();
        String name = purpose != null ? purpose.getName() : null;
        if (name == null) {
            name = "";
        }
        return MapsKt.mapOf(TuplesKt.to("{targetName}", name));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppConfiguration.Preferences.Content g0() {
        return (AppConfiguration.Preferences.Content) this.preferencesContent.getValue();
    }

    private final oa j0() {
        return (oa) this.regulationResources.getValue();
    }

    private final List<String> t() {
        return CollectionsKt.listOf((Object[]) new String[]{n7.a(this.languagesHelper, "reset_consent_action", null, f0(), null, 10, null), n7.a(this.languagesHelper, "disable_consent_action", null, f0(), null, 10, null), n7.a(this.languagesHelper, "enable_consent_action", null, f0(), null, 10, null)});
    }

    private final List<String> v() {
        return CollectionsKt.listOf((Object[]) new String[]{n7.a(this.languagesHelper, "enable_li_action", null, f0(), null, 10, null), n7.a(this.languagesHelper, "disable_li_action", null, f0(), null, 10, null), n7.a(this.languagesHelper, "enable_li_action", null, f0(), null, 10, null)});
    }

    private final String w() {
        return n7.a(this.languagesHelper, "know_more_about_this_purpose", null, null, null, 14, null);
    }

    private final String y0() {
        return n7.a(this.languagesHelper, this.configurationRepository.b().getNotice().getContent().d(), null, 2, null);
    }

    private final List<String> z() {
        return CollectionsKt.listOf((Object[]) new String[]{n7.a(this.languagesHelper, "reset_this_purpose", null, null, null, 14, null), n7.a(this.languagesHelper, "disable_this_purpose", null, null, null, 14, null), n7.a(this.languagesHelper, "enable_this_purpose", null, null, null, 14, null)});
    }

    public final boolean A0() {
        return this.consentRepository.t();
    }

    public final boolean B0() {
        return ((Boolean) this.showWhenConsentIsMissing.getValue()).booleanValue();
    }

    public final String C() {
        return n7.a(this.languagesHelper, "list_of_additional_data_processing_on_purposes", null, null, null, 14, null);
    }

    public final List<m1> C0() {
        return CollectionsKt.sortedWith(this.vendorRepository.g(), new e());
    }

    public final String D() {
        return n7.a(this.languagesHelper, this.configurationRepository.b().getPreferences().getContent().a(), "agree_to_all_5b7ca45d", (gc) null, 4, (Object) null);
    }

    public final String D0() {
        return x8.a.a(this.configurationRepository, this.languagesHelper);
    }

    public final DidomiToggle.b F() {
        if (b()) {
            return DidomiToggle.b.ENABLED;
        }
        return a() ? DidomiToggle.b.DISABLED : DidomiToggle.b.UNKNOWN;
    }

    /* JADX INFO: renamed from: F0, reason: from getter */
    public final eh getUiProvider() {
        return this.uiProvider;
    }

    public final Accessibility G() {
        return new Accessibility(n7.a(this.languagesHelper, "close", null, null, null, 14, null), n7.a(this.languagesHelper, "go_back_to_purposes_list", null, null, null, 14, null), null, false, 0, null, 60, null);
    }

    /* JADX INFO: renamed from: H, reason: from getter */
    protected final e0 getConfigurationRepository() {
        return this.configurationRepository;
    }

    protected final Set<Purpose> I() {
        return this.consentPurposes;
    }

    public final String J() {
        return T0() ? n7.a(this.languagesHelper, "opt_in", (gc) null, (Map) null, 6, (Object) null) : n7.a(this.languagesHelper, AuthorizationRequest.Prompt.CONSENT, (gc) null, (Map) null, 6, (Object) null);
    }

    public final boolean J0() {
        return ((Boolean) this.usePurposeTitleInPurposeCategory.getValue()).booleanValue();
    }

    public final boolean K() {
        return ((Boolean) this.disableButtonsUntilScroll.getValue()).booleanValue();
    }

    public final Set<Purpose> L() {
        return this.userChoicesInfoProvider.d();
    }

    /* JADX INFO: renamed from: L0, reason: from getter */
    protected final jh getUserChoicesInfoProvider() {
        return this.userChoicesInfoProvider;
    }

    public final Set<Purpose> M() {
        return this.userChoicesInfoProvider.b();
    }

    /* JADX INFO: renamed from: M0, reason: from getter */
    public final zh getVendorRepository() {
        return this.vendorRepository;
    }

    public final Set<Purpose> N() {
        Set<Purpose> setB = this.userChoicesInfoProvider.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setB) {
            if (!ca.a((Purpose) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final String N0() {
        return n7.a(this.languagesHelper, "manage_our_partners", null, null, null, 14, null);
    }

    public final Set<Vendor> O() {
        return this.userChoicesInfoProvider.c();
    }

    public List<Purpose> O0() {
        this.requiredPurposes = CollectionsKt.toList(ai.c(this.vendorRepository));
        return j1();
    }

    public final Set<Vendor> P() {
        return this.userChoicesInfoProvider.e();
    }

    public final boolean P0() {
        return (this.userChoicesInfoProvider.f().isEmpty() && this.userChoicesInfoProvider.h().isEmpty()) ? false : true;
    }

    public final String Q() {
        return n7.a(this.languagesHelper, "refuse_data_processing", null, null, null, 14, null);
    }

    public final boolean Q0() {
        return (p() && !t1()) || G0();
    }

    public final String R() {
        return n7.a(this.languagesHelper, this.configurationRepository.b().getPreferences().getContent().d(), "disagree_to_all_c0355616", (gc) null, 4, (Object) null);
    }

    public final boolean R0() {
        Purpose purpose = (Purpose) this.selectedPurpose.getValue();
        if (purpose == null) {
            return false;
        }
        return ca.a(U(), purpose) || ca.a(N(), purpose) || !ca.a(this.consentPurposes, purpose);
    }

    public final Set<Purpose> S() {
        return this.userChoicesInfoProvider.h();
    }

    public final boolean S0() {
        Purpose purpose = (Purpose) this.selectedPurpose.getValue();
        return purpose != null && purpose.isEssential();
    }

    public final Set<Purpose> T() {
        return this.userChoicesInfoProvider.f();
    }

    public final boolean T0() {
        Purpose purpose = (Purpose) this.selectedPurpose.getValue();
        return purpose != null && purpose.isSpecialFeature();
    }

    public final Set<Purpose> U() {
        Set<Purpose> setF = this.userChoicesInfoProvider.f();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setF) {
            if (!ca.a((Purpose) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    protected final boolean U0() {
        return ((Boolean) this.isTcf2_2.getValue()).booleanValue();
    }

    public final Set<Vendor> V() {
        return this.userChoicesInfoProvider.g();
    }

    public final void V0() {
        UserStatus.Vendors vendors = this.userStatusRepository.b().getVendors();
        for (Vendor vendor : l0()) {
            if (vendors.getGlobalConsent().getEnabled().contains(vendor.getId())) {
                b(vendor);
            } else if (vendors.getConsent().getDisabled().contains(vendor.getId())) {
                a(vendor);
            }
        }
    }

    public final Set<Vendor> W() {
        return this.userChoicesInfoProvider.i();
    }

    public final void W0() {
        this.userChoicesInfoProvider.i(new LinkedHashSet());
        this.userChoicesInfoProvider.e(new LinkedHashSet());
    }

    public String X() {
        return n7.a(this.languagesHelper, "essential_purpose_label", gc.UPPER_CASE, null, null, 12, null);
    }

    public final boolean X0() {
        if (U().isEmpty() && N().isEmpty()) {
            return (S().isEmpty() || S().size() == this.requiredPurposesLegInt.size()) && L().isEmpty();
        }
        return false;
    }

    public final boolean Y() {
        return ((Boolean) this.excludeBulkConsentButtons.getValue()).booleanValue();
    }

    public final void Y0() {
        o1();
        l1();
        a(new PreferencesClickAgreeToAllEvent());
        this.navigationManager.b();
        this.navigationManager.a();
    }

    /* JADX INFO: renamed from: Z, reason: from getter */
    public final boolean getHasNonEssentialPurposes() {
        return this.hasNonEssentialPurposes;
    }

    public final void Z0() {
        InitialPurposesHolder initialPurposesHolder = this.initialPurposesHolder;
        if (initialPurposesHolder != null) {
            c7.a(initialPurposesHolder, this.userChoicesInfoProvider);
        }
        k1();
    }

    protected void a(List<Purpose> purposes, List<PurposeCategory> categories) {
        Intrinsics.checkNotNullParameter(purposes, "purposes");
        Intrinsics.checkNotNullParameter(categories, "categories");
    }

    public final List<String> a0() {
        ArrayList arrayList;
        List<String> illustrations;
        Purpose purpose = (Purpose) this.selectedPurpose.getValue();
        if (purpose == null || (illustrations = purpose.getIllustrations()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(illustrations, 10));
            Iterator<T> it = illustrations.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((String) it.next()).toString());
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    public final void a1() {
        this.initialPurposesHolder = InitialPurposesHolder.INSTANCE.a(this.userChoicesInfoProvider);
    }

    public String b0() {
        return n7.a(this.languagesHelper, "purpose_illustration_explanation", null, null, null, 14, null);
    }

    public final void b1() {
        p1();
        l1();
        a(new PreferencesClickDisagreeToAllEvent());
        this.navigationManager.b();
        this.navigationManager.a();
    }

    /* JADX INFO: renamed from: c0, reason: from getter */
    protected final n7 getLanguagesHelper() {
        return this.languagesHelper;
    }

    public final void c1() {
        this.navigationManager.b();
    }

    public final String d0() {
        return n7.a(this.languagesHelper, "legitimate_interest", (gc) null, (Map) null, 6, (Object) null);
    }

    public final void d1() {
        InitialPurposesHolder initialPurposesHolder = this.initialPurposesHolder;
        if (initialPurposesHolder != null) {
            c7.a(initialPurposesHolder, this.userChoicesInfoProvider);
        }
        Purpose purpose = (Purpose) this.selectedPurpose.getValue();
        if (purpose != null) {
            this.selectedPurposeLegIntState.setValue(j(purpose));
            this.selectedPurposeConsentState.setValue(h(purpose));
        }
        k1();
    }

    /* JADX INFO: renamed from: e0, reason: from getter */
    public final u7 getLogoProvider() {
        return this.logoProvider;
    }

    public final void e1() {
        this.initialPurposesHolder = InitialPurposesHolder.INSTANCE.a(this.userChoicesInfoProvider);
    }

    public final DidomiToggle.b f(PurposeCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        List<PurposeCategory> children = category.getChildren();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            Purpose purposeH = h((PurposeCategory) it.next());
            if (purposeH != null) {
                arrayList.add(purposeH);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((Purpose) obj).isEssential()) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(l((Purpose) it2.next()));
        }
        List listDistinct = CollectionsKt.distinct(arrayList3);
        return listDistinct.size() == 1 ? (DidomiToggle.b) CollectionsKt.first(listDistinct) : DidomiToggle.b.UNKNOWN;
    }

    protected final void f1() {
        this.apiEventsRepository.g();
    }

    public final void g() {
        this.userChoicesInfoProvider.i(new LinkedHashSet());
        this.userChoicesInfoProvider.e(CollectionsKt.toMutableSet(this.consentRepository.a(this.vendorRepository.l())));
    }

    public final void g1() {
        if (B0()) {
            return;
        }
        this.apiEventsRepository.j();
    }

    protected final void h() {
        this.userChoicesInfoProvider.k(new LinkedHashSet());
        this.userChoicesInfoProvider.g(CollectionsKt.toMutableSet(this.requiredPurposesLegInt));
    }

    public final String h0() {
        Purpose purpose = (Purpose) this.selectedPurpose.getValue();
        return fc.k(purpose != null ? purpose.getDescriptionLegal() : null).toString();
    }

    public final void h1() {
        v1();
        a(new PreferencesClickSaveChoicesEvent());
        this.navigationManager.b();
        this.navigationManager.a();
    }

    public final String i(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        return StringsKt.trim(purpose.getDescription()).toString();
    }

    public final String i0() {
        return n7.a(this.languagesHelper, this.configurationRepository.b().getPreferences().getContent().j(), "preferences_message", (gc) null, 4, (Object) null);
    }

    public final void i1() {
        this.navigationManager.b();
    }

    public final void j(PurposeCategory selectedCategory) {
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        this.selectedCategoryState.setValue(f(selectedCategory));
    }

    public final List<Purpose> j1() {
        List<Purpose> mutableList = CollectionsKt.toMutableList((Collection) this.requiredPurposes);
        ca.a(mutableList);
        if (this.requiredCategories.isEmpty()) {
            return mutableList;
        }
        a(mutableList, this.requiredCategories);
        this.shouldAddRoomForIcon = false;
        for (Purpose purpose : mutableList) {
            Iterator<T> it = this.requiredCategories.iterator();
            while (it.hasNext()) {
                a(purpose, (PurposeCategory) it.next());
            }
        }
        return mutableList;
    }

    public final String k(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        return purpose.getName();
    }

    protected final Set<Purpose> k0() {
        return this.requiredPurposesLegInt;
    }

    public final void k1() {
        this.selectedPurpose.setValue(null);
        this.selectedPurposeConsentState.setValue(null);
        this.selectedPurposeLegIntState.setValue(null);
    }

    public final void l(PurposeCategory item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.selectedCategory.setValue(item);
    }

    protected final Set<Vendor> l0() {
        return this.vendorRepository.r();
    }

    public final void l1() {
        this.consentRepository.a(T(), M(), S(), L(), V(), O(), W(), P(), true, "click", this.apiEventsRepository, this.eventsRepository);
    }

    public final boolean m(PurposeCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        List<PurposeCategory> children = category.getChildren();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            Purpose purposeH = h((PurposeCategory) it.next());
            if (purposeH != null) {
                arrayList.add(purposeH);
            }
        }
        return !d(arrayList);
    }

    public final Set<Vendor> m0() {
        return this.requiredVendorsLegInt;
    }

    public final boolean m1() {
        Purpose purpose = (Purpose) this.selectedPurpose.getValue();
        return purpose != null && purpose.isConsentNotEssential();
    }

    public final String n(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        if (U0()) {
            return a(ai.b(this.vendorRepository, purpose).size());
        }
        return null;
    }

    public final String n0() {
        return n7.a(this.languagesHelper, E0(), j0().a(), (gc) null, 4, (Object) null);
    }

    public final boolean n1() {
        Purpose purpose = (Purpose) this.selectedPurpose.getValue();
        return (purpose == null || !purpose.isLegitimateInterestNotEssential() || purpose.isSpecialFeature()) ? false : true;
    }

    public final void o(Purpose selectedPurpose) {
        Intrinsics.checkNotNullParameter(selectedPurpose, "selectedPurpose");
        this.selectedPurposeLegIntState.setValue(j(selectedPurpose));
        this.selectedPurposeConsentState.setValue(h(selectedPurpose));
    }

    public final String o0() {
        return n7.a(this.languagesHelper, "disabled_save_button_description", null, null, null, 14, null);
    }

    protected void o1() {
        o();
        n();
        k();
        m();
    }

    public final boolean p() {
        return U().size() + N().size() == this.consentPurposes.size() && S().size() + L().size() == this.requiredPurposesLegInt.size();
    }

    public final String p0() {
        return n7.a(this.languagesHelper, this.configurationRepository.b().getPreferences().getContent().g(), "save_11a80ec3", (gc) null, 4, (Object) null);
    }

    protected void p1() {
        j();
        f();
        if (this.configurationRepository.b().getPreferences().getDenyAppliesToLI()) {
            h();
            i();
        } else {
            m();
            n();
        }
    }

    public final String q() {
        return n7.a(this.languagesHelper, "accept_data_processing", null, null, null, 14, null);
    }

    public final String q0() {
        return n7.a(this.languagesHelper, "disable_buttons_until_scroll_indicator", gc.UPPER_CASE, null, null, 12, null);
    }

    public final boolean q1() {
        return this.configurationRepository.b().getPreferences().getCanCloseWhenConsentIsMissing() || !this.consentRepository.n();
    }

    public final String r() {
        return n7.a(this.languagesHelper, "close", null, null, null, 14, null);
    }

    /* JADX INFO: renamed from: r0, reason: from getter */
    public final MutableLiveData getSelectedCategory() {
        return this.selectedCategory;
    }

    public final boolean r1() {
        return !this.vendorRepository.g().isEmpty();
    }

    public final String s() {
        return n7.a(this.languagesHelper, "close_purpose_view", null, null, null, 14, null);
    }

    /* JADX INFO: renamed from: s0, reason: from getter */
    public final MutableLiveData getSelectedCategoryState() {
        return this.selectedCategoryState;
    }

    public final boolean s1() {
        String descriptionLegal;
        Purpose purpose = (Purpose) this.selectedPurpose.getValue();
        if (purpose == null || (descriptionLegal = purpose.getDescriptionLegal()) == null) {
            return false;
        }
        return !StringsKt.isBlank(descriptionLegal);
    }

    /* JADX INFO: renamed from: t0, reason: from getter */
    public final MutableLiveData getSelectedPurpose() {
        return this.selectedPurpose;
    }

    public final boolean t1() {
        return K() && !this.hasScrolledToTheBottom && !p() && X0();
    }

    public final String u() {
        return n7.a(this.languagesHelper, "consent_management", null, null, null, 14, null);
    }

    public final Accessibility u0() {
        DidomiToggle.b bVar = (DidomiToggle.b) this.selectedPurposeConsentState.getValue();
        if (bVar == null) {
            bVar = DidomiToggle.b.UNKNOWN;
        }
        int iOrdinal = bVar.ordinal();
        return new Accessibility(n7.a(this.languagesHelper, AuthorizationRequest.Prompt.CONSENT, null, null, null, 14, null), t().get(iOrdinal), B().get(iOrdinal), false, 0, null, 56, null);
    }

    public final void u1() {
        kh.a(this.userChoicesInfoProvider, this.consentRepository.b(), this.vendorRepository);
    }

    /* JADX INFO: renamed from: v0, reason: from getter */
    public final MutableLiveData getSelectedPurposeConsentState() {
        return this.selectedPurposeConsentState;
    }

    public void v1() {
        if (P0()) {
            o();
        } else {
            j();
        }
        n();
        l1();
    }

    public final Accessibility w0() {
        DidomiToggle.b bVar = (DidomiToggle.b) this.selectedPurposeLegIntState.getValue();
        if (bVar == null) {
            bVar = DidomiToggle.b.ENABLED;
        }
        Intrinsics.checkNotNullExpressionValue(bVar, "selectedPurposeLegIntSta…idomiToggle.State.ENABLED");
        return new Accessibility(n7.a(this.languagesHelper, "legitimate_interest", null, null, null, 14, null), v().get((bVar == DidomiToggle.b.ENABLED ? bVar : DidomiToggle.b.UNKNOWN).ordinal()), B().get(bVar.ordinal()), false, 0, null, 56, null);
    }

    public final String x() {
        return n7.a(this.languagesHelper, "save_data_processing_choices", null, null, null, 14, null);
    }

    /* JADX INFO: renamed from: x0, reason: from getter */
    public final MutableLiveData getSelectedPurposeLegIntState() {
        return this.selectedPurposeLegIntState;
    }

    public final String y() {
        return n7.a(this.languagesHelper, "save_vendor_and_back_to_purpose", null, null, null, 14, null);
    }

    public final boolean z0() {
        return ((Boolean) this.shouldBeCancelable.getValue()).booleanValue();
    }

    private final boolean c(List<PurposeDisplayItem> purposes) {
        return f0.c(this.configurationRepository) && this.hasNonEssentialPurposes && purposes.size() > 1;
    }

    private final boolean d(List<Purpose> purposes) {
        return f0.d(this.configurationRepository) && a(purposes) && purposes.size() > 1;
    }

    protected final void b(List<Purpose> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.requiredPurposes = list;
    }

    public final List<o9> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c());
        List<PurposeDisplayItem> listD = d();
        if (c(listD)) {
            arrayList.add(a(false));
        }
        arrayList.addAll(listD);
        if (r1()) {
            String strC = C();
            String strW = w();
            List<m1> listC0 = C0();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC0, 10));
            Iterator<T> it = listC0.iterator();
            while (it.hasNext()) {
                arrayList2.add(a((m1) it.next()));
            }
            arrayList.add(new PurposeDisplayAdditionalDataProcessing(strC, strW, arrayList2));
        }
        if (f0.e(this.configurationRepository)) {
            arrayList.add(new PurposeDisplayFooterSensitivePersonalInfo(y0()));
        }
        arrayList.add(new PurposeDisplayFooterVendor(N0()));
        return arrayList;
    }

    public final void i() {
        for (Vendor vendor : this.requiredVendorsLegInt) {
            if (!this.userChoicesInfoProvider.i().contains(vendor)) {
                this.userChoicesInfoProvider.e().add(vendor);
            }
        }
    }

    public final void j() {
        this.userChoicesInfoProvider.b(l0());
    }

    public final boolean k(PurposeCategory purposeCategory) {
        Intrinsics.checkNotNullParameter(purposeCategory, "purposeCategory");
        List<PurposeCategory> children = purposeCategory.getChildren();
        boolean z = false;
        if (children.isEmpty()) {
            return false;
        }
        if (!children.isEmpty()) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                Purpose purposeH = h((PurposeCategory) it.next());
                if (purposeH != null && !purposeH.isEssential()) {
                    z = true;
                    break;
                }
            }
        }
        return !z;
    }

    public final DidomiToggle.b l(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        DidomiToggle.b bVar = DidomiToggle.b.UNKNOWN;
        if ((ca.a(this.userChoicesInfoProvider.f(), purpose) || !v(purpose)) && (ca.a(this.userChoicesInfoProvider.h(), purpose) || !w(purpose))) {
            return DidomiToggle.b.ENABLED;
        }
        return ((ca.a(this.userChoicesInfoProvider.b(), purpose) || !v(purpose)) && (ca.a(this.userChoicesInfoProvider.d(), purpose) || !w(purpose))) ? DidomiToggle.b.DISABLED : bVar;
    }

    public final boolean q(Purpose purpose) {
        return ca.a(this.userChoicesInfoProvider.h(), purpose);
    }

    protected final void r(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        c(purpose);
        a(new PreferencesClickPurposeDisagreeEvent(purpose.getId()));
    }

    protected final void s(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        f(purpose);
        a(new PreferencesClickPurposeAgreeEvent(purpose.getId()));
    }

    public final void u(Purpose item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.selectedPurpose.setValue(item);
    }

    public final boolean w(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        return purpose.isLegitimateInterestNotEssential();
    }

    public final void x(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        this.userChoicesInfoProvider.e(purpose);
    }

    private final DidomiToggle.b h(Purpose purpose) {
        if (ca.a(this.userChoicesInfoProvider.b(), purpose)) {
            return DidomiToggle.b.DISABLED;
        }
        return ca.a(this.userChoicesInfoProvider.f(), purpose) ? DidomiToggle.b.ENABLED : DidomiToggle.b.UNKNOWN;
    }

    private final DidomiToggle.b j(Purpose purpose) {
        if (ca.a(this.userChoicesInfoProvider.d(), purpose)) {
            return DidomiToggle.b.DISABLED;
        }
        return DidomiToggle.b.ENABLED;
    }

    private final boolean p(Purpose purpose) {
        return this.requiredPurposesLegInt.contains(purpose);
    }

    public final List<o9> a(PurposeCategory category, boolean accessibilityAnnounceState) {
        Intrinsics.checkNotNullParameter(category, "category");
        ArrayList arrayList = new ArrayList();
        List<PurposeCategory> children = category.getChildren();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            Purpose purposeH = h((PurposeCategory) it.next());
            if (purposeH != null) {
                arrayList2.add(purposeH);
            }
        }
        if (d(CollectionsKt.distinct(arrayList2))) {
            arrayList.add(a(f(category), accessibilityAnnounceState));
        }
        List<PurposeCategory> children2 = category.getChildren();
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it2 = children2.iterator();
        while (it2.hasNext()) {
            Purpose purposeH2 = h((PurposeCategory) it2.next());
            if (purposeH2 != null) {
                arrayList3.add(purposeH2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            PurposeDisplayItem purposeDisplayItemG = g((Purpose) it3.next());
            if (purposeDisplayItemG != null) {
                arrayList4.add(purposeDisplayItemG);
            }
        }
        arrayList.addAll(CollectionsKt.distinct(arrayList4));
        return CollectionsKt.toList(arrayList);
    }

    public final void b(boolean z) {
        this.hasScrolledToTheBottom = z;
    }

    public final List<o9> c(PurposeCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        ArrayList arrayList = new ArrayList();
        List<PurposeCategory> children = category.getChildren();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            Purpose purposeH = h((PurposeCategory) it.next());
            if (purposeH != null) {
                arrayList2.add(purposeH);
            }
        }
        if (J0()) {
            arrayList.add(new PurposeDisplayCategoryHeader("", d(category)));
        } else {
            arrayList.add(new PurposeDisplayCategoryHeader(e(category), d(category)));
        }
        if (d(arrayList2)) {
            arrayList.add(a(f(category), false));
        }
        List<PurposeCategory> children2 = category.getChildren();
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it2 = children2.iterator();
        while (it2.hasNext()) {
            Purpose purposeH2 = h((PurposeCategory) it2.next());
            if (purposeH2 != null) {
                arrayList3.add(purposeH2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            PurposeDisplayItem purposeDisplayItemG = g((Purpose) it3.next());
            if (purposeDisplayItemG != null) {
                arrayList4.add(purposeDisplayItemG);
            }
        }
        arrayList.addAll(CollectionsKt.distinct(arrayList4));
        return arrayList;
    }

    public final void n() {
        this.userChoicesInfoProvider.d(this.requiredVendorsLegInt);
    }

    public final void o() {
        Set mutableSet = CollectionsKt.toMutableSet(l0());
        mutableSet.removeAll(this.userChoicesInfoProvider.c());
        this.userChoicesInfoProvider.g().addAll(mutableSet);
    }

    private final PurposeDisplayItem g(Purpose purpose) {
        int iA;
        String str;
        if (purpose == null) {
            return null;
        }
        String strK = k(purpose);
        String strX = X();
        long jHashCode = purpose.getId().hashCode();
        o9.a aVar = o9.a.Purpose;
        String id = purpose.getId();
        if (this.shouldAddRoomForIcon) {
            v0 v0Var = this.contextHelper;
            PurposeCategory category = purpose.getCategory();
            iA = v0Var.a(category != null ? category.getIcon() : null);
        } else {
            iA = -1;
        }
        int i2 = iA;
        boolean zIsEssential = purpose.isEssential();
        boolean zIsLegitimateInterestOnly = purpose.isLegitimateInterestOnly();
        DidomiToggle.b bVarL = l(purpose);
        if (purpose.isEssential()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format("%s, %s", Arrays.copyOf(new Object[]{strK, strX}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            str = str2;
        } else {
            str = strK;
        }
        return new PurposeDisplayItem(jHashCode, aVar, id, i2, strK, strX, zIsEssential, zIsLegitimateInterestOnly, str, w(), bVarL, z(), B(), false);
    }

    public final Purpose b(String id) {
        Object next;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = this.requiredPurposes.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((Purpose) next).getId(), id)) {
                return (Purpose) next;
            }
        }
        next = null;
        return (Purpose) next;
    }

    private final void t(Purpose purpose) {
        if (v(purpose)) {
            x(purpose);
        }
        if (w(purpose)) {
            d(purpose);
        }
    }

    public final void b(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        this.userChoicesInfoProvider.a(purpose);
    }

    public final List<o9> d(boolean accessibilityAnnounceState) {
        ArrayList arrayList = new ArrayList();
        List<PurposeDisplayItem> listD = d();
        if (c(listD)) {
            arrayList.add(a(accessibilityAnnounceState));
        }
        arrayList.addAll(listD);
        return CollectionsKt.toList(arrayList);
    }

    public final boolean v(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        return purpose.isConsentNotEssential();
    }

    private final void b(Vendor vendor) {
        this.userChoicesInfoProvider.g().add(vendor);
    }

    private final Purpose h(PurposeCategory purposeCategory) {
        if (l9.a(purposeCategory) == PurposeCategory.Type.Purpose) {
            return b(purposeCategory.getPurposeId());
        }
        return null;
    }

    public final boolean b() {
        return this.consentRepository.a(new HashSet(this.consentPurposes)).size() == this.userChoicesInfoProvider.f().size() && this.consentRepository.a(new HashSet(this.requiredPurposesLegInt)).size() == this.userChoicesInfoProvider.h().size();
    }

    public final void b(DidomiToggle.b value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.selectedPurposeConsentState.setValue(value);
    }

    public final void b(Purpose purpose, DidomiToggle.b state) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Intrinsics.checkNotNullParameter(state, "state");
        a(purpose, state);
        int i2 = a.a[state.ordinal()];
        if (i2 == 1) {
            a(new PreferencesClickPurposeDisagreeEvent(purpose.getId()));
        } else if (i2 == 3) {
            a(new PreferencesClickPurposeAgreeEvent(purpose.getId()));
        }
        this.selectedPurposeConsentState.setValue(state);
        this.apiEventsRepository.g();
    }

    public final void l() {
        this.userChoicesInfoProvider.i(CollectionsKt.toMutableSet(this.consentRepository.a(this.vendorRepository.l())));
        this.userChoicesInfoProvider.e(new LinkedHashSet());
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004c  */
    public final List<PurposeDisplayItem> d() {
        PurposeDisplayItem purposeDisplayItemG;
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (PurposeCategory purposeCategory : this.requiredCategories) {
            if (l9.a(purposeCategory) == PurposeCategory.Type.Purpose) {
                Purpose purposeB = b(purposeCategory.getPurposeId());
                if (purposeB != null) {
                    purposeDisplayItemG = g(purposeB);
                    linkedHashSet.add(purposeCategory.getPurposeId());
                } else {
                    purposeDisplayItemG = null;
                }
            } else {
                Set<String> setI = i(purposeCategory);
                if (setI.isEmpty()) {
                    purposeDisplayItemG = null;
                } else {
                    linkedHashSet.addAll(setI);
                    purposeDisplayItemG = g(purposeCategory);
                }
            }
            if (purposeDisplayItemG != null) {
                arrayList.add(purposeDisplayItemG);
            }
        }
        for (Purpose purpose : j1()) {
            if (!linkedHashSet.contains(purpose.getId())) {
                arrayList.add(g(purpose));
            }
        }
        return CollectionsKt.filterNotNull(arrayList);
    }

    private final void b(PurposeCategory category) {
        if (this.shouldAddRoomForIcon) {
            return;
        }
        this.shouldAddRoomForIcon = this.contextHelper.a(category.getIcon()) != 0;
    }

    private final PurposeDisplayItem g(PurposeCategory category) {
        String str;
        if (category == null) {
            return null;
        }
        String strE = e(category);
        String strX = X();
        boolean zK = k(category);
        long jHashCode = category.getId().hashCode();
        o9.a aVar = o9.a.Category;
        String id = category.getId();
        int iA = this.shouldAddRoomForIcon ? this.contextHelper.a(category.getIcon()) : -1;
        DidomiToggle.b bVarF = f(category);
        if (zK) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format("%s, %s", Arrays.copyOf(new Object[]{strE, strX}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            str = str2;
        } else {
            str = strE;
        }
        return new PurposeDisplayItem(jHashCode, aVar, id, iA, strE, strX, zK, false, str, w(), bVarF, z(), B(), false);
    }

    private final String d(PurposeCategory category) {
        return n7.a(this.languagesHelper, category.getDescription(), null, 2, null);
    }

    public final void d(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        if (p(purpose)) {
            this.userChoicesInfoProvider.d(purpose);
        }
    }

    public final void d(Purpose purpose, DidomiToggle.b legIntState) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Intrinsics.checkNotNullParameter(legIntState, "legIntState");
        int i2 = a.a[legIntState.ordinal()];
        if (i2 == 1) {
            a(purpose);
            a(new PreferencesClickPurposeDisagreeEvent(purpose.getId()));
        } else {
            if (i2 != 3) {
                return;
            }
            d(purpose);
            a(new PreferencesClickPurposeAgreeEvent(purpose.getId()));
        }
    }

    private final void d(DidomiToggle.b state) {
        int i2 = a.a[state.ordinal()];
        if (i2 == 1) {
            g();
            h();
        } else if (i2 == 2) {
            W0();
            m();
        } else {
            if (i2 != 3) {
                return;
            }
            l();
            m();
        }
    }

    private final Set<String> i(PurposeCategory category) {
        List<PurposeCategory> children = category.getChildren();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            Purpose purposeH = h((PurposeCategory) it.next());
            String id = purposeH != null ? purposeH.getId() : null;
            if (id != null) {
                arrayList.add(id);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final void k() {
        this.userChoicesInfoProvider.i(CollectionsKt.toMutableSet(this.vendorRepository.l()));
        this.userChoicesInfoProvider.e(new LinkedHashSet());
    }

    public final String e(PurposeCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return n7.a(this.languagesHelper, category.getName(), null, 2, null);
    }

    public final void e(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        this.userChoicesInfoProvider.c(purpose);
    }

    public final void e(Purpose purpose, DidomiToggle.b state) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Intrinsics.checkNotNullParameter(state, "state");
        int i2 = a.a[state.ordinal()];
        if (i2 == 1) {
            r(purpose);
        } else if (i2 == 2) {
            t(purpose);
        } else if (i2 == 3) {
            s(purpose);
        }
        f1();
    }

    public final String m(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        if (U0()) {
            return a(ai.a(this.vendorRepository, purpose).size());
        }
        return null;
    }

    public final void m() {
        this.userChoicesInfoProvider.k(CollectionsKt.toMutableSet(this.requiredPurposesLegInt));
        this.userChoicesInfoProvider.g(new LinkedHashSet());
    }

    public final void f() {
        this.userChoicesInfoProvider.i(new LinkedHashSet());
        this.userChoicesInfoProvider.e(CollectionsKt.toMutableSet(this.vendorRepository.l()));
    }

    private final void f(Purpose purpose) {
        if (v(purpose)) {
            e(purpose);
        }
        if (w(purpose)) {
            d(purpose);
        }
    }

    private final PurposeDisplayHeader c() {
        SpannableString spannableString;
        String strI0 = i0();
        String privacyPolicyURL = this.configurationRepository.b().getApp().getPrivacyPolicyURL();
        boolean z = privacyPolicyURL.length() > 0 && !fc.a(i0(), privacyPolicyURL);
        if (z) {
            spannableString = new SpannableString(n7.a(this.languagesHelper, "our_privacy_policy", null, null, null, 14, null));
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
        } else {
            spannableString = null;
        }
        return new PurposeDisplayHeader(fc.j(strI0), spannableString, z ? n7.a(this.languagesHelper, "link_privacy_policy", null, null, null, 14, null) : null, privacyPolicyURL);
    }

    public final boolean c(boolean isMainScreen) {
        AppConfiguration appConfigurationB = this.configurationRepository.b();
        if (appConfigurationB.getApp().getShouldHideDidomiLogo()) {
            return true;
        }
        return isMainScreen && appConfigurationB.getPreferences().getShowWhenConsentIsMissing();
    }

    public final void c(DidomiToggle.b selectedPurposeLegIntState) {
        this.selectedPurposeLegIntState.setValue(selectedPurposeLegIntState);
    }

    public final void c(Purpose purpose, DidomiToggle.b state) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Intrinsics.checkNotNullParameter(state, "state");
        d(purpose, state);
        c(state);
        this.apiEventsRepository.g();
    }

    private final void c(Purpose purpose) {
        if (v(purpose)) {
            b(purpose);
        }
        if (w(purpose)) {
            a(purpose);
        }
    }

    private final PurposeDisplayBulkAction a(DidomiToggle.b state, boolean accessibilityAnnounceState) {
        String strE = E();
        boolean z = Build.VERSION.SDK_INT >= 30;
        new PurposeDisplayBulkAction(strE, z ? strE : null, false, state, A(), B(), accessibilityAnnounceState, z ? null : strE, 4, null);
        return r2;
    }

    private final PurposeDisplayAdditionalDataProcessing.DataProcessingItem a(m1 dataProcessing) {
        SpannableString spannableString = new SpannableString(StringsKt.trim(dataProcessing.getName()).toString());
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
        return new PurposeDisplayAdditionalDataProcessing.DataProcessingItem(spannableString, dataProcessing);
    }

    private final PurposeDisplayBulkAction a(boolean accessibilityAnnounceState) {
        String strE = E();
        boolean z = Build.VERSION.SDK_INT >= 30;
        new PurposeDisplayBulkAction(strE, z ? strE : null, f0.f(this.configurationRepository), F(), A(), B(), accessibilityAnnounceState, z ? null : strE);
        return r2;
    }

    public final void a(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventsRepository.c(event);
    }

    public final PurposeCategory a(String id) {
        Object next;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = this.requiredCategories.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((PurposeCategory) next).getId(), id)) {
                return (PurposeCategory) next;
            }
        }
        next = null;
        return (PurposeCategory) next;
    }

    private final String a(int count) {
        return n7.a(this.languagesHelper, count == 1 ? "single_partner_count" : "simple_partners_count", null, MapsKt.mapOf(TuplesKt.to("{nb}", String.valueOf(count))), null, 10, null);
    }

    public final boolean a(PurposeCategory category) {
        int i2;
        if (category != null) {
            Set<String> setI = i(category);
            if ((setI instanceof Collection) && setI.isEmpty()) {
                i2 = 0;
            } else {
                Iterator<T> it = setI.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    Purpose purposeB = b((String) it.next());
                    if (purposeB != null && (ca.a(U(), purposeB) || ca.a(N(), purposeB) || purposeB.isEssential() || !ca.a(this.consentPurposes, purposeB))) {
                        i2++;
                        if (i2 < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
            }
            if (i2 == setI.size()) {
                return true;
            }
        }
        return false;
    }

    private final void a(Vendor vendor) {
        this.userChoicesInfoProvider.c().add(vendor);
    }

    public final void a(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        if (p(purpose)) {
            this.userChoicesInfoProvider.b(purpose);
        }
    }

    private final boolean a() {
        return this.consentRepository.a(new HashSet(this.consentPurposes)).size() == this.userChoicesInfoProvider.b().size() && this.consentRepository.a(new HashSet(this.requiredPurposesLegInt)).size() == this.userChoicesInfoProvider.d().size();
    }

    public final void a(PurposeCategory category, DidomiToggle.b state) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(state, "state");
        List<PurposeCategory> children = category.getChildren();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            Purpose purposeH = h((PurposeCategory) it.next());
            if (purposeH != null) {
                arrayList.add(purposeH);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((Purpose) obj).isEssential()) {
                arrayList2.add(obj);
            }
        }
        int i2 = a.a[state.ordinal()];
        if (i2 == 1) {
            a(new PreferencesClickCategoryDisagreeEvent(category.getId()));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c((Purpose) it2.next());
            }
        } else if (i2 != 3) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                t((Purpose) it3.next());
            }
        } else {
            a(new PreferencesClickCategoryAgreeEvent(category.getId()));
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                f((Purpose) it4.next());
            }
        }
        f1();
    }

    public final void a(Purpose purpose, DidomiToggle.b consentStatus) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Intrinsics.checkNotNullParameter(consentStatus, "consentStatus");
        int i2 = a.a[consentStatus.ordinal()];
        if (i2 == 1) {
            b(purpose);
        } else if (i2 == 2) {
            x(purpose);
        } else {
            if (i2 != 3) {
                return;
            }
            e(purpose);
        }
    }

    public final void a(DidomiToggle.b state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i2 = a.a[state.ordinal()];
        if (i2 == 1) {
            a(new PreferencesClickDisagreeToAllPurposesEvent());
        } else if (i2 == 2) {
            a(new PreferencesClickResetAllPurposesEvent());
        } else if (i2 == 3) {
            a(new PreferencesClickAgreeToAllPurposesEvent());
        }
        d(state);
    }

    private final void a(Purpose purpose, PurposeCategory category) {
        if (StringsKt.isBlank(purpose.getId()) || !Intrinsics.areEqual(purpose.getId(), category.getPurposeId())) {
            return;
        }
        purpose.setCategory(category);
        b(category);
    }

    private final boolean a(List<Purpose> purposes) {
        if ((purposes instanceof Collection) && purposes.isEmpty()) {
            return false;
        }
        Iterator<T> it = purposes.iterator();
        while (it.hasNext()) {
            if (!((Purpose) it.next()).isEssential()) {
                return true;
            }
        }
        return false;
    }
}
