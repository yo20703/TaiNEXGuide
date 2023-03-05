package com.ukn.edu.tainex;


import java.util.ArrayList;
import java.util.List;

public class Exhibit {
    private static Exhibit instance;
    private static List<ExhibitData> exhibits;

    public static Exhibit getInstance(){
        synchronized (Exhibit.class){
            if(instance == null){
                instance = new Exhibit();
                initCardList();
            }

            return instance;
        }
    }

    public List<ExhibitData> getExhibits() {
        return exhibits;
    }

    private static void initCardList(){
        exhibits = new ArrayList<>();
        exhibits.add(new ExhibitData(
                R.drawable.exhibit1,
                "2023 03/06(一)-11(六)",
                "2023年台北國際工具機展",
                "地點 : 一樓展場 四樓展場")
        );

        exhibits.add(new ExhibitData(
                R.drawable.exhibit2,
                "2023 03/22(三)-25(六)",
                "2023年TaiSPO台灣國際運動及健身展",
                "地點 : 一樓展場")
        );

        exhibits.add(new ExhibitData(
                R.drawable.exhibit3,
                "2023 03/28(二)-31(五)",
                "智慧城市展",
                "地點 : 一樓展場")
        );
    }

}