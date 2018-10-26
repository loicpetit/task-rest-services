Remove-Item "$pwd\data" -Force -Recurse
New-Item -ItemType directory -Path "$pwd\data"
