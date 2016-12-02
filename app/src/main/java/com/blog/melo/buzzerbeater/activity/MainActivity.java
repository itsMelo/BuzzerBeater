package com.blog.melo.buzzerbeater.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.blog.melo.buzzerbeater.R;
import com.blog.melo.buzzerbeater.fragment.BlankFragment;
import com.blog.melo.buzzerbeater.fragment.CarFragment;
import com.blog.melo.buzzerbeater.fragment.MusicFragment;
import com.blog.melo.buzzerbeater.fragment.SearchFragment;
import com.blog.melo.buzzerbeater.fragment.SettingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BlankFragment.OnFragmentInteractionListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottomNavigation;


    private SearchFragment searchFragment;
    private MusicFragment musicFragment;
    private CarFragment carFragment;
    private SettingFragment settingFragment;
    private BlankFragment blankFragment;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initView();
        initData();
        initListener();
    }


    private void initView() {
        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(getResources().getString(R.string.tab_1), R.drawable.ic_bottom_navigation);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(getResources().getString(R.string.tab_2), R.drawable.ic_bottom_music);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(getResources().getString(R.string.tab_3), R.drawable.ic_bottom_car);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(getResources().getString(R.string.tab_4), R.drawable.ic_bottom_setting);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem(getResources().getString(R.string.tab_5), R.drawable.ic_bottom_toys);
        // Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);
        bottomNavigation.addItem(item5);

        // 默认背景颜色
        bottomNavigation.setDefaultBackgroundColor(ContextCompat.getColor(this, R.color.bg_bottom_navigation));
        // 切换时颜色的转变
        bottomNavigation.setAccentColor(ContextCompat.getColor(this, R.color.accent_bottom_navigation));
        bottomNavigation.setInactiveColor(ContextCompat.getColor(this, R.color.inactive_bottom_navigation));
        // 强制着色
        bottomNavigation.setForceTint(true);
        // 强制展示标题
        bottomNavigation.setForceTitlesDisplay(true);
        // 使用圆圈效果
        bottomNavigation.setColored(false);
        // Set current item programmatically
        bottomNavigation.setCurrentItem(0);
    }

    private void initData() {
        if (searchFragment == null) {
            searchFragment = SearchFragment.newInstance(getString(R.string.tab_1));
        }

        if (!searchFragment.isAdded()) {
            // 提交事务
            getSupportFragmentManager().beginTransaction().add(R.id.fl_content, searchFragment).commit();

            // 记录当前Fragment
            currentFragment = searchFragment;
        }
    }

    private void initListener() {
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                Log.d(TAG, "onTabSelected: position:" + position + ",wasSelected:" + wasSelected);

                if (position == 0) {// 导航
                    clickSearchLayout();
                }
                if (position == 1) {// 音乐
                    clickMusicLayout();
                }
                if (position == 2) {// OBD
                    clickCarLayout();
                }
                if (position == 3) {
                    clickSettingLayout();
                }
                if (position == 4) {
                    clickToysLayout();
                }
                return true;
            }
        });
    }

    private void clickSearchLayout() {
        if (searchFragment == null) {
            searchFragment = SearchFragment.newInstance(getString(R.string.tab_1));
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), searchFragment);
    }

    private void clickMusicLayout() {
        if (musicFragment == null) {
            musicFragment = MusicFragment.newInstance(getString(R.string.tab_2));
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), musicFragment);
    }

    private void clickCarLayout() {
        if (carFragment == null) {
            carFragment = CarFragment.newInstance(getString(R.string.tab_3));
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), carFragment);
    }

    private void clickSettingLayout() {
        if (settingFragment == null) {
            settingFragment = SettingFragment.newInstance(getString(R.string.tab_4));
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), settingFragment);
    }

    private void clickToysLayout() {
        if (blankFragment == null) {
            blankFragment = BlankFragment.newInstance(getString(R.string.tab_5), "玩乐");
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), blankFragment);
    }

    @Override
    public void onFragmentInteraction(String message) {
        Log.e(TAG, "onFragmentInteraction: " + message);
    }
}

