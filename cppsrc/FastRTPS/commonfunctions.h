#ifndef COMMONFUNCTIONS_H
#define COMMONFUNCTIONS_H


#include <fastrtps/rtps/common/Guid.h>
#include <fastrtps/rtps/common/Types.h>
class CommonFunctions
{
public:
    static void guidcpy(GUID_t src, octet *dest)
    {
        for(int g_c = 0; g_c < GuidPrefix_t::size; g_c++)
        {
            dest[g_c] = src.guidPrefix.value[g_c];
        }

        for(int g_c = 0; g_c < EntityId_t::size; g_c++)
        {
            dest[GuidPrefix_t::size + g_c] = src.entityId.value[g_c];
        }
    }
};
#endif // COMMONFUNCTIONS_H
