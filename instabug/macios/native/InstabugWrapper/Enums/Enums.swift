//
//  Enums.swift
//  InstabugWrapper
//
//  Created by Lasse Jon Marqaurdt Frederiksen on 14/06/2024.
//

import Foundation
import Instabug

// Selection of enums has bit value for conversion from rawvalue. Others are in correct order.
// See native type for values and orders.
@objc(IBGInvocationEvent) public enum IBGInvocationEventWrapper: Int {
    case shake = 1
    case screenshot = 2
    case twoFingersSwipeLeft = 4
    case rightEdgePan = 8
    case floatingButton = 16
    case none = 32

    // Step 2: Add a Computed Property to Map to IBGInvocationEvent
    var ibgInvocationEvent: IBGInvocationEvent {
        switch self {
            case .shake:
                return .shake
            case .screenshot:
                return .screenshot
            case .twoFingersSwipeLeft:
                return .twoFingersSwipeLeft
            case .rightEdgePan:
                return .rightEdgePan
            case .floatingButton:
                return .floatingButton
            case .none:
                return .none
        }
    }
}

@objc(IBGUserStepsMode) public enum IBGUserStepsModeWrapper: Int {
    case enable
    case enabledWithNoScreenshots
    case disable
    
    var ibgUserStepsMode: IBGUserStepsMode {
        switch self {
            case .enable:
                return .enable
            case .enabledWithNoScreenshots:
                return .enabledWithNoScreenshots
            case .disable:
                return .disable
        }
    }
}

@objc(IBGColorTheme) public enum IBGColorThemeWrapper: Int {
    case light
    case dark
    
    var ibgColorTheme: IBGColorTheme {
        switch self {
            case .light:
                return .light
            case .dark:
                return .dark
        }
    }
}

@objc(IBGIssueType) public enum IBGIssueTypeWrapper: Int {
    case bug
    case crash
    case sessionReplay
    case all
    
    var ibgIssueType: IBGIssueType {
        switch self {
            case .bug:
                return .bug
            case .crash:
                return .crash
            case .sessionReplay:
                return .sessionReplay
            case .all:
                return .all
        }
    }
}

@objc(IBGDismissType) public enum IBGDismissTypeWrapper: Int {
    case submit
    case cancel
    case addAttachment
    
    var ibgDismissType: IBGDismissType {
        switch self {
        case .submit:
            return .addAttachment
        case .cancel:
            return .cancel
        case .addAttachment :
            return .addAttachment
        }
    }
}

@objc(IBGReportType) public enum IBGReportTypeWrapper: Int {
    case bug = 1
    case feedback = 2
    case question = 4
    case other = 8
    
    var ibgReportType: IBGReportType {
        switch self {
        case .bug:
            return .bug
        case .feedback:
            return .feedback
        case .question:
            return .question
        case .other:
            return .other
        }
    }
}

@objc(IBGWelcomeMessageMode) public enum IBGWelcomeMessageModeWrapper: Int {
    case live
    case beta
    case disabled
    
    var ibgWelcomeMessageMode: IBGWelcomeMessageMode {
        switch self {
        case .beta:
            return .beta
        case .live:
            return .live
        case .disabled:
            return .disabled
        }
    }
}

@objc(IBGBugReportingReportType) public enum IBGBugReportingReportTypeWrapper: Int {
    case bug = 1
    case feedback = 2
    case question = 4
    
    var ibgBugReportingReportType: IBGBugReportingReportType {
        switch self {
        case .bug:
            return .bug
        case .feedback:
            return .feedback
        case .question:
            return .question
        }
    }
}

@objc(IBGBugReportingOption) public enum IBGBugReportingOptionWrapper: Int {
    case emailFieldHidden = 1
    case emailFieldOptional = 2
    case commentFieldRequired = 4
    case disablePostSendingDialog = 8
    case none = 16
    
    var ibgBugReportingOption: IBGBugReportingOption {
        switch self {
        case .emailFieldHidden:
            return .emailFieldHidden
        case .emailFieldOptional:
            return .emailFieldOptional
        case .commentFieldRequired:
            return .commentFieldRequired
        case .disablePostSendingDialog:
            return .disablePostSendingDialog
        case .none:
            return .none
        }
    }
}

@objc(IBGAttachmentType) public enum IBGAttachmentTypeWrapper: Int {
    case screenShot = 2
    case extraScreenShot = 4
    case galleryImage = 16
    case screenRecording = 64
    
    var ibgAttachmentType: IBGAttachmentType {
        switch self {
        case .screenShot:
            return .screenShot;
        case .extraScreenShot:
            return .extraScreenShot;
        case .galleryImage:
            return .galleryImage;
        case .screenRecording:
            return .screenRecording;
        }
    }
}

@objc(IBGLocale) public enum IBGLocaleWrapper: Int {
    case arabic
    case azerbaijani
    case catalan
    case catalanSpain
    case chineseSimplified
    case chineseTaiwan
    case chineseTraditional
    case czech
    case danish
    case dutch
    case english
    case french
    case german
    case italian
    case japanese
    case korean
    case norwegian
    case polish
    case portuguese
    case portugueseBrazil
    case russian
    case slovak
    case spanish
    case swedish
    case turkish
    case hungarian
    case finnish
    
    var ibgLocale: IBGLocale {
        switch self {
            case .arabic:
                return .arabic
            case .azerbaijani:
                return .azerbaijani
            case .catalan:
                return .catalan
            case .catalanSpain:
                return .catalanSpain
            case .chineseSimplified:
                return .chineseSimplified
            case .chineseTaiwan:
                return .chineseTaiwan
            case .chineseTraditional:
                return .chineseTraditional
            case .czech:
                return .czech
            case .danish:
                return .danish
            case .dutch:
                return .dutch
            case .english:
                return .english
            case .french:
                return .french
            case .german:
                return .german
            case .italian:
                return .italian
            case .japanese:
                return .japanese
            case .korean:
                return .korean
            case .norwegian:
                return .norwegian
            case .polish:
                return .polish
            case .portuguese:
                return .portuguese
            case .portugueseBrazil:
                return .portugueseBrazil
            case .russian:
                return .russian
            case .slovak:
                return .slovak
            case .spanish:
                return .spanish
            case .swedish:
                return .swedish
            case .turkish:
                return .turkish
            case .hungarian:
                return .hungarian
            case .finnish:
                return .finnish
        }
    }
}
