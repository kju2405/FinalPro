package com.example.finalpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment_menu extends Fragment {
    public Fragment_menu(){

    }

    ArrayList<ChickenMenu> chickenMenus;
    ListView customListView;
    private static MenuCustumAdapter customAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_menu,container,false);

        chickenMenus=new ArrayList<>();
        chickenMenus.add(new ChickenMenu(R.drawable.gold,"황금 치킨","20,000"));
        chickenMenus.add(new ChickenMenu(R.drawable.fried,"후라이드 치킨","20,000"));
        chickenMenus.add(new ChickenMenu(R.drawable.galic,"갈릭 치킨","23,000"));
        chickenMenus.add(new ChickenMenu(R.drawable.mayonas,"마요네즈 치킨","18,000"));
        chickenMenus.add(new ChickenMenu(R.drawable.soybean,"간장 치킨","20,000"));
        chickenMenus.add(new ChickenMenu(R.drawable.tanduri,"탄두리 치킨","19,000"));
        chickenMenus.add(new ChickenMenu(R.drawable.yangnum,"양념 치킨","18,000"));

        customListView = (ListView) rootView.findViewById(R.id.listMenu);
        customAdapter = new MenuCustumAdapter(getContext(),chickenMenus);
        customListView.setAdapter(customAdapter);
        return rootView;
    }

    class ChickenMenu{
        private int chickenMenuImg;
        private String menuName;
        private String chickenPrice;

        public String getChickenPrice() {
            return chickenPrice;
        }

        public void setChickenPrice(String chickenPrice) {
            this.chickenPrice = chickenPrice;
        }

        public ChickenMenu(int chickenMenuImgmg, String menuName, String chickenPrice){
            this.chickenMenuImg=chickenMenuImgmg;
            this.menuName=menuName;
            this.chickenPrice=chickenPrice;
        }

        public int getChickenMenuImg() {
            return chickenMenuImg;
        }

        public void setChickenMenuImg(int chickenMenuImg) {
            this.chickenMenuImg = chickenMenuImg;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }
    }
}
