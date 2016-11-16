package com.qf.meituan.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.meituan.R;
import com.qf.meituan.beans.IndianaBean;
import com.qf.meituan.fragments.ShoppingCartFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class ShoppingCartAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    Context context;
    public static int allWoBi = 0;
    List<IndianaBean.DataBean> data;
    public static List<Integer> nums = new ArrayList<>();
    private AlertDialog alertDialog;

    public ShoppingCartAdapter(Context context, List<IndianaBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);


    }


    @Override
    public int getCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.shopping_cart_item, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = ((Holder) convertView.getTag());
        }

        IndianaBean.DataBean dataBean = data.get(position);
        String short_name = dataBean.getShort_name();
        String money = dataBean.getMoney();
        float moneyFloat = Float.parseFloat(money);
        final int moneyInt = (int) moneyFloat;
        String usedcount = dataBean.getUsedcount();
        final int usedcountsInt = Integer.parseInt(usedcount);
        String imgUrl = dataBean.getPhotos();
        holder.info.setText(short_name);
        holder.num.setText("剩余" + (moneyInt - usedcountsInt) + "人次");
        Glide.with(context).load(Uri.parse(imgUrl)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.iv);

        //点击tvadd添加该条商品数量
        tvAddOnClick(position, holder, moneyInt, usedcountsInt);

        //点击minus减少该条商品数量
        minusOnClick(position, holder);


        Integer numPosition = nums.get(position);
        String s = String.valueOf(numPosition);
        holder.et.setText(s);

        //点击扫尾，添加条商品所有可添加数量
        tvTailOnClick(position, holder, moneyInt, usedcountsInt);

        //条目点击弹出删除对话框dialog
        llshopCartItemOnClick(position, holder);


        return convertView;

    }

    private void llshopCartItemOnClick(final int position, final Holder holder) {
        holder.llshopCartItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                View dialogView = LayoutInflater.from(context).inflate(R.layout.shopping_cart_alertdialog, null, false);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                alertDialog = builder.setView(dialogView)
                        .create();
                TextView deleteScale = (TextView) dialogView.findViewById(R.id.deleteScale);
                TextView deleteConfind = (TextView) dialogView.findViewById(R.id.deleteConfind);
                deleteConfind.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String string = holder.et.getText().toString();
                        int etNum = Integer.parseInt(string);
                        allWoBi = allWoBi - etNum;
                        ShoppingCartFragment.tvMoney(allWoBi);
                        data.remove(position);
                        ShoppingCartFragment.deleteItemCountChage();
                        nums.remove(position);
                        notifyDataSetChanged();
                        alertDialog.dismiss();
                        ShoppingCartFragment.isShow -= 1;
                        ShoppingCartFragment.isShow(ShoppingCartFragment.isShow);
                    }
                });
                deleteScale.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
                return true;
            }
        });
    }

    private void tvTailOnClick(final int position, final Holder holder, final int moneyInt, final int usedcountsInt) {
        holder.tvTail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int all = moneyInt - usedcountsInt;
                String allStr = String.valueOf(all);
                Integer integer = Integer.parseInt(allStr);
                nums.set(position, integer);
                String string = holder.et.getText().toString();
                int i = Integer.parseInt(string);
                holder.et.setText(allStr);
                allWoBi += all - i;
                ShoppingCartFragment.tvMoney(allWoBi);
            }
        });
    }

    private void minusOnClick(final int position, Holder holder) {
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nums.get(position) > 1) {
                    Integer integer = nums.get(position);
                    integer--;
                    nums.set(position, integer);
                    allWoBi -= 1;
                    ShoppingCartFragment.tvMoney(allWoBi);
                } else {
                    Toast.makeText(context, "商品数至少为1", Toast.LENGTH_SHORT).show();
                }
                notifyDataSetChanged();
            }
        });
    }

    private void tvAddOnClick(final int position, Holder holder, final int moneyInt, final int usedcountsInt) {
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int all = moneyInt - usedcountsInt;
                String allStr = String.valueOf(all);

                if (nums.get(position) < all) {
                    Integer integer = nums.get(position);
                    integer += 1;
                    nums.set(position, integer);
                    allWoBi += 1;
                    ShoppingCartFragment.tvMoney(allWoBi);
                } else {
                    Toast.makeText(context, "最多只可添加" + (moneyInt - usedcountsInt) + "人次", Toast.LENGTH_SHORT).show();
                }
                notifyDataSetChanged();
            }
        });
    }

    static class Holder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.info)
        TextView info;
        @BindView(R.id.num)
        TextView num;
        @BindView(R.id.minus)
        TextView minus;
        @BindView(R.id.add)
        TextView add;
        @BindView(R.id.tvTail)
        TextView tvTail;
        @BindView(R.id.et)
        EditText et;
        @BindView(R.id.llshopCartItem)
        LinearLayout llshopCartItem;

        Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
