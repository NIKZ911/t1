package com.t1;



public class docmodel {

    private String image,patientxp,Name,Reveiw,timing,uid,latitude,longitude,address;
    private Long consultationfees;

    public docmodel(String dimage,String dpatientxp,String dname,String dReveiw,Long dconsultationfees,
                    String dtiming,String uid,String latitude,String longitude,String address)
    {
        this.uid = uid;
        this.image = dimage;
        this.patientxp = dpatientxp;
        this.Name = dname;
        this.Reveiw = dReveiw;
        this.consultationfees = dconsultationfees;
        this.timing = dtiming;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUid() { return uid; }

    public String getTiming() {return timing; }

    public String getImage() {
        return image;
    }

    public String getName() {
        return Name;
    }

    public String getPatientxp() {
        return patientxp;
    }

    public Long getConsultationfees() { return consultationfees; }

    public String getReveiw() { return Reveiw; }


    public void setUid(String uid) { this.uid = uid; }

    public void setTiming(String timing){ this.timing = timing;}

    public void setPatientxp(String patientxp) {
        this.patientxp = patientxp;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setReveiw(String reveiw) {
        Reveiw = reveiw;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setConsultationfees(Long consultationfees) {
        this.consultationfees = consultationfees;
    }
}
