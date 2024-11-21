package com.example.hisaab;


public class FullData {
//    String farmerName, date, troliWeight, factoryRate,
//            totalMoney, labourRate, labourName, labourTotalMoney,
//            vehicle, driverName, vehicleRate, vehicleTotalMoney;



//    String farmerName = "किसान : सौरभ कौरव",
//            date ="दिनांक : 05/01/2022",
//            troliWeight ="शुद्ध वजन : 96.30",
//            factoryRate ="गन्ना रेट : 320.00",
//            totalMoney ="17921.00",
//            labourRate ="लेबर रेट : 37.00",
//            labourName ="लेबर : श्यामलाल",
//            labourTotalMoney = "लेबर रकम : 1201.00",
//            vehicle ="वाहन : ट्रैक्टर",
//            driverName ="चालक का नाम : देवेंद्र कौरव",
//            vehicleRate = "वाहन रेट : 30.00",
//            vehicleTotalMoney = "वाहन रकम : 549.00";

    String farmerName = "किसान : ",
            date ="दिनांक : ",
            troliWeight ="शुद्ध वजन : ",
            factoryRate ="गन्ना रेट : 3",
            totalMoney =" ",
            labourRate ="लेबर रेट : ",
            labourName ="लेबर : ",
            labourTotalMoney = "लेबर रकम : ",
            vehicle ="वाहन : ",
            driverName ="चालक का नाम : ",
            vehicleRate = "वाहन रेट : ",
            vehicleTotalMoney = "वाहन रकम : ";

//    String farmerName = "किसान : सौरभ कौरव", date ="दिनांक : 05/01/2022";

    public FullData(String farmerName, String date, String troliWeight, String factoryRate,
                    String totalMoney, String labourRate, String labourName, String labourTotalMoney,
                    String vehicle, String driverName, String vehicleRate, String vehicleTotalMoney) {

        this.farmerName += farmerName;
        this.date += date;
        this.troliWeight += troliWeight;
        this.factoryRate += factoryRate;
        this.totalMoney += totalMoney;
        this.labourRate += labourRate;
        this.labourName += labourName;
        this.labourTotalMoney += labourTotalMoney;
        this.vehicle += vehicle;
        this.driverName += driverName;
        this.vehicleRate += vehicleRate;
        this.vehicleTotalMoney += vehicleTotalMoney;
    }

//    public FullData(String farmerName, String date) {
//        this.farmerName = farmerName;
//        this.date = date;
//    }

    public FullData() {
    }
}
