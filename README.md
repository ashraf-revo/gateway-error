# gateway-error
issue with spring cloud HostRoutePredicateFactory
the pattern don't match because when the host contains port like gateway.lcl don't match gateway.lcl:8080
I crated FHostRoutePredicateFactory to simulate how to fix it
###
steps to produce it 
1. create new host mapping in `/etc/hosts` with those values


   `127.0.0.1	gateway.lcl`

  ` 127.0.0.1	home.lcl`



2. run the application   
3. when accessing `home.lcl:8080` it will work fine which is implemented by custom FHostRoutePredicateFactory
4. when accessing `gateway.lcl:8080` it will not work fine because pattern don't match