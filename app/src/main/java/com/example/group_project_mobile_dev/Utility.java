package com.example.group_project_mobile_dev;

public class Utility {
    int accNo;
    String type;
    double billAmt;
    int img;




    public Utility(int accNo, String type, int billAmt, int img) {
        this.accNo = accNo;
        this.type = type;
        this.billAmt = billAmt;
        this.img = img;
    }



    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBillAmt() {
        return billAmt;
    }

    public void setBillAmt(double billAmt) {
        this.billAmt = billAmt;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


}
