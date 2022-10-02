package com.epam.training.student_anton_marhol.framework_practical_task.model;

import java.util.Objects;

public class Instances {

    private String numberOfInstances;
    private String operatingSystemOrSoftware;
    private String provisioningModel;
    private String machineSeries;
    private String machineType;
    private String addGPU;
    private String typeOfGPU;
    private String numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;
    private String committedUsagePeriod;

    public Instances(String numberOfInstances, String operatingSystemOrSoftware
            , String provisioningModel, String machineSeries, String machineType
            , String addGPU, String typeOfGPU, String numberOfGPUs, String localSSD
            , String datacenterLocation, String commitedUsage, String commitedUsagePeriod) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemOrSoftware = operatingSystemOrSoftware;
        this.provisioningModel = provisioningModel;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.addGPU = addGPU;
        this.typeOfGPU = typeOfGPU;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = commitedUsage;
        this.committedUsagePeriod = commitedUsagePeriod;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystemOrSoftware() { return (operatingSystemOrSoftware); }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getAddGPU() { return addGPU; }

    public String getTypeOfGPU() {
        return typeOfGPU;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String getCommittedUsagePeriod() { return committedUsagePeriod; }

    @Override
    public String toString() {
        return "Instances{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystemOrSoftware='" + operatingSystemOrSoftware + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", machineSeries='" + machineSeries + '\'' +
                ", machineType='" + machineType + '\'' +
                ", addGPU=" + addGPU +
                ", typeOfGPU='" + typeOfGPU + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", commitedUsagePeriod='" + committedUsage + '\'' +
                ", commitedUsagePeriod='" + committedUsagePeriod + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instances instances = (Instances) o;
        return numberOfInstances.equals(instances.numberOfInstances) &&
                operatingSystemOrSoftware.equals(instances.operatingSystemOrSoftware) &&
                provisioningModel.equals(instances.provisioningModel) &&
                machineSeries.equals(instances.machineSeries) &&
                machineType.equals(instances.machineType) &&
                localSSD.equals(instances.localSSD) &&
                datacenterLocation.equals(instances.datacenterLocation) &&
                committedUsage.equals(instances.committedUsagePeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, machineSeries, typeOfGPU, numberOfGPUs, localSSD, datacenterLocation, committedUsagePeriod);
    }
}
