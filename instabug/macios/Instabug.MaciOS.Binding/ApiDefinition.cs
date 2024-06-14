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

	// @interface InstabugSdk : NSObject
	[BaseType(typeof(NSObject))]
	interface InstabugSdk
	{
		// @property (nonatomic, class) BOOL trackUserSteps;
		[Static]
		[Export("trackUserSteps")]
		bool TrackUserSteps { get; set; }

		// @property (nonatomic, class) enum IBGUserStepsMode reproStepsMode;
		[Static]
		[Export("reproStepsMode", ArgumentSemantic.Assign)]
		IBGUserStepsMode ReproStepsMode { get; set; }

		// @property (nonatomic, class) BOOL shouldCaptureViewHierarch;
		[Static]
		[Export("shouldCaptureViewHierarch")]
		bool ShouldCaptureViewHierarch { get; set; }

		// +(void)setColorThemeWithIbgColorTheme:(enum IBGColorTheme)ibgColorTheme;
		[Static]
		[Export("setColorThemeWithIbgColorTheme:")]
		void SetColorThemeWithIbgColorTheme(IBGColorTheme ibgColorTheme);

		// +(void)startWithToken:(NSString * _Nonnull)token invocationEvents:(enum IBGInvocationEvent)invocationEvents;
		[Static]
		[Export("startWithToken:invocationEvents:")]
		void StartWithToken(string token, IBGInvocationEvent invocationEvents);

		// +(void)setLocaleWithLocale:(enum IBGLocale)locale;
		[Static]
		[Export("setLocaleWithLocale:")]
		void SetLocaleWithLocale(IBGLocale locale);

		// +(void)show;
		[Static]
		[Export("show")]
		void Show();
	}
}
