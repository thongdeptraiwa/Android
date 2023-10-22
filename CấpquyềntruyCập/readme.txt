final int codeL=1;
                if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + String.valueOf(txtPhone.getText().toString())));
                    startActivity(intent);
                } else {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CALL_PHONE)) {
                        Toast.makeText(MainActivity.this, "Ban phai cap quyen cho toi", Toast.LENGTH_SHORT).show();
                    }
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, codeL);
                }
