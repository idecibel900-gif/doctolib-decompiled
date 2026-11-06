package expo.modules.image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.github.penfeizhou.animation.gif.GifDrawable;
import expo.modules.image.enums.ContentFit;
import expo.modules.image.enums.Priority;
import expo.modules.image.events.GlideRequestListener;
import expo.modules.image.events.OkHttpProgressListener;
import expo.modules.image.okhttp.GlideUrlWrapper;
import expo.modules.image.records.CachePolicy;
import expo.modules.image.records.ContentPosition;
import expo.modules.image.records.DecodeFormat;
import expo.modules.image.records.ImageTransition;
import expo.modules.image.records.Source;
import expo.modules.image.svg.SVGPictureDrawable;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import java.lang.ref.WeakReference;
import java.util.List;
import jp.wasabeef.glide.transformations.BlurTransformation;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 Ô\u00012\u00020\u0001:\u0002Ô\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u0004\u0018\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J-\u0010+\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010 2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010*\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\fH\u0002¢\u0006\u0004\b0\u00101J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u00102J'\u00103\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b3\u00104J/\u0010:\u001a\u00020\f2\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u0002052\u0006\u00109\u001a\u000205H\u0014¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\f¢\u0006\u0004\b<\u00101J#\u0010A\u001a\u00020\f2\b\b\u0002\u0010=\u001a\u00020\n2\b\b\u0002\u0010>\u001a\u00020\nH\u0000¢\u0006\u0004\b?\u0010@R\u001a\u0010G\u001a\u00020B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010LR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010RR!\u0010Y\u001a\b\u0012\u0004\u0012\u00020\f0T8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR!\u0010]\u001a\b\u0012\u0004\u0012\u00020Z0T8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b[\u0010V\u001a\u0004\b\\\u0010XR!\u0010a\u001a\b\u0012\u0004\u0012\u00020^0T8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b_\u0010V\u001a\u0004\b`\u0010XR!\u0010e\u001a\b\u0012\u0004\u0012\u00020b0T8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bc\u0010V\u001a\u0004\bd\u0010XR!\u0010h\u001a\b\u0012\u0004\u0012\u00020\f0T8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bf\u0010V\u001a\u0004\bg\u0010XR(\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR(\u0010n\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bn\u0010i\u001a\u0004\bo\u0010k\"\u0004\bp\u0010mR.\u0010q\u001a\u0004\u0018\u0001052\b\u0010\u0016\u001a\u0004\u0018\u0001058\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR$\u0010x\u001a\u0004\u0018\u00010w8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R/\u0010\u007f\u001a\u00020~2\u0006\u0010\u0016\u001a\u00020~8\u0000@@X\u0080\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R1\u0010\u0085\u0001\u001a\u00020~2\u0006\u0010\u0016\u001a\u00020~8\u0000@@X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0080\u0001\u001a\u0006\b\u0086\u0001\u0010\u0082\u0001\"\u0006\b\u0087\u0001\u0010\u0084\u0001R3\u0010\u0089\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0016\u001a\u00030\u0088\u00018\u0000@@X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R2\u0010\u008f\u0001\u001a\u0004\u0018\u0001052\b\u0010\u0016\u001a\u0004\u0018\u0001058\u0000@@X\u0080\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010r\u001a\u0005\b\u0090\u0001\u0010t\"\u0005\b\u0091\u0001\u0010vR0\u0010\u0092\u0001\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n8\u0000@@X\u0080\u000e¢\u0006\u0017\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0005\b\u0096\u0001\u00102R0\u0010\u0097\u0001\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n8\u0000@@X\u0080\u000e¢\u0006\u0017\n\u0006\b\u0097\u0001\u0010\u0093\u0001\u001a\u0006\b\u0098\u0001\u0010\u0095\u0001\"\u0005\b\u0099\u0001\u00102R7\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010\u0016\u001a\u0005\u0018\u00010\u009a\u00018\u0000@@X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R7\u0010¡\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010\u0016\u001a\u0005\u0018\u00010\u009a\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010\u009c\u0001\u001a\u0006\b¢\u0001\u0010\u009e\u0001\"\u0006\b£\u0001\u0010 \u0001R0\u0010¤\u0001\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n8\u0000@@X\u0080\u000e¢\u0006\u0017\n\u0006\b¤\u0001\u0010\u0093\u0001\u001a\u0006\b¥\u0001\u0010\u0095\u0001\"\u0005\b¦\u0001\u00102R3\u0010¨\u0001\u001a\u00030§\u00012\u0007\u0010\u0016\u001a\u00030§\u00018\u0000@@X\u0080\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R(\u0010®\u0001\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b®\u0001\u0010\u0093\u0001\u001a\u0006\b¯\u0001\u0010\u0095\u0001\"\u0005\b°\u0001\u00102R(\u0010±\u0001\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b±\u0001\u0010\u0093\u0001\u001a\u0006\b²\u0001\u0010\u0095\u0001\"\u0005\b³\u0001\u00102R*\u0010µ\u0001\u001a\u00030´\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R*\u0010¼\u0001\u001a\u00030»\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R(\u0010Â\u0001\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\bÂ\u0001\u0010\u0093\u0001\u001a\u0006\bÃ\u0001\u0010\u0095\u0001\"\u0005\bÄ\u0001\u00102R\u001b\u0010Å\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001b\u0010Ç\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010Æ\u0001R\u0019\u0010È\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010\u0093\u0001R\u0017\u00100\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b0\u0010\u0093\u0001R\u0018\u0010Ì\u0001\u001a\u00030É\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u0017\u0010Ï\u0001\u001a\u00020\u00118BX\u0082\u0004¢\u0006\b\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0018\u0010Ñ\u0001\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\"\u0010Ð\u0001R\u0019\u0010Ó\u0001\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Ð\u0001¨\u0006Õ\u0001"}, d2 = {"Lexpo/modules/image/ExpoImageViewWrapper;", "Lexpo/modules/kotlin/views/ExpoView;", "Landroid/content/Context;", "context", "Lexpo/modules/kotlin/AppContext;", "appContext", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "Lcom/github/penfeizhou/animation/gif/GifDrawable;", "resource", "", "setAnimating", "", "setIsAnimating", "(Lcom/github/penfeizhou/animation/gif/GifDrawable;Z)V", "Landroid/graphics/drawable/Animatable;", "(Landroid/graphics/drawable/Animatable;Z)V", "Lexpo/modules/image/ExpoImageView;", "view", "copyProps", "(Lexpo/modules/image/ExpoImageView;)V", "Landroid/view/View;", "value", "setIsScreenReaderFocusable", "(Landroid/view/View;Z)V", "Lexpo/modules/image/ImageViewWrapperTarget;", "target", "Landroid/graphics/drawable/Drawable;", "isPlaceholder", "configureView", "(Lexpo/modules/image/ExpoImageView;Lexpo/modules/image/ImageViewWrapperTarget;Landroid/graphics/drawable/Drawable;Z)V", "", "Lexpo/modules/image/records/Source;", "sources", "getBestSource", "(Ljava/util/List;)Lexpo/modules/image/records/Source;", "Lcom/bumptech/glide/request/RequestOptions;", "createPropOptions", "()Lcom/bumptech/glide/request/RequestOptions;", "newBestSource", "Lexpo/modules/image/GlideModelProvider;", "newBestSourceModel", "newBestPlaceholderModel", "cleanIfNeeded", "(Lexpo/modules/image/records/Source;Lexpo/modules/image/GlideModelProvider;Lexpo/modules/image/GlideModelProvider;)Z", "Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;", "createDownsampleStrategy", "(Lexpo/modules/image/ImageViewWrapperTarget;)Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;", "clearViewBeforeChangingSource", "()V", "(Z)V", "onResourceReady", "(Lexpo/modules/image/ImageViewWrapperTarget;Landroid/graphics/drawable/Drawable;Z)Z", "", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "onViewDestroys", "shouldRerenderBecauseOfResize", "force", "rerenderIfNeeded$expo_image_release", "(ZZ)V", "rerenderIfNeeded", "Lcom/bumptech/glide/RequestManager;", "requestManager$1", "Lcom/bumptech/glide/RequestManager;", "getRequestManager$expo_image_release", "()Lcom/bumptech/glide/RequestManager;", "requestManager", "Lexpo/modules/image/events/OkHttpProgressListener;", "progressListener", "Lexpo/modules/image/events/OkHttpProgressListener;", "firstView", "Lexpo/modules/image/ExpoImageView;", "secondView", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "firstTarget", "Lexpo/modules/image/ImageViewWrapperTarget;", "secondTarget", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onLoadStart$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "getOnLoadStart$expo_image_release", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onLoadStart", "Lexpo/modules/image/records/ImageProgressEvent;", "onProgress$delegate", "getOnProgress$expo_image_release", "onProgress", "Lexpo/modules/image/records/ImageErrorEvent;", "onError$delegate", "getOnError$expo_image_release", "onError", "Lexpo/modules/image/records/ImageLoadEvent;", "onLoad$delegate", "getOnLoad$expo_image_release", "onLoad", "onDisplay$delegate", "getOnDisplay$expo_image_release", "onDisplay", "Ljava/util/List;", "getSources$expo_image_release", "()Ljava/util/List;", "setSources$expo_image_release", "(Ljava/util/List;)V", "placeholders", "getPlaceholders$expo_image_release", "setPlaceholders$expo_image_release", "blurRadius", "Ljava/lang/Integer;", "getBlurRadius$expo_image_release", "()Ljava/lang/Integer;", "setBlurRadius$expo_image_release", "(Ljava/lang/Integer;)V", "Lexpo/modules/image/records/ImageTransition;", "transition", "Lexpo/modules/image/records/ImageTransition;", "getTransition$expo_image_release", "()Lexpo/modules/image/records/ImageTransition;", "setTransition$expo_image_release", "(Lexpo/modules/image/records/ImageTransition;)V", "Lexpo/modules/image/enums/ContentFit;", "contentFit", "Lexpo/modules/image/enums/ContentFit;", "getContentFit$expo_image_release", "()Lexpo/modules/image/enums/ContentFit;", "setContentFit$expo_image_release", "(Lexpo/modules/image/enums/ContentFit;)V", "placeholderContentFit", "getPlaceholderContentFit$expo_image_release", "setPlaceholderContentFit$expo_image_release", "Lexpo/modules/image/records/ContentPosition;", "contentPosition", "Lexpo/modules/image/records/ContentPosition;", "getContentPosition$expo_image_release", "()Lexpo/modules/image/records/ContentPosition;", "setContentPosition$expo_image_release", "(Lexpo/modules/image/records/ContentPosition;)V", "tintColor", "getTintColor$expo_image_release", "setTintColor$expo_image_release", "isFocusableProp", "Z", "isFocusableProp$expo_image_release", "()Z", "setFocusableProp$expo_image_release", "accessible", "getAccessible$expo_image_release", "setAccessible$expo_image_release", "", "accessibilityLabel", "Ljava/lang/String;", "getAccessibilityLabel$expo_image_release", "()Ljava/lang/String;", "setAccessibilityLabel$expo_image_release", "(Ljava/lang/String;)V", "recyclingKey", "getRecyclingKey", "setRecyclingKey", "allowDownscaling", "getAllowDownscaling$expo_image_release", "setAllowDownscaling$expo_image_release", "Lexpo/modules/image/records/DecodeFormat;", "decodeFormat", "Lexpo/modules/image/records/DecodeFormat;", "getDecodeFormat$expo_image_release", "()Lexpo/modules/image/records/DecodeFormat;", "setDecodeFormat$expo_image_release", "(Lexpo/modules/image/records/DecodeFormat;)V", "autoplay", "getAutoplay$expo_image_release", "setAutoplay$expo_image_release", "lockResource", "getLockResource$expo_image_release", "setLockResource$expo_image_release", "Lexpo/modules/image/enums/Priority;", "priority", "Lexpo/modules/image/enums/Priority;", "getPriority$expo_image_release", "()Lexpo/modules/image/enums/Priority;", "setPriority$expo_image_release", "(Lexpo/modules/image/enums/Priority;)V", "Lexpo/modules/image/records/CachePolicy;", "cachePolicy", "Lexpo/modules/image/records/CachePolicy;", "getCachePolicy$expo_image_release", "()Lexpo/modules/image/records/CachePolicy;", "setCachePolicy$expo_image_release", "(Lexpo/modules/image/records/CachePolicy;)V", "shouldRerender", "getShouldRerender$expo_image_release", "setShouldRerender$expo_image_release", "loadedSource", "Lexpo/modules/image/GlideModelProvider;", "loadedPlaceholder", "transformationMatrixChanged", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "getActiveView", "()Lexpo/modules/image/ExpoImageView;", "activeView", "()Lexpo/modules/image/records/Source;", "bestSource", "getBestPlaceholder", "bestPlaceholder", "Companion", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
public final class ExpoImageViewWrapper extends ExpoView {
    private static RequestManager requestManager;
    private String accessibilityLabel;
    private boolean accessible;
    private boolean allowDownscaling;
    private boolean autoplay;
    private Integer blurRadius;
    private CachePolicy cachePolicy;
    private boolean clearViewBeforeChangingSource;
    private ContentFit contentFit;
    private ContentPosition contentPosition;
    private DecodeFormat decodeFormat;
    private ImageViewWrapperTarget firstTarget;
    private final ExpoImageView firstView;
    private boolean isFocusableProp;
    private GlideModelProvider loadedPlaceholder;
    private GlideModelProvider loadedSource;
    private boolean lockResource;
    private final Handler mainHandler;

    /* JADX INFO: renamed from: onDisplay$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onDisplay;

    /* JADX INFO: renamed from: onError$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onError;

    /* JADX INFO: renamed from: onLoad$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onLoad;

    /* JADX INFO: renamed from: onLoadStart$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onLoadStart;

    /* JADX INFO: renamed from: onProgress$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onProgress;
    private ContentFit placeholderContentFit;
    private List<? extends Source> placeholders;
    private Priority priority;
    private final OkHttpProgressListener progressListener;
    private String recyclingKey;

    /* JADX INFO: renamed from: requestManager$1, reason: from kotlin metadata */
    private final RequestManager requestManager;
    private ImageViewWrapperTarget secondTarget;
    private final ExpoImageView secondView;
    private boolean shouldRerender;
    private List<? extends Source> sources;
    private Integer tintColor;
    private boolean transformationMatrixChanged;
    private ImageTransition transition;
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ExpoImageViewWrapper.class, "onLoadStart", "getOnLoadStart$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoImageViewWrapper.class, "onProgress", "getOnProgress$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoImageViewWrapper.class, "onError", "getOnError$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoImageViewWrapper.class, "onLoad", "getOnLoad$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ExpoImageViewWrapper.class, "onDisplay", "getOnDisplay$expo_image_release()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference<AppContext> appContextRef = new WeakReference<>(null);
    private static WeakReference<Activity> activityRef = new WeakReference<>(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoImageViewWrapper(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.requestManager = INSTANCE.getOrCreateRequestManager(appContext, getActivity());
        this.progressListener = new OkHttpProgressListener(new WeakReference(this));
        ExpoImageView expoImageView = new ExpoImageView(getActivity());
        this.firstView = expoImageView;
        ExpoImageView expoImageView2 = new ExpoImageView(getActivity());
        this.secondView = expoImageView2;
        this.mainHandler = new Handler(context.getMainLooper());
        this.firstTarget = new ImageViewWrapperTarget(new WeakReference(this));
        this.secondTarget = new ImageViewWrapperTarget(new WeakReference(this));
        this.onLoadStart = new ViewEventDelegate(this, null);
        this.onProgress = new ViewEventDelegate(this, null);
        this.onError = new ViewEventDelegate(this, null);
        this.onLoad = new ViewEventDelegate(this, null);
        this.onDisplay = new ViewEventDelegate(this, null);
        this.sources = CollectionsKt.emptyList();
        this.placeholders = CollectionsKt.emptyList();
        this.contentFit = ContentFit.Cover;
        this.placeholderContentFit = ContentFit.ScaleDown;
        this.contentPosition = ContentPosition.INSTANCE.getCenter();
        this.allowDownscaling = true;
        this.decodeFormat = DecodeFormat.ARGB_8888;
        this.autoplay = true;
        this.priority = Priority.NORMAL;
        this.cachePolicy = CachePolicy.DISK;
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setLayoutParams(layoutParams);
        expoImageView.setVisibility(0);
        expoImageView2.setVisibility(0);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.addView(expoImageView, layoutParams);
        frameLayout.addView(expoImageView2, layoutParams);
        addView(frameLayout, layoutParams);
    }

    private final Activity getActivity() {
        return getAppContext().getThrowingActivity();
    }

    /* JADX INFO: renamed from: getRequestManager$expo_image_release, reason: from getter */
    public final RequestManager getRequestManager() {
        return this.requestManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExpoImageView getActiveView() {
        if (this.secondView.getDrawable() != null) {
            return this.secondView;
        }
        return this.firstView;
    }

    public final ViewEventCallback getOnLoadStart$expo_image_release() {
        return this.onLoadStart.getValue(this, $$delegatedProperties[0]);
    }

    public final ViewEventCallback getOnProgress$expo_image_release() {
        return this.onProgress.getValue(this, $$delegatedProperties[1]);
    }

    public final ViewEventCallback getOnError$expo_image_release() {
        return this.onError.getValue(this, $$delegatedProperties[2]);
    }

    public final ViewEventCallback getOnLoad$expo_image_release() {
        return this.onLoad.getValue(this, $$delegatedProperties[3]);
    }

    public final ViewEventCallback getOnDisplay$expo_image_release() {
        return this.onDisplay.getValue(this, $$delegatedProperties[4]);
    }

    public final List<Source> getSources$expo_image_release() {
        return this.sources;
    }

    public final void setSources$expo_image_release(List<? extends Source> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sources = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Source getBestSource() {
        return getBestSource(this.sources);
    }

    public final List<Source> getPlaceholders$expo_image_release() {
        return this.placeholders;
    }

    public final void setPlaceholders$expo_image_release(List<? extends Source> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.placeholders = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Source getBestPlaceholder() {
        return getBestSource(this.placeholders);
    }

    /* JADX INFO: renamed from: getBlurRadius$expo_image_release, reason: from getter */
    public final Integer getBlurRadius() {
        return this.blurRadius;
    }

    public final void setBlurRadius$expo_image_release(Integer num) {
        if (!Intrinsics.areEqual(this.blurRadius, num)) {
            this.shouldRerender = true;
        }
        this.blurRadius = num;
    }

    /* JADX INFO: renamed from: getTransition$expo_image_release, reason: from getter */
    public final ImageTransition getTransition() {
        return this.transition;
    }

    public final void setTransition$expo_image_release(ImageTransition imageTransition) {
        this.transition = imageTransition;
    }

    /* JADX INFO: renamed from: getContentFit$expo_image_release, reason: from getter */
    public final ContentFit getContentFit() {
        return this.contentFit;
    }

    public final void setContentFit$expo_image_release(ContentFit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.contentFit = value;
        getActiveView().setContentFit$expo_image_release(value);
        this.transformationMatrixChanged = true;
    }

    /* JADX INFO: renamed from: getPlaceholderContentFit$expo_image_release, reason: from getter */
    public final ContentFit getPlaceholderContentFit() {
        return this.placeholderContentFit;
    }

    public final void setPlaceholderContentFit$expo_image_release(ContentFit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.placeholderContentFit = value;
        getActiveView().setPlaceholderContentFit$expo_image_release(value);
        this.transformationMatrixChanged = true;
    }

    /* JADX INFO: renamed from: getContentPosition$expo_image_release, reason: from getter */
    public final ContentPosition getContentPosition() {
        return this.contentPosition;
    }

    public final void setContentPosition$expo_image_release(ContentPosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.contentPosition = value;
        getActiveView().setContentPosition$expo_image_release(value);
        this.transformationMatrixChanged = true;
    }

    /* JADX INFO: renamed from: getTintColor$expo_image_release, reason: from getter */
    public final Integer getTintColor() {
        return this.tintColor;
    }

    public final void setTintColor$expo_image_release(Integer num) {
        this.tintColor = num;
        if (getActiveView().getDrawable() instanceof SVGPictureDrawable) {
            this.shouldRerender = true;
        } else {
            getActiveView().setTintColor$expo_image_release(num);
        }
    }

    public final void setFocusableProp$expo_image_release(boolean z) {
        this.isFocusableProp = z;
        getActiveView().setFocusable(z);
    }

    /* JADX INFO: renamed from: getAccessible$expo_image_release, reason: from getter */
    public final boolean getAccessible() {
        return this.accessible;
    }

    public final void setAccessible$expo_image_release(boolean z) {
        this.accessible = z;
        setIsScreenReaderFocusable(getActiveView(), z);
    }

    /* JADX INFO: renamed from: getAccessibilityLabel$expo_image_release, reason: from getter */
    public final String getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    public final void setAccessibilityLabel$expo_image_release(String str) {
        this.accessibilityLabel = str;
        getActiveView().setContentDescription(this.accessibilityLabel);
    }

    public final String getRecyclingKey() {
        return this.recyclingKey;
    }

    public final void setRecyclingKey(String str) {
        String str2 = this.recyclingKey;
        this.clearViewBeforeChangingSource = (str2 == null || str == null || Intrinsics.areEqual(str, str2)) ? false : true;
        this.recyclingKey = str;
    }

    /* JADX INFO: renamed from: getAllowDownscaling$expo_image_release, reason: from getter */
    public final boolean getAllowDownscaling() {
        return this.allowDownscaling;
    }

    public final void setAllowDownscaling$expo_image_release(boolean z) {
        this.allowDownscaling = z;
        this.shouldRerender = true;
    }

    /* JADX INFO: renamed from: getDecodeFormat$expo_image_release, reason: from getter */
    public final DecodeFormat getDecodeFormat() {
        return this.decodeFormat;
    }

    public final void setDecodeFormat$expo_image_release(DecodeFormat value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.decodeFormat = value;
        this.shouldRerender = true;
    }

    /* JADX INFO: renamed from: getAutoplay$expo_image_release, reason: from getter */
    public final boolean getAutoplay() {
        return this.autoplay;
    }

    public final void setAutoplay$expo_image_release(boolean z) {
        this.autoplay = z;
    }

    /* JADX INFO: renamed from: getLockResource$expo_image_release, reason: from getter */
    public final boolean getLockResource() {
        return this.lockResource;
    }

    public final void setLockResource$expo_image_release(boolean z) {
        this.lockResource = z;
    }

    /* JADX INFO: renamed from: getPriority$expo_image_release, reason: from getter */
    public final Priority getPriority() {
        return this.priority;
    }

    public final void setPriority$expo_image_release(Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "<set-?>");
        this.priority = priority;
    }

    /* JADX INFO: renamed from: getCachePolicy$expo_image_release, reason: from getter */
    public final CachePolicy getCachePolicy() {
        return this.cachePolicy;
    }

    public final void setCachePolicy$expo_image_release(CachePolicy cachePolicy) {
        Intrinsics.checkNotNullParameter(cachePolicy, "<set-?>");
        this.cachePolicy = cachePolicy;
    }

    public final void setIsAnimating(boolean setAnimating) {
        Object drawable = getActiveView().getDrawable();
        if (drawable instanceof GifDrawable) {
            setIsAnimating((GifDrawable) drawable, setAnimating);
        } else if (drawable instanceof Animatable) {
            setIsAnimating((Animatable) drawable, setAnimating);
        }
    }

    private final void setIsAnimating(GifDrawable resource, boolean setAnimating) {
        if (setAnimating) {
            if (resource.isPaused()) {
                resource.resume();
                return;
            } else {
                resource.start();
                return;
            }
        }
        resource.pause();
    }

    private final void setIsAnimating(Animatable resource, boolean setAnimating) {
        if (setAnimating) {
            resource.start();
        } else {
            resource.stop();
        }
    }

    /* JADX INFO: renamed from: getShouldRerender$expo_image_release, reason: from getter */
    public final boolean getShouldRerender() {
        return this.shouldRerender;
    }

    public final void setShouldRerender$expo_image_release(boolean z) {
        this.shouldRerender = z;
    }

    private final void copyProps(ExpoImageView view) {
        view.setContentFit$expo_image_release(this.contentFit);
        view.setContentPosition$expo_image_release(this.contentPosition);
        view.setTintColor$expo_image_release(this.tintColor);
        view.setFocusable(this.isFocusableProp);
        view.setContentDescription(this.accessibilityLabel);
        setIsScreenReaderFocusable(view, this.accessible);
    }

    private final void setIsScreenReaderFocusable(View view, final boolean value) {
        if (Build.VERSION.SDK_INT >= 28) {
            view.setScreenReaderFocusable(value);
        } else {
            ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: expo.modules.image.ExpoImageViewWrapper.setIsScreenReaderFocusable.1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                    Intrinsics.checkNotNullParameter(host, "host");
                    Intrinsics.checkNotNullParameter(info, "info");
                    info.setScreenReaderFocusable(value);
                    super.onInitializeAccessibilityNodeInfo(host, info);
                }
            });
        }
    }

    public final boolean onResourceReady(final ImageViewWrapperTarget target, final Drawable resource, final boolean isPlaceholder) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(resource, "resource");
        return this.mainHandler.postAtFrontOfQueue(new Runnable() { // from class: expo.modules.image.ExpoImageViewWrapper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExpoImageViewWrapper.onResourceReady$lambda$5(this.f$0, isPlaceholder, target, resource);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onResourceReady$lambda$5(final ExpoImageViewWrapper expoImageViewWrapper, boolean z, final ImageViewWrapperTarget imageViewWrapperTarget, Drawable drawable) {
        androidx.tracing.Trace.beginSection("[" + Trace.INSTANCE.getTag() + "] onResourceReady");
        try {
            ImageTransition transition = expoImageViewWrapper.getTransition();
            long duration = transition != null ? transition.getDuration() : 0;
            if (!z || !imageViewWrapperTarget.getHasSource()) {
                Pair pair = expoImageViewWrapper.firstView.getDrawable() == null ? TuplesKt.to(expoImageViewWrapper.firstView, expoImageViewWrapper.secondView) : TuplesKt.to(expoImageViewWrapper.secondView, expoImageViewWrapper.firstView);
                ExpoImageView expoImageView = (ExpoImageView) pair.getFirst();
                final ExpoImageView expoImageView2 = (ExpoImageView) pair.getSecond();
                final Function0 function0 = new Function0() { // from class: expo.modules.image.ExpoImageViewWrapper$onResourceReady$1$1$clearPreviousView$1
                    @Override // kotlin.jvm.functions.Function0
                    public final ImageViewWrapperTarget invoke() {
                        ImageViewWrapperTarget imageViewWrapperTargetRecycleView = expoImageView2.recycleView();
                        if (imageViewWrapperTargetRecycleView == null) {
                            return null;
                        }
                        ImageViewWrapperTarget imageViewWrapperTarget2 = imageViewWrapperTarget;
                        ExpoImageViewWrapper expoImageViewWrapper2 = expoImageViewWrapper;
                        if (!Intrinsics.areEqual(imageViewWrapperTargetRecycleView, imageViewWrapperTarget2)) {
                            imageViewWrapperTargetRecycleView.clear(expoImageViewWrapper2.getRequestManager());
                        }
                        return imageViewWrapperTargetRecycleView;
                    }
                };
                expoImageViewWrapper.configureView(expoImageView, imageViewWrapperTarget, drawable, z);
                if (imageViewWrapperTarget.getHasSource()) {
                    expoImageViewWrapper.getOnDisplay$expo_image_release().invoke(Unit.INSTANCE);
                }
                if (duration <= 0) {
                    function0.invoke();
                    expoImageView.setAlpha(1.0f);
                    expoImageView.bringToFront();
                } else {
                    expoImageView.bringToFront();
                    expoImageView2.setAlpha(1.0f);
                    expoImageView.setAlpha(0.0f);
                    ViewPropertyAnimator viewPropertyAnimatorAnimate = expoImageView2.animate();
                    viewPropertyAnimatorAnimate.setDuration(duration);
                    viewPropertyAnimatorAnimate.alpha(0.0f);
                    viewPropertyAnimatorAnimate.withEndAction(new Runnable() { // from class: expo.modules.image.ExpoImageViewWrapper$onResourceReady$1$1$1$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            function0.invoke();
                        }
                    });
                    ViewPropertyAnimator viewPropertyAnimatorAnimate2 = expoImageView.animate();
                    viewPropertyAnimatorAnimate2.setDuration(duration);
                    viewPropertyAnimatorAnimate2.alpha(1.0f);
                }
            } else {
                if ((expoImageViewWrapper.firstView.getDrawable() == null || expoImageViewWrapper.firstView.isPlaceholder()) && expoImageViewWrapper.secondView.getDrawable() == null) {
                    ImageViewWrapperTarget imageViewWrapperTargetRecycleView = expoImageViewWrapper.firstView.recycleView();
                    if (imageViewWrapperTargetRecycleView != null && !Intrinsics.areEqual(imageViewWrapperTargetRecycleView, imageViewWrapperTarget)) {
                        imageViewWrapperTargetRecycleView.clear(expoImageViewWrapper.getRequestManager());
                    }
                    expoImageViewWrapper.configureView(expoImageViewWrapper.firstView, imageViewWrapperTarget, drawable, z);
                    if (duration > 0) {
                        expoImageViewWrapper.firstView.bringToFront();
                        expoImageViewWrapper.firstView.setAlpha(0.0f);
                        expoImageViewWrapper.secondView.setVisibility(8);
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = expoImageViewWrapper.firstView.animate();
                        viewPropertyAnimatorAnimate3.setDuration(duration);
                        viewPropertyAnimatorAnimate3.alpha(1.0f);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            if ((drawable instanceof Animatable) && !z && !expoImageViewWrapper.getAutoplay()) {
                ((Animatable) drawable).stop();
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            androidx.tracing.Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void configureView(ExpoImageView view, ImageViewWrapperTarget target, Drawable resource, boolean isPlaceholder) {
        view.setImageDrawable(resource);
        view.setPlaceholder(isPlaceholder);
        ContentFit placeholderContentFit = target.getPlaceholderContentFit();
        if (placeholderContentFit == null) {
            placeholderContentFit = ContentFit.ScaleDown;
        }
        view.setPlaceholderContentFit$expo_image_release(placeholderContentFit);
        copyProps(view);
        view.setVisibility(0);
        view.setCurrentTarget(target);
        view.layout(0, 0, getWidth(), getHeight());
        view.applyTransformationMatrix();
        target.setUsed(true);
        if (resource instanceof Animatable) {
            ((Animatable) resource).start();
        }
    }

    private final Source getBestSource(List<? extends Source> sources) {
        Source source = null;
        if (sources.isEmpty()) {
            return null;
        }
        if (sources.size() == 1) {
            return (Source) CollectionsKt.first((List) sources);
        }
        int width = getWidth() * getHeight();
        if (width == 0) {
            return null;
        }
        double d = Double.MAX_VALUE;
        for (Source source2 : sources) {
            double dAbs = Math.abs(((double) 1) - (source2.getPixelCount() / ((double) width)));
            if (dAbs < d) {
                source = source2;
                d = dAbs;
            }
        }
        return source;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        ContentFit contentFit;
        super.onSizeChanged(w, h, oldw, oldh);
        rerenderIfNeeded$expo_image_release$default(this, (!this.allowDownscaling || (contentFit = this.contentFit) == ContentFit.Fill || contentFit == ContentFit.None) ? false : true, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestOptions createPropOptions() {
        BaseRequestOptions baseRequestOptionsPriority = new RequestOptions().priority(this.priority.toGlidePriority$expo_image_release());
        Intrinsics.checkNotNullExpressionValue(baseRequestOptionsPriority, "priority(...)");
        RequestOptions requestOptions = (RequestOptions) baseRequestOptionsPriority;
        CachePolicy cachePolicy = this.cachePolicy;
        if ((cachePolicy == CachePolicy.MEMORY_AND_DISK || cachePolicy == CachePolicy.MEMORY) ? false : true) {
            BaseRequestOptions baseRequestOptionsSkipMemoryCache = requestOptions.skipMemoryCache(true);
            Intrinsics.checkNotNullExpressionValue(baseRequestOptionsSkipMemoryCache, "skipMemoryCache(...)");
            requestOptions = (RequestOptions) baseRequestOptionsSkipMemoryCache;
        }
        CachePolicy cachePolicy2 = this.cachePolicy;
        if (cachePolicy2 == CachePolicy.NONE || cachePolicy2 == CachePolicy.MEMORY) {
            BaseRequestOptions baseRequestOptionsDiskCacheStrategy = requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
            Intrinsics.checkNotNullExpressionValue(baseRequestOptionsDiskCacheStrategy, "diskCacheStrategy(...)");
            requestOptions = (RequestOptions) baseRequestOptionsDiskCacheStrategy;
        }
        Integer num = this.blurRadius;
        if (num == null) {
            return requestOptions;
        }
        BaseRequestOptions baseRequestOptionsTransform = requestOptions.transform(new BlurTransformation(Math.min(num.intValue(), 25), 4));
        Intrinsics.checkNotNullExpressionValue(baseRequestOptionsTransform, "transform(...)");
        return (RequestOptions) baseRequestOptionsTransform;
    }

    public final void onViewDestroys() {
        this.firstView.setImageDrawable(null);
        this.secondView.setImageDrawable(null);
        this.requestManager.clear(this.firstTarget);
        this.requestManager.clear(this.secondTarget);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean cleanIfNeeded(Source newBestSource, GlideModelProvider newBestSourceModel, GlideModelProvider newBestPlaceholderModel) {
        if (getWidth() != 0 && getHeight() != 0 && ((newBestSource != null && newBestSourceModel != null) || newBestPlaceholderModel != null)) {
            return false;
        }
        this.firstView.recycleView();
        this.secondView.recycleView();
        this.requestManager.clear(this.firstTarget);
        this.requestManager.clear(this.secondTarget);
        this.shouldRerender = false;
        this.loadedSource = null;
        this.loadedPlaceholder = null;
        this.transformationMatrixChanged = false;
        this.clearViewBeforeChangingSource = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DownsampleStrategy createDownsampleStrategy(ImageViewWrapperTarget target) {
        if (!this.allowDownscaling) {
            DownsampleStrategy downsampleStrategy = DownsampleStrategy.NONE;
            Intrinsics.checkNotNull(downsampleStrategy);
            return downsampleStrategy;
        }
        ContentFit contentFit = this.contentFit;
        if (contentFit != ContentFit.Fill && contentFit != ContentFit.None) {
            return new ContentFitDownsampleStrategy(target, this.contentFit);
        }
        return new SafeDownsampleStrategy(this.decodeFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearViewBeforeChangingSource() {
        ExpoImageView expoImageView;
        if (this.clearViewBeforeChangingSource) {
            if (this.firstView.getDrawable() != null) {
                expoImageView = this.firstView;
            } else {
                expoImageView = this.secondView;
            }
            ImageViewWrapperTarget imageViewWrapperTargetRecycleView = expoImageView.recycleView();
            if (imageViewWrapperTargetRecycleView != null) {
                imageViewWrapperTargetRecycleView.clear(this.requestManager);
            }
        }
    }

    public static /* synthetic */ void rerenderIfNeeded$expo_image_release$default(ExpoImageViewWrapper expoImageViewWrapper, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        expoImageViewWrapper.rerenderIfNeeded$expo_image_release(z, z2);
    }

    public final void rerenderIfNeeded$expo_image_release(boolean shouldRerenderBecauseOfResize, boolean force) {
        GlideModelProvider glideModelProviderCreateGlideModelProvider;
        GlideModelProvider glideModelProviderCreateGlideModelProvider2;
        RequestOptions requestOptionsCreateGlideOptions;
        ContentFit placeholderContentFit;
        Trace trace = Trace.INSTANCE;
        androidx.tracing.Trace.beginSection("[" + trace.getTag() + "] " + ("rerenderIfNeeded(shouldRerenderBecauseOfResize=" + shouldRerenderBecauseOfResize + ",force=" + force + ")"));
        try {
            if (!getLockResource() || force) {
                Source bestSource = getBestSource();
                Source bestPlaceholder = getBestPlaceholder();
                if (bestSource != null) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    glideModelProviderCreateGlideModelProvider = bestSource.createGlideModelProvider(context);
                } else {
                    glideModelProviderCreateGlideModelProvider = null;
                }
                if (bestPlaceholder != null) {
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    glideModelProviderCreateGlideModelProvider2 = bestPlaceholder.createGlideModelProvider(context2);
                } else {
                    glideModelProviderCreateGlideModelProvider2 = null;
                }
                if (!cleanIfNeeded(bestSource, glideModelProviderCreateGlideModelProvider, glideModelProviderCreateGlideModelProvider2)) {
                    if (!Intrinsics.areEqual(glideModelProviderCreateGlideModelProvider, this.loadedSource) || !Intrinsics.areEqual(glideModelProviderCreateGlideModelProvider2, this.loadedPlaceholder) || getShouldRerender() || ((glideModelProviderCreateGlideModelProvider == null && glideModelProviderCreateGlideModelProvider2 != null) || shouldRerenderBecauseOfResize)) {
                        clearViewBeforeChangingSource();
                        setShouldRerender$expo_image_release(false);
                        this.loadedSource = glideModelProviderCreateGlideModelProvider;
                        this.loadedPlaceholder = glideModelProviderCreateGlideModelProvider2;
                        if (bestSource != null) {
                            Context context3 = getContext();
                            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                            requestOptionsCreateGlideOptions = bestSource.createGlideOptions(context3);
                        } else {
                            requestOptionsCreateGlideOptions = null;
                        }
                        RequestOptions requestOptionsCreatePropOptions = createPropOptions();
                        Object glideModel = glideModelProviderCreateGlideModelProvider != null ? glideModelProviderCreateGlideModelProvider.getGlideModel() : null;
                        if (glideModel instanceof GlideUrlWrapper) {
                            ((GlideUrlWrapper) glideModel).setProgressListener(this.progressListener);
                        }
                        getOnLoadStart$expo_image_release().invoke(Unit.INSTANCE);
                        ImageViewWrapperTarget imageViewWrapperTarget = this.secondTarget.isUsed() ? this.firstTarget : this.secondTarget;
                        imageViewWrapperTarget.setHasSource(glideModelProviderCreateGlideModelProvider != null);
                        DownsampleStrategy downsampleStrategyCreateDownsampleStrategy = createDownsampleStrategy(imageViewWrapperTarget);
                        RequestBuilder requestBuilderLoad = getRequestManager().asDrawable().load(glideModel);
                        Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "load(...)");
                        if (bestPlaceholder != null && glideModelProviderCreateGlideModelProvider2 != null) {
                            if (!bestPlaceholder.usesPlaceholderContentFit()) {
                                placeholderContentFit = getContentFit();
                            } else {
                                placeholderContentFit = getPlaceholderContentFit();
                            }
                            imageViewWrapperTarget.setPlaceholderContentFit(placeholderContentFit);
                            RequestBuilder requestBuilder = (RequestBuilder) getRequestManager().load(glideModelProviderCreateGlideModelProvider2.getGlideModel()).downsample(new PlaceholderDownsampleStrategy(imageViewWrapperTarget));
                            Context context4 = getContext();
                            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                            requestBuilderLoad = requestBuilderLoad.thumbnail(requestBuilder.apply((BaseRequestOptions) bestPlaceholder.createGlideOptions(context4)));
                            Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "thumbnail(...)");
                        }
                        RequestBuilder requestBuilderApply = ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) requestBuilderLoad.downsample(downsampleStrategyCreateDownsampleStrategy)).addListener(new GlideRequestListener(new WeakReference(this))).encodeQuality(100)).format(getDecodeFormat().toGlideFormat())).apply((BaseRequestOptions) requestOptionsCreatePropOptions);
                        Intrinsics.checkNotNullExpressionValue(requestBuilderApply, "apply(...)");
                        RequestBuilder requestBuilderApply2 = GlideExtensionsKt.apply(requestBuilderApply, requestOptionsCreateGlideOptions);
                        Integer tintColor = getTintColor();
                        if (tintColor != null) {
                            requestBuilderApply2 = requestBuilderApply2.apply(new RequestOptions().set(CustomOptions.INSTANCE.getTintColor(), Integer.valueOf(tintColor.intValue())));
                            Intrinsics.checkNotNullExpressionValue(requestBuilderApply2, "apply(...)");
                        }
                        int nextCookieValue = trace.getNextCookieValue();
                        androidx.tracing.Trace.beginAsyncSection("[" + trace.getTag() + "] " + trace.getLoadNewImageBlock(), nextCookieValue);
                        imageViewWrapperTarget.setCookie(nextCookieValue);
                        requestBuilderApply2.into(imageViewWrapperTarget);
                        this.transformationMatrixChanged = false;
                        this.clearViewBeforeChangingSource = false;
                    } else {
                        if (this.transformationMatrixChanged) {
                            getActiveView().applyTransformationMatrix();
                        }
                        this.transformationMatrixChanged = false;
                        this.clearViewBeforeChangingSource = false;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            androidx.tracing.Trace.endSection();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RequestManager getOrCreateRequestManager(AppContext appContext, Activity activity) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Intrinsics.checkNotNullParameter(activity, "activity");
            Companion companion = ExpoImageViewWrapper.INSTANCE;
            synchronized (companion) {
                RequestManager requestManager = ExpoImageViewWrapper.requestManager;
                if (requestManager != null) {
                    if (Intrinsics.areEqual(ExpoImageViewWrapper.appContextRef.get(), appContext) && Intrinsics.areEqual(ExpoImageViewWrapper.activityRef.get(), activity)) {
                        return requestManager;
                    }
                    RequestManager requestManagerCreateNewRequestManager = companion.createNewRequestManager(activity);
                    ExpoImageViewWrapper.requestManager = requestManagerCreateNewRequestManager;
                    ExpoImageViewWrapper.appContextRef = new WeakReference(appContext);
                    ExpoImageViewWrapper.activityRef = new WeakReference(activity);
                    return requestManagerCreateNewRequestManager;
                }
                RequestManager requestManagerCreateNewRequestManager2 = companion.createNewRequestManager(activity);
                ExpoImageViewWrapper.requestManager = requestManagerCreateNewRequestManager2;
                ExpoImageViewWrapper.appContextRef = new WeakReference(appContext);
                ExpoImageViewWrapper.activityRef = new WeakReference(activity);
                return requestManagerCreateNewRequestManager2;
            }
        }

        private final RequestManager createNewRequestManager(Activity activity) {
            RequestManager requestManagerWith = Glide.with(activity);
            Intrinsics.checkNotNullExpressionValue(requestManagerWith, "with(...)");
            return requestManagerWith;
        }
    }
}
