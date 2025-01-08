# Réponses 

## Exercice 2

```bash
# Autoriser les connexions ssh
ufw allow ssh

# Activer le pare-feu
ufw enable

# Autoriser les communications TCP entrantes vers le port 2023
ufw allow 2023/tcp

# Désactiver le pare-feu
ufw disable
```

## Exercice 3


```bash
# Liste des règles
iptables --list

# Nom des interfaces réseaux
ip link
```

Script : [firewall.sh](./firewall.sh)

