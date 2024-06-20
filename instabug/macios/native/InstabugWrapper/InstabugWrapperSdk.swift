//
//  InstabugWrapperSdk.swift
//  InstabugWrapper
//
//  Created by Lasse Jon Marqaurdt Frederiksen on 12/06/2024.
//

import Foundation
import Instabug

@objc(InstabugSdk)
public class InstabugWrapperSdk : NSObject {
    @objc static public var trackUserSteps: Bool = false {
        didSet {
            Instabug.trackUserSteps = trackUserSteps;
        }
    }
    
    @objc static public var welcomeMessageMode: IBGWelcomeMessageModeWrapper = IBGWelcomeMessageModeWrapper.disabled {
        didSet {
            Instabug.welcomeMessageMode = welcomeMessageMode.ibgWelcomeMessageMode;
        }
    }
    
    @objc static public var reproStepsMode: IBGUserStepsModeWrapper = IBGUserStepsModeWrapper.disable {
        didSet {
            Instabug.setReproStepsFor(IBGIssueType.all, with: reproStepsMode.ibgUserStepsMode);
        }
    }
    
    @objc static public var shouldCaptureViewHierarchy: Bool = false {
        didSet {
            BugReporting.shouldCaptureViewHierarchy = shouldCaptureViewHierarchy;
        }
    }
    
    @objc static public func setColorTheme(ibgColorTheme: IBGColorThemeWrapper) {
        Instabug.setColorTheme(ibgColorTheme.ibgColorTheme);
    }
    
    @objc static public func start(token: String, invocationEvents: IBGInvocationEventWrapper) -> Void {
        Instabug.start(withToken: token, invocationEvents: invocationEvents.ibgInvocationEvent);
    }
    
    @objc
    static public func setLocale(locale: IBGLocaleWrapper) -> Void {
        Instabug.setLocale(locale.ibgLocale);
    }
    
    @objc static public func show() -> Void {
        Instabug.show();
    }
}

@objc(CrashReporting)
public class IBGCrashReportingWrapper : NSObject {
    @objc public static var enabled: Bool = false {
        didSet {
            CrashReporting.enabled = enabled;
        }
    }
}

@objc(BugReporting)
public class IBGBugReportingWrapper : NSObject {
    @objc public static var willInvokeHandler: (() -> Void) = {} {
        didSet {
            BugReporting.willInvokeHandler = willInvokeHandler;
        }
    }
    
    @objc public static var didDismissHandler: ((IBGDismissTypeWrapper, IBGReportTypeWrapper) -> Void) = {_,_ in } {
        didSet {
            BugReporting.didDismissHandler = { dismissType, reportType in
                // Convert IBGDismissType and IBGReportType to their corresponding wrappers
                NSLog("BugReporting.didDismissHandler called with dismissType: \(dismissType), reportType: \(reportType)")
                            
                // Safely unwrap raw values and create wrapper objects
                guard let dismissTypeWrapper = IBGDismissTypeWrapper(rawValue: dismissType.rawValue) else {
                    NSLog("Error: Failed to create IBGDismissTypeWrapper from \(dismissType.rawValue)")
                    NSLog("Dismiss type: \(dismissType)")
                    return
                }
                guard let reportTypeWrapper = IBGReportTypeWrapper(rawValue: reportType.rawValue) else {
                    NSLog("Error: Failed to create IBGReportTypeWrapper from \(reportType.rawValue)")
                    NSLog("Report type: \(reportType)")
                    return
                }
                
                self.didDismissHandler(dismissTypeWrapper, reportTypeWrapper)
            }
        }
    }
    
    @objc public static var invocationEvents: IBGInvocationEventWrapper = IBGInvocationEventWrapper.none {
        didSet {
            BugReporting.invocationEvents = invocationEvents.ibgInvocationEvent;
        }
    }
    
    @objc public static var floatingButtonEdge: CoreGraphics.CGRectEdge = CoreGraphics.CGRectEdge.maxXEdge {
        didSet {
            BugReporting.floatingButtonEdge = floatingButtonEdge;
        }
    }
    
    @objc public static var shakingThresholdForiPhone: Float = 1 {
        didSet {
            BugReporting.shakingThresholdForiPhone = CGFloat(shakingThresholdForiPhone);
        }
    }
    
    @objc public static var shakingThresholdForiPad: Float = 3 {
        didSet {
            BugReporting.shakingThresholdForiPad = CGFloat(shakingThresholdForiPad);
        }
    }
    
    @objc public static var floatingButtonTopOffset: Float = 0 {
        didSet {
            BugReporting.floatingButtonTopOffset = CGFloat(floatingButtonTopOffset);
        }
    }
    
    @objc public static var enabledAttachmentTypes: IBGAttachmentTypeWrapper = IBGAttachmentTypeWrapper.screenShot {
        didSet {
            BugReporting.enabledAttachmentTypes = enabledAttachmentTypes.ibgAttachmentType;
        }
    }
    
    @objc static public func showWithReportType(reportType: IBGBugReportingReportTypeWrapper, reportOption: IBGBugReportingOptionWrapper) {
        BugReporting.show(with: reportType.ibgBugReportingReportType, options: reportOption.ibgBugReportingOption);
    }
}

@objc(IBGLogger)
public class IBGLogWrapper : NSObject {
    @objc static public func logInfo(text: String) {
        IBGLog.logInfo(text)
    }
    
    @objc static public func logError(text: String) {
        IBGLog.logError(text)
    }
}
