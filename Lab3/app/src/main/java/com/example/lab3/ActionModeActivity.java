package com.example.lab3;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActionModeActivity extends AppCompatActivity {
    private ListView listView;
    private List<Item> list;

    private String[] data = {"One", "Two", "Three", "Four", "Five", "Six"};
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);

        listView = findViewById(R.id.mylist);
        list = new ArrayList<Item>();
        for (int i=0; i<6;i++){
            list.add(new Item(data[i],false));
        }

        //对listview进行适配器适配
        adapter = new AdapterCur(list,ActionModeActivity.this);
        listView.setAdapter(adapter);

        //设置listview允许多选模式
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            //选中数量
            int num = 0;
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
                if (b == true){
                    list.get(i).setBo(true);
                    System.out.println(i);
                    //实时刷新
                    adapter.notifyDataSetChanged();
                    num++;
                }else{
                    list.get(i).setBo(false);
                    //实时刷新
                    adapter.notifyDataSetChanged();
                    num--;
                }
                // 用TextView显示
                actionMode.setTitle("  " + num + " Selected");

            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                // 设置长按后所要显示的标题栏的内容
                MenuInflater inflater = actionMode.getMenuInflater();
                inflater.inflate(R.menu.menu_setting_p4,menu);
                num = 0;
                adapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                adapter.notifyDataSetChanged();
                return false;
            }

            public void refresh(){
                for(int i=0; i<data.length;i++){
                    list.get(i).setBo(false);
                }
            }
            /*
             * 可在此方法中监听标题栏Menu的监听，从而进行相应操作
             * 设置actionMode菜单每个按钮的点击事件
             */
            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.delete:
                        num = 0;
                        refresh();
                      //  adapter.notifyDataSetChanged();
                        actionMode.finish();
                        return true;
                    default:
                        refresh();
                        adapter.notifyDataSetChanged();
                        num=0;
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                refresh();
                adapter.notifyDataSetChanged();
            }
        });

    }

}
