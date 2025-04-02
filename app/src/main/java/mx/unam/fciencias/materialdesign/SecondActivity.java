package mx.unam.fciencias.materialdesign;

public class SecondActivity {
}
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends AppCompatActivity {

    InfiniteListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = findViewById(R.id.add_to_list_button);
        button.setOnClickListener(this::addListElement);
        RecyclerView infiniteList = findViewById(R.id.infinite_list);
        infiniteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        infiniteList.setLayoutManager(layoutManager);
        listAdapter = new InfiniteListAdapter(getResources());
        addListElement(null);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void addListElement(View button) {
        listAdapter.addItem();
    }
}
