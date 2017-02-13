#ifndef SAMPLEINFOMARSHALLER_H
#define SAMPLEINFOMARSHALLER_H

#include <fastrtps/rtps/common/Types.h>
#include <cstring>


namespace us{
namespace ihmc{
namespace rtps{
namespace impl{
namespace fastRTPS{
    class SampleInfoMarshaller
    {
    public:

        bool updateKey;

        int16_t encapsulation;
        int32_t dataLength;

        int32_t changeKind;
        int32_t ownershipStrength;

        int32_t time_seconds;
        int64_t time_fraction;

        unsigned char instanceHandle_value[16];

        int64_t sampleIdentity_GuidHigh;
        int64_t sampleIdentity_GuidLow;
        int32_t sampleIdentity_sequenceNumberHigh;
        int64_t sampleIdentity_sequenceNumberLow;

        int64_t relatedSampleIdentity_GuidHigh;
        int64_t relatedSampleIdentity_GuidLow;
        int32_t relatedSampleIdentity_sequenceNumberHigh;
        int64_t relatedSampleIdentity_sequenceNumberLow;

        void getInstanceHandleValue(unsigned char* dest)
        {
            memcpy(dest, instanceHandle_value, 16);
        }

    };

}}}}}
#endif // SAMPLEINFOMARSHALLER_H

