# Share Button

## MainActivity.java

```xml
@Override
    public void onBackPressed(){
        final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Çıkış Yapmak İstiyor Musunuz?");
        builder.setCancelable(true);
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }

```
