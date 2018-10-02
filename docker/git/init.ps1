if(!(Test-Path -Path "$pwd/tmp")){
    New-Item -ItemType directory -Path "$pwd/tmp"
}
docker build -t portepoisse/git .
