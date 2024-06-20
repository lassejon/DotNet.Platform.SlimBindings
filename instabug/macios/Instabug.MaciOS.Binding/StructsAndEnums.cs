using ObjCRuntime;

namespace Instabug.MaciOS.Binding
{
    [Native]
    public enum IBGAttachmentType : long
    {
        ScreenShot = 2,
        ExtraScreenShot = 4,
        GalleryImage = 16,
        ScreenRecording = 64
    }

    [Native]
    public enum IBGBugReportingOption : long
    {
        EmailFieldHidden = 1,
        EmailFieldOptional = 2,
        CommentFieldRequired = 4,
        DisablePostSendingDialog = 8,
        None = 16
    }

    [Native]
    public enum IBGBugReportingReportType : long
    {
        Bug = 1,
        Feedback = 2,
        Question = 4
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
        Cancel = 1,
        AddAttachment = 2
    }

    [Native]
    public enum IBGInvocationEvent : long
    {
        Shake = 1,
        Screenshot = 2,
        TwoFingersSwipeLeft = 4,
        RightEdgePan = 8,
        FloatingButton = 16,
        None = 32
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
        Bug = 1,
        Feedback = 2,
        Question = 4,
        Other = 8
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
        Live = 0,
        Beta = 1,
        Disabled = 2
    }
}
