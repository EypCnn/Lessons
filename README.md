# Share Button

##activity_main.xml
```xml
<Button
        android:id="@+id/paylas"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Share"
        tools:layout_editor_absoluteX="148dp"
        tools:layout_editor_absoluteY="231dp"
        tools:ignore="MissingConstraints" />

		```

##MainActivity.java

```xml
Button eyp;

eyp=(Button)findViewById(R.id.paylas);
        eyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent((Intent.ACTION_SEND));
                myIntent.setType("text/plain");
                String shareBody = "TestApp";
                String shareSub = "EypCnn";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Şununla Paylaş"));
            }
        });		

```
