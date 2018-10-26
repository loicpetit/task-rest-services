$current = $pwd

cd ../springbootadmin
./push-image.ps1

cd ../appdb
./push-image.ps1

cd ../appbase
./push-image.ps1

cd $current
./push-image.ps1
