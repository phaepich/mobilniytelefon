package ru.mirea.popov.camera;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ru.mirea.popov.camera.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PERMISSION = 200;
    private Uri imageUri;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView imageView = binding.imageView;

        ActivityResultCallback<ActivityResult> callback = new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    imageView.setImageURI(imageUri);
                }
            }
        };

        ActivityResultLauncher<Intent> cameraActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), callback);

        imageView.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                try {
                    File photoFile = createImageFile();
                    String authorities = getApplicationContext().getPackageName() + ".fileprovider";
                    imageUri = FileProvider.getUriForFile(MainActivity.this, authorities, photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    cameraActivityResultLauncher.launch(cameraIntent);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error creating image file", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date());
        String imageFileName = "IMAGE_" + timeStamp + "_";
        File storageDirectory = getExternalFilesDir(null);
        return File.createTempFile(imageFileName, ".jpg", storageDirectory);
    }
}
