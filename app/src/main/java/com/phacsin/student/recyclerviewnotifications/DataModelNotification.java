package com.phacsin.student.recyclerviewnotifications;

/**
 * Created by Bineesh P Babu on 08-01-2017.
 */

public class DataModelNotification {

    String name;
    String version;
    String date;
            int id_;
            int image;

    public DataModelNotification(String name, String version,String date, int id_, int image) {
            this.name = name;
            this.version = version;
            this.date=date;
            this.id_ = id_;
            this.image=image;
            }

    public String getName() {
            return name;
            }

    public String getVersion() {
            return version;
            }
    public String getdate(){
        return date;
    }

    public int getImage() {
            return image;
            }

    public int getId() {
            return id_;
            }
}
