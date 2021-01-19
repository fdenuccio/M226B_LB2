# JavaSocket Documentation


## Servercode
`ServerSocket incoming = new ServerSocket(9090);` erstellt ein Socket auf Port 9090
` Socket clientConnection = incoming.accept();` Blocking call -> code stopt und wartet auf eine TCP verbindung


## Clientcode

`String serverIp= "127.0.0.1;" ` IP

`int serverPort= 9090;` Port

`Socket s = new Socket(IP, Port);` Connection Socket


## Socket Data 

`BufferedReader receiver = new BufferedReader( new InputStreamReader( s.getInputStream() ) );` holt die gebufferten Daten

`PrintWriter sender = new PrintWriter( s.getOutputStream(), true );` sendet Daten


