package com.blog.melo.buzzerbeater.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.blog.melo.buzzerbeater.R;
import com.blog.melo.buzzerbeater.fragment.BaseDialogFragment;
import com.blog.melo.buzzerbeater.fragment.BaseFragment;
import com.blog.melo.buzzerbeater.fragment.BlankFragment;
import com.blog.melo.buzzerbeater.fragment.CarFragment;
import com.blog.melo.buzzerbeater.fragment.CommonDialog;
import com.blog.melo.buzzerbeater.fragment.MusicFragment;
import com.blog.melo.buzzerbeater.fragment.SearchFragment;
import com.blog.melo.buzzerbeater.fragment.SettingFragment;
import com.blog.melo.buzzerbeater.listener.PermissionsResultListener;
import com.blog.melo.buzzerbeater.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener, Toolbar.OnMenuItemClickListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottomNavigation;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.tv_toolbar_right)
    TextView tvToolbarRight;


    private SearchFragment searchFragment;
    private MusicFragment musicFragment;
    private CarFragment carFragment;
    private SettingFragment settingFragment;
    private BlankFragment blankFragment;

    private static final String TAG = "MainActivity";

    private static final int PER_REQUEST_CODE = 1;

    @Override
    protected void initIntentParam(Intent intent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
        initView();
        initData();
        initListener();
    }

    private void initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(this);
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

            getSupportFragmentManager().beginTransaction().add(R.id.fl_content, searchFragment).commitAllowingStateLoss();

        } else {
            getSupportFragmentManager().beginTransaction().show(searchFragment).commitAllowingStateLoss();
        }

        currentFragment = searchFragment;
        tvToolbarTitle.setText(getString(R.string.tab_1));
    }

    private void initListener() {
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                Log.d(TAG, "onTabSelected: position:" + position + ",wasSelected:" + wasSelected);

                if (position == 0) {// 导航
                    clickSearchLayout();
                } else if (position == 1) {// 音乐
                    clickMusicLayout();
                } else if (position == 2) {// OBD
                    clickCarLayout();
                } else if (position == 3) {
                    clickSettingLayout();
                } else if (position == 4) {
                    clickToysLayout();
                }
                return true;
            }
        });

        toolbar.setOnMenuItemClickListener(this);
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
    public void onFragmentInteraction(Bundle bundle) {
        Log.e(TAG, "onFragmentInteraction: " + bundle.getString("BlankFragment"));
    }

    @OnClick(R.id.tv_toolbar_right)
    public void onClick() {

    }

    @Override
    protected void setToolbarStyle() {
        super.setToolbarStyle();
        if (currentFragment instanceof SearchFragment) {
            tvToolbarTitle.setText(getString(R.string.tab_1));
        } else if (currentFragment instanceof MusicFragment) {
            tvToolbarTitle.setText(getString(R.string.tab_2));
        } else if (currentFragment instanceof CarFragment) {
            tvToolbarTitle.setText(getString(R.string.tab_3));
        } else if (currentFragment instanceof SettingFragment) {
            tvToolbarTitle.setText(getString(R.string.tab_4));
        } else if (currentFragment instanceof BlankFragment) {
            tvToolbarTitle.setText(getString(R.string.tab_5));
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                ToastUtils.showShortToast("Settings");
                return true;
            case R.id.action_permissions:
                performRequestPermissions(getString(R.string.permission_desc), new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION}
                        , PER_REQUEST_CODE, new PermissionsResultListener() {
                            @Override
                            public void onPermissionGranted() {
                                ToastUtils.showShortToast("已申请权限");
                            }

                            @Override
                            public void onPermissionDenied() {
                                ToastUtils.showShortToast("拒绝申请权限");
                            }
                        });
                return true;
            case R.id.action_dialog:
                CommonDialog dialog = CommonDialog.newInstance("提示", "这是一个Message~", "确认", "取消", false, new BaseDialogFragment.OnDialogInteraction() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                    @Override
                    public void onConfirm(DialogInterface dialog, int which) {
                        ToastUtils.showShortToast("onConfirm");
                    }

                    @Override
                    public void onCancel(DialogInterface dialog, int which) {
                        ToastUtils.showShortToast("onCancel");
                    }

                });
                dialog.show(getSupportFragmentManager(), TAG);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

