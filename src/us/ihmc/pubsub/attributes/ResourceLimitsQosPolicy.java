package us.ihmc.pubsub.attributes;

/**
 * Class ResourceLimitsQosPolicy, defines the ResourceLimits for the Writer or the Reader.
 * max_samples: Default value 5000.
 * max_instances: Default value 10.
 * max_samples_per_instance: Default value 400.
 * allocated_samples: Default value 100.
 */
public class ResourceLimitsQosPolicy extends QosPolicy
{

   private int maxSamples = 5000;
   private int max_instances = 10;
   private int max_samples_per_instance = 400;
   private int allocated_samples = 100;
   
   public ResourceLimitsQosPolicy()
   {
      super(false);
   }

   public int getMaxSamples()
   {
      return maxSamples;
   }

   public void setMaxSamples(int maxSamples)
   {
      this.maxSamples = maxSamples;
   }

   public int getMax_instances()
   {
      return max_instances;
   }

   public void setMax_instances(int max_instances)
   {
      this.max_instances = max_instances;
   }

   public int getMax_samples_per_instance()
   {
      return max_samples_per_instance;
   }

   public void setMax_samples_per_instance(int max_samples_per_instance)
   {
      this.max_samples_per_instance = max_samples_per_instance;
   }

   public int getAllocated_samples()
   {
      return allocated_samples;
   }

   public void setAllocated_samples(int allocated_samples)
   {
      this.allocated_samples = allocated_samples;
   }
   
   

}
