package com.dotplays.adapterandroid;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }


    // số lượng item sẽ hiển thị
    @Override
    public int getCount() {
        // so lượng hiển thị = kích thước của mảng
        return students.size();
    }


    // đối tượng được hiện thị trên hàng
    @Override
    public Student getItem(int i) {
        return students.get(i);
    }

    //
    @Override
    public long getItemId(int i) {
        return i;
    }

    // nơi truyền dữ liệu và khai báo giao diện cho dòng trên listview
    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        final Student student = getItem(i);
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
            viewHolder.tvName = view.findViewById(R.id.tvName);
            viewHolder.tvNumber = view.findViewById(R.id.tvNumber);
            Log.e("ABC", "VV " + i);
            viewHolder.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(viewGroup.getContext(), student.name,
                            Toast.LENGTH_SHORT).show();
                }
            });

            viewHolder.tvNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(viewGroup.getContext(), student.number,
                            Toast.LENGTH_SHORT).show();
                }
            });

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvName.setText(student.getName());
        viewHolder.tvNumber.setText(student.getNumber());

        return view;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvNumber;
    }
}
