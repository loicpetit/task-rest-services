# registry api : https://docs.docker.com/registry/spec/api
(curl http://localhost:5000/v2/_catalog).Content | ConvertFrom-Json | ConvertTo-Json
