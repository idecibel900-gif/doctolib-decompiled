package com.revenuecat.purchases.models;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.SharedConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u0017J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0003J\u0017\u0010\u001b\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0096\u0001J\u0013\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\u0018\u0010!\u001a\u0004\u0018\u00010\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002J\u0018\u0010#\u001a\u0004\u0018\u00010\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002J\u0011\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\u0096\u0003J\b\u0010&\u001a\u00020\u0011H\u0016J\u0011\u0010'\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0001J\t\u0010(\u001a\u00020\u0019H\u0096\u0001J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020*H\u0096\u0003J\u0011\u0010+\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0001J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020-H\u0096\u0001J\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020-2\u0006\u0010%\u001a\u00020\u0011H\u0096\u0001J\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0096\u0001J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u00102\u001a\u000203R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028F¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0007R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0012\u0010\u0010\u001a\u00020\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/revenuecat/purchases/models/SubscriptionOptions;", "", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "subscriptionOptions", "(Ljava/util/List;)V", "basePlan", "getBasePlan", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "defaultOffer", "getDefaultOffer$annotations", "()V", "getDefaultOffer", "freeTrial", "getFreeTrial", "introOffer", "getIntroOffer", "size", "", "getSize", "()I", "billingPeriodToDays", "period", "Lcom/revenuecat/purchases/models/Period;", "billingPeriodToDays$purchases_defaultsBc8Release", "contains", "", "element", "containsAll", "elements", "", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "findLongestFreeTrial", "offers", "findLowestNonFreeOffer", b.au, "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "withTag", "tag", "", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionOptions implements List<SubscriptionOption>, KMappedMarker {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String RC_IGNORE_OFFER_TAG = "rc-ignore-offer";
    private final List<SubscriptionOption> subscriptionOptions;

    public static /* synthetic */ void getDefaultOffer$annotations() {
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public void add2(int i, SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i, SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends SubscriptionOption> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends SubscriptionOption> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addFirst(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addLast(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(SubscriptionOption element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.subscriptionOptions.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.subscriptionOptions.containsAll(elements);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public SubscriptionOption get(int index) {
        return this.subscriptionOptions.get(index);
    }

    public int getSize() {
        return this.subscriptionOptions.size();
    }

    public int indexOf(SubscriptionOption element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.subscriptionOptions.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.subscriptionOptions.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<SubscriptionOption> iterator() {
        return this.subscriptionOptions.iterator();
    }

    public int lastIndexOf(SubscriptionOption element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.subscriptionOptions.lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<SubscriptionOption> listIterator() {
        return this.subscriptionOptions.listIterator();
    }

    @Override // java.util.List
    public ListIterator<SubscriptionOption> listIterator(int index) {
        return this.subscriptionOptions.listIterator(index);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public SubscriptionOption remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ SubscriptionOption remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public SubscriptionOption removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: removeFirst, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3911removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public SubscriptionOption removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: removeLast, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3912removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<SubscriptionOption> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public SubscriptionOption set2(int i, SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ SubscriptionOption set(int i, SubscriptionOption subscriptionOption) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void sort(Comparator<? super SubscriptionOption> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<SubscriptionOption> subList(int fromIndex, int toIndex) {
        return this.subscriptionOptions.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptionOptions(List<? extends SubscriptionOption> subscriptionOptions) {
        Intrinsics.checkNotNullParameter(subscriptionOptions, "subscriptionOptions");
        this.subscriptionOptions = subscriptionOptions;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof SubscriptionOption) {
            return contains((SubscriptionOption) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof SubscriptionOption) {
            return indexOf((SubscriptionOption) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof SubscriptionOption) {
            return lastIndexOf((SubscriptionOption) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/models/SubscriptionOptions$Companion;", "", "()V", "RC_IGNORE_OFFER_TAG", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final SubscriptionOption findLongestFreeTrial(List<? extends SubscriptionOption> offers) {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = offers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SubscriptionOption subscriptionOption = (SubscriptionOption) it.next();
            PricingPhase freePhase = subscriptionOption.getFreePhase();
            Pair pair = freePhase != null ? new Pair(subscriptionOption, Integer.valueOf(billingPeriodToDays$purchases_defaultsBc8Release(freePhase.getBillingPeriod()))) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int iIntValue = ((Number) ((Pair) next).getSecond()).intValue();
                do {
                    Object next2 = it2.next();
                    int iIntValue2 = ((Number) ((Pair) next2).getSecond()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next2;
                        iIntValue = iIntValue2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Pair pair2 = (Pair) next;
        if (pair2 != null) {
            return (SubscriptionOption) pair2.getFirst();
        }
        return null;
    }

    private final SubscriptionOption findLowestNonFreeOffer(List<? extends SubscriptionOption> offers) {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = offers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SubscriptionOption subscriptionOption = (SubscriptionOption) it.next();
            PricingPhase introPhase = subscriptionOption.getIntroPhase();
            Pair pair = introPhase != null ? new Pair(subscriptionOption, Long.valueOf(introPhase.getPrice().getAmountMicros())) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                long jLongValue = ((Number) ((Pair) next).getSecond()).longValue();
                do {
                    Object next2 = it2.next();
                    long jLongValue2 = ((Number) ((Pair) next2).getSecond()).longValue();
                    if (jLongValue > jLongValue2) {
                        next = next2;
                        jLongValue = jLongValue2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Pair pair2 = (Pair) next;
        if (pair2 != null) {
            return (SubscriptionOption) pair2.getFirst();
        }
        return null;
    }

    public final int billingPeriodToDays$purchases_defaultsBc8Release(Period period) {
        Intrinsics.checkNotNullParameter(period, "period");
        Integer num = (Integer) SubscriptionOptionsKt.DAYS_IN_UNIT.get(period.getUnit());
        return period.getValue() * (num != null ? num.intValue() : 0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (Intrinsics.areEqual(SubscriptionOptions.class, other != null ? other.getClass() : null)) {
            return (other instanceof SubscriptionOptions ? (SubscriptionOptions) other : null) != null && Intrinsics.areEqual(CollectionsKt.listOf(this.subscriptionOptions), CollectionsKt.listOf(((SubscriptionOptions) other).subscriptionOptions));
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return CollectionsKt.listOf(this.subscriptionOptions).hashCode();
    }

    public final SubscriptionOption getBasePlan() {
        SubscriptionOption next;
        Iterator<SubscriptionOption> it = iterator();
        while (it.hasNext()) {
            next = it.next();
            if (next.isBasePlan()) {
                return next;
            }
        }
        next = null;
        return next;
    }

    public final SubscriptionOption getDefaultOffer() {
        SubscriptionOption next;
        Iterator<SubscriptionOption> it = iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!next.isBasePlan());
        SubscriptionOption subscriptionOption = next;
        if (subscriptionOption == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SubscriptionOption subscriptionOption2 : this) {
            if (!subscriptionOption2.isBasePlan()) {
                arrayList.add(subscriptionOption2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((SubscriptionOption) obj).getTags().contains(RC_IGNORE_OFFER_TAG)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (!((SubscriptionOption) obj2).getTags().contains(SharedConstants.RC_CUSTOMER_CENTER_TAG)) {
                arrayList3.add(obj2);
            }
        }
        SubscriptionOption subscriptionOptionFindLongestFreeTrial = findLongestFreeTrial(arrayList3);
        if (subscriptionOptionFindLongestFreeTrial != null) {
            return subscriptionOptionFindLongestFreeTrial;
        }
        SubscriptionOption subscriptionOptionFindLowestNonFreeOffer = findLowestNonFreeOffer(arrayList3);
        return subscriptionOptionFindLowestNonFreeOffer == null ? subscriptionOption : subscriptionOptionFindLowestNonFreeOffer;
    }

    public final SubscriptionOption getFreeTrial() {
        SubscriptionOption next;
        Iterator<SubscriptionOption> it = iterator();
        while (it.hasNext()) {
            next = it.next();
            if (next.getFreePhase() != null) {
                return next;
            }
        }
        next = null;
        return next;
    }

    public final SubscriptionOption getIntroOffer() {
        SubscriptionOption next;
        Iterator<SubscriptionOption> it = iterator();
        while (it.hasNext()) {
            next = it.next();
            if (next.getIntroPhase() != null) {
                return next;
            }
        }
        next = null;
        return next;
    }

    public final List<SubscriptionOption> withTag(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        ArrayList arrayList = new ArrayList();
        for (SubscriptionOption subscriptionOption : this) {
            if (subscriptionOption.getTags().contains(tag)) {
                arrayList.add(subscriptionOption);
            }
        }
        return arrayList;
    }
}
