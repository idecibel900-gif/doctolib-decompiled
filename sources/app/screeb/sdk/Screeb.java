package app.screeb.sdk;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import app.screeb.sdk.internal.A;
import app.screeb.sdk.internal.AbstractC0293b0;
import app.screeb.sdk.internal.AbstractC0298e;
import app.screeb.sdk.internal.AbstractC0306i;
import app.screeb.sdk.internal.C0291a0;
import app.screeb.sdk.internal.C0294c;
import app.screeb.sdk.internal.C0303g0;
import app.screeb.sdk.internal.C0304h;
import app.screeb.sdk.internal.V;
import app.screeb.sdk.internal.W;
import app.screeb.sdk.internal.WindowCallbackC0292b;
import app.screeb.sdk.internal.X;
import app.screeb.sdk.internal.Y;
import app.screeb.sdk.internal.Z;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002ï\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJG\u0010\u0013\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2&\b\u0002\u0010\u0012\u001a \u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\f\u0012\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014JO\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016`\u00172\"\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r0\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r`\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010\"J\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\u0003J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0016H\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010+\u001a\u00020\b2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010\u0003J\u0017\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\u00020\b*\u00020.H\u0002¢\u0006\u0004\b2\u00103J\u0013\u00104\u001a\u00020\b*\u00020.H\u0002¢\u0006\u0004\b4\u00103J\u0013\u00105\u001a\u00020\b*\u00020.H\u0002¢\u0006\u0004\b5\u00103J\u0013\u00106\u001a\u00020\b*\u00020.H\u0002¢\u0006\u0004\b6\u00103J'\u0010<\u001a\u00020\b2\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u0016H\u0002¢\u0006\u0004\b<\u0010=J\u0019\u0010@\u001a\u0004\u0018\u0001072\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AJ/\u0010B\u001a\u00020\b2\u0006\u0010?\u001a\u00020>2\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u0016H\u0002¢\u0006\u0004\bB\u0010CJ/\u0010H\u001a\u00020\b2\u0006\u0010?\u001a\u00020>2\u0006\u00108\u001a\u0002072\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bH\u0010IJ'\u0010J\u001a\u00020\b2\u0006\u0010?\u001a\u00020>2\u0006\u00108\u001a\u0002072\u0006\u0010E\u001a\u000209H\u0002¢\u0006\u0004\bJ\u0010KJ\u001f\u0010L\u001a\u00020\b2\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020\b2\u0006\u00108\u001a\u000207H\u0002¢\u0006\u0004\bN\u0010OJ#\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020F0P2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\bQ\u0010RJ7\u0010U\u001a\"\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0015j\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r`\u00172\u0006\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bU\u0010VJ\u001f\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010X\u001a\u00020WH\u0002¢\u0006\u0004\bY\u0010ZJ\u001b\u0010\\\u001a\u0004\u0018\u00010\r2\b\u0010[\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\\\u0010]J\u0019\u0010`\u001a\u00020\b2\b\u0010_\u001a\u0004\u0018\u00010^H\u0007¢\u0006\u0004\b`\u0010aJ\u0019\u0010`\u001a\u00020\b2\b\u0010_\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b`\u0010'J\u0019\u0010`\u001a\u00020\b2\b\u0010c\u001a\u0004\u0018\u00010bH\u0007¢\u0006\u0004\b`\u0010dJG\u0010h\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r0\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r`\u00172\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160e2\u0006\u0010\u0012\u001a\u00020gH\u0007¢\u0006\u0004\bh\u0010iJ\u0019\u0010m\u001a\u00020\u00042\b\u0010j\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\bk\u0010lJ\u0093\u0001\u0010t\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00162\b\u0010n\u001a\u0004\u0018\u00010\u00162\u001c\u0010p\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0004\u0018\u0001`o2*\u0010q\u001a&\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`\u00172\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0004\u0018\u0001`r2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\bt\u0010uJ\u0017\u0010v\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\bv\u0010\"J\u001f\u0010y\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u00162\u0006\u0010x\u001a\u00020\u0016H\u0007¢\u0006\u0004\by\u0010zJ\u0081\u0001\u0010|\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010%\u001a\u00020\u00162\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u00162\u001e\b\u0002\u0010p\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0004\u0018\u0001`o2\b\b\u0002\u0010q\u001a\u00020{2\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0004\u0018\u0001`r2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b|\u0010}J$\u0010\u0082\u0001\u001a\u00020\b2\b\u0010~\u001a\u0004\u0018\u00010(2\u0006\u0010\u007f\u001a\u00020\u0004H\u0000¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0011\u0010\u0084\u0001\u001a\u00020\bH\u0000¢\u0006\u0005\b\u0083\u0001\u0010\u0003J\u0011\u0010\u0086\u0001\u001a\u00020\bH\u0000¢\u0006\u0005\b\u0085\u0001\u0010\u0003J\u0011\u0010\u0087\u0001\u001a\u00020\bH\u0007¢\u0006\u0005\b\u0087\u0001\u0010\u0003JX\u0010\u0088\u0001\u001a\u00020\b2D\u0010\u0012\u001a@\u0012(\u0012&\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`\u0017\u0012\f\u0012\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u0012\u0004\u0012\u00020\b0\u000fH\u0007¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J=\u0010\u008d\u0001\u001a\u00020\b2\u0007\u0010\u008a\u0001\u001a\u00020\u00162 \b\u0002\u0010\u008c\u0001\u001a\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0005\u0018\u0001`\u008b\u0001H\u0007¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001a\u0010\u0090\u0001\u001a\u00020\b2\u0007\u0010\u008f\u0001\u001a\u00020\u0016H\u0007¢\u0006\u0005\b\u0090\u0001\u0010'J\u0011\u0010\u0091\u0001\u001a\u00020\bH\u0007¢\u0006\u0005\b\u0091\u0001\u0010\u0003J,\u0010\u0092\u0001\u001a\u00020\b2\u0018\u0010p\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0015j\u0002`oH\u0007¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001JI\u0010\u0096\u0001\u001a\u00020\b2\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00162\u0006\u0010w\u001a\u00020\u00162 \b\u0002\u0010\u008c\u0001\u001a\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0005\u0018\u0001`\u0095\u0001H\u0007¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001JI\u0010\u0098\u0001\u001a\u00020\b2\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00162\u0006\u0010w\u001a\u00020\u00162 \b\u0002\u0010\u008c\u0001\u001a\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0005\u0018\u0001`\u0095\u0001H\u0007¢\u0006\u0006\b\u0098\u0001\u0010\u0097\u0001J<\u0010\u009a\u0001\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u00162 \b\u0002\u0010\u0099\u0001\u001a\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0005\u0018\u0001`\u008b\u0001H\u0007¢\u0006\u0006\b\u009a\u0001\u0010\u008e\u0001J<\u0010\u009b\u0001\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u00162 \b\u0002\u0010\u0099\u0001\u001a\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0005\u0018\u0001`\u008b\u0001H\u0007¢\u0006\u0006\b\u009b\u0001\u0010\u008e\u0001J\u008b\u0001\u0010£\u0001\u001a\u00020\b2\u0007\u0010\u009c\u0001\u001a\u00020\u00162\t\b\u0002\u0010\u009d\u0001\u001a\u00020\u00042 \b\u0002\u0010\u009f\u0001\u001a\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0005\u0018\u0001`\u009e\u00012\t\b\u0002\u0010 \u0001\u001a\u00020\u00042\u001d\b\u0002\u0010\u0018\u001a\u0017\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0005\u0018\u0001`¡\u00012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u00162\u000b\b\u0002\u0010¢\u0001\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u008b\u0001\u0010§\u0001\u001a\u00020\b2\u0007\u0010¥\u0001\u001a\u00020\u00162\t\b\u0002\u0010\u009d\u0001\u001a\u00020\u00042 \b\u0002\u0010\u009f\u0001\u001a\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0005\u0018\u0001`\u009e\u00012\t\b\u0002\u0010¦\u0001\u001a\u00020\u00042\u001d\b\u0002\u0010\u0018\u001a\u0017\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0005\u0018\u0001`¡\u00012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u00162\u000b\b\u0002\u0010¢\u0001\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0006\b§\u0001\u0010¤\u0001J\u001c\u0010¨\u0001\u001a\u00020\b2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0005\b¨\u0001\u0010'J\u001e\u0010©\u0001\u001a\u00020\b2\u000b\b\u0002\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0005\b©\u0001\u0010'J\u001e\u0010ª\u0001\u001a\u00020\b2\u000b\b\u0002\u0010¥\u0001\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0005\bª\u0001\u0010'J\u0011\u0010«\u0001\u001a\u00020\bH\u0007¢\u0006\u0005\b«\u0001\u0010\u0003J\u0011\u0010¬\u0001\u001a\u00020\bH\u0007¢\u0006\u0005\b¬\u0001\u0010\u0003J%\u0010®\u0001\u001a\u00020\b2\u0007\u0010\u00ad\u0001\u001a\u00020\u00162\b\u0010j\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0006\b®\u0001\u0010¯\u0001J8\u0010°\u0001\u001a\u00020\b2$\b\u0002\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\f\u0012\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0007¢\u0006\u0006\b°\u0001\u0010\u0089\u0001J8\u0010±\u0001\u001a\u00020\b2$\b\u0002\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\f\u0012\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0007¢\u0006\u0006\b±\u0001\u0010\u0089\u0001J\u0019\u0010²\u0001\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0005\b²\u0001\u00103J\u0019\u0010³\u0001\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0005\b³\u0001\u00103J\u0019\u0010´\u0001\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0005\b´\u0001\u00103J\u0019\u0010µ\u0001\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0005\bµ\u0001\u00103J\u0019\u0010¶\u0001\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0005\b¶\u0001\u00103J&\u0010¹\u0001\u001a\u00020\b2\u0006\u0010/\u001a\u00020.2\n\u0010¸\u0001\u001a\u0005\u0018\u00010·\u0001H\u0016¢\u0006\u0006\b¹\u0001\u0010º\u0001J$\u0010¼\u0001\u001a\u00020\b2\u0006\u0010/\u001a\u00020.2\b\u0010»\u0001\u001a\u00030·\u0001H\u0016¢\u0006\u0006\b¼\u0001\u0010º\u0001J\u001c\u0010½\u0001\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010>H\u0007¢\u0006\u0006\b½\u0001\u0010¾\u0001R\u0019\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0010¿\u0001R\u001b\u0010À\u0001\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R*\u0010%\u001a\u0004\u0018\u00010\u00162\b\u0010[\u001a\u0004\u0018\u00010\u00168\u0002@BX\u0082\u000e¢\u0006\u000e\n\u0005\b%\u0010Â\u0001\"\u0005\bÃ\u0001\u0010'R\u0019\u0010Ä\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u0019\u0010Æ\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Å\u0001R\u001e\u0010È\u0001\u001a\t\u0012\u0004\u0012\u00020D0Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001e\u0010Ê\u0001\u001a\t\u0012\u0004\u0012\u00020D0Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010É\u0001R0\u0010Ì\u0001\u001a\u001b\u0012\u0004\u0012\u000209\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u0002070P0Ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001e\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u00020.0Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0001\u0010É\u0001R\"\u0010Ð\u0001\u001a\u000b\u0012\u0004\u0012\u00020.\u0018\u00010Ï\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R%\u0010Ó\u0001\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0005\u0012\u00030Ò\u00010Ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Í\u0001R\u001e\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160Ô\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001b\u0010×\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Â\u0001R-\u0010p\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0015j\u0004\u0018\u0001`o8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bp\u0010Ø\u0001R'\u0010Ù\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u0017\u0010q\u001a\u00020{8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bq\u0010Û\u0001R\u0017\u0010Ü\u0001\u001a\u00020F8\u0002X\u0082D¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001RP\u0010ß\u0001\u001a;\u00126\u00124\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\"\u0012 \u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\f\u0012\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f0P0Þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u0018\u0010â\u0001\u001a\u00030á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001c\u0010å\u0001\u001a\u0005\u0018\u00010ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u0019\u0010ç\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010Å\u0001R\u0019\u0010è\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R\u0019\u0010ê\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010é\u0001R\u0018\u0010ì\u0001\u001a\u00030ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u0017\u0010î\u0001\u001a\u00020(8\u0002X\u0082T¢\u0006\b\n\u0006\bî\u0001\u0010é\u0001¨\u0006ð\u0001"}, d2 = {"Lapp/screeb/sdk/Screeb;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "", "isMainThread", "()Z", "Lkotlin/Function0;", "", "block", "postToMainThread", "(Lkotlin/jvm/functions/Function0;)V", "", "", "cmd", "Lkotlin/Function2;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "callback", "sendCommand", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "hooks", "constructHooks", "(Ljava/util/HashMap;)Ljava/util/HashMap;", "payload", "extractNativeHookId", "(Ljava/lang/Object;)Ljava/lang/String;", "stringifyHookPayload", "Landroid/content/Context;", "context", "ensureActivityLifecycleCallbacksRegistered", "(Landroid/content/Context;)V", "initWebview", "onRecover", "channelId", "sendClientConfig", "(Ljava/lang/String;)V", "", "now", "force", "sendActivityPing", "(JZ)V", "installActivityTouchObserver", "Landroid/app/Activity;", "activity", "isOverlayEligible", "(Landroid/app/Activity;)Z", "registerOverlay", "(Landroid/app/Activity;)V", "unregisterOverlay", "updateOverlay", "removeOverlay", "Landroid/widget/FrameLayout;", "parent", "Lapp/screeb/sdk/internal/g0;", "wv", "logReason", "attachWebViewToParent", "(Landroid/widget/FrameLayout;Lapp/screeb/sdk/internal/g0;Ljava/lang/String;)V", "Landroid/view/Window;", "window", "resolveOverlayParent", "(Landroid/view/Window;)Landroid/widget/FrameLayout;", "syncOverlayInWindow", "(Landroid/view/Window;Landroid/widget/FrameLayout;Lapp/screeb/sdk/internal/g0;Ljava/lang/String;)V", "Landroid/view/View;", "view", "", "imeBottom", "applyOverlayFrame", "(Landroid/view/Window;Landroid/widget/FrameLayout;Landroid/view/View;I)V", "installOverlayInsetsHandling", "(Landroid/view/Window;Landroid/widget/FrameLayout;Lapp/screeb/sdk/internal/g0;)V", "installOverlayZOrderKeeper", "(Landroid/widget/FrameLayout;Lapp/screeb/sdk/internal/g0;)V", "removeOverlayZOrderKeeper", "(Landroid/widget/FrameLayout;)V", "Lkotlin/Pair;", "getCurrentWindowSize", "(Landroid/view/Window;)Lkotlin/Pair;", "Lorg/json/JSONObject;", "json", "jsonObjectToHashMap", "(Lorg/json/JSONObject;)Ljava/util/HashMap;", "Lorg/json/JSONArray;", "array", "jsonArrayToList", "(Lorg/json/JSONArray;)Ljava/util/List;", "value", "convertJsonValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "Landroid/net/Uri;", "url", "handleDeepLink", "(Landroid/net/Uri;)V", "Landroid/content/Intent;", "intent", "(Landroid/content/Intent;)V", "", "hookIds", "Lapp/screeb/sdk/ScreebHookCallback;", "makeHooks", "(Ljava/util/Map;Lapp/screeb/sdk/ScreebHookCallback;)Ljava/util/HashMap;", "result", "isPendingHookResult$sdk_release", "(Ljava/lang/Object;)Z", "isPendingHookResult", "visitorId", "Lapp/screeb/sdk/init/model/VisitorProperties;", "visitorProperties", "initOptions", "Lapp/screeb/sdk/init/model/GlobalHooks;", "language", "pluginInit", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;)V", "initSdkWithContextOnly", "name", DiagnosticsEntry.VERSION_KEY, "setSecondarySDK", "(Ljava/lang/String;Ljava/lang/String;)V", "Lapp/screeb/sdk/InitOptions;", "initSdk", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lapp/screeb/sdk/InitOptions;Ljava/util/HashMap;Ljava/lang/String;)V", "inMs", "needsActivity", "onWebviewSchedule$sdk_release", "(Ljava/lang/Long;Z)V", "onWebviewSchedule", "noteHostTouch$sdk_release", "noteHostTouch", "sendActivityPingOnForeground$sdk_release", "sendActivityPingOnForeground", "closeSdk", "getIdentity", "(Lkotlin/jvm/functions/Function2;)V", "uniqueVisitorId", "Lapp/screeb/sdk/tracking/model/TrackingEventProperties;", DiagnosticsEntry.PROPERTIES_KEY, "setIdentity", "(Ljava/lang/String;Ljava/util/HashMap;)V", "anonymousId", "setAnonymousId", "resetIdentity", "setVisitorProperties", "(Ljava/util/HashMap;)V", "type", "Lapp/screeb/sdk/tracking/model/GroupProperties;", "assignGroup", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "unassignGroup", "trackingEventProperties", "trackEvent", "trackScreen", "surveyId", "allowMultipleResponses", "Lapp/screeb/sdk/tracking/model/HiddenFields;", "hiddenFields", "ignoreSurveyStatus", "Lapp/screeb/sdk/init/model/SurveyHooks;", "distributionId", "startSurvey", "(Ljava/lang/String;ZLjava/util/HashMap;ZLjava/util/HashMap;Ljava/lang/String;Ljava/lang/String;)V", "messageId", "ignoreMessageStatus", "startMessage", "startSurveyFromNotification", "closeSurvey", "closeMessage", "sessionReplayStart", "sessionReplayStop", "hookId", "onHookResult", "(Ljava/lang/String;Ljava/lang/Object;)V", "debug", "debugTargeting", "onActivityStarted", "onActivityDestroyed", "onActivityResumed", "onActivityPaused", "onActivityStopped", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "outState", "onActivitySaveInstanceState", "attachToWindow", "(Landroid/view/Window;)V", "Landroid/content/Context;", "webView", "Lapp/screeb/sdk/internal/g0;", "Ljava/lang/String;", "setChannelId", "initialized", "Z", "lifecycleSubscribed", "", "applyingInsetsViews", "Ljava/util/Set;", "pendingPostLayoutFrameViews", "Ljava/util/WeakHashMap;", "overlayInsetsBindings", "Ljava/util/WeakHashMap;", "activitySet", "Ljava/lang/ref/WeakReference;", "resumedActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "overlayZOrderListeners", "", "overlayForeignActivityPrefixes", "[Ljava/lang/String;", "identity", "Ljava/util/HashMap;", "secondarySDK", "Lkotlin/Pair;", "Lapp/screeb/sdk/InitOptions;", "commandsQueueMaxSize", "I", "Lkotlin/collections/ArrayDeque;", "commandsQueue", "Lkotlin/collections/ArrayDeque;", "Landroid/os/Handler;", "scheduleHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "scheduleRunnable", "Ljava/lang/Runnable;", "activityObservationEnabled", "lastTouchAtMs", "J", "lastPingAtMs", "Lapp/screeb/sdk/internal/c;", "activityTouchObserver", "Lapp/screeb/sdk/internal/c;", "PING_THROTTLE_MS", "app/screeb/sdk/internal/V", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class Screeb implements Application.ActivityLifecycleCallbacks {
    public static final Screeb INSTANCE = new Screeb();
    private static final long PING_THROTTLE_MS = 5000;
    private static boolean activityObservationEnabled;
    private static final Set<Activity> activitySet;
    private static final C0294c activityTouchObserver;
    private static final Set<View> applyingInsetsViews;
    private static String channelId;
    private static final ArrayDeque commandsQueue;
    private static final int commandsQueueMaxSize;
    private static Context context;
    private static String identity;
    private static InitOptions initOptions;
    private static boolean initialized;
    private static volatile long lastPingAtMs;
    private static volatile long lastTouchAtMs;
    private static boolean lifecycleSubscribed;
    private static final String[] overlayForeignActivityPrefixes;
    private static final WeakHashMap<C0303g0, Pair<View, FrameLayout>> overlayInsetsBindings;
    private static final WeakHashMap<FrameLayout, ViewTreeObserver.OnGlobalLayoutListener> overlayZOrderListeners;
    private static final Set<View> pendingPostLayoutFrameViews;
    private static volatile WeakReference<Activity> resumedActivityRef;
    private static final Handler scheduleHandler;
    private static Runnable scheduleRunnable;
    private static Pair<String, String> secondarySDK;
    private static HashMap<String, Object> visitorProperties;
    private static C0303g0 webView;

    static {
        Set<View> setNewSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap, "newSetFromMap(...)");
        applyingInsetsViews = setNewSetFromMap;
        Set<View> setNewSetFromMap2 = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap2, "newSetFromMap(...)");
        pendingPostLayoutFrameViews = setNewSetFromMap2;
        overlayInsetsBindings = new WeakHashMap<>();
        Set<Activity> setNewSetFromMap3 = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap3, "newSetFromMap(...)");
        activitySet = setNewSetFromMap3;
        overlayZOrderListeners = new WeakHashMap<>();
        overlayForeignActivityPrefixes = new String[]{"com.google.android.gms.ads.", "com.google.android.play.core.", "com.google.android.play.integrity.", "com.android.billingclient.", "androidx.browser.customtabs.", "com.facebook.ads.", "com.applovin.", "com.unity3d.", "com.ironsource.", "com.vungle.", "com.mbridge.", "com.chartboost.", "com.fyber.", "com.inmobi."};
        initOptions = new InitOptions(false, false, false, 7, null);
        commandsQueueMaxSize = 100;
        commandsQueue = new ArrayDeque();
        scheduleHandler = new Handler(Looper.getMainLooper());
        activityTouchObserver = new C0294c(new Function0() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Screeb.activityTouchObserver$lambda$0();
            }
        });
    }

    private Screeb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activityTouchObserver$lambda$0() {
        INSTANCE.noteHostTouch$sdk_release();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyOverlayFrame(final Window window, final FrameLayout parent, final View view, final int imeBottom) {
        if (!ViewCompat.isAttachedToWindow(view)) {
            view.addOnAttachStateChangeListener(new W(parent, window, imeBottom));
            return;
        }
        int width = parent.getResources().getDisplayMetrics().widthPixels;
        int height = parent.getResources().getDisplayMetrics().heightPixels;
        boolean z = parent.getWidth() > 0 && parent.getHeight() > 0;
        Pair<Integer, Integer> currentWindowSize = !z ? getCurrentWindowSize(window) : null;
        int iIntValue = currentWindowSize != null ? ((Number) currentWindowSize.getFirst()).intValue() : 0;
        int iIntValue2 = currentWindowSize != null ? ((Number) currentWindowSize.getSecond()).intValue() : 0;
        if (!z && pendingPostLayoutFrameViews.add(view)) {
            parent.post(new Runnable() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    Screeb.applyOverlayFrame$lambda$31(view, parent, window, imeBottom);
                }
            });
        }
        if (z) {
            width = parent.getWidth();
        } else if (iIntValue > 0) {
            width = iIntValue;
        }
        if (z) {
            height = parent.getHeight();
        } else if (iIntValue2 > 0) {
            height = iIntValue2;
        }
        int height2 = parent.getHeight() > 0 ? parent.getHeight() : height;
        int iCoerceAtLeast = height2 - RangesKt.coerceAtLeast(imeBottom - RangesKt.coerceAtLeast(height - height2, 0), 0);
        if (iCoerceAtLeast < height2 / 4) {
            Z z2 = Z.b;
            Y.a();
            Z.b("Overlay", "degenerate computed overlay height " + iCoerceAtLeast + "px (parent " + height2 + "px, ime " + imeBottom + ") — falling back to parent height");
            iCoerceAtLeast = RangesKt.coerceAtLeast(height2, 1);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(width, iCoerceAtLeast);
        }
        if (layoutParams2.width == width && layoutParams2.height == iCoerceAtLeast && layoutParams2.leftMargin == 0 && layoutParams2.topMargin == 0 && layoutParams2.rightMargin == 0 && layoutParams2.bottomMargin == 0) {
            return;
        }
        layoutParams2.width = width;
        layoutParams2.height = iCoerceAtLeast;
        layoutParams2.leftMargin = 0;
        layoutParams2.topMargin = 0;
        layoutParams2.rightMargin = 0;
        layoutParams2.bottomMargin = 0;
        view.setLayoutParams(layoutParams2);
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyOverlayFrame$lambda$31(View view, FrameLayout frameLayout, Window window, int i) {
        pendingPostLayoutFrameViews.remove(view);
        if (ViewCompat.isAttachedToWindow(view) && view.getParent() == frameLayout) {
            INSTANCE.applyOverlayFrame(window, frameLayout, view, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void assignGroup$default(Screeb screeb, String str, String str2, HashMap map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        screeb.assignGroup(str, str2, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachToWindow$lambda$24(Window window) {
        INSTANCE.attachToWindow(window);
        return Unit.INSTANCE;
    }

    private final void attachWebViewToParent(FrameLayout parent, final C0303g0 wv, String logReason) {
        try {
            C0291a0 mirror$sdk_release = wv.getMirror$sdk_release();
            if (mirror$sdk_release != null) {
                mirror$sdk_release.b();
            }
            if (Intrinsics.areEqual(wv.getParent(), parent)) {
                wv.bringToFront();
                wv.post(new Runnable() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        wv.bringToFront();
                    }
                });
                return;
            }
            ViewParent parent2 = wv.getParent();
            FrameLayout frameLayout = parent2 instanceof FrameLayout ? (FrameLayout) parent2 : null;
            if (frameLayout != null) {
                INSTANCE.removeOverlayZOrderKeeper(frameLayout);
            }
            ViewParent parent3 = wv.getParent();
            ViewGroup viewGroup = parent3 instanceof ViewGroup ? (ViewGroup) parent3 : null;
            if (viewGroup != null) {
                viewGroup.removeView(wv);
            }
            parent.addView(wv, new FrameLayout.LayoutParams(-1, -1));
            wv.bringToFront();
            wv.post(new Runnable() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    wv.bringToFront();
                }
            });
            Z z = Z.b;
            Y.a();
            Z.a("Core", logReason);
        } catch (Exception e) {
            Z z2 = Z.b;
            Y.a();
            Z.a("Overlay", "error while attaching overlay: " + logReason, e, 8);
        }
    }

    public static /* synthetic */ void closeMessage$default(Screeb screeb, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        screeb.closeMessage(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit closeSdk$lambda$17() {
        INSTANCE.closeSdk();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void closeSurvey$default(Screeb screeb, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        screeb.closeSurvey(str);
    }

    private final synchronized HashMap<String, String> constructHooks(HashMap<String, Object> hooks) {
        HashMap<String, String> map;
        ConcurrentHashMap<String, Object> hooksRegistry;
        try {
            map = new HashMap<>();
            for (Map.Entry<String, Object> entry : hooks.entrySet()) {
                if (Intrinsics.areEqual(entry.getKey(), DiagnosticsEntry.VERSION_KEY)) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    String string = value instanceof String ? (String) value : null;
                    if (string == null) {
                        string = entry.getValue().toString();
                    }
                    map.put(key, string);
                } else {
                    String string2 = UUID.randomUUID().toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                    C0303g0 c0303g0 = webView;
                    if (c0303g0 != null && (hooksRegistry = c0303g0.getHooksRegistry()) != null) {
                        hooksRegistry.put(string2, entry.getValue());
                    }
                    map.put(entry.getKey(), string2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return map;
    }

    private final Object convertJsonValue(Object value) {
        if (value instanceof JSONObject) {
            return jsonObjectToHashMap((JSONObject) value);
        }
        if (value instanceof JSONArray) {
            return jsonArrayToList((JSONArray) value);
        }
        if (Intrinsics.areEqual(value, JSONObject.NULL)) {
            return null;
        }
        return value;
    }

    public static /* synthetic */ void debug$default(Screeb screeb, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = null;
        }
        screeb.debug(function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit debug$lambda$21(Function2 function2, Object obj, Exception exc) {
        if (exc != null) {
            function2.invoke("", exc);
        } else if (obj instanceof String) {
            function2.invoke(obj, null);
        } else {
            function2.invoke("", new Exception("Unexpected result type"));
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void debugTargeting$default(Screeb screeb, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = null;
        }
        screeb.debugTargeting(function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit debugTargeting$lambda$22(Function2 function2, Object obj, Exception exc) {
        if (exc != null) {
            function2.invoke("", exc);
        } else if (obj instanceof String) {
            function2.invoke(obj, null);
        } else {
            function2.invoke("", new Exception("Unexpected result type"));
        }
        return Unit.INSTANCE;
    }

    private final synchronized void ensureActivityLifecycleCallbacksRegistered(Context context2) {
        if (lifecycleSubscribed) {
            return;
        }
        Context applicationContext = context2.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
        lifecycleSubscribed = true;
    }

    private final String extractNativeHookId(Object payload) {
        String strOptString;
        if (payload instanceof Map) {
            Object obj = ((Map) payload).get("hook_id");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        JSONObject jSONObject = payload instanceof JSONObject ? (JSONObject) payload : null;
        if (jSONObject == null || (strOptString = jSONObject.optString("hook_id")) == null || StringsKt.isBlank(strOptString)) {
            return null;
        }
        return strOptString;
    }

    private final Pair<Integer, Integer> getCurrentWindowSize(Window window) {
        if (Build.VERSION.SDK_INT >= 30) {
            Rect bounds = window.getWindowManager().getCurrentWindowMetrics().getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            return new Pair<>(Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        }
        Rect rect = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int iWidth = rect.width();
        int iHeight = rect.height();
        if (iWidth > 0 && iHeight > 0) {
            return new Pair<>(Integer.valueOf(iWidth), Integer.valueOf(iHeight));
        }
        DisplayMetrics displayMetrics = window.getDecorView().getResources().getDisplayMetrics();
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getIdentity$lambda$19(Function2 function2, Object obj, Exception exc) {
        if (exc != null) {
            function2.invoke(null, exc);
        } else if (obj instanceof JSONObject) {
            function2.invoke(INSTANCE.jsonObjectToHashMap((JSONObject) obj), null);
        } else {
            function2.invoke(null, new Exception("Unexpected result type"));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initSdk$default(Screeb screeb, Context context2, String str, String str2, HashMap map, InitOptions initOptions2, HashMap map2, String str3, int i, Object obj) {
        screeb.initSdk(context2, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : map, (i & 16) != 0 ? new InitOptions(false, false, false, 7, null) : initOptions2, (i & 32) != 0 ? null : map2, (i & 64) != 0 ? null : str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initSdk$lambda$12(InitOptions initOptions2, String str, HashMap map, String str2, HashMap map2, String str3) {
        Unit unit;
        Screeb screeb = INSTANCE;
        synchronized (screeb) {
            try {
                C0303g0 c0303g0 = webView;
                if (c0303g0 != null) {
                    c0303g0.setReplayTelemetry(initOptions2.getReplayTelemetry());
                }
                if (initOptions2.isDebugMode()) {
                    Z.a("Command", "‼️ debug mode enabled, don't forget to disable it in production", null, 12);
                    C0303g0 c0303g1 = webView;
                    if (c0303g1 != null) {
                        c0303g1.setDebugMode(true);
                    }
                }
                HashMap map3 = new HashMap();
                if (str != null || (map != null && (!map.isEmpty()))) {
                    map3.put("identity", MapsKt.hashMapOf(TuplesKt.to(DiagnosticsEntry.ID_KEY, str), TuplesKt.to(DiagnosticsEntry.PROPERTIES_KEY, map)));
                }
                if (str2 != null) {
                    map3.put("language", str2);
                }
                if (map2 != null) {
                    map3.put("hooks", screeb.constructHooks(map2));
                }
                if (map3.isEmpty()) {
                    C0303g0 c0303g2 = webView;
                    if (c0303g2 != null) {
                        ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf("init", str3);
                        int i = C0303g0.$r8$clinit;
                        c0303g2.a(arrayListArrayListOf, (Function2) null);
                    }
                } else {
                    C0303g0 c0303g3 = webView;
                    if (c0303g3 != null) {
                        ArrayList arrayListArrayListOf2 = CollectionsKt.arrayListOf("init", str3, map3);
                        int i2 = C0303g0.$r8$clinit;
                        c0303g3.a(arrayListArrayListOf2, (Function2) null);
                    }
                }
                screeb.sendClientConfig(str3);
                initialized = true;
                for (Pair pair : commandsQueue) {
                    List list = (List) pair.getFirst();
                    Function2 function2 = (Function2) pair.getSecond();
                    C0303g0 c0303g4 = webView;
                    if (c0303g4 != null) {
                        c0303g4.a(list, function2);
                    }
                }
                commandsQueue.clear();
                unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initSdk$lambda$9(Context context2, String str, String str2, HashMap map, InitOptions initOptions2, HashMap map2, String str3) {
        INSTANCE.initSdk(context2, str, str2, map, initOptions2, map2, str3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSdkWithContextOnly$lambda$8() {
        Screeb screeb = INSTANCE;
        synchronized (screeb) {
            try {
                if (webView == null) {
                    try {
                        if (channelId != null) {
                            Context context2 = context;
                            Intrinsics.checkNotNull(context2);
                            String str = channelId;
                            Intrinsics.checkNotNull(str);
                            initSdk$default(screeb, context2, str, identity, visitorProperties, initOptions, null, null, 96, null);
                        }
                    } catch (Throwable th) {
                        Z.a("Command", "deferred init failed", th, 8);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final synchronized void initWebview(Context context2) {
        try {
            ensureActivityLifecycleCallbacksRegistered(context2);
            if (context2 instanceof Activity) {
                WeakReference<Activity> weakReference = resumedActivityRef;
                if ((weakReference != null ? weakReference.get() : null) == null) {
                    resumedActivityRef = new WeakReference<>(context2);
                }
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    String processName = Application.getProcessName();
                    String packageName = context2.getPackageName();
                    if ((packageName == null || StringsKt.isBlank(packageName) || processName == null || StringsKt.isBlank(processName)) ? false : !Intrinsics.areEqual(processName, packageName)) {
                        Intrinsics.checkNotNull(processName);
                        WebView.setDataDirectorySuffix(AbstractC0293b0.a(processName));
                    }
                } catch (Exception e) {
                    Z.a("Command", "error while calling initWebview", e, 8);
                }
            }
            C0303g0 c0303g0 = webView;
            if (c0303g0 != null) {
                c0303g0.destroy();
            }
            C0303g0 c0303g1 = new C0303g0(context2, new X(this), initOptions.getDisableMirror(), new Function0() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Screeb.initWebview$lambda$13();
                }
            }, initOptions.getWebViewHardwareLayer());
            webView = c0303g1;
            Intrinsics.checkNotNull(c0303g1);
            c0303g1.setOnBridgeUnavailable(new Function2() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Screeb.initWebview$lambda$14((List) obj, (Function2) obj2);
                }
            });
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity initWebview$lambda$13() {
        WeakReference<Activity> weakReference = resumedActivityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initWebview$lambda$14(List cmd, Function2 function2) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        INSTANCE.sendCommand(cmd, function2);
        return Unit.INSTANCE;
    }

    private final void installActivityTouchObserver() {
        Activity activity;
        Window window;
        WeakReference<Activity> weakReference = resumedActivityRef;
        if (weakReference == null || (activity = weakReference.get()) == null || (window = activity.getWindow()) == null) {
            return;
        }
        C0294c c0294c = activityTouchObserver;
        if (c0294c.a(window)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(window, "window");
            c0294c.a();
            c0294c.b = new WeakReference(window);
            Window.Callback callback = window.getCallback();
            c0294c.c = callback;
            window.setCallback(new WindowCallbackC0292b(c0294c, callback));
        } catch (Exception e) {
            Z.a("Command", "error while installing activity touch observer", e, 8);
        }
    }

    private final void installOverlayInsetsHandling(final Window window, final FrameLayout parent, final C0303g0 view) {
        final View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        WeakHashMap<C0303g0, Pair<View, FrameLayout>> weakHashMap = overlayInsetsBindings;
        Pair<View, FrameLayout> pair = weakHashMap.get(view);
        if (pair != null && pair.getFirst() == decorView && pair.getSecond() == parent) {
            return;
        }
        weakHashMap.put(view, new Pair<>(decorView, parent));
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda10
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return Screeb.installOverlayInsetsHandling$lambda$32(view, parent, window, decorView, view2, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat installOverlayInsetsHandling$lambda$32(C0303g0 c0303g0, FrameLayout frameLayout, Window window, View view, View view2, WindowInsetsCompat windowInsetsCompat) {
        if (!ViewCompat.isAttachedToWindow(c0303g0) || c0303g0.getParent() != frameLayout || window.getDecorView() != view || !applyingInsetsViews.add(c0303g0)) {
            return windowInsetsCompat;
        }
        try {
            INSTANCE.applyOverlayFrame(window, frameLayout, c0303g0, windowInsetsCompat.isVisible(WindowInsetsCompat.Type.ime()) ? windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom : 0);
            C0291a0 mirror$sdk_release = c0303g0.getMirror$sdk_release();
            if (mirror$sdk_release != null) {
                mirror$sdk_release.b();
            }
            return windowInsetsCompat;
        } finally {
            applyingInsetsViews.remove(c0303g0);
        }
    }

    private final void installOverlayZOrderKeeper(final FrameLayout parent, final C0303g0 wv) {
        WeakHashMap<FrameLayout, ViewTreeObserver.OnGlobalLayoutListener> weakHashMap = overlayZOrderListeners;
        if (weakHashMap.containsKey(parent)) {
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda14
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Screeb.installOverlayZOrderKeeper$lambda$33(wv, parent);
            }
        };
        if (parent.getViewTreeObserver().isAlive()) {
            weakHashMap.put(parent, onGlobalLayoutListener);
            parent.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installOverlayZOrderKeeper$lambda$33(C0303g0 c0303g0, FrameLayout frameLayout) {
        if (c0303g0.getVisibility() == 0 && c0303g0.getParent() == frameLayout && frameLayout.getChildAt(frameLayout.getChildCount() - 1) != c0303g0) {
            c0303g0.bringToFront();
        }
        if (c0303g0.getParent() != frameLayout || frameLayout.getWidth() <= 0 || frameLayout.getHeight() <= 0) {
            return;
        }
        if (c0303g0.getWidth() <= 1 || c0303g0.getHeight() <= frameLayout.getHeight() / 4) {
            Context context2 = frameLayout.getContext();
            Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
            Window window = activity != null ? activity.getWindow() : null;
            if (window != null) {
                Z z = Z.b;
                Y.a();
                Z.b("Overlay", "overlay laid out " + c0303g0.getWidth() + "x" + c0303g0.getHeight() + " in a " + frameLayout.getWidth() + "x" + frameLayout.getHeight() + " parent — re-applying frame");
                INSTANCE.applyOverlayFrame(window, frameLayout, c0303g0, 0);
            }
        }
    }

    private final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    private final boolean isOverlayEligible(Activity activity) {
        String name = activity.getClass().getName();
        for (String str : overlayForeignActivityPrefixes) {
            Intrinsics.checkNotNull(name);
            if (StringsKt.startsWith$default(name, str, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    private final List<Object> jsonArrayToList(JSONArray array) {
        IntRange intRangeUntil = RangesKt.until(0, array.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.convertJsonValue(array.opt(((IntIterator) it).nextInt())));
        }
        return arrayList;
    }

    private final HashMap<String, Object> jsonObjectToHashMap(JSONObject json) {
        HashMap<String, Object> map = new HashMap<>();
        Iterator<String> itKeys = json.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, convertJsonValue(json.opt(next)));
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V makeHooks$lambda$5$lambda$4(ScreebHookCallback screebHookCallback, String str, Object payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Screeb screeb = INSTANCE;
        String strExtractNativeHookId = screeb.extractNativeHookId(payload);
        if (strExtractNativeHookId == null) {
            strExtractNativeHookId = "";
        }
        screebHookCallback.invoke(str, strExtractNativeHookId, screeb.stringifyHookPayload(payload));
        return V.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onRecover() throws Throwable {
        Context context2;
        try {
            try {
                initialized = false;
                C0303g0 c0303g0 = webView;
                webView = null;
                if (c0303g0 != null) {
                    try {
                        c0303g0.destroy();
                    } catch (Exception e) {
                        Z z = Z.b;
                        Z z2 = Z.b;
                        Z z3 = Z.b;
                        Z.a("Core", "error while destroying crashed webview", e, 8);
                    }
                }
                if (channelId == null || (context2 = context) == null) {
                    Z.a("Core", "can't recover webview", null, 12);
                } else {
                    Intrinsics.checkNotNull(context2);
                    String str = channelId;
                    Intrinsics.checkNotNull(str);
                    initSdk$default(this, context2, str, identity, visitorProperties, initOptions, null, null, 96, null);
                    Z.a("Core", "webview recovering");
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onWebviewSchedule$lambda$16() {
        if (activityObservationEnabled) {
            INSTANCE.sendActivityPing(SystemClock.elapsedRealtime(), true);
        }
        sendCommand$default(INSTANCE, CollectionsKt.arrayListOf("targeting.check"), null, 2, null);
    }

    public static /* synthetic */ void pluginInit$default(Screeb screeb, String str, String str2, HashMap map, HashMap map2, HashMap map3, String str3, int i, Object obj) throws Throwable {
        if ((i & 32) != 0) {
            str3 = null;
        }
        screeb.pluginInit(str, str2, map, map2, map3, str3);
    }

    private final void postToMainThread(final Function0 block) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                block.invoke();
            }
        });
    }

    private final void registerOverlay(Activity activity) {
        activitySet.add(activity);
        updateOverlay(activity);
    }

    private final void removeOverlay(Activity activity) {
        C0303g0 c0303g0 = webView;
        if (c0303g0 == null) {
            return;
        }
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        FrameLayout frameLayoutResolveOverlayParent = resolveOverlayParent(window);
        if (frameLayoutResolveOverlayParent == null) {
            Z.a("Core", "Unable to find root view", null, 12);
        } else {
            removeOverlayZOrderKeeper(frameLayoutResolveOverlayParent);
            frameLayoutResolveOverlayParent.removeView(c0303g0);
        }
    }

    private final void removeOverlayZOrderKeeper(FrameLayout parent) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerRemove = overlayZOrderListeners.remove(parent);
        if (onGlobalLayoutListenerRemove != null && parent.getViewTreeObserver().isAlive()) {
            parent.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListenerRemove);
        }
    }

    private final FrameLayout resolveOverlayParent(Window window) {
        View decorView = window.getDecorView();
        FrameLayout frameLayout = decorView instanceof FrameLayout ? (FrameLayout) decorView : null;
        return frameLayout == null ? (FrameLayout) window.getDecorView().findViewById(R.id.content) : frameLayout;
    }

    private final void sendActivityPing(long now, boolean force) {
        if (force || now - lastPingAtMs >= 5000) {
            lastPingAtMs = now;
            sendCommand$default(this, CollectionsKt.arrayListOf("event.activity", Long.valueOf(now - lastTouchAtMs)), null, 2, null);
        }
    }

    private final synchronized void sendClientConfig(String channelId2) {
        try {
            HashMap map = new HashMap();
            map.put("app_version", AbstractC0298e.a(context));
            map.put("api_version", "1.3.0");
            map.put("sdk_version", "4.4.0");
            map.put("os", String.valueOf(Build.VERSION.SDK_INT));
            map.put("brand_name", Build.BRAND);
            map.put("manufacturer_name", Build.MANUFACTURER);
            map.put("model_name", Build.MODEL);
            map.put("device_name", Build.DEVICE);
            map.put("platform", "android");
            Pair<String, String> pair = secondarySDK;
            if (pair != null) {
                Intrinsics.checkNotNull(pair);
                map.put("secondary_sdk_version", pair.getSecond());
                Pair<String, String> pair2 = secondarySDK;
                Intrinsics.checkNotNull(pair2);
                map.put("secondary_sdk_name", pair2.getFirst());
            }
            List listC = AbstractC0298e.c(context);
            if (!listC.isEmpty()) {
                map.put("networks", listC);
            }
            String strB = AbstractC0298e.b(context);
            if (strB != null) {
                map.put("carrier", strB);
            }
            String languageTag = Locale.getDefault().toLanguageTag();
            Intrinsics.checkNotNull(languageTag);
            if (languageTag.length() > 0) {
                map.put("locale", languageTag);
            }
            C0303g0 c0303g0 = webView;
            if (c0303g0 != null) {
                c0303g0.a(CollectionsKt.arrayListOf("client.internal", channelId2, map), (Function2) null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void sendCommand(List<? extends Object> cmd, Function2 callback) {
        C0303g0 c0303g0 = webView;
        if (c0303g0 != null) {
            Intrinsics.checkNotNull(c0303g0);
            if (c0303g0.e && initialized) {
                C0303g0 c0303g1 = webView;
                Intrinsics.checkNotNull(c0303g1);
                c0303g1.a(cmd, callback);
                return;
            }
        }
        ArrayDeque arrayDeque = commandsQueue;
        if (arrayDeque.size() < commandsQueueMaxSize) {
            arrayDeque.add(new Pair(cmd, callback));
        } else {
            Z.a("Command", "Screeb SDK not yet initialized — please init before sending more commands.", null, 12);
        }
    }

    public static /* synthetic */ void sendCommand$default(Screeb screeb, List list, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        screeb.sendCommand(list, function2);
    }

    private final void setChannelId(String str) {
        channelId = str;
        Z.b.a = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setIdentity$default(Screeb screeb, String str, HashMap map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        screeb.setIdentity(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startMessage$default(Screeb screeb, String str, boolean z, HashMap map, boolean z2, HashMap map2, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        if ((i & 16) != 0) {
            map2 = null;
        }
        if ((i & 32) != 0) {
            str2 = null;
        }
        if ((i & 64) != 0) {
            str3 = null;
        }
        screeb.startMessage(str, z, map, z2, map2, str2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startSurvey$default(Screeb screeb, String str, boolean z, HashMap map, boolean z2, HashMap map2, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        if ((i & 16) != 0) {
            map2 = null;
        }
        if ((i & 32) != 0) {
            str2 = null;
        }
        if ((i & 64) != 0) {
            str3 = null;
        }
        screeb.startSurvey(str, z, map, z2, map2, str2, str3);
    }

    private final String stringifyHookPayload(Object payload) {
        return payload.toString();
    }

    private final void syncOverlayInWindow(Window window, FrameLayout parent, C0303g0 wv, String logReason) {
        attachWebViewToParent(parent, wv, logReason);
        installOverlayInsetsHandling(window, parent, wv);
        installOverlayZOrderKeeper(parent, wv);
        applyOverlayFrame(window, parent, wv, 0);
        C0291a0 mirror$sdk_release = wv.getMirror$sdk_release();
        if (mirror$sdk_release != null) {
            mirror$sdk_release.b();
        }
        ViewCompat.requestApplyInsets(wv);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackEvent$default(Screeb screeb, String str, HashMap map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        screeb.trackEvent(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackScreen$default(Screeb screeb, String str, HashMap map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        screeb.trackScreen(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void unassignGroup$default(Screeb screeb, String str, String str2, HashMap map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        screeb.unassignGroup(str, str2, map);
    }

    private final void unregisterOverlay(Activity activity) {
        activitySet.remove(activity);
        removeOverlay(activity);
    }

    private final void updateOverlay(Activity activity) {
        C0303g0 c0303g0 = webView;
        if (c0303g0 == null) {
            return;
        }
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        FrameLayout frameLayoutResolveOverlayParent = resolveOverlayParent(window);
        if (frameLayoutResolveOverlayParent == null) {
            Z.a("Overlay", "Unable to find root view", null, 12);
            return;
        }
        Window window2 = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window2, "getWindow(...)");
        syncOverlayInWindow(window2, frameLayoutResolveOverlayParent, c0303g0, "webview moved to top window");
    }

    @Keep
    public final synchronized void assignGroup(String type, String name, HashMap<String, Object> properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        sendCommand$default(this, CollectionsKt.arrayListOf("identity.group.assign", type, name, properties != null ? properties : MapsKt.emptyMap()), null, 2, null);
    }

    @Keep
    public final synchronized void attachToWindow(final Window window) {
        if (window == null) {
            return;
        }
        try {
            if (!isMainThread()) {
                postToMainThread(new Function0() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Screeb.attachToWindow$lambda$24(window);
                    }
                });
                return;
            }
            C0303g0 c0303g0 = webView;
            if (c0303g0 == null) {
                return;
            }
            try {
                FrameLayout frameLayoutResolveOverlayParent = resolveOverlayParent(window);
                if (frameLayoutResolveOverlayParent == null) {
                    Z.a("Overlay", "Unable to find root view for provided window", null, 12);
                } else {
                    syncOverlayInWindow(window, frameLayoutResolveOverlayParent, c0303g0, "webview moved to provided window");
                }
            } catch (Exception e) {
                Z.a("Overlay", "error while attaching overlay to provided window", e, 8);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Keep
    public final synchronized void closeMessage(String messageId) {
        sendCommand$default(this, CollectionsKt.arrayListOf("message.close", messageId), null, 2, null);
    }

    @Keep
    public final synchronized void closeSdk() {
        if (!isMainThread()) {
            postToMainThread(new Function0() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Screeb.closeSdk$lambda$17();
                }
            });
            return;
        }
        if (initialized) {
            Runnable runnable = scheduleRunnable;
            if (runnable != null) {
                scheduleHandler.removeCallbacks(runnable);
            }
            scheduleRunnable = null;
            if (activityObservationEnabled) {
                activityObservationEnabled = false;
                activityTouchObserver.a();
            }
            sendCommand$default(this, CollectionsKt.arrayListOf("close"), null, 2, null);
            initialized = false;
            C0303g0 c0303g0 = webView;
            if (c0303g0 != null) {
                C0291a0 c0291a0 = c0303g0.j;
                if (c0291a0 != null) {
                    c0291a0.a.g();
                    A a = c0291a0.c;
                    if (a != null) {
                        a.b();
                    }
                    c0291a0.c = null;
                }
                c0303g0.b((String) null);
            }
        }
    }

    @Keep
    public final synchronized void closeSurvey(String surveyId) {
        sendCommand$default(this, CollectionsKt.arrayListOf("survey.close", surveyId), null, 2, null);
    }

    @Keep
    public final synchronized void debug(final Function2 callback) {
        try {
            if (callback == null) {
                sendCommand$default(this, CollectionsKt.arrayListOf("debug"), null, 2, null);
            } else {
                sendCommand(CollectionsKt.arrayListOf("debug"), new Function2() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Screeb.debug$lambda$21(callback, obj, (Exception) obj2);
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Keep
    public final synchronized void debugTargeting(final Function2 callback) {
        try {
            if (callback == null) {
                sendCommand$default(this, CollectionsKt.arrayListOf("targeting.debug"), null, 2, null);
            } else {
                sendCommand(CollectionsKt.arrayListOf("targeting.debug"), new Function2() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Screeb.debugTargeting$lambda$22(callback, obj, (Exception) obj2);
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Keep
    public final synchronized void getIdentity(final Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        sendCommand(CollectionsKt.arrayListOf("identity.get"), new Function2() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Screeb.getIdentity$lambda$19(callback, obj, (Exception) obj2);
            }
        });
    }

    @Keep
    public final synchronized void handleDeepLink(Intent intent) {
        Uri data;
        if (intent != null) {
            try {
                data = intent.getData();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            data = null;
        }
        if (data != null) {
            handleDeepLink(data);
        }
    }

    @Keep
    public final synchronized void handleDeepLink(Uri url) throws Throwable {
        try {
            if (url == null) {
                return;
            }
            try {
                C0304h c0304hA = AbstractC0306i.a(url.toString(), url.getScheme(), url.getHost(), url.getEncodedQuery());
                if (c0304hA == null) {
                    return;
                }
                if (channelId == null) {
                    try {
                        initSdk$default(this, context, c0304hA.a, null, null, null, null, null, 124, null);
                    } catch (Exception e) {
                        e = e;
                        Z.a("Command", "error while calling handleDeepLink", e, 8);
                    }
                }
                ArrayList arrayList = c0304hA.b;
                if (arrayList != null) {
                    sendCommand$default(INSTANCE, arrayList, null, 2, null);
                }
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
            Z.a("Command", "error while calling handleDeepLink", e, 8);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Keep
    public final synchronized void handleDeepLink(String url) {
        if (url == null) {
            return;
        }
        try {
            handleDeepLink(Uri.parse(url));
        } catch (Exception e) {
            Z.a("Command", "error while calling handleDeepLink(String)", e, 8);
        }
    }

    @Keep
    public final synchronized void initSdk(final Context context2, final String channelId2, final String visitorId, final HashMap<String, Object> visitorProperties2, final InitOptions initOptions2, final HashMap<String, Object> hooks, final String language) {
        Activity activity;
        C0303g0 c0303g0;
        Context context3;
        try {
            Intrinsics.checkNotNullParameter(channelId2, "channelId");
            Intrinsics.checkNotNullParameter(initOptions2, "initOptions");
            if (!isMainThread()) {
                postToMainThread(new Function0() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Screeb.initSdk$lambda$9(context2, channelId2, visitorId, visitorProperties2, initOptions2, hooks, language);
                    }
                });
                return;
            }
            try {
                setChannelId(channelId2);
                identity = visitorId;
                visitorProperties = visitorProperties2;
                initOptions = initOptions2;
                if (context2 != null) {
                    context = context2.getApplicationContext();
                }
                if (webView == null && (context3 = context) != null) {
                    Intrinsics.checkNotNull(context3);
                    initWebview(context3);
                } else if (context == null) {
                    Z.a("Command", "can't init sdk, context is nil", null, 12);
                    return;
                }
                C0303g0 c0303g1 = webView;
                if (c0303g1 != null) {
                    c0303g1.setHardwareLayer(initOptions2.getWebViewHardwareLayer());
                }
                C0303g0 c0303g2 = webView;
                boolean z = c0303g2 != null ? c0303g2.e : false;
                C0303g0 c0303g3 = webView;
                if (c0303g3 != null) {
                    c0303g3.setOnSdkLoaded(new Function0() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Screeb.initSdk$lambda$12(initOptions2, visitorId, visitorProperties2, language, hooks, channelId2);
                        }
                    });
                }
                if (z && (c0303g0 = webView) != null) {
                    c0303g0.f();
                }
            } catch (Exception e) {
                Z.a("Command", "error while calling initSdk", e, 8);
            }
            try {
                WeakReference<Activity> weakReference = resumedActivityRef;
                if (weakReference != null && (activity = weakReference.get()) != null) {
                    updateOverlay(activity);
                }
            } catch (Exception e2) {
                Z.a("Overlay", "error while attaching overlay to current activity", e2, 8);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Keep
    public final synchronized void initSdkWithContextOnly(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Context applicationContext = context2.getApplicationContext();
        context = applicationContext;
        Intrinsics.checkNotNull(applicationContext);
        ensureActivityLifecycleCallbacksRegistered(applicationContext);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Screeb.initSdkWithContextOnly$lambda$8();
            }
        });
    }

    public final boolean isPendingHookResult$sdk_release(Object result) {
        return result == V.a;
    }

    @Keep
    public final synchronized HashMap<String, Object> makeHooks(Map<String, String> hookIds, final ScreebHookCallback callback) {
        HashMap<String, Object> map;
        try {
            Intrinsics.checkNotNullParameter(hookIds, "hookIds");
            Intrinsics.checkNotNullParameter(callback, "callback");
            map = new HashMap<>();
            for (Map.Entry<String, String> entry : hookIds.entrySet()) {
                if (Intrinsics.areEqual(entry.getKey(), DiagnosticsEntry.VERSION_KEY)) {
                    map.put(entry.getKey(), entry.getValue());
                } else {
                    final String value = entry.getValue();
                    map.put(entry.getKey(), new Function1() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Screeb.makeHooks$lambda$5$lambda$4(callback, value, obj);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return map;
    }

    public final void noteHostTouch$sdk_release() {
        if (activityObservationEnabled) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            lastTouchAtMs = jElapsedRealtime;
            sendActivityPing(jElapsedRealtime, false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activitySet.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            unregisterOverlay(activity);
        } catch (Exception e) {
            Z z = Z.b;
            Z z2 = Z.b;
            Z z3 = Z.b;
            Z.a("Overlay", "error while detaching overlay on destroy", e, 8);
        }
        try {
            Window window = activity.getWindow();
            if (window != null) {
                C0294c c0294c = activityTouchObserver;
                if (c0294c.a(window)) {
                    c0294c.a();
                }
            }
        } catch (Exception e2) {
            Z.a("Command", "error while detaching activity touch observer on destroy", e2, 8);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        WeakReference<Activity> weakReference = resumedActivityRef;
        if ((weakReference != null ? weakReference.get() : null) == activity) {
            resumedActivityRef = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (isOverlayEligible(activity)) {
            resumedActivityRef = new WeakReference<>(activity);
            try {
                registerOverlay(activity);
            } catch (Exception e) {
                Z z = Z.b;
                Z z2 = Z.b;
                Z z3 = Z.b;
                Z.a("Overlay", "error while attaching overlay on resume", e, 8);
            }
            if (activityObservationEnabled) {
                installActivityTouchObserver();
                sendActivityPingOnForeground$sdk_release();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activitySet.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Keep
    public final synchronized void onHookResult(String hookId, Object result) {
        Intrinsics.checkNotNullParameter(hookId, "hookId");
        C0303g0 c0303g0 = webView;
        if (c0303g0 != null) {
            c0303g0.a(hookId, result);
        }
    }

    public final void onWebviewSchedule$sdk_release(Long inMs, boolean needsActivity) {
        Runnable runnable = scheduleRunnable;
        if (runnable != null) {
            scheduleHandler.removeCallbacks(runnable);
        }
        scheduleRunnable = null;
        if (inMs != null) {
            Runnable runnable2 = new Runnable() { // from class: app.screeb.sdk.Screeb$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    Screeb.onWebviewSchedule$lambda$16();
                }
            };
            scheduleRunnable = runnable2;
            scheduleHandler.postDelayed(runnable2, inMs.longValue());
        }
        boolean z = activityObservationEnabled;
        if (!needsActivity) {
            if (z) {
                activityObservationEnabled = false;
                activityTouchObserver.a();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        activityObservationEnabled = true;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        lastTouchAtMs = jElapsedRealtime;
        installActivityTouchObserver();
        sendActivityPing(jElapsedRealtime, true);
    }

    @Keep
    public final synchronized void pluginInit(String channelId2, String visitorId, HashMap<String, Object> visitorProperties2, HashMap<String, Object> initOptions2, HashMap<String, Object> hooks, String language) throws Throwable {
        Throwable th;
        try {
            try {
                Intrinsics.checkNotNullParameter(channelId2, "channelId");
                setChannelId(channelId2);
                identity = visitorId;
                visitorProperties = visitorProperties2;
                InitOptions.Companion.getClass();
                InitOptions initOptions3 = new InitOptions(false, false, false, 7, null);
                if (initOptions2 != null) {
                    if (initOptions2.get("isDebugMode") instanceof Boolean) {
                        try {
                            Object obj = initOptions2.get("isDebugMode");
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                            initOptions3.setDebugMode(((Boolean) obj).booleanValue());
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    if (initOptions2.get("disableMirror") instanceof Boolean) {
                        Object obj2 = initOptions2.get("disableMirror");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                        initOptions3.setDisableMirror(((Boolean) obj2).booleanValue());
                    }
                    if (initOptions2.get("replayTelemetry") instanceof Boolean) {
                        Object obj3 = initOptions2.get("replayTelemetry");
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                        initOptions3.setReplayTelemetry$sdk_release(((Boolean) obj3).booleanValue());
                    }
                    if (initOptions2.get("webViewHardwareLayer") instanceof Boolean) {
                        Object obj4 = initOptions2.get("webViewHardwareLayer");
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                        initOptions3.setWebViewHardwareLayer(((Boolean) obj4).booleanValue());
                    }
                }
                initOptions = initOptions3;
                Context context2 = context;
                if (context2 != null) {
                    Intrinsics.checkNotNull(context2);
                    initSdk(context2, channelId2, visitorId, visitorProperties2, initOptions, hooks, language);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    @Keep
    public final synchronized void resetIdentity() {
        sendCommand$default(this, CollectionsKt.arrayListOf("identity.reset"), null, 2, null);
    }

    public final void sendActivityPingOnForeground$sdk_release() {
        if (activityObservationEnabled) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            lastTouchAtMs = jElapsedRealtime;
            sendActivityPing(jElapsedRealtime, true);
        }
    }

    @Keep
    public final synchronized void sessionReplayStart() {
        sendCommand$default(this, CollectionsKt.arrayListOf("session-replay.start"), null, 2, null);
    }

    @Keep
    public final synchronized void sessionReplayStop() {
        sendCommand$default(this, CollectionsKt.arrayListOf("session-replay.stop"), null, 2, null);
    }

    @Keep
    public final synchronized void setAnonymousId(String anonymousId) {
        Intrinsics.checkNotNullParameter(anonymousId, "anonymousId");
        sendCommand$default(this, CollectionsKt.arrayListOf("identity.anonymous_id", anonymousId), null, 2, null);
    }

    @Keep
    public final synchronized void setIdentity(String uniqueVisitorId, HashMap<String, Object> properties) {
        Intrinsics.checkNotNullParameter(uniqueVisitorId, "uniqueVisitorId");
        sendCommand$default(this, CollectionsKt.arrayListOf("identity", uniqueVisitorId, properties != null ? properties : MapsKt.emptyMap()), null, 2, null);
    }

    @Keep
    public final synchronized void setSecondarySDK(String name, String version) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        secondarySDK = new Pair<>(name, version);
    }

    @Keep
    public final synchronized void setVisitorProperties(HashMap<String, Object> visitorProperties2) {
        Intrinsics.checkNotNullParameter(visitorProperties2, "visitorProperties");
        sendCommand$default(this, CollectionsKt.arrayListOf("identity.properties", visitorProperties2), null, 2, null);
    }

    @Keep
    public final synchronized void startMessage(String messageId, boolean allowMultipleResponses, HashMap<String, Object> hiddenFields, boolean ignoreMessageStatus, HashMap<String, Object> hooks, String language, String distributionId) {
        try {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            HashMap map = new HashMap();
            map.put("allow_multiple_responses", Boolean.valueOf(allowMultipleResponses));
            map.put("hidden_fields", hiddenFields);
            map.put("ignore_message_status", Boolean.valueOf(ignoreMessageStatus));
            if (language != null) {
                map.put("language", language);
            }
            if (hooks != null) {
                map.put("hooks", constructHooks(hooks));
            }
            if (distributionId != null) {
                map.put("distribution_id", distributionId);
            }
            sendCommand$default(this, CollectionsKt.arrayListOf("message.start", messageId, map), null, 2, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Keep
    public final synchronized void startSurvey(String surveyId, boolean allowMultipleResponses, HashMap<String, Object> hiddenFields, boolean ignoreSurveyStatus, HashMap<String, Object> hooks, String language, String distributionId) {
        try {
            Intrinsics.checkNotNullParameter(surveyId, "surveyId");
            HashMap map = new HashMap();
            map.put("allow_multiple_responses", Boolean.valueOf(allowMultipleResponses));
            map.put("hidden_fields", hiddenFields);
            map.put("ignore_survey_status", Boolean.valueOf(ignoreSurveyStatus));
            if (language != null) {
                map.put("language", language);
            }
            if (hooks != null) {
                map.put("hooks", constructHooks(hooks));
            }
            if (distributionId != null) {
                map.put("distribution_id", distributionId);
            }
            sendCommand$default(this, CollectionsKt.arrayListOf("survey.start", surveyId, map), null, 2, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    @Keep
    public final synchronized void startSurveyFromNotification(String surveyId) {
        if (surveyId == null) {
            return;
        }
        startSurvey$default(this, surveyId, true, null, true, null, null, null, 112, null);
    }

    @Keep
    public final synchronized void trackEvent(String name, HashMap<String, Object> trackingEventProperties) {
        Intrinsics.checkNotNullParameter(name, "name");
        sendCommand$default(this, CollectionsKt.arrayListOf("event.track", name, trackingEventProperties != null ? trackingEventProperties : MapsKt.emptyMap()), null, 2, null);
    }

    @Keep
    public final synchronized void trackScreen(String name, HashMap<String, Object> trackingEventProperties) {
        try {
            Intrinsics.checkNotNullParameter(name, "name");
            String str = channelId;
            if (str != null) {
                INSTANCE.sendClientConfig(str);
            }
            sendCommand$default(this, CollectionsKt.arrayListOf("event.screen", name, trackingEventProperties != null ? trackingEventProperties : MapsKt.emptyMap()), null, 2, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Keep
    public final synchronized void unassignGroup(String type, String name, HashMap<String, Object> properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        sendCommand$default(this, CollectionsKt.arrayListOf("identity.group.unassign", type, name, properties != null ? properties : MapsKt.emptyMap()), null, 2, null);
    }
}
