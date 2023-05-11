1. sqldeveloper -> view (uppper menu) -> ssh
2. ssh hosts (left panel) -> right-click on ssh-hosts -> new ssh host
3.  - name: modbd1
- host: 144.24.161.57
- username: opc
- check 'use key file' -> browse and select: 'ssh-key-2023-05-09.key'
- check 'add a local port forward' -> name: modbd1
  host: instance-20230509-2215.sub04171650120.modbd.oraclevcn.com
  port: 1521
- save

4. right click on ssh host : modbd1 - connect, modbd1 (local port forward) -> connect
5. oracle connections -> new database connection
6. - name: modbd1
- username: modbd_user
- password: modbd2023
- connection type -> ssh
- port forward -> modbd1
- service name : pdb

7. repeat steps 1-6 for modbd2:
   - use modbd2 instead of modbd1
   - same username, pass
   - same ssh key
   - ip: 141.147.18.194
   - host: instance-20230510-1838.sub04171650120.modbd.oraclevcn.com
   - same port

[PDB]

    ssh -f opc@144.24.161.57 -L localhost:9090:instance-20230509-2215.sub04171650120.modbd.oraclevcn.com:1521 -N -i ssh-key-2023-05-09.key

[PDB_BUC]

    ssh -f opc@141.147.18.194 -L localhost:9091:instance-20230510-1838.sub04171650120.modbd.oraclevcn.com:1521 -N -i ssh-key-2023-05-09.key
