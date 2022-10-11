package com.epam.training.student_anton_marhol.hardcore.service;

import com.epam.training.student_anton_marhol.hardcore.ui.page.google.GoogleCloudHomePage;
import com.epam.training.student_anton_marhol.hardcore.ui.page.yopmail.YopmailMailPage;
import org.openqa.selenium.WebDriver;

public class FormFiller {

    protected static final String NUMBER_OF_INSTANCES = "4";
    protected static final String OPERATION_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
    protected static final String PROVISIONING_MODEL = "Regular";
    protected static final String MACHINE_SERIES = "N1";
    protected static final String MACHINE_TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    protected static final String GPU_TYPE = "NVIDIA Tesla V100";
    protected static final String NUMBER_OF_GPUs = "1";
    protected static final String LOCAL_SSD_SIZE = "2x375 GB";
    protected static final String DATACENTER_LOCATION = "Frankfurt (europe-west3)";
    protected static final String COMMITMENT_USAGE = "1 Year";

    public static YopmailMailPage fillTheForm (WebDriver driver) {
        return new GoogleCloudHomePage(driver)
                .openPage()
                .searchOnHomePage()
                .lookingForPricingCalculatorInSearchResult()
                .activateTabHolder()
                .selectNumberOfInstances(NUMBER_OF_INSTANCES)
                .openOperationSystemDropDownList()
                .selectOperationSystem(OPERATION_SYSTEM)
                .openProvisioningModelDropDownList()
                .selectProvisioningModel(PROVISIONING_MODEL)
                .openSeriesOfMachineDropDownList()
                .selectSeriesOfMachine(MACHINE_SERIES)
                .openMachineTypeDropDownList()
                .selectMachineType(MACHINE_TYPE)
                .pushOnCheckBox()
                .openTypeOfGPUDropDownList()
                .selectTypeOfGPU(GPU_TYPE)
                .openNumberOfGPUDropDownList()
                .selectNumberOfGPU(NUMBER_OF_GPUs)
                .openLocalSSDDropDownList()
                .selectLocalSSD(LOCAL_SSD_SIZE)
                .openDatacenterLocationDropDownList()
                .selectDatacenterLocation(DATACENTER_LOCATION)
                .openCommittedUsageDropDownList()
                .selectCommittedUsage(COMMITMENT_USAGE)
                .pressTheButtonAddToEstimate()
                .selectOptionSendByEmail()
                .generateMail()
                .copyGeneratedMail()
                .insertMail()
                .clickButtonSendByMail()
                .goToTheMailBox()
                .checkForLetter();
    }
}


