using Foundation;
using ObjCRuntime;

namespace Instabug.MaciOS.Binding
{
    [Native]
    public enum IBGInvocationEventWrapper : long
    {
        Shake = 0,
        Screenshot = 1,
        TwoFingersSwipeLeft = 2,
        RightEdgePan = 3,
        FloatingButton = 4,
        None = 5
    }
}