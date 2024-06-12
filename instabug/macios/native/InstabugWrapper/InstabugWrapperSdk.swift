//
//  InstabugWrapperSdk.swift
//  InstabugWrapper
//
//  Created by Lasse Jon Marqaurdt Frederiksen on 12/06/2024.
//

import Foundation
import Instabug

//struct EventArgs {
//    
//}



public class InstabugSdk {
//    typealias EventHandler = (AnyObject, EventArgs) -> Void
    public var WillInvokeHandler: (() -> Void)?;
    public var DidDismissHandler: (() -> Void)?;
    
    public var trackUserSteps: Bool = true {
        didSet {
            Instabug.trackUserSteps = trackUserSteps;
        }
    }
    
    public var shouldCaptureViewHierarchy: Bool = true {
        didSet {
            
        }
    }
    
    public var reproStepsMode: IBGUserStepsMode = IBGUserStepsMode.disable {
        didSet {
//            Instabug.setReproStepsFor(<#T##issueType: IBGIssueType##IBGIssueType#>, with: reproStepsMode);
        }
    }
    
    public func startWithToken(token: String, invocationEvents: IBGInvocationEvent) {
        Instabug.start(withToken: token, invocationEvents: invocationEvents);
    }
    
    public func SetLocale(locale: IBGLocale) {
        Instabug.setLocale(locale);
    }
}

//public class IBGCrashReportingSdk {
//    public var enabled: Bool = false {
//        didSet {
//            
//        }
//    }
//}
//
//public class IBGBugReportingSdk {
//    public var floatingButtonEdge: CoreGraphics.CGRectEdge = CoreGraphics.CGRectEdge.maxXEdge {
//        didSet {
//            
//        }
//    }
//    
//    public var floatingButtonTopOffset: Int = 40;
//}
