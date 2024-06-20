using System;
using CoreGraphics;
using Foundation;
using ObjCRuntime;

namespace Instabug.MaciOS.Binding
{
	// @interface BugReporting : NSObject
	[BaseType(typeof(NSObject))]
	interface BugReporting
	{
		// @property (copy, nonatomic, class) void (^ _Nonnull)(void) willInvokeHandler;
		[Static]
		[Export("willInvokeHandler", ArgumentSemantic.Copy)]
		Action WillInvokeHandler { get; set; }

		// @property (copy, nonatomic, class) void (^ _Nonnull)(enum IBGDismissType, enum IBGReportType) didDismissHandler;
		[Static]
		[Export("didDismissHandler", ArgumentSemantic.Copy)]
		Action<IBGDismissType, IBGReportType> DidDismissHandler { get; set; }

		// @property (nonatomic, class) enum IBGInvocationEvent invocationEvents;
		[Static]
		[Export("invocationEvents", ArgumentSemantic.Assign)]
		IBGInvocationEvent InvocationEvents { get; set; }

		// @property (nonatomic, class) CGRectEdge floatingButtonEdge;
		[Static]
		[Export("floatingButtonEdge", ArgumentSemantic.Assign)]
		CGRectEdge FloatingButtonEdge { get; set; }

		// @property (nonatomic, class) float shakingThresholdForiPhone;
		[Static]
		[Export("shakingThresholdForiPhone")]
		float ShakingThresholdForiPhone { get; set; }

		// @property (nonatomic, class) float shakingThresholdForiPad;
		[Static]
		[Export("shakingThresholdForiPad")]
		float ShakingThresholdForiPad { get; set; }

		// @property (nonatomic, class) float floatingButtonTopOffset;
		[Static]
		[Export("floatingButtonTopOffset")]
		float FloatingButtonTopOffset { get; set; }

		// @property (nonatomic, class) enum IBGAttachmentType enabledAttachmentTypes;
		[Static]
		[Export("enabledAttachmentTypes", ArgumentSemantic.Assign)]
		IBGAttachmentType EnabledAttachmentTypes { get; set; }

		// +(void)showWithReportType:(enum IBGBugReportingReportType)reportType reportType:(enum IBGBugReportingOption)reportOption;
		[Static]
		[Export("showWithReportType:reportType:")]
		void ShowWithReportType(IBGBugReportingReportType reportType, IBGBugReportingOption reportOption);
	}

	// @interface CrashReporting : NSObject
	[BaseType(typeof(NSObject))]
	interface CrashReporting
	{
		// @property (nonatomic, class) BOOL enabled;
		[Static]
		[Export("enabled")]
		bool Enabled { get; set; }
	}

	// @interface IBGLogger : NSObject
	[BaseType(typeof(NSObject))]
	interface IBGLogger
	{
		// +(void)logInfoWithText:(NSString * _Nonnull)text;
		[Static]
		[Export("logInfoWithText:")]
		void LogInfoWithText(string text);

		// +(void)logErrorWithText:(NSString * _Nonnull)text;
		[Static]
		[Export("logErrorWithText:")]
		void LogErrorWithText(string text);
	}

	// @interface InstabugSdk : NSObject
	[BaseType(typeof(NSObject))]
	interface InstabugSdk
	{
		// @property (nonatomic, class) BOOL trackUserSteps;
		[Static]
		[Export("trackUserSteps")]
		bool TrackUserSteps { get; set; }

		// @property (nonatomic, class) enum IBGWelcomeMessageMode welcomeMessageMode;
		[Static]
		[Export("welcomeMessageMode", ArgumentSemantic.Assign)]
		IBGWelcomeMessageMode WelcomeMessageMode { get; set; }

		// @property (nonatomic, class) BOOL shouldCaptureViewHierarchy;
		[Static]
		[Export("shouldCaptureViewHierarchy")]
		bool ShouldCaptureViewHierarchy { get; set; }

		// +(void)setReproStepsFor:(enum IBGIssueType)issueType issueType:(enum IBGUserStepsMode)reproStepsMode;
		[Static]
		[Export("setReproStepsFor:issueType:")]
		void SetReproStepsFor(IBGIssueType issueType, IBGUserStepsMode reproStepsMode);

		// +(void)setColorTheme:(enum IBGColorTheme)ibgColorTheme;
		[Static]
		[Export("setColorTheme:")]
		void SetColorTheme(IBGColorTheme ibgColorTheme);

		// +(void)start:(NSString * _Nonnull)token token:(enum IBGInvocationEvent)invocationEvents;
		[Static]
		[Export("start:token:")]
		void Start(string token, IBGInvocationEvent invocationEvents);

		// +(void)setLocale:(enum IBGLocale)locale;
		[Static]
		[Export("setLocale:")]
		void SetLocale(IBGLocale locale);

		// +(void)show;
		[Static]
		[Export("show")]
		void Show();
	}
}