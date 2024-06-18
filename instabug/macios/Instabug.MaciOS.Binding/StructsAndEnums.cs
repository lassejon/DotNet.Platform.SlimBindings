using ObjCRuntime;

namespace Instabug.MaciOS.Binding
{
    [Native]
    public enum IBGAttachmentType : long
    {
        ScreenShot = 0,
        ExtraScreenShot = 1,
        GalleryImage = 2,
        ScreenRecording = 3
    }

    [Native]
    public enum IBGBugReportingOption : long
    {
        EmailFieldHidden = 0,
        EmailFieldOptional = 1,
        CommentFieldRequired = 2,
        DisablePostSendingDialog = 3
    }

    [Native]
    public enum IBGBugReportingReportType : long
    {
        Bug = 0,
        Feedback = 1,
        Question = 2
    }

    [Native]
    public enum IBGColorTheme : long
    {
        Light = 0,
        Dark = 1
    }

    [Native]
    public enum IBGDismissType : long
    {
        Submit = 0,
        Cancel = 1
    }

    [Native]
    public enum IBGInvocationEvent : long
    {
        Shake = 0,
        Screenshot = 1,
        TwoFingersSwipeLeft = 2,
        RightEdgePan = 3,
        FloatingButton = 4,
        None = 5
    }

    [Native]
    public enum IBGLocale : long
    {
        Arabic = 0,
        Azerbaijani = 1,
        Catalan = 2,
        CatalanSpain = 3,
        ChineseSimplified = 4,
        ChineseTaiwan = 5,
        ChineseTraditional = 6,
        Czech = 7,
        Danish = 8,
        Dutch = 9,
        English = 10,
        French = 11,
        German = 12,
        Italian = 13,
        Japanese = 14,
        Korean = 15,
        Norwegian = 16,
        Polish = 17,
        Portuguese = 18,
        PortugueseBrazil = 19,
        Russian = 20,
        Slovak = 21,
        Spanish = 22,
        Swedish = 23,
        Turkish = 24,
        Hungarian = 25,
        Finnish = 26
    }

    [Native]
    public enum IBGReportType : long
    {
        Bug = 0,
        Feedback = 1,
        Question = 2,
        Other = 3
    }

    [Native]
    public enum IBGUserStepsMode : long
    {
        Enable = 0,
        EnabledWithNoScreenshots = 1,
        Disable = 2
    }

    [Native]
    public enum IBGWelcomeMessageMode : long
    {
        Beta = 0,
        Live = 1,
        Disabled = 2
    }
}
