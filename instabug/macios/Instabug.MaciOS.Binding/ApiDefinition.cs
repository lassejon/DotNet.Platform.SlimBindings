using Foundation;

namespace Instabug.MaciOS.Binding
{
	// @interface InstabugSdk : NSObject
	[BaseType(typeof(NSObject))]
	interface InstabugSdk
	{
		// +(void)startWithToken:(NSString * _Nonnull)token invocationEvents:(enum IBGInvocationEventWrapper)invocationEvents;
		[Static]
		[Export("startWithToken:invocationEvents:")]
		void StartWithToken(string token, IBGInvocationEventWrapper invocationEvents);
	}
}
