package kotlin.reflect.jvm.internal.impl.utils;

import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DFS {

    public static abstract class AbstractNodeHandler implements NodeHandler {
        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public void afterChildren(Object obj) {
        }
    }

    public interface Neighbors {
        Iterable getNeighbors(Object obj);
    }

    public interface NodeHandler {
        void afterChildren(Object obj);

        boolean beforeChildren(Object obj);

        Object result();
    }

    public interface Visited {
        boolean checkAndMarkVisited(Object obj);
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case BaseVideoCapturer.RGBA /* 11 */:
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
            case 16:
            case 19:
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case BaseVideoCapturer.RGBA /* 11 */:
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
            case 13:
            case 14:
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static Object dfs(Collection collection, Neighbors neighbors, Visited visited, NodeHandler nodeHandler) {
        if (collection == null) {
            $$$reportNull$$$0(0);
        }
        if (neighbors == null) {
            $$$reportNull$$$0(1);
        }
        if (visited == null) {
            $$$reportNull$$$0(2);
        }
        if (nodeHandler == null) {
            $$$reportNull$$$0(3);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            doDfs(it.next(), neighbors, visited, nodeHandler);
        }
        return nodeHandler.result();
    }

    public static Object dfs(Collection collection, Neighbors neighbors, NodeHandler nodeHandler) {
        if (collection == null) {
            $$$reportNull$$$0(4);
        }
        if (neighbors == null) {
            $$$reportNull$$$0(5);
        }
        if (nodeHandler == null) {
            $$$reportNull$$$0(6);
        }
        return dfs(collection, neighbors, new VisitedWithSet(), nodeHandler);
    }

    public static Boolean ifAny(Collection collection, Neighbors neighbors, final Function1 function1) {
        if (collection == null) {
            $$$reportNull$$$0(7);
        }
        if (neighbors == null) {
            $$$reportNull$$$0(8);
        }
        if (function1 == null) {
            $$$reportNull$$$0(9);
        }
        final boolean[] zArr = new boolean[1];
        return (Boolean) dfs(collection, neighbors, new AbstractNodeHandler() { // from class: kotlin.reflect.jvm.internal.impl.utils.DFS.1
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(Object obj) {
                if (((Boolean) function1.invoke(obj)).booleanValue()) {
                    zArr[0] = true;
                }
                return !zArr[0];
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public Boolean result() {
                return Boolean.valueOf(zArr[0]);
            }
        });
    }

    public static void doDfs(Object obj, Neighbors neighbors, Visited visited, NodeHandler nodeHandler) {
        if (obj == null) {
            $$$reportNull$$$0(22);
        }
        if (neighbors == null) {
            $$$reportNull$$$0(23);
        }
        if (visited == null) {
            $$$reportNull$$$0(24);
        }
        if (nodeHandler == null) {
            $$$reportNull$$$0(25);
        }
        if (visited.checkAndMarkVisited(obj) && nodeHandler.beforeChildren(obj)) {
            Iterator it = neighbors.getNeighbors(obj).iterator();
            while (it.hasNext()) {
                doDfs(it.next(), neighbors, visited, nodeHandler);
            }
            nodeHandler.afterChildren(obj);
        }
    }

    public static class VisitedWithSet implements Visited {
        private final Set visited;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }

        public VisitedWithSet() {
            this(new HashSet());
        }

        public VisitedWithSet(Set set) {
            if (set == null) {
                $$$reportNull$$$0(0);
            }
            this.visited = set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Visited
        public boolean checkAndMarkVisited(Object obj) {
            return this.visited.add(obj);
        }
    }
}
