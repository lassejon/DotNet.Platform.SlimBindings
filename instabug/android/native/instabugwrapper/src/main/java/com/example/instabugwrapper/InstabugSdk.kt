package com.example.instabugwrapper

import android.app.Application
import com.instabug.bug.BugReporting
import com.instabug.library.IBGFeature
import com.instabug.library.Instabug
import com.instabug.library.InstabugColorTheme
import com.instabug.library.OnSdkDismissCallback
import com.instabug.library.invocation.InstabugInvocationEvent
import com.instabug.library.invocation.util.InstabugFloatingButtonEdge
import com.instabug.library.logging.InstabugLog
import com.instabug.library.ui.onboarding.WelcomeMessage
import java.util.Locale

class InstabugSdk {
    companion object {
        var builder: Builder? = null

        fun show() {
            Instabug.show();
        }

        fun setTrackingUserStepsState(state: FeatureWrapper.State) {
            Instabug.setTrackingUserStepsState(state.toNative())
        }

        fun setViewHierarchyState(state: FeatureWrapper.State) {
            builder?.builder?.setViewHierarchyState(state.toNative())
        }

        fun setReproStepsState(state: FeatureWrapper.State) {
            Instabug.setTrackingUserStepsState(state.toNative())
        }

        fun setColorTheme(colorTheme: InstabugColorThemeWrapper) {
            Instabug.setColorTheme(colorTheme.toNative())
        }

        fun setWelcomeMessageState(welcomeMessage: WelcomeMessageWrapper.State) {
            Instabug.setWelcomeMessageState(welcomeMessage.toNative())
        }

        fun setLocale(locale: IBGLocale) {
            Instabug.setLocale(locale.toNative());
        }

        class Builder(context: Application, instabugToken: String) {
            internal var builder: Instabug.Builder? = null

            init {
                builder = Instabug.Builder(context, instabugToken)
                InstabugSdk.builder = this
            }

            fun setInvocationEvents(event: InstabugInvocationEvent): Builder {
                builder = builder?.setInvocationEvents(event)

                return this
            }

            fun build() {
                builder?.build()
            }
        }
    }
}

class BugReporting {
    companion object {
        fun show(reportType: ReportTypeWrapper) {
            BugReporting.show(reportType.toNative().ordinal)
        }

        fun setFloatingButtonEdge(instabugFloatingButtonEdge: InstabugFloatingButtonEdgeWrapper) {
            BugReporting.setFloatingButtonEdge(instabugFloatingButtonEdge.toNative())
        }

        fun setFloatingButtonOffset(offset: Int) {
            BugReporting.setFloatingButtonOffset(offset)
        }

        fun setInvocationEvents(vararg instabugInvocationEvents: com.example.instabugwrapper.InstabugInvocationEvent) {
            val nativeEvents = instabugInvocationEvents.map { it.toNative() }.toTypedArray()
            BugReporting.setInvocationEvents(*nativeEvents)
        }

        fun setShakingTreshold(treshold: Int) {
            BugReporting.setShakingThreshold(treshold)
        }

        fun setAttachmentTypesEnabled(initialScreenshot: Boolean, extraScreenshot: Boolean, imageFromGallery: Boolean, screenRecording: Boolean) {
            BugReporting.setAttachmentTypesEnabled(initialScreenshot, extraScreenshot, imageFromGallery, screenRecording)
        }

        fun setAutoScreenRecordingEnabled(autoScreenRecordingEnabled: Boolean) {
            BugReporting.setAutoScreenRecordingEnabled(autoScreenRecordingEnabled)
        }

        fun setOnDismissCallback(onDismissCallback: (issueState: DismissType, reportType: com.example.instabugwrapper.ReportType) -> Unit) {
            BugReporting.setOnDismissCallback { issueState, reportType ->
                onDismissCallback(DismissType.fromNative(issueState), com.example.instabugwrapper.ReportType.fromNative(reportType))
            }
        }

        fun setOnInvokeCallback(onInvokeCallback: () -> Unit) {
            BugReporting.setOnInvokeCallback { onInvokeCallback() }
        }
    }

    class InstabugLog {
        companion object {
            fun i(text: String) {
                com.instabug.library.logging.InstabugLog.i(text)
            }

            fun e(text: String) {
                com.instabug.library.logging.InstabugLog.e(text);
            }
        }
    }
}

enum class IBGLocale {
    ENGLISH,
    FRENCH,
    GERMAN,
    ITALIAN,
    JAPANESE,
    KOREAN,
    CHINESE,
    SIMPLIFIED_CHINESE,
    TRADITIONAL_CHINESE,
    FRANCE,
    GERMANY,
    ITALY,
    JAPAN,
    KOREA,
    CHINA,
    PRC,
    TAIWAN,
    UK,
    US,
    CANADA,
    CANADA_FRENCH,
    ROOT;

    fun toNative(): Locale {
        return when (this) {
            ENGLISH -> Locale.ENGLISH
            FRENCH -> Locale.FRENCH
            GERMAN -> Locale.GERMAN
            ITALIAN -> Locale.ITALIAN
            JAPANESE -> Locale.JAPANESE
            KOREAN -> Locale.KOREAN
            CHINESE -> Locale.CHINESE
            SIMPLIFIED_CHINESE -> Locale.SIMPLIFIED_CHINESE
            TRADITIONAL_CHINESE -> Locale.TRADITIONAL_CHINESE
            FRANCE -> Locale.FRANCE
            GERMANY -> Locale.GERMANY
            ITALY -> Locale.ITALY
            JAPAN -> Locale.JAPAN
            KOREA -> Locale.KOREA
            CHINA -> Locale.CHINA
            PRC -> Locale.PRC
            TAIWAN -> Locale.TAIWAN
            UK -> Locale.UK
            US -> Locale.US
            CANADA -> Locale.CANADA
            CANADA_FRENCH -> Locale.CANADA_FRENCH
            ROOT -> Locale.ROOT
        }
    }
}

enum class DismissTypeWrapper {
    SUBMIT,
    CANCEL,
    ADD_ATTACHMENT;

    fun toNative(): OnSdkDismissCallback.DismissType {
        return when (this) {
            SUBMIT -> OnSdkDismissCallback.DismissType.SUBMIT
            CANCEL -> OnSdkDismissCallback.DismissType.CANCEL
            ADD_ATTACHMENT -> OnSdkDismissCallback.DismissType.ADD_ATTACHMENT
        }
    }

    companion object {
        internal fun fromNative(reportType: OnSdkDismissCallback.DismissType): DismissType {
            return when (reportType) {
                OnSdkDismissCallback.DismissType.SUBMIT -> com.example.instabugwrapper.DismissType.SUBMIT
                OnSdkDismissCallback.DismissType.CANCEL -> com.example.instabugwrapper.DismissType.CANCEL
                OnSdkDismissCallback.DismissType.ADD_ATTACHMENT -> com.example.instabugwrapper.DismissType.ADD_ATTACHMENT
            }
        }
    }
}

enum class ReportType {
    BUG,
    FEEDBACK,
    QUESTION,
    OTHER;

    internal fun toNative(): OnSdkDismissCallback.ReportType {
        return when (this) {
            BUG -> OnSdkDismissCallback.ReportType.BUG
            FEEDBACK -> OnSdkDismissCallback.ReportType.FEEDBACK
            QUESTION -> OnSdkDismissCallback.ReportType.QUESTION
            OTHER -> OnSdkDismissCallback.ReportType.OTHER
        }
    }

    companion object {
        internal fun fromNative(reportType: OnSdkDismissCallback.ReportType): com.example.instabugwrapper.ReportType {
            return when (reportType) {
                OnSdkDismissCallback.ReportType.BUG -> BUG
                OnSdkDismissCallback.ReportType.FEEDBACK -> FEEDBACK
                OnSdkDismissCallback.ReportType.QUESTION -> QUESTION
                OnSdkDismissCallback.ReportType.OTHER -> OTHER
            }
        }
    }
}

enum class InstabugInvocationEvent {
    NONE,
    FLOATING_BUTTON,
    SCREENSHOT,
    SHAKE,
    TWO_FINGER_SWIPE_LEFT;

    internal fun toNative(): InstabugInvocationEvent {
        return when (this) {
            NONE -> InstabugInvocationEvent.NONE
            FLOATING_BUTTON -> InstabugInvocationEvent.FLOATING_BUTTON
            SCREENSHOT -> InstabugInvocationEvent.SCREENSHOT
            SHAKE -> InstabugInvocationEvent.SHAKE
            TWO_FINGER_SWIPE_LEFT -> InstabugInvocationEvent.TWO_FINGER_SWIPE_LEFT
        }
    }
}

enum class InstabugFloatingButtonEdge {
    LEFT, RIGHT;

    internal fun toNative(): InstabugFloatingButtonEdge {
        return when (this) {
            LEFT -> InstabugFloatingButtonEdge.LEFT
            RIGHT -> InstabugFloatingButtonEdge.RIGHT
        }
    }
}

enum class Feature {
    ;
    enum class State {
        DISABLED, ENABLED;

        internal fun toNative(): com.instabug.library.Feature.State  {
            return when (this) {
                DISABLED -> com.instabug.library.Feature.State.DISABLED
                ENABLED -> com.instabug.library.Feature.State.ENABLED
            }
        }
    }
}

enum class WelcomeMessage {
    ;
    enum class State {
        BETA, DISABLED, LIVE;

        internal fun toNative(): WelcomeMessage.State {
            return when (this) {
                BETA -> WelcomeMessage.State.BETA
                DISABLED -> WelcomeMessage.State.DISABLED
                LIVE -> WelcomeMessage.State.LIVE
            }
        }
    }
}

enum class InstabugColorTheme {
    InstabugColorThemeLight,
    InstabugColorThemeDark;

    internal fun toNative(): InstabugColorTheme  {
        return when (this) {
            InstabugColorThemeLight -> InstabugColorTheme.InstabugColorThemeLight
            InstabugColorThemeDark -> InstabugColorTheme.InstabugColorThemeDark
        }
    }
}
