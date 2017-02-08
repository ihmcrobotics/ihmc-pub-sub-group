#ifndef PUBLISHERHISTORY_H
#define PUBLISHERHISTORY_H

#include <fastrtps/rtps/resources/ResourceManagement.h>
#include <fastrtps/rtps/history/WriterHistory.h>
#include <fastrtps/qos/QosPolicies.h>
#include "fastrtpsexception.h"

using namespace eprosima::fastrtps;
using namespace eprosima::fastrtps::rtps;

class NativePublisherImpl;

class NativePublisherHistory:public WriterHistory
{
public:
    typedef std::pair<InstanceHandle_t,std::vector<CacheChange_t*>> t_p_I_Change;
    typedef std::vector<t_p_I_Change> t_v_Inst_Caches;
    /**
    * Constructor of the PublisherHistory.
    * @param pimpl Pointer to the PublisherImpl.
    * @param payloadInitialSize Initial payload size.
    * @param mempolicy Set wether the payloads ccan dynamically resized or not.
    * @param history QOS of the associated History.
    * @param resource ResourceLimits for the History.
    */

    NativePublisherHistory(NativePublisherImpl* pimpl,int32_t payloadMax,
            HistoryQosPolicy& history,ResourceLimitsQosPolicy& resource,MemoryManagementPolicy_t mempolicy);

    virtual ~NativePublisherHistory();

    /**
    * Add a change comming from the Publisher.
    * @param change Pointer to the change
    * @param wparams Extra write parameters.
    * @param wparams
    * @return True if added.
    */
    bool add_pub_change(CacheChange_t* change) throw(FastRTPSException);//, WriteParams &wparams);

    /**
    * Remove all change from the associated history.
    * @param removed Number of elements removed.
    * @return True if all elements were removed.
    */
    bool removeAllChange(size_t* removed);

    /**
    * Remove the change with the minimum sequence Number.
    * @return True if removed.
    */
    bool removeMinChange();

    /**
    * Remove a change by the publisher History.
    * @param change Pointer to the CacheChange_t.
    * @param vit Pointer to the iterator of the Keyed history vector.
    * @return True if removed.
    */
    bool remove_change_pub(CacheChange_t* change,t_v_Inst_Caches::iterator* vit=nullptr);

    virtual bool remove_change_g(CacheChange_t* a_change);

private:
    //!Vector of pointer to the CacheChange_t divided by key.
    t_v_Inst_Caches m_keyedChanges;
    //!HistoryQosPolicy values.
    HistoryQosPolicy m_historyQos;
    //!ResourceLimitsQosPolicy values.
    ResourceLimitsQosPolicy m_resourceLimitsQos;
    //!Publisher Pointer
    NativePublisherImpl* mp_pubImpl;

    bool find_Key(CacheChange_t* a_change,t_v_Inst_Caches::iterator* vecPairIterrator);
};

#endif // PUBLISHERHISTORY_H
