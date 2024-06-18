package com.example.instabugwrapper

import android.app.Application
import com.instabug.bug.BugReporting
import com.instabug.library.Instabug
import com.instabug.library.InstabugColorTheme
import com.instabug.library.OnSdkDismissCallback
import com.instabug.library.invocation.InstabugInvocationEvent
import com.instabug.library.invocation.util.InstabugFloatingButtonEdge
import com.instabug.library.ui.onboarding.WelcomeMessage
import java.util.Locale

class InstabugSdk {
    companion object {
        @JvmStatic
        var builder: Builder? = null

        @JvmStatic
        fun show() {
            Instabug.show();
        }

        @JvmStatic
        fun setTrackingUserStepsState(state: Feature.State) {
            Instabug.setTrackingUserStepsState(state.toNative())
        }

        @JvmStatic
        fun setViewHierarchyState(state: Feature.State) {
            builder?.builder?.setViewHierarchyState(state.toNative())
        }

        @JvmStatic
        fun setReproStepsState(state: Feature.State) {
            Instabug.setTrackingUserStepsState(state.toNative())
        }

        @JvmStatic
        fun setColorTheme(colorTheme: com.example.instabugwrapper.InstabugColorTheme) {
            Instabug.setColorTheme(colorTheme.toNative())
        }

        @JvmStatic
        fun setWelcomeMessageState(welcomeMessage: com.example.instabugwrapper.WelcomeMessage.State) {
            Instabug.setWelcomeMessageState(welcomeMessage.toNative())
        }

        @JvmStatic
        fun setLocale(locale: Locale) {
            Instabug.setLocale(locale);
        }
    }

     class Builder(context: Application, instabugToken: String) {
        internal var builder: Instabug.Builder? = null

        init {
            builder = Instabug.Builder(context, instabugToken)
            InstabugSdk.builder = this
        }

        fun setInvocationEvents(vararg instabugInvocationEvents: com.example.instabugwrapper.InstabugInvocationEvent): Builder {
            val nativeEvents = instabugInvocationEvents.map { it.toNative() }.toTypedArray()
            builder = builder?.setInvocationEvents(*nativeEvents)

            return this
        }

        fun build() {
            builder?.build()
        }
    }
}

class InstabugLog {
    companion object {
        @JvmStatic
        fun i(text: String) {
            com.instabug.library.logging.InstabugLog.i(text)
        }

        @JvmStatic
        fun e(text: String) {
            com.instabug.library.logging.InstabugLog.e(text);
        }
    }
}

class BugReporting {
    companion object {
        @JvmStatic
        fun showWrapper(reportType: ReportType) {
            BugReporting.show(reportType.toNative().ordinal)
        }

        @JvmStatic
        fun setFloatingButtonEdge(instabugFloatingButtonEdge: com.example.instabugwrapper.InstabugFloatingButtonEdge) {
            BugReporting.setFloatingButtonEdge(instabugFloatingButtonEdge.toNative())
        }

        @JvmStatic
        fun setFloatingButtonOffset(offset: Int) {
            BugReporting.setFloatingButtonOffset(offset)
        }

        @JvmStatic
        fun setInvocationEvents(vararg instabugInvocationEvents: com.example.instabugwrapper.InstabugInvocationEvent) {
            val nativeEvents = instabugInvocationEvents.map { it.toNative() }.toTypedArray()
            BugReporting.setInvocationEvents(*nativeEvents)
        }

        @JvmStatic
        fun setShakingThreshold(threshold: Int) {
            BugReporting.setShakingThreshold(threshold)
        }

        @JvmStatic
        fun setAttachmentTypesEnabled(initialScreenshot: Boolean, extraScreenshot: Boolean, imageFromGallery: Boolean, screenRecording: Boolean) {
            BugReporting.setAttachmentTypesEnabled(initialScreenshot, extraScreenshot, imageFromGallery, screenRecording)
        }

        @JvmStatic
        fun setAutoScreenRecordingEnabled(autoScreenRecordingEnabled: Boolean) {
            BugReporting.setAutoScreenRecordingEnabled(autoScreenRecordingEnabled)
        }

        @JvmStatic
        fun setOnDismissCallback(onDismissCallback: IOnDismissCallBack) {
            BugReporting.setOnDismissCallback { issueState, reportType ->
                onDismissCallback.onDismiss(DismissType.fromNative(issueState), ReportType.fromNative(reportType))
            }
        }

        @JvmStatic
        fun setOnInvokeCallback(onInvokeCallback: IOnInvokeCallback) {
            BugReporting.setOnInvokeCallback { onInvokeCallback.onInvoke() }
        }
    }
}

interface IOnDismissCallBack {
    fun onDismiss(issueState: DismissType, reportType: ReportType)
}

interface IOnInvokeCallback {
    fun onInvoke()
}

enum class DismissType {
    SUBMIT,
    CANCEL,
    ADD_ATTACHMENT;

    internal fun toNative(): OnSdkDismissCallback.DismissType {
        return when (this) {
            SUBMIT -> OnSdkDismissCallback.DismissType.SUBMIT
            CANCEL -> OnSdkDismissCallback.DismissType.CANCEL
            ADD_ATTACHMENT -> OnSdkDismissCallback.DismissType.ADD_ATTACHMENT
        }
    }

    companion object {
        @JvmStatic
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
        @JvmStatic
        internal fun fromNative(reportType: OnSdkDismissCallback.ReportType): ReportType {
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

    internal fun toNative(): InstabugColorTheme {
        return when (this) {
            InstabugColorThemeLight -> InstabugColorTheme.InstabugColorThemeLight
            InstabugColorThemeDark -> InstabugColorTheme.InstabugColorThemeDark
        }
    }
}
