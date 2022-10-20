/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
#ifndef COMMONFUNCTIONS_H
#define COMMONFUNCTIONS_H

#include <fastdds/rtps/common/Guid.h>
#include <fastdds/rtps/common/Types.h>
#include <fastdds/rtps/common/InstanceHandle.h>

namespace us {
namespace ihmc {
namespace rtps {
namespace impl {
namespace fastDDS {
    union GuidUnion
    {

        struct
        {
            int64_t high;
            int64_t low;
        } primitive;

        eprosima::fastrtps::rtps::octet guid[eprosima::fastrtps::rtps::GuidPrefix_t::size + eprosima::fastrtps::rtps::EntityId_t::size];

    };

    class CommonFunctions
    {
    public:
        static void guidcpy(const eprosima::fastrtps::rtps::GUID_t &src, GuidUnion *dest)
        {
            for(int g_c = 0; g_c < eprosima::fastrtps::rtps::GuidPrefix_t::size; g_c++)
            {
                dest->guid[g_c] = src.guidPrefix.value[g_c];
            }

            for(int g_c = 0; g_c < eprosima::fastrtps::rtps::EntityId_t::size; g_c++)
            {
                dest->guid[eprosima::fastrtps::rtps::GuidPrefix_t::size + g_c] = src.entityId.value[g_c];
            }
        }

        static void guidcpy(const InstanceHandle_t &src, GuidUnion *dest)
        {
            for(int g_c = 0; g_c < eprosima::fastrtps::rtps::GuidPrefix_t::size + eprosima::fastrtps::rtps::EntityId_t::size; g_c++)
            {
                dest->guid[g_c] = src.value[g_c];
            }
        }
    };
}}}}}
#endif // COMMONFUNCTIONS_H
