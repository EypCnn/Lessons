# Snackbar

## build.gradle
```xml
implementation 'com.android.support:design:26.1.0'

```
## activity_main.xml

```xml
<Button
        android:layout_gravity="center"
        android:id="@+id/snackbarr"
        android:text="Snackbar Göster"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

```

## MainActivity.java

```xml
Button snack = (Button) findViewById(R.id.snackbarr);
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Snackbar EypCnn", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

```