#include "loglevel.h"

#include <fastrtps/log/Log.h>

using namespace eprosima::fastrtps;
using namespace us::ihmc::rtps::impl::fastRTPS;
void LogLevel::setLogLevel(int level)
{
    switch(level)
    {
    case 0:
        eprosima::fastrtps::Log::SetVerbosity(Log::Error);
        break;
    case 1:
        eprosima::fastrtps::Log::SetVerbosity(Log::Warning);
        break;
    case 2:
        eprosima::fastrtps::Log::SetVerbosity(Log::Info);
        break;
    }
}
