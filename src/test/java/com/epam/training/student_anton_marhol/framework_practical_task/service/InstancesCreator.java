package com.epam.training.student_anton_marhol.framework_practical_task.service;

import com.epam.training.student_anton_marhol.framework_practical_task.model.Instances;

public class InstancesCreator {

    public static final String NUMBER_OF_INSTANCES = "testdata.numberOfInstances";
    public static final String OPERATING_SYSTEM_OR_SOFTWARE = "testdata.operatingSystemOrSoftware";
    public static final String PROVISIONING_MODEL = "testdata.provisioningModel";
    public static final String MACHINE_SERIES = "testdata.machineSeries";
    public static final String MACHINE_TYPE = "testdata.machineType";
    public static final String CHEXBOX_ADD_GPU = "testdata.addGPU";
    public static final String TYPE_OF_GPU = "testdata.typeOfGPU";
    public static final String NUMBER_OF_GPUS = "testdata.numberOfGPUs";
    public static final String LOCAL_SSD = "testdata.localSSD";
    public static final String DATACENTER_LOCATION = "testdata.datacenterLocation";
    public static final String COMMITTED_USAGE = "testdata.commitedUsage";
    public static final String COMMITTED_USAGE_PERIOD = "testdata.commitedUsagePeriod";

    public static Instances withCredentialsFromProperties(){
        return new Instances (InstancesReader.getInstances(NUMBER_OF_INSTANCES),
                InstancesReader.getInstances(OPERATING_SYSTEM_OR_SOFTWARE),
                InstancesReader.getInstances(PROVISIONING_MODEL),
                InstancesReader.getInstances(MACHINE_SERIES),
                InstancesReader.getInstances(MACHINE_TYPE),
                InstancesReader.getInstances(CHEXBOX_ADD_GPU),
                InstancesReader.getInstances(TYPE_OF_GPU),
                InstancesReader.getInstances(NUMBER_OF_GPUS),
                InstancesReader.getInstances(LOCAL_SSD),
                InstancesReader.getInstances(DATACENTER_LOCATION),
                InstancesReader.getInstances(COMMITTED_USAGE),
                InstancesReader.getInstances(COMMITTED_USAGE_PERIOD));
    }
}
