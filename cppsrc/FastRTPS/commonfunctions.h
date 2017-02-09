#ifndef COMMONFUNCTIONS_H
#define COMMONFUNCTIONS_H


#include <fastrtps/rtps/common/Guid.h>
#include <fastrtps/rtps/common/Types.h>

union GuidUnion
{

    struct
    {
        int64_t high;
        int64_t low;
    } primitive;

    octet guid[GuidPrefix_t::size + EntityId_t::size];

};

class CommonFunctions
{
public:
    static void guidcpy(GUID_t src, GuidUnion *dest)
    {
        for(int g_c = 0; g_c < GuidPrefix_t::size; g_c++)
        {
            dest->guid[g_c] = src.guidPrefix.value[g_c];
        }

        for(int g_c = 0; g_c < EntityId_t::size; g_c++)
        {
            dest->guid[GuidPrefix_t::size + g_c] = src.entityId.value[g_c];
        }
    }
};
#endif // COMMONFUNCTIONS_H
