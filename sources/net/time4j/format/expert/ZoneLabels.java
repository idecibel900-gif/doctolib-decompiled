package net.time4j.format.expert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.time4j.tz.TZID;

/* JADX INFO: loaded from: classes5.dex */
class ZoneLabels {
    private final Node root;

    ZoneLabels(Node node) {
        this.root = node;
    }

    public String toString() {
        ArrayList<String> arrayList = new ArrayList();
        collect(this.root, new StringBuilder(), arrayList);
        StringBuilder sb = new StringBuilder();
        sb.append("count=");
        sb.append(arrayList.size());
        sb.append(",labels={");
        for (String str : arrayList) {
            sb.append(str);
            sb.append("=>");
            sb.append(find(str));
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1).append('}');
        return sb.toString();
    }

    static Node insert(Node node, String str, TZID tzid) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Empty key cannot be inserted.");
        }
        if (tzid == null) {
            throw new NullPointerException("Missing timezone id.");
        }
        return insert(node, str, tzid, 0);
    }

    String longestPrefixOf(CharSequence charSequence, int i) {
        Node node = this.root;
        int length = charSequence.length();
        int i2 = i;
        int i3 = i2;
        while (node != null && i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < node.c) {
                node = node.left;
            } else if (cCharAt > node.c) {
                node = node.right;
            } else {
                i2++;
                if (node.zoneIDs != null) {
                    i3 = i2;
                }
                node = node.mid;
            }
        }
        return i >= i3 ? "" : charSequence.subSequence(i, i3).toString();
    }

    List find(String str) {
        if (str.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        Node nodeFind = find(this.root, str, 0);
        if (nodeFind == null) {
            return Collections.EMPTY_LIST;
        }
        return Collections.unmodifiableList(nodeFind.zoneIDs);
    }

    private static Node find(Node node, String str, int i) {
        if (node == null) {
            return null;
        }
        char cCharAt = str.charAt(i);
        if (cCharAt < node.c) {
            return find(node.left, str, i);
        }
        if (cCharAt > node.c) {
            return find(node.right, str, i);
        }
        return i < str.length() + (-1) ? find(node.mid, str, i + 1) : node;
    }

    private static Node insert(Node node, String str, TZID tzid, int i) {
        char cCharAt = str.charAt(i);
        if (node == null) {
            node = new Node(cCharAt);
        }
        if (cCharAt < node.c) {
            return node.withLeft(insert(node.left, str, tzid, i));
        }
        if (cCharAt > node.c) {
            return node.withRight(insert(node.right, str, tzid, i));
        }
        return i < str.length() + (-1) ? node.withMid(insert(node.mid, str, tzid, i + 1)) : node.with(tzid);
    }

    private void collect(Node node, StringBuilder sb, List list) {
        if (node == null) {
            return;
        }
        collect(node.left, sb, list);
        if (node.zoneIDs != null) {
            list.add(sb.toString() + node.c);
        }
        Node node2 = node.mid;
        sb.append(node.c);
        collect(node2, sb, list);
        sb.deleteCharAt(sb.length() - 1);
        collect(node.right, sb, list);
    }

    static class Node {
        private final char c;
        private final Node left;
        private final Node mid;
        private final Node right;
        private final List zoneIDs;

        private Node(char c) {
            this(c, null, null, null, null);
        }

        private Node(char c, Node node, Node node2, Node node3, List list) {
            this.c = c;
            this.left = node;
            this.mid = node2;
            this.right = node3;
            this.zoneIDs = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node withLeft(Node node) {
            return new Node(this.c, node, this.mid, this.right, this.zoneIDs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node withMid(Node node) {
            return new Node(this.c, this.left, node, this.right, this.zoneIDs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node withRight(Node node) {
            return new Node(this.c, this.left, this.mid, node, this.zoneIDs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node with(TZID tzid) {
            ArrayList arrayList = new ArrayList();
            List list = this.zoneIDs;
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(tzid);
            return new Node(this.c, this.left, this.mid, this.right, arrayList);
        }
    }
}
