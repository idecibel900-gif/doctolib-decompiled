package expo.modules.calendar;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.tracing.Trace;
import expo.modules.calendar.dialogs.CreatedEventOptions;
import expo.modules.calendar.dialogs.ViewedEventOptions;
import expo.modules.calendar.domain.attendee.AttendeeRepository;
import expo.modules.calendar.domain.attendee.records.Attendee;
import expo.modules.calendar.domain.calendar.CalendarRepository;
import expo.modules.calendar.domain.calendar.records.input.CalendarUpdateInput;
import expo.modules.calendar.domain.calendar.records.input.NewCalendarInput;
import expo.modules.calendar.domain.event.EventRepository;
import expo.modules.calendar.domain.event.records.input.EventUpdateInput;
import expo.modules.calendar.domain.event.records.input.NewEventInput;
import expo.modules.calendar.domain.event.records.input.RemoveEventInput;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions$IllegalArgument;
import expo.modules.kotlin.exception.Exceptions$ReactContextLost;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0016J\"\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$H\u0082@¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020)H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lexpo/modules/calendar/CalendarModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "reactContext", "Landroid/content/Context;", "getReactContext", "()Landroid/content/Context;", "createEventLauncher", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "Lexpo/modules/calendar/dialogs/CreatedEventOptions;", "Lexpo/modules/calendar/dialogs/CreateEventIntentResult;", "viewEventLauncher", "Lexpo/modules/calendar/dialogs/ViewedEventOptions;", "Lexpo/modules/calendar/dialogs/ViewEventIntentResult;", "calendarRepository", "Lexpo/modules/calendar/domain/calendar/CalendarRepository;", "getCalendarRepository", "()Lexpo/modules/calendar/domain/calendar/CalendarRepository;", "calendarRepository$delegate", "Lkotlin/Lazy;", "eventRepository", "Lexpo/modules/calendar/domain/event/EventRepository;", "getEventRepository", "()Lexpo/modules/calendar/domain/event/EventRepository;", "eventRepository$delegate", "attendeeRepository", "Lexpo/modules/calendar/domain/attendee/AttendeeRepository;", "getAttendeeRepository", "()Lexpo/modules/calendar/domain/attendee/AttendeeRepository;", "attendeeRepository$delegate", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "saveEvent", "", "eventInput", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/calendar/domain/event/records/input/NewEventInput;", "Lexpo/modules/calendar/domain/event/records/input/EventUpdateInput;", "(Lexpo/modules/kotlin/types/Either;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPermissions", "", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarModule extends Module {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = CalendarModule.class.getSimpleName();
    private AppContextActivityResultLauncher createEventLauncher;
    private AppContextActivityResultLauncher viewEventLauncher;

    /* JADX INFO: renamed from: calendarRepository$delegate, reason: from kotlin metadata */
    private final Lazy calendarRepository = LazyKt.lazy(new Function0() { // from class: expo.modules.calendar.CalendarModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CalendarModule.calendarRepository_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: eventRepository$delegate, reason: from kotlin metadata */
    private final Lazy eventRepository = LazyKt.lazy(new Function0() { // from class: expo.modules.calendar.CalendarModule$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CalendarModule.eventRepository_delegate$lambda$1(this.f$0);
        }
    });

    /* JADX INFO: renamed from: attendeeRepository$delegate, reason: from kotlin metadata */
    private final Lazy attendeeRepository = LazyKt.lazy(new Function0() { // from class: expo.modules.calendar.CalendarModule$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CalendarModule.attendeeRepository_delegate$lambda$2(this.f$0);
        }
    });

    /* JADX INFO: renamed from: expo.modules.calendar.CalendarModule$saveEvent$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return CalendarModule.this.saveEvent(null, this);
        }
    }

    private final Context getReactContext() throws Exceptions$ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions$ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CalendarRepository getCalendarRepository() {
        return (CalendarRepository) this.calendarRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CalendarRepository calendarRepository_delegate$lambda$0(CalendarModule calendarModule) {
        return new CalendarRepository(calendarModule.getReactContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventRepository getEventRepository() {
        return (EventRepository) this.eventRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventRepository eventRepository_delegate$lambda$1(CalendarModule calendarModule) {
        return new EventRepository(calendarModule.getReactContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AttendeeRepository getAttendeeRepository() {
        return (AttendeeRepository) this.attendeeRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AttendeeRepository attendeeRepository_delegate$lambda$2(CalendarModule calendarModule) {
        return new AttendeeRepository(calendarModule.getReactContext());
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Class cls;
        AsyncFunctionComponent stringAsyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent stringAsyncFunctionComponent2;
        AsyncFunctionComponent asyncFunctionWithPromiseComponent2;
        AsyncFunctionComponent stringAsyncFunctionComponent3;
        AsyncFunctionComponent asyncFunctionWithPromiseComponent3;
        Trace.beginSection("[ExpoModulesCore] " + (getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
            moduleDefinitionBuilder.Name("ExpoCalendar");
            moduleDefinitionBuilder.RegisterActivityContracts(new CalendarModule$definition$1$1(this, null));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("getCalendarsAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            Boolean bool = Boolean.TRUE;
            AnyType anyType = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, bool));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }), converters);
            }
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, new AnyType[]{anyType}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$2(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("saveCalendarAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            TypeConverterProvider converters2 = asyncFunctionBuilderAsyncFunction2.getConverters();
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Either.class);
            Boolean bool2 = Boolean.FALSE;
            AnyType anyType2 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass2, bool2));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Either.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        KTypeProjection.Companion companion = KTypeProjection.Companion;
                        return Reflection.typeOf(Either.class, companion.invariant(Reflection.typeOf(NewCalendarInput.class)), companion.invariant(Reflection.typeOf(CalendarUpdateInput.class)));
                    }
                }), converters2);
            }
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, new AnyType[]{anyType2}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$4(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("deleteCalendarAsync");
            String name3 = asyncFunctionBuilderAsyncFunction3.getName();
            TypeConverterProvider converters3 = asyncFunctionBuilderAsyncFunction3.getConverters();
            AnyType anyType3 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), bool2));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters3);
            }
            asyncFunctionBuilderAsyncFunction3.setAsyncFunctionComponent(new SuspendFunctionComponent(name3, new AnyType[]{anyType3}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$6(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction4 = moduleDefinitionBuilder.AsyncFunction("getEventsAsync");
            String name4 = asyncFunctionBuilderAsyncFunction4.getName();
            TypeConverterProvider converters4 = asyncFunctionBuilderAsyncFunction4.getConverters();
            AnyType anyType4 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), bool2));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Either.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        KTypeProjection.Companion companion = KTypeProjection.Companion;
                        return Reflection.typeOf(Either.class, companion.invariant(Reflection.typeOf(String.class)), companion.invariant(Reflection.typeOf(Long.TYPE)));
                    }
                }), converters4);
            }
            AnyType anyType5 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), bool2));
            if (anyType5 == null) {
                cls = Either.class;
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(cls), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        KTypeProjection.Companion companion = KTypeProjection.Companion;
                        return Reflection.typeOf(Either.class, companion.invariant(Reflection.typeOf(String.class)), companion.invariant(Reflection.typeOf(Long.TYPE)));
                    }
                }), converters4);
            } else {
                cls = Either.class;
            }
            AnyType anyType6 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r4), bool2));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$9
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                    }
                }), converters4);
            }
            asyncFunctionBuilderAsyncFunction4.setAsyncFunctionComponent(new SuspendFunctionComponent(name4, new AnyType[]{anyType4, anyType5, anyType6}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$10(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction5 = moduleDefinitionBuilder.AsyncFunction("getEventByIdAsync");
            String name5 = asyncFunctionBuilderAsyncFunction5.getName();
            TypeConverterProvider converters5 = asyncFunctionBuilderAsyncFunction5.getConverters();
            AnyType anyType7 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), bool2));
            if (anyType7 == null) {
                anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters5);
            }
            asyncFunctionBuilderAsyncFunction5.setAsyncFunctionComponent(new SuspendFunctionComponent(name5, new AnyType[]{anyType7}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$12(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction6 = moduleDefinitionBuilder.AsyncFunction("saveEventAsync");
            String name6 = asyncFunctionBuilderAsyncFunction6.getName();
            TypeConverterProvider converters6 = asyncFunctionBuilderAsyncFunction6.getConverters();
            AnyType anyType8 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(cls), bool2));
            if (anyType8 == null) {
                anyType8 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(cls), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$13
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        KTypeProjection.Companion companion = KTypeProjection.Companion;
                        return Reflection.typeOf(Either.class, companion.invariant(Reflection.typeOf(NewEventInput.class)), companion.invariant(Reflection.typeOf(EventUpdateInput.class)));
                    }
                }), converters6);
            }
            AnyType anyType9 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r6), bool));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$14
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(ReadableArguments.class);
                    }
                }), converters6);
            }
            asyncFunctionBuilderAsyncFunction6.setAsyncFunctionComponent(new SuspendFunctionComponent(name6, new AnyType[]{anyType8, anyType9}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$15(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction7 = moduleDefinitionBuilder.AsyncFunction("deleteEventAsync");
            String name7 = asyncFunctionBuilderAsyncFunction7.getName();
            TypeConverterProvider converters7 = asyncFunctionBuilderAsyncFunction7.getConverters();
            AnyType anyType10 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r3), bool2));
            if (anyType10 == null) {
                anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(RemoveEventInput.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$16
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(RemoveEventInput.class);
                    }
                }), converters7);
            }
            AnyType anyType11 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r6), bool));
            if (anyType11 == null) {
                anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(r6), true, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$17
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(ReadableArguments.class);
                    }
                }), converters7);
            }
            asyncFunctionBuilderAsyncFunction7.setAsyncFunctionComponent(new SuspendFunctionComponent(name7, new AnyType[]{anyType10, anyType11}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$18(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction8 = moduleDefinitionBuilder.AsyncFunction("getAttendeesForEventAsync");
            String name8 = asyncFunctionBuilderAsyncFunction8.getName();
            TypeConverterProvider converters8 = asyncFunctionBuilderAsyncFunction8.getConverters();
            AnyType anyType12 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), bool2));
            if (anyType12 == null) {
                anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$19
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters8);
            }
            asyncFunctionBuilderAsyncFunction8.setAsyncFunctionComponent(new SuspendFunctionComponent(name8, new AnyType[]{anyType12}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$20(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction9 = moduleDefinitionBuilder.AsyncFunction("saveAttendeeForEventAsync");
            String name9 = asyncFunctionBuilderAsyncFunction9.getName();
            TypeConverterProvider converters9 = asyncFunctionBuilderAsyncFunction9.getConverters();
            AnyType anyType13 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Attendee.class), bool2));
            if (anyType13 == null) {
                anyType13 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Attendee.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$21
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Attendee.class);
                    }
                }), converters9);
            }
            AnyType anyType14 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), bool));
            if (anyType14 == null) {
                anyType14 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$22
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }), converters9);
            }
            asyncFunctionBuilderAsyncFunction9.setAsyncFunctionComponent(new SuspendFunctionComponent(name9, new AnyType[]{anyType13, anyType14}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$23(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction10 = moduleDefinitionBuilder.AsyncFunction("deleteAttendeeAsync");
            String name10 = asyncFunctionBuilderAsyncFunction10.getName();
            TypeConverterProvider converters10 = asyncFunctionBuilderAsyncFunction10.getConverters();
            AnyType anyType15 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), bool2));
            if (anyType15 == null) {
                anyType15 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$24
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters10);
            }
            asyncFunctionBuilderAsyncFunction10.setAsyncFunctionComponent(new SuspendFunctionComponent(name10, new AnyType[]{anyType15}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$25(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction11 = moduleDefinitionBuilder.AsyncFunction("createEventInCalendarAsync");
            String name11 = asyncFunctionBuilderAsyncFunction11.getName();
            TypeConverterProvider converters11 = asyncFunctionBuilderAsyncFunction11.getConverters();
            AnyType anyType16 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CreatedEventOptions.class), bool2));
            if (anyType16 == null) {
                anyType16 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(CreatedEventOptions.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$26
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(CreatedEventOptions.class);
                    }
                }), converters11);
            }
            asyncFunctionBuilderAsyncFunction11.setAsyncFunctionComponent(new SuspendFunctionComponent(name11, new AnyType[]{anyType16}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$27(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction12 = moduleDefinitionBuilder.AsyncFunction("openEventInCalendarAsync");
            String name12 = asyncFunctionBuilderAsyncFunction12.getName();
            TypeConverterProvider converters12 = asyncFunctionBuilderAsyncFunction12.getConverters();
            AnyType anyType17 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r5), bool2));
            if (anyType17 == null) {
                anyType17 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ViewedEventOptions.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$28
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ViewedEventOptions.class);
                    }
                }), converters12);
            }
            asyncFunctionBuilderAsyncFunction12.setAsyncFunctionComponent(new SuspendFunctionComponent(name12, new AnyType[]{anyType17}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$29(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction13 = moduleDefinitionBuilder.AsyncFunction("editEventInCalendarAsync");
            String name13 = asyncFunctionBuilderAsyncFunction13.getName();
            TypeConverterProvider converters13 = asyncFunctionBuilderAsyncFunction13.getConverters();
            AnyType anyType18 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r5), bool2));
            if (anyType18 == null) {
                anyType18 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(r5), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$Coroutine$30
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ViewedEventOptions.class);
                    }
                }), converters13);
            }
            asyncFunctionBuilderAsyncFunction13.setAsyncFunctionComponent(new SuspendFunctionComponent(name13, new AnyType[]{anyType18}, new CalendarModule$definition$lambda$20$$inlined$Coroutine$31(null, this)));
            boolean zAreEqual = Intrinsics.areEqual(String.class, Promise.class);
            Class cls2 = Float.TYPE;
            Class cls3 = Double.TYPE;
            Class cls4 = Boolean.TYPE;
            Class cls5 = Integer.TYPE;
            if (zAreEqual) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("openEventInCalendar", new AnyType[0], new Function2() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    public final void invoke(Object[] objArr, Promise promise) throws Exceptions$ReactContextLost {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String str = (String) promise;
                        Context reactContext = this.this$0.getAppContext().getReactContext();
                        if (reactContext == null) {
                            throw new Exceptions$ReactContextLost();
                        }
                        Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, Long.parseLong(str));
                        Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                        Intent data = new Intent("android.intent.action.VIEW").addFlags(268435456).setData(uriWithAppendedId);
                        Intrinsics.checkNotNullExpressionValue(data, "setData(...)");
                        if (data.resolveActivity(reactContext.getPackageManager()) != null) {
                            reactContext.startActivity(data);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Exceptions$ReactContextLost {
                        invoke((Object[]) obj, (Promise) obj2);
                        return Unit.INSTANCE;
                    }
                });
                moduleDefinitionBuilder = moduleDefinitionBuilder;
            } else {
                TypeConverterProvider converters14 = moduleDefinitionBuilder.getConverters();
                AnyType anyType19 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), bool2));
                if (anyType19 == null) {
                    anyType19 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }), converters14);
                }
                AnyType[] anyTypeArr = {anyType19};
                Function1 function1 = new Function1() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] objArr) throws Exceptions$ReactContextLost {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        String str = (String) objArr[0];
                        Context reactContext = this.this$0.getAppContext().getReactContext();
                        if (reactContext == null) {
                            throw new Exceptions$ReactContextLost();
                        }
                        Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, Long.parseLong(str));
                        Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                        Intent data = new Intent("android.intent.action.VIEW").addFlags(268435456).setData(uriWithAppendedId);
                        Intrinsics.checkNotNullExpressionValue(data, "setData(...)");
                        if (data.resolveActivity(reactContext.getPackageManager()) != null) {
                            reactContext.startActivity(data);
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (Intrinsics.areEqual(Unit.class, cls5)) {
                    stringAsyncFunctionComponent = new IntAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                } else if (Intrinsics.areEqual(Unit.class, cls4)) {
                    stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                } else if (Intrinsics.areEqual(Unit.class, cls3)) {
                    stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                } else if (Intrinsics.areEqual(Unit.class, cls2)) {
                    stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                } else {
                    stringAsyncFunctionComponent = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1) : new UntypedAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = stringAsyncFunctionComponent;
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("openEventInCalendar", asyncFunctionWithPromiseComponent);
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("requestCalendarPermissionsAsync", new AnyType[0], new Function2() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Object[]) obj, (Promise) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), promise, "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
                    }
                });
            } else {
                TypeConverterProvider converters15 = moduleDefinitionBuilder.getConverters();
                AnyType anyType20 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), bool2));
                if (anyType20 == null) {
                    anyType20 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }), converters15);
                }
                AnyType[] anyTypeArr2 = {anyType20};
                Function1 function2 = new Function1() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
                        return Unit.INSTANCE;
                    }
                };
                if (Intrinsics.areEqual(Unit.class, cls5)) {
                    stringAsyncFunctionComponent2 = new IntAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function2);
                } else if (Intrinsics.areEqual(Unit.class, cls4)) {
                    stringAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function2);
                } else if (Intrinsics.areEqual(Unit.class, cls3)) {
                    stringAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function2);
                } else if (Intrinsics.areEqual(Unit.class, cls2)) {
                    stringAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function2);
                } else {
                    stringAsyncFunctionComponent2 = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function2) : new UntypedAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function2);
                }
                asyncFunctionWithPromiseComponent2 = stringAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("requestCalendarPermissionsAsync", asyncFunctionWithPromiseComponent2);
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("getCalendarPermissionsAsync", new AnyType[0], new Function2() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$AsyncFunction$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Object[]) obj, (Promise) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), promise, "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
                    }
                });
            } else {
                TypeConverterProvider converters16 = moduleDefinitionBuilder.getConverters();
                AnyType anyType21 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), bool2));
                if (anyType21 == null) {
                    anyType21 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$AsyncFunction$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }), converters16);
                }
                AnyType[] anyTypeArr3 = {anyType21};
                Function1 function3 = new Function1() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$20$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
                        return Unit.INSTANCE;
                    }
                };
                if (Intrinsics.areEqual(Unit.class, cls5)) {
                    stringAsyncFunctionComponent3 = new IntAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function3);
                } else if (Intrinsics.areEqual(Unit.class, cls4)) {
                    stringAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function3);
                } else if (Intrinsics.areEqual(Unit.class, cls3)) {
                    stringAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function3);
                } else if (Intrinsics.areEqual(Unit.class, cls2)) {
                    stringAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function3);
                } else {
                    stringAsyncFunctionComponent3 = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function3) : new UntypedAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function3);
                }
                asyncFunctionWithPromiseComponent3 = stringAsyncFunctionComponent3;
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("getCalendarPermissionsAsync", asyncFunctionWithPromiseComponent3);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object saveEvent(Either either, Continuation continuation) throws Exceptions$IllegalArgument {
        AnonymousClass1 anonymousClass1;
        NewEventInput newEventInput;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objFindCalendarById = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFindCalendarById);
            if (either.isSecondType(Reflection.getOrCreateKotlinClass(EventUpdateInput.class))) {
                EventRepository eventRepository = getEventRepository();
                EventUpdateInput eventUpdateInput = (EventUpdateInput) either.second();
                anonymousClass1.label = 1;
                Object objUpdateEvent = eventRepository.updateEvent(eventUpdateInput, anonymousClass1);
                if (objUpdateEvent != coroutine_suspended) {
                    return objUpdateEvent;
                }
            } else {
                newEventInput = (NewEventInput) either.first();
                CalendarRepository calendarRepository = getCalendarRepository();
                String calendarId = newEventInput.getCalendarId();
                anonymousClass1.L$0 = newEventInput;
                anonymousClass1.label = 2;
                objFindCalendarById = calendarRepository.findCalendarById(calendarId, anonymousClass1);
                if (objFindCalendarById != coroutine_suspended) {
                }
            }
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(objFindCalendarById);
            return objFindCalendarById;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFindCalendarById);
            return objFindCalendarById;
        }
        newEventInput = (NewEventInput) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objFindCalendarById);
        if (objFindCalendarById == null) {
            throw new Exceptions$IllegalArgument("Couldn't find calendar with given id: " + newEventInput.getCalendarId(), null, 2, null);
        }
        EventRepository eventRepository2 = getEventRepository();
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 3;
        Object objCreateEvent = eventRepository2.createEvent(newEventInput, anonymousClass1);
        return objCreateEvent == coroutine_suspended ? coroutine_suspended : objCreateEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkPermissions() throws CodedException {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions == null || !permissions.hasGrantedPermissions("android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR")) {
            throw new CodedException("E_MISSING_PERMISSIONS", "CALENDAR permission is required to do this operation.", null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$expo_calendar_release() {
            return CalendarModule.TAG;
        }
    }
}
