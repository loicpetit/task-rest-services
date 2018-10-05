# Generer sa clé ssh sur alpine

```
ssh-keygen -t rsa -N "" -f /root/.ssh/id_rsa
```
Les clé se truove dans **/root/.ssh**

# Définir un algorithme spécifique pour un host (dans ce cas le TFS)
Créer / ajouter dans le fichier **config** (dans  **/root/.ssh**) :
```
Host frparenc-tfs.corp.capgemini.com
    Ciphers aes256-cbc
```
Pour générer le fichier :
```
echo -e "Host frparenc-tfs.corp.capgemini.com\n\tCiphers aes256-cbc" > /root/.ssh/config
```
Oblige l'algorithme déprécié (et donc ignoré si non forcé) aes256-cbc car le TFS n'accepte que des algo obsolètes pour l'instant...

# Ajouter un host de confiance
```
ssh -o StrictHostKeyChecking=no frparenc-tfs.corp.capgemini.com
```
Génère le fichier **/root/.ssh/known_hosts**

Le TFS n'est pas bien configuré et l'hôte n'apparaît pas comme un hôte de confiance.

# Image git

Tous les fichiers nécessaires sont monté dans l'image.

Il faut ajouter clé ssh à un profil sur TFS qui a accès au repo.

Les clés RS doit avoir un accès restreint sinon git se plaint.
```
chmod -R 644 /root/.ssh && chmod 600 /root/.ssh/id_rsa
```
