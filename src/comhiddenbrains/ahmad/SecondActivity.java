package comhiddenbrains.ahmad;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

 
public class SecondActivity extends Activity {

	Button btn1, btn2, btn3, btn4;
	public LinearLayout middle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Gallery gallery = (Gallery) findViewById(R.id.mygallery);
        gallery.setAdapter(new ImageAdapter(SecondActivity.this));
        gallery.setSpacing(10);
        gallery.setSelection((Integer.MAX_VALUE/2) - (Integer.MAX_VALUE/2) % 5 );

       gallery.setOnItemLongClickListener(longClickListener);
      
}

private OnItemLongClickListener longClickListener = new OnItemLongClickListener() {
        public boolean onItemLongClick(AdapterView<?> parent, View v, int position,
                        long id) {
                String temp = "Hello World!";
                Toast toast = Toast.makeText(getBaseContext(), "Posituoin is "+id, Toast.LENGTH_SHORT);
                toast.show();
                return true;
        }
};

public class ImageAdapter extends BaseAdapter {
        private LayoutInflater inflater = null;

        private final Integer[] imageDataList = { R.drawable.a, R.drawable.b,
                        R.drawable.c, R.drawable.d, R.drawable.a };

        public ImageAdapter(Context c) {
                inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount() {
                if (imageDataList != null) {
                        return Integer.MAX_VALUE;
                } else {
                        return 0;
                }
        }

        public Object getItem(int position) {
                if(position >= imageDataList.length) {
                        position = position % imageDataList.length;
                }
                
                return position;
        }

        public long getItemId(int position) {
                if(position >= imageDataList.length) {
                        position = position % imageDataList.length;
                }
                return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
                View view = convertView;

                if (view == null) {
                        view = inflater.inflate(R.layout.ff, parent, false);
                }

                if(position >= imageDataList.length) {
                        position = position % imageDataList.length;
                }
                
                ((ImageView) view).setImageResource(imageDataList[position]);
                return view;
        }
        
        public int checkPosition(int position) {
                if(position >= imageDataList.length) {
                        position = position % imageDataList.length;
                }
                
                return position;
        }
}


}
