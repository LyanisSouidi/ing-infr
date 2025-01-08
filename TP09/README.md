# Réponses 

# Exercice 1

- Serveur qui écoute sur le port 2023 : [Server.java](./Server.java)
- Client qui parle sur le port 2023 : [Client.java](./Client.java)

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
#iptables --list
iptables -L

# Nom des interfaces réseaux
#ip link
ip l
```

- Script bash de configuration du firewall : [firewall.sh](./firewall.sh)

