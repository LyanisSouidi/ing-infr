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

# Vider les chaînes de la table filter
iptables --flush

# Autoriser le trafic entrant ssh
iptables --append INPUT --protocol tcp --destination-port 22 --jump ACCEPT

# Rejeter tout le trafic entrant sur l'interface externe
iptables --append INPUT --in-interface ens160 --jump DROP

# Autoriser le trafic entrant en loopback
iptables --append INPUT --in-interface lo --jump ACCEPT

# Autoriser les communications TCP en provenance de 172.31.250.166
iptables --insert INPUT 2 --protocol tcp --source 172.31.250.166 --jump ACCEPT

# Autoriser les communications TCP entrantes sur le port 2023
iptables --insert INPUT 3 --protocol tcp --destination-port 2023 --jump ACCEPT

# Accepter les demandes de ping entrantes
iptables --insert INPUT 4 --protocol icmp --icmp-type echo-request --jump ACCEPT

# Accepter les paquets entrants correspondant à des connexions établies ou associées
iptables --insert INPUT 5 --match state --state RELATED,ESTABLISHED
```

